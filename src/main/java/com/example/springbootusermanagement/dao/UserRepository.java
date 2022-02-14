package com.example.springbootusermanagement.dao;

import com.example.springbootusermanagement.entity.User;

import java.util.List;

public interface UserRepository {
    User createUser(User user);

    void deleteUser(int id);

    User editUser(User user);

    User searchUser(int id);

    List<User> viewUser();
}
