package com.example.springbootusermanagement.service;

import com.example.springbootusermanagement.dao.UserRepository;
import com.example.springbootusermanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(@RequestBody User user){
        return userRepository.createUser(user);

    }

    public User editUser(@RequestBody User user){
        return userRepository.editUser(user);
    }

    public User searchUser(int id){
        return userRepository.searchUser(id);
    }
    public void deleteUser(int id){
        userRepository.deleteUser(id);

    }
    public List<User> viewUser(){
        return userRepository.viewUser();
    }

}
