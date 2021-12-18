package com.stackroute.tenantprofileservice.service;

import com.stackroute.tenantprofileservice.model.TenantGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Siva
 * @Date 12/13/2021 12:20 PM
 */
@Repository
public class GroupServiceImpl {
    private MongoTemplate mongoTemplate;

    @Autowired
    public GroupServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<TenantGroup> getTenantGroupsByEmail(String email){
        Query query = new Query();
        query.addCriteria(Criteria.where("tenantMember1").regex(email));
        List<TenantGroup> tenantGroups = mongoTemplate.find(query, TenantGroup.class);

        Query query1 = new Query();
        query1.addCriteria(Criteria.where("tenantMember2").regex(email));
        List<TenantGroup> tenantGroups2 = mongoTemplate.find(query1, TenantGroup.class);
        List<TenantGroup> groupList = tenantGroups;
        for (TenantGroup group: tenantGroups2) {
            groupList.add(group);
        }
        System.out.println(groupList);
        return groupList;
    }
}
