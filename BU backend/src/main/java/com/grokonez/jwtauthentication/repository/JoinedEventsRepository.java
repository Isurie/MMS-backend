package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.JoinedEvents;
import com.grokonez.jwtauthentication.model.JoinEvent;
import com.grokonez.jwtauthentication.model.EventCreation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JoinedEventsRepository extends JpaRepository<JoinedEvents,Long>{


@Query("SELECT e FROM  EventCreation e  where eventid IN (SELECT c FROM JoinEvent c WHERE c.memberid= :id)")
List<EventCreation> JoinedEvents(@Param("id") long id);
}
