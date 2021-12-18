package com.stackroute.propertyownerservice.repository;
import com.stackroute.propertyownerservice.model.Property;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
/**
 * @Author Rohit
 * @Date 11/18/2021 2:26 PM
 */

@Repository
public interface PropertyRepository extends ElasticsearchRepository<Property,String> {
}
