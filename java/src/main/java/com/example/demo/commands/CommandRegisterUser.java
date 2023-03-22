package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.UserService;
import com.example.demo.entities.User;


public class CommandRegisterUser implements ICommand
{
    private final UserService userService;

    public CommandRegisterUser(UserService userService)
    {
       this.userService = userService;
    }

    @Override
    public void invoke(List<String> tokens)
    {
       User user = userService.registerUser(tokens.get(1));

       System.out.println("User [id="+user.getId()+"]");
    }
}