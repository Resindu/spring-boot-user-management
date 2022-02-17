package com.example.springbootusermanagement.service;

import com.example.springbootusermanagement.dao.UserRepository;
import com.example.springbootusermanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(@RequestBody User user){
        return userRepository.createUser(user);

    }

    public User editUser(@RequestBody User user) throws Exception{
        if(user == null || user.getId() == 0){
            throw new Exception("User or Id must not be null");
        }
        User existingUser = userRepository.searchUser(user.getId());
//        if(existingUser == null){
//            throw new Exception("User does not exist");
//        }
        existingUser.setId(user.getId());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return userRepository.editUser(existingUser);
    }

    public User searchUser(int id) throws Exception{
        return userRepository.searchUser(id);
    }
    public void deleteUser(int id) throws Exception{
        User usrsearch = userRepository.searchUser(id);
        if(usrsearch == null  && usrsearch.getId() ==0){
            throw new Exception("user doesnt exist");

        }
        userRepository.deleteUser(id);

    }
    public List<User> viewUser(){
        return userRepository.viewUser();
    }

}
