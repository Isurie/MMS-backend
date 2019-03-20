package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.ReportRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRequestRepository extends JpaRepository<ReportRequest,Long>{

}
