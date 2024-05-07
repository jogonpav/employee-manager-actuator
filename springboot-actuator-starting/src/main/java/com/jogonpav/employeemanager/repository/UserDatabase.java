package com.jogonpav.employeemanager.repository;

import com.jogonpav.employeemanager.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class UserDatabase {

    public List<User> getAllUser(){
        return Stream.of(
                new User(108,"jhon", "jhon@email.com", "inactive"),
                new User(109,"Enber", "Enber@email.com", "inactive"),
                new User(101,"Petter", "Petter@email.com", "active"),
                new User(102,"Mary", "Mary@email.com", "inactive"),
                new User(100,"Andry", "Andry@email.com", "active")
        ).collect(Collectors.toList());
    }

    public long getUserStatusCountByStatus(String status) {
        return getAllUser().stream().filter(user -> user.getStatus().equals(status)).count();
    }

}
