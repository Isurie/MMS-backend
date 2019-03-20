package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.model.AdminRequest;
import com.grokonez.jwtauthentication.repository.AdminRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminRequestController {
    @Autowired
    AdminRequestRepository adminRequestRepository;

    @PostMapping("/adminrequest")
    public AdminRequest createEventJoin(@Valid @RequestBody AdminRequest joinEventobj){
        return adminRequestRepository.save(joinEventobj);
    }

}
