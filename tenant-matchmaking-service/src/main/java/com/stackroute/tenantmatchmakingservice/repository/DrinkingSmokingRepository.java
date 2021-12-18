package com.stackroute.tenantmatchmakingservice.repository;

import com.stackroute.tenantmatchmakingservice.model.DrinkingSmoking;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @Author Rohit
 * @Date 08-Dec-21 5:30 PM
 */
@Repository
public interface DrinkingSmokingRepository extends Neo4jRepository<DrinkingSmoking, String> {

    @Query("MATCH ( a : Tenant{email : $tenantEmail }),(b : DrinkingSmoking {name : $ drinkingSmoking }) MERGE (a)-[r : do_drinkingSmoking]->(b)")
    void createTenantDrinkingSmokingRelationship(String tenantEmail, String drinkingSmoking );
}
