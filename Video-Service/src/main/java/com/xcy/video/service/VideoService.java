package com.xcy.video.service;


import com.xcy.video.pojo.Video;
import com.xcy.video.pojo.VideoQueryVo;

import java.util.List;

public interface VideoService {
    List<Video> selectAll(VideoQueryVo videoQueryVo, int page, int pageSize);

    void delete(int id);

    void batchDeleteVideos(Integer[] ids);

    void saveVideo(Video video);

    Video getVideoById(int id);

    List<Video> selectVideoListByCourseId(int id);

    Video showVideo(int videoId);

    List<Video> showVideoList(int id);
}
