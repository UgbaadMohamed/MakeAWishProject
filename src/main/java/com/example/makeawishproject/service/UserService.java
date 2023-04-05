package com.example.makeawishproject.service;
import com.example.makeawishproject.respository.UserRepo;
import com.example.makeawishproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public void createNewUser(User u){
        userRepo.NewUser(u);
    }

    public User validateLogin(String username,String user_password) {
        return userRepo.valdiateLogin(username,user_password);
    }


}