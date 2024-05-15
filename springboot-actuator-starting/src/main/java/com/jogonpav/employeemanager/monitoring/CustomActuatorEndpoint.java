package com.jogonpav.employeemanager.monitoring;

import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Endpoint(id = "custom")
@Component
public class CustomActuatorEndpoint {

    @ReadOperation
    public Map<String, String> customEndpoint (String username){
        Map<String, String> map = new HashMap<>();
        map.put("key","value");
        map.put("username",username);
        return map;
    }

    @WriteOperation
    public String helloNameBody(@Selector String name) {
        //In this part is to add or save the data in a repository.
        return "Hello " + name;
    }

    @WriteOperation
    public String helloNameBody(String name, String lastName) {
        //In this part is to add or save the data in a repository.
        return "Hello " + name +" " + lastName;
    }

    @DeleteOperation
    public String goodbyeNameParam(String name) {
        return "Goodbye " + name;
    }

    @DeleteOperation
    public String goodbyeNameSelector(@Selector String name) {
        return "Goodbye " + name;
    }
}
