package com.example.exam.services;

import com.example.exam.dao.entities.Conference;
import com.example.exam.dao.entities.Speaker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IConferenceService {

    Conference addConference(Conference conference);
    List<Conference> getBySpeaker(Speaker speaker);
}
