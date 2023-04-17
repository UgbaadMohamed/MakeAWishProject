package com.example.makeawishproject.service;

import com.example.makeawishproject.repository.UserRepo;
import com.example.makeawishproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
    public class UserService {
        @Autowired
        UserRepo userRepo;

        public void createNewUser(User u){
            userRepo.createNewUser(u);
        }

        public Boolean validateLogin(String username, String user_password) {
            return userRepo.validateLogin(username, user_password);
        }

        public int getUser_id(String username, String user_password){
            return userRepo.getUser_id(username, user_password);
        }


}
