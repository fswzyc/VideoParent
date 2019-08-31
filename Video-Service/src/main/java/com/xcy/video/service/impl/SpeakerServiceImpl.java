package com.xcy.video.service.impl;


import com.xcy.video.mapper.SpeakerMapper;
import com.xcy.video.pojo.Speaker;
import com.xcy.video.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
    SpeakerMapper mapper;
    public List<Speaker> selectAllSpeaker() {
        List<Speaker> speakersList = mapper.selectAllSpeaker();

        return speakersList;

    }

    public void deleteSpeaker(int id) {

        mapper.deleteSpeaker(id);

    }

    public void addSpeaker(Speaker speaker) {

        if(speaker.getId() != 0){
            mapper.updateSpeaker(speaker);
        }else{
            mapper.addSpeaker(speaker);
        }

    }

    public Speaker getSpeakerById(int id) {

        return mapper.getSpeakerById(id);
    }


    public List<Speaker> selectAll(Speaker speaker) {
        List<Speaker> speakerList = mapper.selectAll(speaker);
        return speakerList;
    }


    public int getCount(Speaker speaker) {
        return mapper.getCount(speaker);

    }

    public Speaker showSpeaker(int videoId) {
       Speaker speaker = mapper.showSpeaker(videoId);
        return speaker;
    }
}
