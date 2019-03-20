package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.JoinEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoinEventRepository extends JpaRepository<JoinEvent,Long>{
}
