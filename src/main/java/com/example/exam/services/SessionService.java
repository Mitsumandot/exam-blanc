package com.example.exam.services;

import com.example.exam.dao.entities.Session;
import com.example.exam.dao.repositories.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }

    public Session addSession(Session session){
        return sessionRepository.save(session);
    }

    public List<Session> getAllSession(){
        return sessionRepository.findAll();
    }

    public Optional<Session> getSessionById(Long id){
        return sessionRepository.findById(id);
    }

    public Session deleteSession(Session session){
        sessionRepository.delete(session);
        return session;
    }

}
