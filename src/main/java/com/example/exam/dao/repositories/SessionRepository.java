package com.example.exam.dao.repositories;

import com.example.exam.dao.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
