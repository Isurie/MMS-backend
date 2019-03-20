package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.model.ReportRequest;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.ReportRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ReportRequestController {

    @Autowired
    ReportRequestRepository reportRequestRepository;

    @GetMapping("/reportrequest")
    public List<ReportRequest> getAllReportRequests(){return reportRequestRepository.findAll();}

    @PostMapping("/reportrequestcreate")
    public ReportRequest createRequest(@Valid @RequestBody ReportRequest reportRequstObj){
        return reportRequestRepository.save(reportRequstObj);
    }
//    @GetMapping(value = "memberreport/memberid/{memberid}")
//    public List<ReportRequest> findByMemberid(@PathVariable Long memberid) {
//
//        List<ReportRequest> reportRequests = reportRequestRepository.findByMemberid(memberid);
//        return reportRequests;
//    }

}
