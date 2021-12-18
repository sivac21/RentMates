package com.stackroute.tenantmatchmakingservice.repository;

import com.stackroute.tenantmatchmakingservice.model.GenderSpecific;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @Author Rohit
 * @Date 08-Dec-21 3:18 PM
 */
@Repository
public interface GenderSpecificRepository extends Neo4jRepository<GenderSpecific,String> {

    @Query("MATCH ( a : Tenant{email : $tenantEmail }),(b : GenderSpecific {name : $ gender }) MERGE (a)-[r : gender]->(b)")
    void createTenantGenderRelationship(String tenantEmail, String gender );

}
