//package com.stackroute.tenantprofileservice.controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.tenantprofileservice.model.*;
//import com.stackroute.tenantprofileservice.service.TenantProfileService;
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
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.stackroute.tenantprofileservice.model.Gender.MALE;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * @Author Siva
// * @Date 11/30/2021 8:16 AM
// */
//@ExtendWith(MockitoExtension.class)
//public class TenantProfileControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private TenantProfileService tenantProfileService;
//
//    private TenantProfile tenantProfile;
//    private Questionaire questionaire;
//    private School school;
//    private College college;
//    private Career career;
//    private List<TenantProfile> listTenantProfile;
//
//    @InjectMocks
//    private TenantProfileController tenantProfileController;
//
//    @BeforeEach
//    public void setUp() {
//        listTenantProfile = new ArrayList<>();
//        List<String> hobbies = new ArrayList<>();
//        hobbies.add("Painting");
//        hobbies.add("Reading");
//        tenantProfile = new TenantProfile("siva@gmail.com", "Sivasankaran", 25, "Chennai", "9876543210", MALE, "TamilNadu", hobbies, "Doctor", "Bike rides", questionaire, school, college, career, null);
//        List<String> lang = new ArrayList<>();
//        lang.add("Tamil");
//        lang.add("English");
//        questionaire = new Questionaire(lang, "Veg", "No", "married");
//        school = new School("MSJ", "+2", true);
//        college = new College("SRM", "b.tech", true);
//        career = new Career("TCS", "Engineer", "developer", "2");
//        listTenantProfile.add(tenantProfile);
//
//        List<String> hobbie = new ArrayList<>();
//        hobbies.add("Painting");
//        hobbies.add("Drawing");
//        tenantProfile = new TenantProfile("kishore@gmail.com", "Kishore", 15, "Chennai", "9876543210", MALE, "TamilNadu", hobbie, "Doctor", "Bike rides", questionaire, school, college, career, null);
//        List<String> lan = new ArrayList<>();
//        lang.add("Tamil");
//        lang.add("English");
//        questionaire = new Questionaire(lan, "Veg", "No", "married");
//        school = new School("MSJ", "+2", true);
//        college = new College("SRM", "b.tech", true);
//        career = new Career("TCS", "Engineer", "developer", "2");
//        listTenantProfile.add(tenantProfile);
//        mockMvc = MockMvcBuilders.standaloneSetup(tenantProfileController).build();
//    }
//
//    @AfterEach
//    public void tearDown() {
//        tenantProfile = null;
//        questionaire = null;
//        school = null;
//        college = null;
//        career = null;
//    }
//
//    @Test
//    public void testSaveProfileSuccess() throws Exception {
//        when(tenantProfileService.registerProfile(any())).thenReturn(tenantProfile);
//        mockMvc.perform(post("/api/v1/profile")
//                .contentType(MediaType.APPLICATION_JSON).content(jsonToString(tenantProfile)))
//                .andExpect(status().isCreated())
//                .andDo(print());
//        verify(tenantProfileService,times(1)).registerProfile(any());
//    }
//
////    @Test
////    public void testUpdateProfileSuccess() throws Exception {
////        when(tenantProfileService.updateProfile((tenantProfile.getFullName()),(tenantProfile.getEmail()), (tenantProfile.getImage()))).thenReturn(tenantProfile);
////        mockMvc.perform(put("/api/v1/profile/{email}")
////                .contentType(MediaType.APPLICATION_JSON).content(jsonToString(tenantProfile)))
////                .andExpect(status().isOk())
////                .andDo(print());
////        verify(tenantProfileService,times(1)).updateProfile(tenantProfile.getFullName(),tenantProfile.getEmail(),tenantProfile.getImage());
////    }
//
//    @Test
//    public void testDeleteProfile() throws Exception {
//        when(tenantProfileService.deleteProfile(tenantProfile.getEmail())).thenReturn(tenantProfile);
//        mockMvc.perform(delete("/api/v1/profile/{email}")
//                .contentType(MediaType.APPLICATION_JSON).content(jsonToString(tenantProfile)))
//                .andExpect(status().isOk())
//                .andDo(print());
//        verify(tenantProfileService,times(1)).deleteProfile(tenantProfile.getEmail());
//    }
//
//    @Test
//    public void getAllProfile() throws Exception {
//        when(tenantProfileService.getAllProfiles()).thenReturn(listTenantProfile);
//        mockMvc.perform(get("/api/v1/profiles")
//                .contentType(MediaType.APPLICATION_JSON).content(jsonToString(tenantProfile)))
//                .andExpect(status().isOk())
//                .andDo(print());
//        verify(tenantProfileService,times(1)).getAllProfiles();
//    }
//
//    private static String jsonToString(final Object ob) throws JsonProcessingException {
//        String result;
//
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            String jsonContent = mapper.writeValueAsString(ob);
//            result = jsonContent;
//        } catch(JsonProcessingException e) {
//            result = "JSON processing error";
//        }
//
//        return result;
//    }
//}
