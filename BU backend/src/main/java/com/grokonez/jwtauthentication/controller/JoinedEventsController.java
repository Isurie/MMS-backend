package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.model.EventCreation;
import com.grokonez.jwtauthentication.model.JoinedEvents;
import com.grokonez.jwtauthentication.repository.JoinedEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class JoinedEventsController {
    @Autowired
    JoinedEventsRepository joinedEventsRepository;


    @GetMapping("/joinedevents")
    public List<JoinedEvents> getAlljoinedEvents(){return joinedEventsRepository.findAll();}

    @GetMapping("/joinedevents/{id}")
    public List<EventCreation> getjoinedevents(@PathVariable("id") Long id){
        return joinedEventsRepository.JoinedEvents(id);
    }}
