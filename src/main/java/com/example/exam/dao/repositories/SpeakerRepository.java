package com.example.exam.dao.repositories;

import com.example.exam.dao.entities.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
