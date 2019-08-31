package com.xcy.video.service;



import com.xcy.video.pojo.Speaker;

import java.util.List;

public interface SpeakerService {
    List<Speaker> selectAllSpeaker();

    void deleteSpeaker(int id);

    void addSpeaker(Speaker speaker);

    Speaker getSpeakerById(int id);

    List<Speaker> selectAll(Speaker speaker);

    int getCount(Speaker speaker);

    Speaker showSpeaker(int videoId);
}
