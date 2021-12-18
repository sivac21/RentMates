package com.stackroute.tenantprofileservice.service;

import com.stackroute.tenantprofileservice.exception.TenantProfileAlreadyExistsException;
import com.stackroute.tenantprofileservice.exception.TenantProfileNotFoundException;
import com.stackroute.tenantprofileservice.model.TenantProfile;
import com.stackroute.tenantprofileservice.repository.TenantProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @Author Siva
 * @Date 11/18/2021 2:21 PM
 */

@Service
@Slf4j
public class TenantProfileServiceImpl implements TenantProfileService{

    @Autowired
    private TenantProfileRepository tenantProfileRepository;

    @Autowired
    public TenantProfileServiceImpl(TenantProfileRepository tenantProfileRepository) {
        this.tenantProfileRepository = tenantProfileRepository;
    }

    @Override
    public TenantProfile registerProfile(TenantProfile tenantProfile) throws TenantProfileAlreadyExistsException, IOException {
        log.debug("Inside registerProfile()");
        TenantProfile registeredProfile = new TenantProfile();
        Optional<TenantProfile> registerProfile = tenantProfileRepository.findById(tenantProfile.getEmail());
        if (registerProfile.isPresent())
        {
            log.error("Profile is already present");
            throw new TenantProfileAlreadyExistsException();
        }
        registeredProfile = tenantProfileRepository.save(tenantProfile);
        return registeredProfile;
    }

    @Override
    public List<TenantProfile> getAllProfiles() throws Exception {
        return (List<TenantProfile>) tenantProfileRepository.findAll();
    }

    @Override
    public TenantProfile updateProfile(TenantProfile tenantProfile, String email, MultipartFile file) throws TenantProfileNotFoundException, IOException {
        log.debug("Inside updateProfile()");
        Optional<TenantProfile> tenantExist =  tenantProfileRepository.findById(email);
            if (!tenantExist.isPresent()) {
                log.error("Profile not found");
                throw new TenantProfileNotFoundException();
            }
            else {
                    tenantProfile.setEmail(email);
                    tenantProfile.setImage(file.getBytes());
                    return tenantProfileRepository.save(tenantProfile);
            }
    }

    @Override
    public TenantProfile deleteProfile(String email) throws TenantProfileNotFoundException {
        log.debug("Inside deleteUser()");
        TenantProfile tenantProfile = null;
            if (tenantProfileRepository.findById(email).isEmpty())
            {
                log.error("Profile is not found");
                throw new TenantProfileNotFoundException();
            }
            else {
                tenantProfileRepository.deleteById(email);
            }
        return tenantProfile;
    }

    @Override
    public TenantProfile getProfileByEmail(String email) throws TenantProfileNotFoundException {
        TenantProfile tenantProfile = null;
        tenantProfile = tenantProfileRepository.findById(email).orElse(null);
        if (tenantProfile!=null){
                return tenantProfile;
            }
            else {
                log.error("Profile is not found");
                throw new TenantProfileNotFoundException();
            }
    }
}
