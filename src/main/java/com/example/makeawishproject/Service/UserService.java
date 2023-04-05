package com.example.makeawishproject.Service;
import com.example.makeawishproject.Respository.UserRepo;
import com.example.makeawishproject.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public void NewUser(UserModel u){
        userRepo.NewUser(u);
    }

}