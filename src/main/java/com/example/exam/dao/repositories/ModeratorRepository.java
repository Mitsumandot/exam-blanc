package com.example.exam.dao.repositories;

import com.example.exam.dao.entities.Moderator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeratorRepository extends JpaRepository<Moderator, Long> {
}
