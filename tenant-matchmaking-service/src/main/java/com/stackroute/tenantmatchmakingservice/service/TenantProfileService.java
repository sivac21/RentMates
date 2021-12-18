package com.stackroute.tenantmatchmakingservice.service;
import com.stackroute.tenantmatchmakingservice.exception.TenantProfileAlreadyExistsException;
import com.stackroute.tenantmatchmakingservice.model.*;
import java.io.IOException;
import java.util.List;

/**
 * @Author Rohit
 * @Date 07-Dec-21 8:19 AM
 */
public interface TenantProfileService {
    Tenant registerProfile(TenantProfile tenantProfile) throws TenantProfileAlreadyExistsException, IOException;
    DrinkingSmoking createHabit(DrinkingSmoking drinkingSmoking);
    FoodType foodHabit(FoodType foodType);
    MaritalStatus maritalState(MaritalStatus maritalStatus);
    Age ageGroup(Age age);
    List<String> getAllMatchedTenant(String email, String gender, String state, String ageGroup) throws Exception;
    void createInterestedRelation(String sender, String receiver);
    void createAcceptedRelation(String sender, String receiver);
    List<String> getAllInterestedTenant(String email );
    List<String> getAllPoppedOutTenants(String email);

}
