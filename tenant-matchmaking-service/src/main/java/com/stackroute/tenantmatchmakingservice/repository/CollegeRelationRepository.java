package com.stackroute.tenantmatchmakingservice.repository;

import com.stackroute.tenantmatchmakingservice.model.CollegeRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

/**
 * @Author Rohit
 * @Date 13-Dec-21 3:23 PM
 */
public interface CollegeRelationRepository extends Neo4jRepository<CollegeRelation,String> {
    @Query("MATCH ( a : Tenant{email : $tenantEmail }),(b : CollegeRelation {degree : $ degree }) MERGE (a)-[r :from ]->(b)")
    void createTenantCollegeRelationship(String tenantEmail, String degree );

}
