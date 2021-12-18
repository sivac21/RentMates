package com.stackroute.tenantprofileservice.repository;

import com.stackroute.tenantprofileservice.model.TenantGroup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Siva
 * @Date 12/11/2021 11:28 AM
 */
@Repository
public interface TenantGroupRepository extends MongoRepository<TenantGroup, String> {

//    @Query("{'tenantGroup.email':{$in:[?0]}}")
//    List<TenantGroup> findAllGroupByEmail(String email);
}
