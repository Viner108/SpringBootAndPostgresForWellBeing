package com.mkyong.controller;

import com.fasterxml.uuid.Generators;
import com.mkyong.model.UserHealth;
import com.mkyong.service.WellBeingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/android")
public class WellBeingController {
    @Autowired
    private WellBeingService service;


    @GetMapping("getDTO")
    public UserHealth getDTO(@RequestParam(name = "pressure") String pressure,
                             @RequestParam(name = "headAche") String headAche,
                             @RequestParam(name = "id") Long userId,
                             @RequestParam(name = "date") LocalDate date) throws Exception {
        UserHealth dto = service.useOfTheDTO(pressure, headAche, userId, date);
        return dto;
    }

    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping("postDTO")
    public UserHealth postDTO(@RequestBody UserHealthDto body) throws Exception {
        UserHealth userHealth = getUserHealth(body);
        return service.createDTO(userHealth);
    }

    @GetMapping
    public List<UserHealth> findAll() {
        return service.findAll();
    }

    @GetMapping("getById/{id}")
    public Optional<UserHealth> findById(@RequestParam(name = "id") Long id) {
        return service.findById(id);
    }

    @PutMapping("putUpdateTable")
    public UserHealth update(@RequestBody UserHealthDto body) throws Exception {
        UserHealth userHealth = getUserHealth(body);
        return service.createDTO(userHealth);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("findByUserId/{id}")
    public List<UserHealth> findByUserId(@PathVariable Long id) {
        return service.findByUserId(id);
    }

    @GetMapping("findByDate/{beforedate1}/{date2}")
    public List<UserHealth> findByDate(
            @PathVariable @DateTimeFormat(pattern = "yyyy.MM.dd") LocalDate beforedate1,
            @PathVariable @DateTimeFormat(pattern = "yyyy.MM.dd") LocalDate date2) {
        return service.findByDate(beforedate1, date2);
    }

    static class UserHealthDto {
        public Long userId;
        public String pressure;
        public String headAche;
        public String date;
    }

    public UserHealth getUserHealth(UserHealthDto body) {
        UserHealth userHealth = new UserHealth();
        userHealth.setId(Generators.timeBasedGenerator().generate().node());
        userHealth.setUserId(body.userId);
        userHealth.setPressure(body.pressure);
        userHealth.setHeadAche(body.headAche);
        DateTimeFormatter format= DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate localDate=LocalDate.parse(body.date,format);
        userHealth.setDate(localDate);
        return userHealth;
    }
}

