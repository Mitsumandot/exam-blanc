package com.example.exam.services;

import com.example.exam.DTO.ConferenceDTO;
import com.example.exam.dao.entities.Conference;
import com.example.exam.dao.entities.Session;
import com.example.exam.dao.entities.Speaker;
import com.example.exam.dao.repositories.ConferenceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConferenceService implements IConferenceService {

    private final ConferenceRepository conferenceRepository;
    private final ModelMapper modelMapper;


    public ConferenceService(ConferenceRepository conferenceRepository,
                             ModelMapper modelMapper){
        this.conferenceRepository = conferenceRepository;
        this.modelMapper = modelMapper;
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

    public Conference dtoToConference(ConferenceDTO conferenceDTO){
        return modelMapper.map(conferenceDTO, Conference.class);
    }

    public ConferenceDTO conferenceToDto(Conference conference){
        return modelMapper.map(conference, ConferenceDTO.class);
    }


}
