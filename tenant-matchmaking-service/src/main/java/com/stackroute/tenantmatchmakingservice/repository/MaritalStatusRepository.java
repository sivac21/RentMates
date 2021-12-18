package com.stackroute.tenantmatchmakingservice.repository;

import com.stackroute.tenantmatchmakingservice.model.MaritalStatus;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @Author Rohit
 * @Date 09-Dec-21 9:31 AM
 */
@Repository
public interface MaritalStatusRepository extends Neo4jRepository<MaritalStatus,String> {

    @Query("MATCH ( a : Tenant{email : $tenantEmail }),(b : MaritalStatus {name : $ maritalStatus }) MERGE (a)-[r : maritalStatus]->(b)")
    void createTenantMaritalStatusRelationship(String tenantEmail, String maritalStatus );
}
