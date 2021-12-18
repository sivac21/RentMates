package com.stackroute.tenantprofileservice.controller;

import com.google.gson.Gson;
import com.stackroute.tenantprofileservice.exception.TenantProfileAlreadyExistsException;
import com.stackroute.tenantprofileservice.exception.TenantProfileNotFoundException;
import com.stackroute.tenantprofileservice.model.TenantProfile;
import com.stackroute.tenantprofileservice.service.TenantProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * @Author Siva
 * @Date 11/18/2021 2:26 PM
 */
@Slf4j
@RestController
@RequestMapping("/api/v1")
//@CrossOrigin
public class TenantProfileController {
    private TenantProfileService tenantProfileService;
    private ResponseEntity responseEntity;


    @Autowired
    public TenantProfileController(TenantProfileService tenantProfileService ) {
        this.tenantProfileService = tenantProfileService;
    }

    @PostMapping("/profile")
    public ResponseEntity<TenantProfile> registerProfile(@Valid @RequestBody TenantProfile tenantProfile) throws TenantProfileAlreadyExistsException {
        log.debug("Register request received for Tenant profile" + tenantProfile + "at " + java.time.LocalDateTime.now());
        try {
            log.info("Tenant details" + tenantProfile);
            TenantProfile registeredProfile = tenantProfileService.registerProfile(tenantProfile);
            log.info("Registered profile successfully" + registeredProfile);
            responseEntity = new ResponseEntity<>(registeredProfile, HttpStatus.OK);
        }
        catch (TenantProfileAlreadyExistsException e){
            log.error("Exception occur" + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        catch (Exception e){
            log.error("Exception occur" + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


    @GetMapping("/profiles")
    public ResponseEntity<List<TenantProfile>> getAllProfiles() throws Exception{
        responseEntity = new ResponseEntity<List<TenantProfile>>((List<TenantProfile>) tenantProfileService.getAllProfiles(), HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/profile/{email}")
    public ResponseEntity<?> updateProfile (@PathVariable("email") String email, @RequestParam("file")MultipartFile multipartFile, @RequestParam("tenantprofile")String tenantProfile) throws TenantProfileNotFoundException {
        Gson gson = new Gson();
        TenantProfile tenantProfileObj = gson.fromJson(tenantProfile, TenantProfile.class);
        try {
            tenantProfileService.updateProfile(tenantProfileObj, email, multipartFile);
//            tenantMessageProducer.sendMessageToRabbitMq(email);
            responseEntity = new ResponseEntity<>(tenantProfileObj, HttpStatus.OK);
        } catch (TenantProfileNotFoundException | IOException e){
            log.error("Exception occur" + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("/profile/{email}")
    public ResponseEntity<?> deleteProfile(@PathVariable("email") String email) throws TenantProfileNotFoundException {
        try {
           tenantProfileService.deleteProfile(email);
        }
        catch (TenantProfileNotFoundException e)
        {
            log.error("Exception occur" + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (Exception e) {
            log.error("Exception occur" + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/profiles/{email}")
    public ResponseEntity<?> getProfileByEmail(@PathVariable("email") String email) throws TenantProfileNotFoundException {
        try {
            responseEntity = new ResponseEntity<>(tenantProfileService.getProfileByEmail(email), HttpStatus.OK);
        }
        catch (Exception e){
            log.error("Exception occur" + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}

