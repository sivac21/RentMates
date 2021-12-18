package com.stackroute.userservice.service;

import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.model.User;

public interface UserService {

    User saveUser(User user) throws UserAlreadyExistsException;
    User findUserByEmailId (String email) throws UserNotFoundException;
    boolean validateUser (User user) throws UserNotFoundException;
}
