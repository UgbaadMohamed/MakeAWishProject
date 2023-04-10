package com.example.makeawishproject.Respository;
import com.example.makeawishproject.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {
    @Autowired
    JdbcTemplate template;

    public void NewUser(UserModel u) {
        String sql = "INSERT INTO user (user_id, first_name, last_name, address, username, user_password) VALUES (?, ?, ?, ?, ?, ?)";
        template.update(sql, u.getUser_id(), u.getFirst_name(), u.getLast_name(), u.getAddress(), u.getUsername(), u.getUser_password());
    }




    //TODO:validate the password is not done...

}


