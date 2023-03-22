package com.example.demo.repositories;

import java.util.HashMap;
import com.example.demo.entities.User;
import java.util.Optional;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;

public class UserRepository implements IUserRespository {

    private static HashMap<Integer,User> repository = new HashMap<>();

    @Override
    public void saveUser(User user)
    {
        repository.put(user.getId(),user);
    }


    @Override
    public Optional<User> getUserById(int id)
    { 
        Optional<User> user = Optional.ofNullable(repository.get(id));
        return user;
    }

    @Override
    public void deleteUser(int id)
    {
        repository.remove(id);
    }

    @Override
    public List<User> getAllUsers()
    {
      List<User> users = new LinkedList<>();

      for(Map.Entry<Integer,User> entry:repository.entrySet())
      {
        users.add(entry.getValue());
      }

      return users;
    }
    
}
