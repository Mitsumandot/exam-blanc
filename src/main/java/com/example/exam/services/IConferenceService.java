package com.example.exam.services;

import com.example.exam.DTO.ConferenceDTO;
import com.example.exam.dao.entities.Conference;
import com.example.exam.dao.entities.Speaker;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IConferenceService {

    Conference addConference(Conference conference);
    List<Conference> getBySpeaker(Speaker speaker);
    ConferenceDTO conferenceToDto(Conference conference);
    Conference dtoToConference(ConferenceDTO conferenceDTO);
}
