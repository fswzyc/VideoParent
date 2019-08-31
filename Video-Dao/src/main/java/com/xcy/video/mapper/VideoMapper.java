package com.xcy.video.mapper;



import com.xcy.video.pojo.Video;
import com.xcy.video.pojo.VideoQueryVo;

import java.util.List;

public interface VideoMapper {
    List<Video> selectAll(VideoQueryVo videoQueryVo);
    int delete(int id);
    void batchDeleteVideos(VideoQueryVo videoQueryVo);

    void saveVideo(Video video);

    Video getVideoById(int id);

    void updateVideoById(Video video);

    List<Video> selectVideoListByCourseId(int id);

    Video showVideo(int videoId);

    List<Video> showVideoList(int id);
}
