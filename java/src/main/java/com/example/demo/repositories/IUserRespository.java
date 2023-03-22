package com.example.demo.repositories;

import java.util.List;
import com.example.demo.entities.User;
import java.util.Optional;

public interface IUserRespository {

    public void saveUser(User user);
    public Optional<User> getUserById(int id);
    public void deleteUser(int id);
    public List<User> getAllUsers();

    
}
