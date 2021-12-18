package com.stackroute.tenantmatchmakingservice.repository;

import com.stackroute.tenantmatchmakingservice.model.FoodType;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

/**
 * @Author Rohit
 * @Date 09-Dec-21 8:48 AM
 */
public interface FoodTypeRepository extends Neo4jRepository<FoodType,String> {

    @Query("MATCH ( a : Tenant{email : $tenantEmail }),(b : FoodType {name : $ foodType }) MERGE (a)-[r : foodType]->(b)")
    void createTenantFoodTypeRelationship(String tenantEmail, String foodType );
}
