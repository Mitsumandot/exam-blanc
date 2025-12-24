package com.example.exam.dao.repositories;

import com.example.exam.dao.entities.Conference;
import com.example.exam.dao.entities.Session;
import com.example.exam.dao.entities.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {


    List<Conference> findBySpeaker(Speaker speaker);
    List<Conference> findBySession(Session session);
}
