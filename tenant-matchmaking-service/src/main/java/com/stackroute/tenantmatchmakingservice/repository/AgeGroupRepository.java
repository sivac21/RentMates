package com.stackroute.tenantmatchmakingservice.repository;

import com.stackroute.tenantmatchmakingservice.model.Age;
import com.stackroute.tenantmatchmakingservice.model.MaritalStatus;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @Author Rohit
 * @Date 09-Dec-21 9:31 AM
 */
@Repository
public interface AgeGroupRepository extends Neo4jRepository<Age,String> {

    @Query("MATCH ( a : Tenant{email : $tenantEmail }),(b : Age {name : $ ageGroup }) MERGE (a)-[r : ageGroup]->(b)")
    void createTenantAgeGroupRelationship(String tenantEmail, String ageGroup );
}