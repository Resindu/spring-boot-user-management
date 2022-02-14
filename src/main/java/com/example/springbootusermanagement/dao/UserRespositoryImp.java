package com.example.springbootusermanagement.dao;

import com.example.springbootusermanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserRespositoryImp implements UserRepository{

    private static final String CREATE_USER_QUERY="INSERT INTO user(id,fname,lname,email) values(?,?,?,?)";
    private static final String EDIT_USER_QUERY="UPDATE user SET fname=? WHERE id=?";
    private static final String SEARCH_USER_BY_ID_QUERY="SELECT * FROM user WHERE id=?";
    private static final String DELETE_USER_BY_ID_QUERY="DELETE FROM user WHERE id=?";
    private static final String VIEW_USERS_QUERY="SELECT * FROM user";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User createUser(User user) {
        jdbcTemplate.update(CREATE_USER_QUERY,user.getId(),user.getFname(),user.getLname(),user.getEmail());
        return user;

    }

    @Override
    public void deleteUser(int id) {
        jdbcTemplate.update(DELETE_USER_BY_ID_QUERY,id);
    }

    @Override
    public User editUser(User user) {
        jdbcTemplate.update(EDIT_USER_QUERY, user.getFname(),user.getId());
        return user;
    }

    @Override
    public User searchUser(int id) {
        return jdbcTemplate.queryForObject(SEARCH_USER_BY_ID_QUERY,(rs, rowNum) -> {
            return new User(rs.getInt("id"),rs.getString("fname"), rs.getString("lname"),rs.getString("email") );
        },id);
    }

    @Override
    public List<User> viewUser() {
        return jdbcTemplate.query(VIEW_USERS_QUERY,(rs, rowNum) -> {
            return new User(rs.getInt("id"),rs.getString("fname"), rs.getString("lname"),rs.getString("email") );
        });
    }
}
