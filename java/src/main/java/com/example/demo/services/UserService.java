package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.IUserRespository;


public class UserService {

    private final IUserRespository userRespository;

    public UserService(IUserRespository userRespository)
    {
        this.userRespository = userRespository;
    }

    public User registerUser(String name)
    {
        User user = new User(name);
        userRespository.saveUser(user);
        return user;
    }

    
}
