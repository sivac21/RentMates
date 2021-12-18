package com.stackroute.tenantmatchmakingservice.repository;
import com.stackroute.tenantmatchmakingservice.model.Tenant;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import com.stackroute.tenantmatchmakingservice.model.TenantProfile;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Author Rohit
 * @Date 03-Dec-21 11:00 AM
 */
@Repository
public interface TenantMatchmakingRepository extends Neo4jRepository<Tenant,String> {

//    @Query("MATCH (t: Tenant),(g: GenderSpecific{gender : $ gender}),(l: Location{state : $ state }),(m : MaritalStatus {name : $ maritalStatus }),(f :FoodType {name : $ foodType }) WHERE (g )<-[: gender]-(t) OR  (l)<-[: from]-(t) OR (m)<-[:maritalStatus]-(t) OR (f)<-[:foodType]-(t) return t.email" )
//    List<String> getAllMatchedTenant(String email,String gender, String state , String maritalStatus , String foodType);

    @Query("MATCH(g: GenderSpecific{name : $gender}),(t : Tenant),(l:Location{state:$state}),(m:MaritalStatus{name:\"unmarried\"}),(f:FoodType{name:\"vegetarian\"}),(d:DrinkingSmoking{name:\"DrinkerAndSmoker\"}),(a:Age{name:$ageGroup}) WHERE (g )<-[: gender]-(t) AND (l)<-[: from]-(t) AND (a)<-[:ageGroup ]-(t) return t.email" )
    List<String> getAllMatchedTenant(String email,String gender, String state, String ageGroup );

    @Query("MATCH ( a : Tenant{email : $sender }),(b : Tenant{email : $receiver}) MERGE (a)-[r :interested ]->(b)")
    void createTenantInterestedRelationship(String sender , String receiver );

//    MATCH ( a : Tenant{email : $tenantEmail }),(b : FoodType {name : $ foodType }) MERGE (a)-[r : foodType]->(b)

    @Query("MATCH ( a : Tenant{email : $sender }),(b : Tenant{email : $receiver}) MERGE (a)-[r :accepted ]->(b)")
    void createTenantAcceptedRelationship(String sender , String receiver );

    @Query("MATCH (n:Tenant {email: $email}),(b : Tenant) WHERE exists ((b)-[: interested]->(n)) return b.email")

    List<String> getAllInterestedTenant(String email );

    @Query("MATCH (n:Tenant {email: $email }),(b : Tenant) WHERE exists ((n)-[: interested]->(b)) OR ((n)-[: accepted]->(b)) return b.email")
    List<String> getAllPoppedOutTenants(String email);

}
