package com.grokonez.jwtauthentication.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="eventcreation")
public class EventCreation {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventid;
@NotBlank
    private String eventname;
@NotBlank
    private String venue;
@NotBlank
    private String date;
@NotBlank
    private String starttime;
@NotBlank
    private String endtime;
@NotBlank
    private String eventfee;

    public Integer getEventid() {
        return eventid;
    }

    public void setEventid(Integer eventid) {
        this.eventid = eventid;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getEventfee() {
        return eventfee;
    }

    public void setEventfee(String eventfee) {
        this.eventfee = eventfee;
    }


}
