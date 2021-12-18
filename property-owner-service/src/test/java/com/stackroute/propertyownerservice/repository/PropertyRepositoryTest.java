//package com.stackroute.propertyownerservice.repository;
//import com.stackroute.propertyownerservice.model.Property;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import java.util.List;
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//
//class PropertyRepositoryTest {
//
//    @Autowired
//    private PropertyRepository propertyRepository;
//
//    @Test
//    public  void givenPropertyToRegisterShouldReturnRegisterProperty(){
//        Property property = new Property("Rajput",9000,
//                2000,"meerut","up","varnika");
//        propertyRepository.save(property);
//        Property property1 = propertyRepository.findById(property.getPropertyName()).get();
//        assertNotNull(property1);
//        assertEquals(property1.getPropertyName(),property1.getPropertyName());
//    }
//
//    @Test
//    public void givenGetAllPropertiesShouldReturnListOfAllProperties()
//    {
//        Property property = new Property("Red",9000,2000,"meerut","up","varnika");
//        Property property1 = new Property("Taj",9000,2000,"meerut","up","varnika");
//        propertyRepository.save(property);
//        propertyRepository.save(property1);
//
//        List<Property> propertyList = (List<Property>) propertyRepository.findAll();
//        assertEquals("Red",propertyList.get(1).getPropertyName());
//
//    }
//}