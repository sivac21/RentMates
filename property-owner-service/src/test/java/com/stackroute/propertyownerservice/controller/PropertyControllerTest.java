//package com.stackroute.propertyownerservice.controller;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.propertyownerservice.model.Property;
//import com.stackroute.propertyownerservice.service.PropertyService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import java.util.List;
//import static org.mockito.Mockito.when;
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.times;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//class PropertyControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Mock
//    PropertyService propertyService;
//    @InjectMocks
//    PropertyController propertyController;
//    private Property property1;
//    private Property property2;
//    private Iterable<Property> propertyIterable;
//
//
//    @BeforeEach()
//    public void setUp(){
//        property1 = new Property("Red",9000,2000,"meerut","up","varnika");
//        property2 = new Property("Taj",9000,2000,"meerut","up","varnika");
//        propertyIterable = List.of(property1,property2);
//        mockMvc = MockMvcBuilders.standaloneSetup(propertyController).build();
//    }
//    @AfterEach()
//    public void tearDown(){
//        property1=null;
//        property2=null;
//        propertyIterable=null;
//    }
//    private static String jsonToString(final Object o)throws JsonProcessingException
//    {
//        String result;
//        try{
//            ObjectMapper mapper= new ObjectMapper();
//            String jsonContent=mapper.writeValueAsString(o);
//            result=jsonContent;
//        }
//        catch(JsonProcessingException e)
//        {
//            result="JSON processing error";
//        }
//        return result;
//    }
//
//    @Test
//    public void postPropertyTest() throws Exception {
//        when(propertyService.registerProperty(any())).thenReturn(property2);
//        mockMvc.perform(post("/api/v1/property")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonToString(property2)))
//                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
//        verify(propertyService,times(1)).registerProperty(any());
//    }
////
////        @Test
////    public void getAllPropertiesThenShouldReturnListOfAllProperties() throws Exception {
////        when(propertyService.getAllProperties()).thenReturn(propertyList);
////        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/properties")
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(property)))
////                .andDo(MockMvcResultHandlers.print());
////        verify(propertyService,times(1)).getAllProperties();
////    }
//
//    }
