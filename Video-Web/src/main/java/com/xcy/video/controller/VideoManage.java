package com.xcy.video.controller;

import com.github.pagehelper.PageInfo;

import com.xcy.video.pojo.Course;
import com.xcy.video.pojo.Speaker;
import com.xcy.video.pojo.Video;
import com.xcy.video.pojo.VideoQueryVo;
import com.xcy.video.service.CourseService;
import com.xcy.video.service.SpeakerService;
import com.xcy.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class VideoManage {

    @Autowired
    VideoService videoService;
    @Autowired
    SpeakerService speakerService;
    @Autowired
    CourseService courseService;


    @RequestMapping("/videomanage")
    public String a(Model model, VideoQueryVo videoQueryVo,
                    @RequestParam(name = "page", defaultValue = "1", required = false) int page,
                    @RequestParam(name = "pageSize", defaultValue = "5", required = false) int pageSize) {

        List<Video> videos = videoService.selectAll(videoQueryVo, page, pageSize);
        model.addAttribute("list",videos);

        PageInfo<Video> pageInfo = new PageInfo<Video>(videos);
        model.addAttribute("pageInfo", pageInfo);

        List<Speaker> speakers = speakerService.selectAllSpeaker();
        model.addAttribute("list",speakers);

        List<Course> courses = courseService.selectAllCourse();
        model.addAttribute("course",courses);
        return "behind/videomanage";
    }


    @RequestMapping("/delete")
    public String delete(int id) {

        videoService.delete(id);

        return "redirect:/videomanage";
    }

    @RequestMapping("/delBatchVideos")
    public String delBatchVideos(Integer[] ids) {

        videoService.batchDeleteVideos(ids);
        return "redirect:/videomanage";
    }

    @RequestMapping("/addvideo")
    public String b(Model model) {
        List<Speaker> speakerList = speakerService.selectAllSpeaker();
        model.addAttribute("speakerList", speakerList);

        List<Course> courseList = courseService.selectAllCourse();
        model.addAttribute("courseList", courseList);

        return "behind/addvideo";
    }

    @RequestMapping("/saveVideo")
    public String saveVideo(Video video) {
        videoService.saveVideo(video);

        return "redirect:/videomanage";
    }

    @RequestMapping("/edit")
    public String showEdit(int id, Model model) {
        Video video = videoService.getVideoById(id);
        model.addAttribute("video", video);

        List<Speaker> speakerList = speakerService.selectAllSpeaker();
        model.addAttribute("speakerList", speakerList);

        List<Course> courseList = courseService.selectAllCourse();
        model.addAttribute("courseList", courseList);

        return "behind/addvideo";
    }
}