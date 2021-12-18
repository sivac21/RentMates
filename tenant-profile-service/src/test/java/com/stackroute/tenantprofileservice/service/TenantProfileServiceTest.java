//package com.stackroute.tenantprofileservice.service;
//
//import com.stackroute.tenantprofileservice.exception.TenantProfileAlreadyExistsException;
//import com.stackroute.tenantprofileservice.exception.TenantProfileNotFoundException;
//import com.stackroute.tenantprofileservice.model.*;
//import com.stackroute.tenantprofileservice.repository.TenantProfileRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static com.stackroute.tenantprofileservice.model.Gender.FEMALE;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//
///**
// * @Author Siva
// * @Date 11/30/2021 8:17 AM
// */
//@ExtendWith(MockitoExtension.class)
//public class TenantProfileServiceTest {
//
//    @Mock
//    private TenantProfileRepository tenantProfileRepository;
//
//    private TenantProfile tenantProfile;
//
//    private Optional optional;
//    private Questionaire questionaire;
//    private School school;
//    private College college;
//    private Career career;
//
//    private List<TenantProfile> listTenantProfile = null;
//
//    @InjectMocks
//    private TenantProfileServiceImpl tenantProfileService;
//
//    @BeforeEach
//    public void SetUp() {
//        MockitoAnnotations.initMocks(this);
//        List<String> hobbies = new ArrayList<>();
//        hobbies.add("Painting");
//        hobbies.add("Reading");
//        tenantProfile = new TenantProfile("varshu@gmail.com", "Varshini", 25, "Chennai", "9876543210", FEMALE, "TamilNadu", hobbies, "Doctor", "Bike rides", questionaire, school, college, career,null);
//        List<String> lang = new ArrayList<>();
//        lang.add("Tamil");
//        lang.add("English");
//        questionaire = new Questionaire(lang, "Veg", "No", "married");
//        school = new School("MSJ", "+2", true);
//        college = new College("SRM", "b.tech", true);
//        career = new Career("TCS", "Engineer", "developer", "2");
//
//        listTenantProfile = new ArrayList<>();
//        listTenantProfile.add(tenantProfile);
//        optional = Optional.of(tenantProfile);
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
//    public void givenProfileToSaveReturnSavedProfileSuccess() throws TenantProfileAlreadyExistsException, IOException {
//        when(tenantProfileRepository.findById(tenantProfile.getEmail())).thenReturn(Optional.ofNullable(null));
//        when(tenantProfileRepository.insert(tenantProfile)).thenReturn(tenantProfile);
//
//        TenantProfile profile = tenantProfileService.registerProfile(tenantProfile);
//        assertEquals(tenantProfile, profile);
//        verify(tenantProfileRepository,times(1)).insert(tenantProfile);
//        verify(tenantProfileRepository,times(1)).findById(tenantProfile.getEmail());
//    }
//
//    @Test
//    public void givenProfileToSaveReturnSaveProfileFailure() throws TenantProfileAlreadyExistsException {
//        when(tenantProfileRepository.findById(tenantProfile.getEmail())).thenReturn(Optional.ofNullable(tenantProfile));
//        assertThrows(TenantProfileAlreadyExistsException.class,()->tenantProfileService.registerProfile(tenantProfile));
//        verify(tenantProfileRepository,times(0)).insert(tenantProfile);
//        verify(tenantProfileRepository,times(1)).findById(tenantProfile.getEmail());
//    }
//
////    @Test
////    public void givenProfileToUpdateReturnUpdatedProfileSuccess() throws TenantProfileNotFoundException {
////        when(tenantProfileRepository.findById(tenantProfile.getEmail())).thenReturn(optional);
////        tenantProfile.setEmail("Updated");
////        TenantProfile profile = tenantProfileService.updateProfile(tenantProfile.getFullName(),tenantProfile.getEmail(),tenantProfile.getImage());
////        System.out.println("Profile" + profile.toString());
////        assertEquals(profile.getFullName(), "updated");
////        verify(tenantProfileRepository,times(1)).save(tenantProfile);
////        verify(tenantProfileRepository,times(1)).findById(tenantProfile.getEmail());
////    }
//
//    @Test
//    public void givenProfileToDeleteReturnSuccess() throws TenantProfileNotFoundException {
//        when(tenantProfileRepository.findById(tenantProfile.getEmail())).thenReturn(Optional.ofNullable(tenantProfile));
//        TenantProfile profile = tenantProfileService.deleteProfile(tenantProfile.getEmail());
//        assertEquals(profile.getEmail(), "deleted");
//        verify(tenantProfileRepository,times(1)).findById(tenantProfile.getEmail());
//        verify(tenantProfileRepository,times(1)).deleteById(tenantProfile.getEmail());
//    }
//
//    @Test
//    public void givenTestGetAllProfileSuccess() throws Exception {
//        when(tenantProfileRepository.findAll()).thenReturn(listTenantProfile);
//        List<TenantProfile> list = tenantProfileService.getAllProfiles();
//        assertEquals(list,listTenantProfile);
//        verify(tenantProfileRepository,times(1)).findAll();
//    }
//}
