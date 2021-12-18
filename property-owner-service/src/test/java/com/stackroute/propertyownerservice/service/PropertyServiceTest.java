//package com.stackroute.propertyownerservice.service;
//import com.stackroute.propertyownerservice.exception.PropertyAlreadyExistsException;
//import com.stackroute.propertyownerservice.exception.PropertyNotFoundException;
//import com.stackroute.propertyownerservice.model.Property;
//import com.stackroute.propertyownerservice.repository.PropertyRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Matchers.any;
//import static org.mockito.Mockito.when;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.times;
//
//@ExtendWith(MockitoExtension.class)
//class PropertyServiceTest {
//
//   @Mock
//   private PropertyRepository propertyRepository;
//
//    @InjectMocks
//   private PropertyServiceImpl propertyService;
//
//   @Test
//   public void registerPropertyTest() throws PropertyAlreadyExistsException {
//        List<String> nearByPlaces = new ArrayList<>();
//        nearByPlaces.add("malls");
//        nearByPlaces.add("parks");
//        nearByPlaces.add("clubs");
//
//        Property property = new Property("Rajput",  9000, 2000, "meerut", "up", "varnika");
//        when(propertyRepository.save(any())).thenReturn(property);
//        propertyService.registerProperty(property);
//        verify(propertyRepository,times(1)).save(any());
//    }
//
////@Test
////    public void getAllPropertiesTest() throws Exception {
////    when(propertyRepository.findAll()).thenReturn(Stream
////    .of(new Property("Rajput",  9000, 2000, "meerut", "up", "varnika"),new Property("Taj",  9000, 2000, "meerut", "up", "varnika")).collect(Collectors.toList()));
////    assertEquals(2,propertyService.getAllProperties().size());
////}
////
////@Test
////
////    public void getPropertyByPropertyNameTest() throws PropertyNotFoundException {
////    String propertyName = "Taj";
////    when(propertyRepository.findAllById(Collections.singleton(propertyName)))
////            .thenReturn(Stream.of(new Property("Rajput",  9000, 2000, "meerut", "up", "varnika")).collect(Collectors.toList()));
////    assertEquals(1,propertyService.getPropertyByPropertyName(propertyName).size());
////}
////
////@Test
////    public void deletePropertyTest(){
////    Property property = new Property("Rajput",  9000, 2000, "meerut", "up", "varnika");
////propertyService.deleteProperty(property);
////verify(propertyRepository,times(1)).delete(property);
////}
//
//}