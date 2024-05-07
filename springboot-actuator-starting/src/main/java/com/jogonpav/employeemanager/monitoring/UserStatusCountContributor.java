package com.jogonpav.employeemanager.monitoring;

import com.jogonpav.employeemanager.repository.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserStatusCountContributor implements InfoContributor {
    @Autowired
    private UserDatabase userDatabase;

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Long> userStatusMap = new HashMap<>();
        userStatusMap.put("active", userDatabase.getUserStatusCountByStatus("active"));
        userStatusMap.put("inactive", userDatabase.getUserStatusCountByStatus("inactive"));
        builder.withDetail("userStatus",userStatusMap);
    }
}
