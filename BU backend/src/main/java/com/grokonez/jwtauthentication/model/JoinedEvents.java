package com.grokonez.jwtauthentication.model;

import com.sun.istack.internal.NotNull;

import  javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="joinedEvents")

public class JoinedEvents {
    @Id
    private Long memberid;

    @NotNull
    private Long eventid;


    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public Long getEventid() {
        return eventid;
    }

    public void setEventid(Long eventid) {
        this.eventid = eventid;
    }
}