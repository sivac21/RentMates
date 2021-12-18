package com.stackroute.tenantprofileservice.repository;

import com.stackroute.tenantprofileservice.model.TenantProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Siva
 * @Date 11/18/2021 2:20 PM
 */
@Repository
public interface TenantProfileRepository extends MongoRepository<TenantProfile, String> {
}
