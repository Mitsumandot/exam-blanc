package com.example.exam.dao.repositories;

import com.example.exam.dao.entities.Commentaire;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

}
