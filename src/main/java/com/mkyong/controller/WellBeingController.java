package com.mkyong.controller;

import com.mkyong.model.UserHealth;
import com.mkyong.service.WellBeingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/android/")
public class WellBeingController{
    @Autowired
    private WellBeingService service;


//    @GetMapping("getDTO")
//    public DTO getAndroid(@RequestParam(name = "pressure") String pressure,
//                          @RequestParam(name = "headAche") String headAche) throws Exception {
//        DTO dto=service.useOfTheDTO(pressure,headAche);
//        return dto;
//    }

    @PostMapping("postDTO")
    public UserHealth postPlace(@RequestBody Body body) throws Exception {
        UserHealth dto=service.createDTO(body.pressure, body.headAche);
        return dto;
    }
    static class Body{
        public String pressure;
        public String headAche;
    }
}

