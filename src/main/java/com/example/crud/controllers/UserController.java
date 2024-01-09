package com.example.crud.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.model.User;
// import com.example.crud.service.UserService;
import com.example.crud.service.UserServiceImpl;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody User user) {
        try {
            userServiceImpl.createUser(user);
            Map<String,User> res=new HashMap<>();
            res.put("user",user);
            return new ResponseEntity<>(res,HttpStatus.OK);
        } catch (Exception e) {
            User error_User=new User();
            System.out.println(e.getMessage());
            return new ResponseEntity<>(error_User,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAll")
    @ResponseBody
    public ResponseEntity<?> getAllUsers() {

        try {
            Collection<User> users=userServiceImpl.getAllUsers();
            Map<String,Collection<User> > res=new HashMap<>();
            res.put("users",users);
;           return new ResponseEntity<>(res,HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long userId) {
        try {
            userServiceImpl.deleteUser(userId);
            Map<String,String> res=new HashMap<>();
            res.put("message","user deletd successfully");
            return new ResponseEntity<>(res,HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getUser(@PathVariable("id") Long userId) {
        try {
            User user=userServiceImpl.getUserById(userId);
            Map<String,User> res=new HashMap<>();
            res.put("users",user);
            return new ResponseEntity<>(res,HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> updateUser(@PathVariable("id") Long userId,@RequestBody User user) {

        try {
            User updatedUser=userServiceImpl.updateUser(userId,user);
            Map<String,User> res=new HashMap<>();
            res.put("user",updatedUser);
;           return new ResponseEntity<>(res,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 
}
