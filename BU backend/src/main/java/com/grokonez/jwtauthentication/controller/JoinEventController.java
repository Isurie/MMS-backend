package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.model.JoinEvent;
import com.grokonez.jwtauthentication.repository.JoinEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class JoinEventController {

    @Autowired
    JoinEventRepository joinEventRepository;

    @PostMapping("/joinevent")
    public JoinEvent createEventJoin(@Valid @RequestBody JoinEvent joinEventobj){
        return joinEventRepository.save(joinEventobj);
    }

}
