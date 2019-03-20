package com.grokonez.jwtauthentication.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import  javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ReportRequest")


public class ReportRequest {

    @Id
    private Long memberid;

    @NotBlank
    private String datetime;


    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
