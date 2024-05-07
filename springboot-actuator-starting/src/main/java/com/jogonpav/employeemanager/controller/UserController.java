package com.jogonpav.employeemanager.controller;

import com.jogonpav.employeemanager.model.User;
import com.jogonpav.employeemanager.repository.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserDatabase database;

    @GetMapping("/load-user")
    public List<User> getUser(){
        return database.getAllUser();
    }
}
