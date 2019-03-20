package com.grokonez.jwtauthentication.controller;


import org.springframework.beans.factory.annotation.Autowired;
import com.grokonez.jwtauthentication.model.EventCreation;
import com.grokonez.jwtauthentication.repository.EventCreationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class EventCreationController {

    @Autowired
    EventCreationRepository eventCreationRepository;

    @GetMapping("/event")
    public List<EventCreation> getAllEvents() {
        return eventCreationRepository.findAll();
    }

    @PostMapping("/eventcreation")
    public EventCreation createEvent(@Valid @RequestBody EventCreation eventDataObj) {
        return eventCreationRepository.save(eventDataObj);
    }

    @DeleteMapping("/deleteevent/{eventid}")
    public ResponseEntity<String> deleteEvent(@PathVariable("eventid") int eventid) {
        System.out.println("Delete Customer with ID = " + eventid + "...");

        eventCreationRepository.deleteById(eventid);

        return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
    }

    @PutMapping("/updateevent/{eventid}")
    public ResponseEntity<Object> updateEvent(@RequestBody EventCreation eventCreation, @PathVariable int eventid) {
        Optional<EventCreation> eventCreationOptional = eventCreationRepository.findById(eventid);

        if (!eventCreationOptional.isPresent())
            return ResponseEntity.notFound().build();

        eventCreation.setEventid(eventid);
        eventCreationRepository.save(eventCreation);

        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "eventdetails/eventname/{eventname}")
    public List<EventCreation> findByEventname(@PathVariable String eventname) {
        List<EventCreation> events = eventCreationRepository.findByEventname(eventname);
        return events;
    }
    @GetMapping(value = "eventname/date/{date}")
    public List<EventCreation> findByDate(@PathVariable String date) {
        List<EventCreation> events = eventCreationRepository.findByDate(date);
        return events;
    }
}
