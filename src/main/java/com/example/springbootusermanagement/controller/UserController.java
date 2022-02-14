package com.example.springbootusermanagement.controller;
import com.example.springbootusermanagement.dao.UserRepository;
import com.example.springbootusermanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;


    //create user
    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        return userRepository.createUser(user);
    }

    //edit user
    @RequestMapping(value = "/users",method = RequestMethod.PUT)
    public User editUser(@RequestBody User user){
        return userRepository.editUser(user);
    }

    //search user by id
    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public User searchUserById(@PathVariable int id){
        return userRepository.searchUser(id);
    }

    // delete user
    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id){
        userRepository.deleteUser(id);

    }

    //view users
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<User> viewUsers(){
        return userRepository.viewUser();
    }
}
