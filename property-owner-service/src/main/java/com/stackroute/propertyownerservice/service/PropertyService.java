package com.stackroute.propertyownerservice.service;
import com.stackroute.propertyownerservice.exception.PropertyAlreadyExistsException;
import com.stackroute.propertyownerservice.exception.PropertyNotFoundException;
import com.stackroute.propertyownerservice.model.Property;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Author Rohit
 * @Date 11/18/2021 2:26 PM
 */
public interface PropertyService {

    Property registerProperty(Property property , MultipartFile file) throws PropertyAlreadyExistsException , IOException;
    Iterable<Property>  getAllProperties() throws Exception;
    Property updateProperty(Property property, String propertyName) throws PropertyNotFoundException;
    Property deleteProperty(String propertyName) throws PropertyNotFoundException;
    Property getPropertyByPropertyName(String propertyName) throws PropertyNotFoundException;
    List<Property> searchProperty(String searchText);


}
