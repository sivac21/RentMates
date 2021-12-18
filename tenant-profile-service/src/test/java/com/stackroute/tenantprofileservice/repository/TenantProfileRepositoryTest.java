//package com.stackroute.tenantprofileservice.repository;
//
//import com.stackroute.tenantprofileservice.model.*;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static com.stackroute.tenantprofileservice.model.Gender.FEMALE;
//import static com.stackroute.tenantprofileservice.model.Gender.MALE;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
///**
// * @Author Siva
// * @Date 11/30/2021 8:17 AM
// */
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class TenantProfileRepositoryTest {
//    @Autowired
//    private TenantProfileRepository tenantProfileRepository;
//
//    private TenantProfile tenantProfile;
//    private Questionaire questionaire;
//    private School school;
//    private College college;
//    private Career career;
//
//    public void setUp() {
//        List<String> hobbies = new ArrayList<>();
//        hobbies.add("Painting");
//        hobbies.add("Reading");
//        tenantProfile = new TenantProfile("varshu@gmail.com", "Varshini", 25, "Chennai", "9876543210", FEMALE, "TamilNadu", hobbies, "Doctor", "Bike rides", questionaire, school, college, career,null );
//        List<String> lang = new ArrayList<>();
//        lang.add("Tamil");
//        lang.add("English");
//        questionaire = new Questionaire(lang, "Veg", "No", "married");
//        school = new School("MSJ", "+2", true);
//        college = new College("SRM", "b.tech", true);
//        career = new Career("TCS", "Engineer", "developer", "2");
//    }
//
//    @AfterEach
//    public void tearDown() {
//        tenantProfile = null;
//        questionaire = null;
//        school = null;
//        college = null;
//        career = null;
//        tenantProfileRepository.deleteAll();;
//    }
//
//    @Test
//    public void givenProfileToSaveShouldReturnProfile() {
//        tenantProfileRepository.insert(tenantProfile);
//        TenantProfile profile = tenantProfileRepository.findById(tenantProfile.getEmail()).get();
//        assertEquals(profile.getFullName(),tenantProfile.getFullName());
//    }
//
//    @Test
//    public void givenProfileToUpdateShouldReturnProfile() {
//        tenantProfileRepository.insert(tenantProfile);
//        TenantProfile profile = tenantProfileRepository.findById(tenantProfile.getEmail()).get();
//        profile.setFullName("Updating the Tenant Profile");
//        tenantProfileRepository.save(profile);
//        TenantProfile profileObj = tenantProfileRepository.findById(tenantProfile.getEmail()).get();
//        assertEquals("Updating the Tenant Profile", profileObj.getFullName());
//    }
//
//    @Test
//    public void givenProfileToDeleteShouldDeleteProfile() {
//        tenantProfileRepository.insert(tenantProfile);
//        TenantProfile profile = tenantProfileRepository.findById(tenantProfile.getEmail()).get();
//        tenantProfileRepository.delete(profile);
//        assertEquals(Optional.empty(), tenantProfileRepository.findById(tenantProfile.getEmail()));
//    }
//
//    @Test
//    public void givenProfileReturnGetAllProfile() {
//        tenantProfileRepository.insert(tenantProfile);
//        List<String> hobbies = new ArrayList<>();
//        hobbies.add("Painting");
//        hobbies.add("Drawing");
//        TenantProfile tenantProfile = new TenantProfile("kishore@gmail.com", "Kishore", 15, "Chennai", "9876543210", MALE, "TamilNadu", hobbies, "Doctor", "Bike rides", questionaire, school, college, career, null);
//        List<String> lang = new ArrayList<>();
//        lang.add("Tamil");
//        lang.add("English");
//        Questionaire questionaire = new Questionaire(lang, "Veg", "No", "married");
//        School school = new School("MSJ", "+2", true);
//        College college = new College("SRM", "b.tech", true);
//        Career career = new Career("TCS", "Engineer", "developer", "2");
//        tenantProfileRepository.insert(tenantProfile);
//        List<TenantProfile> list = tenantProfileRepository.findAll();
//        assertEquals(2,list.size());
//        assertEquals("kishore@gamil.com",list.get(1).getEmail());
//    }
//}
