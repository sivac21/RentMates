package com.stackroute.tenantmatchmakingservice.repository;

import com.stackroute.tenantmatchmakingservice.model.CareerRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

/**
 * @Author Rohit
 * @Date 13-Dec-21 3:41 PM
 */
public interface CareerRelationRepository extends Neo4jRepository<CareerRelation,String> {

    @Query("MATCH ( a : Tenant{email : $tenantEmail }),(b : CareerRelation {occupation : $ occupation }) MERGE (a)-[r :from ]->(b)")
    void createTenantCareerRelationship(String tenantEmail, String occupation );
}
