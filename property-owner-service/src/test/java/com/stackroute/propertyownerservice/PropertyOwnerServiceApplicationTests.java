//package com.stackroute.propertyownerservice;
//
//import com.stackroute.propertyownerservice.exception.PropertyAlreadyExistsException;
//import com.stackroute.propertyownerservice.exception.PropertyNotFoundException;
//import com.stackroute.propertyownerservice.model.Property;
//import com.stackroute.propertyownerservice.repository.PropertyRepository;
//import com.stackroute.propertyownerservice.service.PropertyService;
//
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.times;
//
////@RunWith(SpringRunner.class)
//@SpringBootTest
//public class PropertyOwnerServiceApplicationTests {
//    @Test
//    void contextLoads(){
//
//   }
//
////    @Autowired
////	private PropertyService service;
////
////    @MockBean
////    private PropertyRepository repository;
////
////    @Test
////    public void getAllPropertiesTest() throws Exception {
////        when(repository.findAll()).thenReturn(Stream.of(new Property("Rajput","2 BHK",9000,2000,"meerut","up","varnika")).collect(Collectors.toList()));
////        assertEquals(1,service.getAllProperties().iterator());
////
////    }
////@Test
////    public void registerPropertyTest() throws PropertyAlreadyExistsException {
////        Property property = new Property("Rajput","2 BHK",9000,2000,"meerut","up","varnika");
////            when(repository.save(property)).thenReturn(property);
////            assertEquals(property,service.registerProperty(property));
////    }
////
////    @Test
////    public void deleteProperty() throws PropertyNotFoundException {
////        Property property = new Property("Rajput","2 BHK",9000,2000,"meerut","up","varnika");
////        when(repository.save(property)).thenReturn(property);
////        service.deleteProperty(property.getPropertyName());
////        verify(repository, times(1)).deleteById(property.getPropertyName());
////    }
////
//
//}
