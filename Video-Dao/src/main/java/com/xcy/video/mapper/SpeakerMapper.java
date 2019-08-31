package com.xcy.video.mapper;



import com.xcy.video.pojo.Speaker;

import java.util.List;

public interface SpeakerMapper {
    List<Speaker> selectAllSpeaker();

    void deleteSpeaker(int id);

    void addSpeaker(Speaker speaker);

    void updateSpeaker(Speaker speaker);

    Speaker getSpeakerById(int id);

    List<Speaker> selectAll(Speaker speaker);

    int getCount(Speaker speaker);

    Speaker showSpeaker(int videoId);
}
