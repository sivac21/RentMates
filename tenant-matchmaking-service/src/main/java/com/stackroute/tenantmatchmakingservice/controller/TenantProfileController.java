package com.stackroute.tenantmatchmakingservice.controller;

import com.stackroute.tenantmatchmakingservice.exception.TenantProfileAlreadyExistsException;
import com.stackroute.tenantmatchmakingservice.model.*;
import com.stackroute.tenantmatchmakingservice.service.TenantProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Rohit
 * @Date 07-Dec-21 8:29 AM
 */

@Slf4j
@RestController
//@CrossOrigin(value = "*")
@RequestMapping("/api/v1")
public class TenantProfileController {

    private TenantProfileService tenantProfileService;
    private ResponseEntity responseEntity;


    @Autowired
    public TenantProfileController(TenantProfileService tenantProfileService) {
        this.tenantProfileService = tenantProfileService;
    }

    @PostMapping("/tenant")
    public ResponseEntity<TenantProfile> registerProfile(@RequestBody TenantProfile tenantProfile) throws TenantProfileAlreadyExistsException {
        log.debug("Register request received for Tenant profile" + tenantProfile + "at " + java.time.LocalDateTime.now());
        try {
            log.info("Tenant details" + tenantProfile);
            Tenant registeredProfile = tenantProfileService.registerProfile(tenantProfile);
            log.info("Registered profile successfully" + registeredProfile);
            responseEntity = new ResponseEntity<>(registeredProfile, HttpStatus.OK);
        } catch (TenantProfileAlreadyExistsException e) {
            log.error("Exception occur" + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            log.error("Exception occur" + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping("/drink")
    public ResponseEntity<?> createHabit(@RequestBody DrinkingSmoking drinkingSmoking) {
        try {
            DrinkingSmoking drinkerSmoker = tenantProfileService.createHabit(drinkingSmoking);
            log.info("Got Drinker Smoker response successfully" + drinkerSmoker);
            return new ResponseEntity<>(drinkerSmoker, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/food")
    public ResponseEntity<?> foodHabit(@RequestBody FoodType foodType) {
        try {
            FoodType foodType1 = tenantProfileService.foodHabit(foodType);
            return new ResponseEntity<>(foodType1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/maritalStatus")
    public ResponseEntity<?> maritalState(@RequestBody MaritalStatus maritalStatus) {
        try {
            MaritalStatus maritalStatus1 = tenantProfileService.maritalState(maritalStatus);
            return new ResponseEntity<>(maritalStatus1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/ageGroup")
    public ResponseEntity<?> ageGroup(@RequestBody Age age) {
        try {
            Age ageGroup = tenantProfileService.ageGroup(age);
            return new ResponseEntity<>(ageGroup, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/matchedTenant")
    public ResponseEntity<?> getAllMatchedTenant(@RequestParam String email, @RequestParam String gender, @RequestParam String state, @RequestParam String ageGroup) throws Exception {

        try {
            responseEntity = new ResponseEntity<>((List<String>) tenantProfileService.getAllMatchedTenant(email, gender, state, ageGroup), HttpStatus.OK);

        } catch (Exception e) {
            log.error("Exception " + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    //Get mapping to create relationship for tenant as interested

    @GetMapping("/interestedTenant")
    public ResponseEntity<?> createdInterestedTenantRelation(@RequestParam String sender, @RequestParam String receiver) {
        log.info("we are here in interested" + sender + receiver);
        tenantProfileService.createInterestedRelation(sender, receiver);
        log.info("checking response ");
        responseEntity = new ResponseEntity<>("Successfully created", HttpStatus.OK);

        return responseEntity;
    }

    @GetMapping("/acceptedTenant")
    public ResponseEntity<?> createdAcceptedTenantRelation(@RequestParam String sender, @RequestParam String receiver) throws Exception {

        try {
            tenantProfileService.createAcceptedRelation(sender, receiver);
            responseEntity = new ResponseEntity<>("Successfully created", HttpStatus.OK);

        } catch (Exception e) {
            log.error("Exception " + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/showedInterest")
    public ResponseEntity<?> getAllInterestedTenantList(@RequestParam String emailId) throws Exception {

        try {
            responseEntity = new ResponseEntity<>(tenantProfileService.getAllInterestedTenant(emailId), HttpStatus.OK);

        } catch (Exception e) {
            log.error("Exception " + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}