package com.mkyong.service;

import com.mkyong.model.UserHealth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mkyong.repository.UserHealthRepository;

import java.util.UUID;

@Service
public class WellBeingService {
    @Autowired
    public UserHealthRepository userHealthRepository;
    public UserHealth createDTO(String pressure, String headAche) throws Exception{
        UserHealth userHealth=new UserHealth();
        userHealth.setId(String.valueOf(UUID.randomUUID()));
        userHealth.setPressure(pressure);
        userHealth.setHeadAche(headAche);
        userHealthRepository.save(userHealth);
        return userHealth;
    }


}
