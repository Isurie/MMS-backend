package com.grokonez.jwtauthentication.model;

import  javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="joinEvent")

public class JoinEvent {

    @Id
    private Long memberid;

    @NotBlank
    private String eventid;


    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public String getEventid() {
        return eventid;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }
}
