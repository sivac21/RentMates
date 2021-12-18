package com.stackroute.userservice.repository;

import com.stackroute.userservice.enums.UserRole;
import com.stackroute.userservice.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    private User user;

    @BeforeEach
    void setUp(){
        user = new User();
        user.setEmail("siva@gmail.com");
        user.setPassword("SIvaa!12");
        user.setUserRole(UserRole.TENANT);
    }



    @Test
    public void givenUserToSaveShouldReturnSavedUser(){
        userRepository.save(user);
        User user1 = userRepository.findById(user.getEmail()).get();
        assertEquals("siva@gmail.com", user1.getEmail(), user1.getEmail());
    }


    @Test
    public void givenEmailThenShouldReturnRespectiveUser(){
        User user = new User("dhairyash0011@gmail.com","Dheee!12",UserRole.OWNER);
        User user1 = userRepository.save(user);
        Optional<User> optional = userRepository.findById(user1.getEmail());
        assertEquals(user1.getEmail(),optional.get().getEmail());
        assertEquals(user1.getUserRole(),optional.get().getUserRole());
    }


}
