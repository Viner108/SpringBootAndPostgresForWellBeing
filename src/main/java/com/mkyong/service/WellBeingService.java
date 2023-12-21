package com.mkyong.service;

import com.mkyong.model.Book;
import com.mkyong.model.UserHealth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mkyong.repository.UserHealthRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WellBeingService {
    @Autowired
    public UserHealthRepository repository;
    public UserHealth createDTO(UserHealth userHealth) throws Exception{
        return repository.save(userHealth);

    }
    public UserHealth  useOfTheDTO(String pressure, String headAche,Long userId){
        UserHealth userHealth=new UserHealth();
        return userHealth;
    }
    public List<UserHealth> findAll() {
        List<UserHealth> all = repository.findAll();
        return repository.findAll();
    }

    public Optional<UserHealth> findById(Long id) {
        return repository.findById(id);
    }


    public void deleteById(Long id) {
        List<UserHealth> all = repository.findAll();
        for (UserHealth userHealth : all) {
            if(userHealth.getUserId()==id){
                repository.deleteById(userHealth.getId());
            }
        }

    }

    public List<UserHealth> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }


}
