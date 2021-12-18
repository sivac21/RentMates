package com.stackroute.propertyownerservice.service;
import com.stackroute.propertyownerservice.exception.PropertyAlreadyExistsException;
import com.stackroute.propertyownerservice.exception.PropertyNotFoundException;
import com.stackroute.propertyownerservice.model.Property;
import com.stackroute.propertyownerservice.repository.PropertyRepository;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

/**
 * @Author Rohit
 * @Date 11/18/2021 2:26 PM
 */
@Slf4j
@Service
public class PropertyServiceImpl implements PropertyService{

    private PropertyRepository propertyRepository;
    private ElasticsearchRestTemplate elasticsearchRestTemplate;



    @Autowired
    public PropertyServiceImpl(PropertyRepository propertyRepository, ElasticsearchRestTemplate elasticsearchRestTemplate) {
        this.propertyRepository = propertyRepository;
        this.elasticsearchRestTemplate = elasticsearchRestTemplate;
    }


    @Override
    public Property registerProperty(Property property , MultipartFile file) throws PropertyAlreadyExistsException, IOException {
        log.debug("Entered the register profile()");
        Property registeredProperty = new Property();
        Optional<Property> registerProperty = propertyRepository.findById(property.getPropertyName());
        if(registerProperty.isPresent())
        {
            log.error("Property is already present");
            throw new PropertyAlreadyExistsException();
        }else {
            property.setImage(file.getBytes());
            registeredProperty = propertyRepository.save(property);
            return registeredProperty;
        }
    }

    @Override
    public Iterable<Property> getAllProperties() throws Exception {
        return propertyRepository.findAll();
    }

    @Override
    public Property updateProperty(Property property, String propertyName) throws PropertyNotFoundException {
        log.debug("Entered inside updateProperty");
        Optional<Property> propertyExist= propertyRepository.findById(propertyName);
        if(!propertyExist.isPresent())
        {
            log.error("Property not Found");
            throw new PropertyNotFoundException();
        }
        else {
            return propertyRepository.save(property);
        }
    }


    @Override
    public Property deleteProperty(String propertyName) throws PropertyNotFoundException {
        log.debug("Entered inside delete Property");
        Property property = null;
        if(propertyRepository.findById(propertyName).isEmpty())
        {
            log.error("Property Not Found");
            throw new PropertyNotFoundException();
        }
        else
        {
            propertyRepository.deleteById(propertyName);
        }
        return property;
    }

    @Override
    public Property getPropertyByPropertyName(String propertyName) throws PropertyNotFoundException {
        Property property = null;
        property = propertyRepository.findById(propertyName).orElse(null);
        if(property!=null)
        {
            return property;
        }
        else
        {
            log.error("Property not found");
            throw new PropertyNotFoundException();
        }
    }

    @Override
    public List<Property> searchProperty(String searchText) {
        QueryStringQueryBuilder queryStringQueryBuilderBuilder = QueryBuilders.queryStringQuery("*"+ searchText+"*")
                .field("propertyName").field("state").field("city").field("roomType").field("locality").field("expectedRent").field("advancedDeposit").field("ownedBy").field("preferredTenant.STUDENT");
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withFilter(queryStringQueryBuilderBuilder).build();
        List<SearchHit<Property>> searchHitList = elasticsearchRestTemplate.search(nativeSearchQuery,Property.class).getSearchHits();
        List<Property> propertiesList = new ArrayList<>();
        for (SearchHit<Property> property : searchHitList){
            propertiesList.add(property.getContent());
        }
        return propertiesList;
    }
}
