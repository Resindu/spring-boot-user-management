package com.example.springbootusermanagement.dao;

import com.example.springbootusermanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepository{

    private static final String CREATE_USER_QUERY="INSERT INTO user(Id,FirstName,LastName,Email) values(?,?,?,?)";
    private static final String EDIT_USER_QUERY="UPDATE user SET FirstName=? WHERE Id=?";
    private static final String SEARCH_USER_BY_ID_QUERY="SELECT * FROM user WHERE Id=?";
    private static final String DELETE_USER_BY_ID_QUERY="DELETE FROM user WHERE Id=?";
    private static final String VIEW_USERS_QUERY="SELECT * FROM user";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User createUser(User user) {
        jdbcTemplate.update(CREATE_USER_QUERY,user.getId(),user.getFirstName(),user.getLastName(),user.getEmail());
        return user;

    }

    @Override
    public void deleteUser(int id) {

        jdbcTemplate.update(DELETE_USER_BY_ID_QUERY,id);
    }

    @Override
    public User editUser(User user) {
        jdbcTemplate.update(EDIT_USER_QUERY, user.getFirstName(),user.getId());
        return user;
    }

    @Override
    public User searchUser(int id) {
        return jdbcTemplate.queryForObject(SEARCH_USER_BY_ID_QUERY,(rs, rowNum) -> {
            return new User(rs.getInt("Id"),rs.getString("FirstName"), rs.getString("LastName"),rs.getString("Email") );
        },id);
    }

    @Override
    public List<User> viewUser() {
        return jdbcTemplate.query(VIEW_USERS_QUERY,(rs, rowNum) -> {
            return new User(rs.getInt("Id"),rs.getString("FirstName"), rs.getString("LastName"),rs.getString("Email") );
        });
    }
}
