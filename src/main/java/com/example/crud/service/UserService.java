package com.example.crud.service;

import java.util.Collection;

import com.example.crud.model.User;

public interface UserService {
    public abstract void createUser(User user) throws Exception;
    public abstract User updateUser(long id,User user);
    public abstract void deleteUser(long id) throws Exception;
    public abstract Collection<User> getAllUsers();
    public abstract User getUserById(long id);
}
