package com.stackroute.tenantmatchmakingservice.repository;

import com.stackroute.tenantmatchmakingservice.model.Schooling;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @Author Rohit
 * @Date 09-Dec-21 3:49 PM
 */
@Repository
public interface SchoolingRepository extends Neo4jRepository<Schooling,String> {

    @Query("MATCH ( a : Tenant{email : $tenantEmail }),(b : Schooling {grade : $ grade }) MERGE (a)-[r :from ]->(b)")
    void createTenantSchoolingRelationship(String tenantEmail, String grade );
}
