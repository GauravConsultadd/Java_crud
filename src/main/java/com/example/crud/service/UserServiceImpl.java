package com.example.crud.service;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.crud.model.User;
import com.example.crud.repository.UserRespository;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserRespository userRespository;

    public UserServiceImpl(UserRespository userRespository) {
        this.userRespository=userRespository;
    }

    @Override
    public void createUser(User user) throws Exception {
        userRespository.save(user);
    }

    @Override
    public User updateUser(long id,User user) {
        User existingUser = userRespository.findById(id).get();
        if(user.getFirstName()!=null) existingUser.setFirstName(user.getFirstName());
        if(user.getLastName()!=null) existingUser.setLastName(user.getLastName());
        if(user.getUsername()!=null) existingUser.setUsername(user.getUsername());

        User updatedUser = userRespository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(long id) throws Exception {
        User user_1=userRespository.getReferenceById(id);
        if(user_1==null) throw new Exception("User not exists");
        userRespository.deleteById(id);
    }

    @Override
    public User getUserById(long id) {
        User user=userRespository.findById(id).get();
        return user;
    }

    @Override
    public Collection<User> getAllUsers() {
        return userRespository.findAll();
    }
}
