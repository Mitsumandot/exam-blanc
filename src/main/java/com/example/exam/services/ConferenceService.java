package com.example.exam.services;

import com.example.exam.dao.entities.Conference;
import com.example.exam.dao.entities.Session;
import com.example.exam.dao.entities.Speaker;
import com.example.exam.dao.repositories.ConferenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConferenceService implements IConferenceService {

    private final ConferenceRepository conferenceRepository;


    public ConferenceService(ConferenceRepository conferenceRepository){
        this.conferenceRepository = conferenceRepository;
    }

    public Conference addConference(Conference conference){
        return conferenceRepository.save(conference);
    }

    public List<Conference> getBySpeaker(Speaker speaker){
        return conferenceRepository.findBySpeaker(speaker);

    }

    public List<Conference> getAll(){
        return conferenceRepository.findAll();
    }

    public List<Conference> getBySession(Session session){
        return conferenceRepository.findBySession(session);
    }
}
