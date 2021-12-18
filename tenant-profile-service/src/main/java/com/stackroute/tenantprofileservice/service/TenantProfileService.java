package com.stackroute.tenantprofileservice.service;

import com.stackroute.tenantprofileservice.exception.TenantProfileAlreadyExistsException;
import com.stackroute.tenantprofileservice.exception.TenantProfileNotFoundException;
import com.stackroute.tenantprofileservice.model.TenantProfile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Author Siva
 * @Date 11/18/2021 2:20 PM
 */
public interface TenantProfileService {
    TenantProfile registerProfile(TenantProfile tenantProfile) throws TenantProfileAlreadyExistsException, IOException;
    List<TenantProfile> getAllProfiles() throws Exception;
    TenantProfile updateProfile(TenantProfile tenantProfile, String email, MultipartFile file) throws TenantProfileNotFoundException, IOException;
    TenantProfile deleteProfile(String email) throws TenantProfileNotFoundException;
    TenantProfile getProfileByEmail(String email) throws TenantProfileNotFoundException;
}
