package com.xcy.video.service.impl;

import com.github.pagehelper.PageHelper;

import com.xcy.video.mapper.VideoMapper;
import com.xcy.video.pojo.Video;
import com.xcy.video.pojo.VideoQueryVo;
import com.xcy.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoMapper mapper;
    public List<Video> selectAll(VideoQueryVo videoQueryVo, int page, int pageSize) {

        PageHelper.startPage(page,pageSize);
        List<Video> videos = mapper.selectAll(videoQueryVo);

        return videos;
    }

    public void delete(int id) {

        mapper.delete(id);

}

    public void batchDeleteVideos(Integer[] ids) {

        VideoQueryVo videoQueryVo = new VideoQueryVo();
        List<Integer> integers = Arrays.asList(ids);
        videoQueryVo.setIdList(integers);
        mapper.batchDeleteVideos(videoQueryVo);

    }

    public void saveVideo(Video video) {

        if (video.getId() != 0){
            mapper.updateVideoById(video);
        }else {
            mapper.saveVideo(video);

        }

    }

    public Video getVideoById(int id) {

        Video video = mapper.getVideoById(id);
        return video;
    }

    public List<Video> selectVideoListByCourseId(int id) {
         List<Video> videoList = mapper.selectVideoListByCourseId(id);
        return videoList;
    }

    public Video showVideo(int videoId) {
        Video video = mapper.showVideo(videoId);
        return video;
    }

    public List<Video> showVideoList(int id) {
        List<Video> videoList = mapper.showVideoList(id);
        return videoList;
    }
}