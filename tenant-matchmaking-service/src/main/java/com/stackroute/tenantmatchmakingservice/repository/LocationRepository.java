package com.stackroute.tenantmatchmakingservice.repository;

import com.stackroute.tenantmatchmakingservice.model.Location;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @Author Rohit
 * @Date 08-Dec-21 3:22 PM
 */
@Repository
public interface LocationRepository extends Neo4jRepository<Location,String> {

    @Query("MATCH ( a : Tenant{email : $tenantEmail }),(b : Location {state : $ state }) MERGE (a)-[r :from {city : $city } ]->(b)")
    void createTenantAddressRelationship(String tenantEmail, String state , String city);
}
