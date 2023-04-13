package com.example.makeawishproject.service;

import com.example.makeawishproject.repository.UserRepo;
import com.example.makeawishproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

    @Service
    public class UserService {
        @Autowired
        UserRepo userRepo;

        public void createNewUser(User u){
            userRepo.NewUser(u);
        }

        public Boolean validateLogin(String username, String user_password) {
            return userRepo.validateLogin(username,user_password);
        }


}
