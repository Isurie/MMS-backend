package com.grokonez.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.grokonez.jwtauthentication.model.AdminRequest;


@Repository
public interface AdminRequestRepository extends JpaRepository<AdminRequest,Integer> {

}
