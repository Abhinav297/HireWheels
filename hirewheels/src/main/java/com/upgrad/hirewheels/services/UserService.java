package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.User;
import com.upgrad.hirewheels.exceptions.UserAlreadyExistsException;

public interface UserService {
    public User createUser(User user)throws UserAlreadyExistsException;
    public User getUser(String emailId, String password) throws Exception;
}
