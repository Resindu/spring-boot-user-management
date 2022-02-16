package com.example.springbootusermanagement.controller;
import com.example.springbootusermanagement.dao.UserRepository;
import com.example.springbootusermanagement.entity.User;
import com.example.springbootusermanagement.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    //create user
    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        logger.error("user created");
        return userService.createUser(user);
    }

    //edit user
    @RequestMapping(value = "/users",method = RequestMethod.PUT)
    public User editUser(@RequestBody User user) throws  Exception{
        logger.trace("user edited");
        return userService.editUser(user);
    }

    //search user by id
    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public User searchUserById(@PathVariable int id) throws  Exception{
        logger.trace("user found");
        return userService.searchUser(id);
    }

    // delete user
    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id) throws  Exception{
        userService.deleteUser(id);
        logger.trace("user deleted");

    }

    //view users
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<User> viewUsers(){
        logger.trace("users viewed");
        return userService.viewUser();
    }
}
