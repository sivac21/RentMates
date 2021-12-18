package com.stackroute.tenantmatchmakingservice.service;

import com.stackroute.tenantmatchmakingservice.exception.TenantProfileAlreadyExistsException;
import com.stackroute.tenantmatchmakingservice.model.*;
import com.stackroute.tenantmatchmakingservice.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.ArrayUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author Rohit
 * @Date 07-Dec-21 8:21 AM
 */

@Slf4j
@Service
public class TenantProfileServiceImpl implements TenantProfileService {

    private TenantMatchmakingRepository tenantMatchmakingRepository;
    private LocationRepository locationRepository;
    private GenderSpecificRepository genderSpecificRepository;
    private DrinkingSmokingRepository drinkingSmokingRepository;
    private FoodTypeRepository foodTypeRepository;
    private MaritalStatusRepository maritalStatusRepository;
    private SchoolingRepository schoolingRepository;
    private AgeGroupRepository ageGroupRepository;
    private CollegeRelationRepository collegeRelationRepository;
    private CareerRelationRepository careerRelationRepository;

    @Autowired
    public TenantProfileServiceImpl(TenantMatchmakingRepository tenantMatchmakingRepository, LocationRepository locationRepository, GenderSpecificRepository genderSpecificRepository, DrinkingSmokingRepository drinkingSmokingRepository, FoodTypeRepository foodTypeRepository, MaritalStatusRepository maritalStatusRepository, SchoolingRepository schoolingRepository, AgeGroupRepository ageGroupRepository) {
        this.tenantMatchmakingRepository = tenantMatchmakingRepository;
        this.locationRepository = locationRepository;
        this.genderSpecificRepository = genderSpecificRepository;
        this.drinkingSmokingRepository = drinkingSmokingRepository;
        this.foodTypeRepository = foodTypeRepository;
        this.maritalStatusRepository = maritalStatusRepository;
        this.schoolingRepository = schoolingRepository;
        this.ageGroupRepository=ageGroupRepository;
        this.collegeRelationRepository = collegeRelationRepository;
        this.careerRelationRepository = careerRelationRepository;
    }

    @Override
    public Tenant registerProfile(TenantProfile tenantProfile) throws TenantProfileAlreadyExistsException, IOException {
        log.debug("Inside registerProfile()");
        Tenant registeredProfile = new Tenant();
        Optional<Tenant> registerProfile = tenantMatchmakingRepository.findById(tenantProfile.getEmail());
        if (registerProfile.isPresent()) {
            log.error("Profile is already present");
            throw new TenantProfileAlreadyExistsException();
        }

        //Tenant
        Tenant tenant = new Tenant(tenantProfile.getEmail(), tenantProfile.getFullName(), tenantProfile.getContactNumber());
        registeredProfile = tenantMatchmakingRepository.save(tenant);

        //Location
        Optional<Location> tenantAddress = locationRepository.findById(tenantProfile.getState());
        if (!tenantAddress.isPresent()) {
            locationRepository.save(new Location(tenantProfile.getState()));
        }
        locationRepository.createTenantAddressRelationship(tenantProfile.getEmail(), tenantProfile.getState(), tenantProfile.getCity());

        //Gender
        Optional<GenderSpecific> tenantGender = genderSpecificRepository.findById(tenantProfile.getGender().toString());
        if (!tenantGender.isPresent()) {
            genderSpecificRepository.save(new GenderSpecific(tenantProfile.getGender().toString()));
        }
        genderSpecificRepository.createTenantGenderRelationship(tenantProfile.getEmail(), tenantProfile.getGender().toString());

        //DrinkingAndSmoking
        if (tenantProfile.getQuestionaire().getDrinkingSmoking().equals("yes")) {
            drinkingSmokingRepository.createTenantDrinkingSmokingRelationship(tenantProfile.getEmail(), "DrinkerAndSmoker");
        }

        //FoodType
        foodTypeRepository.createTenantFoodTypeRelationship(tenantProfile.getEmail(), tenantProfile.getQuestionaire().getFoodType());

        //Marital Status
        maritalStatusRepository.createTenantMaritalStatusRelationship(tenantProfile.getEmail(), tenantProfile.getQuestionaire().getMaritalStatus());

        //Schooling
        if (!tenantProfile.getSchool().getGrade().isEmpty()) {
            Optional<Schooling> tenantSchooling = schoolingRepository.findById(tenantProfile.getSchool().getGrade());
            if (!tenantSchooling.isPresent()) {
                schoolingRepository.save(new Schooling(tenantProfile.getSchool().getGrade()));
            }
            schoolingRepository.createTenantSchoolingRelationship(tenantProfile.getEmail(), tenantProfile.getSchool().getGrade());
        }

        if (tenantProfile.getAge()<20) {
            ageGroupRepository.createTenantAgeGroupRelationship(tenantProfile.getEmail(), "<20");
        } else if(tenantProfile.getAge()>20 && tenantProfile.getAge()<30){
            ageGroupRepository.createTenantAgeGroupRelationship(tenantProfile.getEmail(), "21to30");
        }else if(tenantProfile.getAge()>30 && tenantProfile.getAge()<40){
            ageGroupRepository.createTenantAgeGroupRelationship(tenantProfile.getEmail(), "31to40");
        }else if(tenantProfile.getAge()>40){
            ageGroupRepository.createTenantAgeGroupRelationship(tenantProfile.getEmail(), ">40");
        }

        //College Relation

        if (!tenantProfile.getCollege().getDegree().isEmpty()) {

            Optional<CollegeRelation> tenantCollege = collegeRelationRepository.findById(tenantProfile.getCollege().getDegree());
            if (!tenantCollege.isPresent()) {
                collegeRelationRepository.save(new CollegeRelation(tenantProfile.getCollege().getDegree()));
            }
            collegeRelationRepository.createTenantCollegeRelationship(tenantProfile.getEmail(), tenantProfile.getCollege().getDegree());
        }

        //Career Relation

        if (!tenantProfile.getCareer().getOccupation().isEmpty()) {
            Optional<CareerRelation> tenantCareer = careerRelationRepository.findById(tenantProfile.getCareer().getOccupation());
            if (!tenantCareer.isPresent()) {
                careerRelationRepository.save(new CareerRelation(tenantProfile.getCareer().getOccupation()));
            }
            careerRelationRepository.createTenantCareerRelationship(tenantProfile.getEmail(), tenantProfile.getCareer().getOccupation());
        }


        return registeredProfile;
    }

    @Override
    public DrinkingSmoking createHabit(DrinkingSmoking drinkingSmoking) {
        return drinkingSmokingRepository.save(drinkingSmoking);
    }

    @Override
    public FoodType foodHabit(FoodType foodType) {
        return foodTypeRepository.save(foodType);
    }

    @Override
    public MaritalStatus maritalState(MaritalStatus maritalStatus) {
        return maritalStatusRepository.save(maritalStatus);
    }



    @Override
    public Age ageGroup(Age age) {
        return ageGroupRepository.save(age);
    }


    //interested Tenant Relationship
    @Override
    public List<String> getAllMatchedTenant(String email, String gender, String state, String ageGroup) throws Exception {
        List<String> matchedTenant =  tenantMatchmakingRepository.getAllMatchedTenant(email,gender,state,ageGroup);

        List<String> matchingTenant = new ArrayList<>();
        for(String emailid : matchedTenant ){
            log.info("inside first for loop" + matchedTenant);
            if(!(email.equals(emailid))){
                matchingTenant.add(emailid);
//                matchedTenant.remove(email);
            }
        }
        log.info("matched Tenant "+ matchingTenant );
        List<String> poppedEmailList = tenantMatchmakingRepository.getAllPoppedOutTenants(email);
        log.info("popped list" + poppedEmailList);
        List<String> poppedMatchingTenant = new ArrayList<>();
        for(String popEmailId : poppedEmailList) {
            log.info("inside popped for loop" + popEmailId);
            for (String matchedEmail : matchingTenant) {
                log.info("popped for loop" + matchedEmail);
                if (!(popEmailId.equals(matchedEmail))) {
                    poppedMatchingTenant.add(matchedEmail);
//                    matchedTenant.remove(popEmailId);
//                    break;
                }
            }
        }
        if(poppedEmailList.size()==0) {
            return matchingTenant;
        }
        log.info("final result" + poppedMatchingTenant);
        return poppedMatchingTenant;
    }
    
    public void createInterestedRelation(String sender, String receiver) {
        tenantMatchmakingRepository.createTenantInterestedRelationship(sender, receiver);
        log.info("serviceImpl result Value");


    }

    //accepted Tenant Relationship
    @Override
    public void createAcceptedRelation(String sender, String receiver) {
         tenantMatchmakingRepository.createTenantAcceptedRelationship(sender, receiver);

    }

    @Override
    public List<String> getAllInterestedTenant(String emailId) {
        return tenantMatchmakingRepository.getAllInterestedTenant(emailId);
    }

    @Override
    public List<String> getAllPoppedOutTenants(String email) {
        return tenantMatchmakingRepository.getAllPoppedOutTenants(email);
    }
}


