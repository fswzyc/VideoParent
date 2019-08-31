package com.xcy.video.controller;

import com.xcy.video.pojo.Course;
import com.xcy.video.pojo.Speaker;
import com.xcy.video.pojo.Subject;
import com.xcy.video.pojo.Video;
import com.xcy.video.service.CourseService;
import com.xcy.video.service.SpeakerService;
import com.xcy.video.service.SubjectService;
import com.xcy.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/course")
public class BeforeSubject {

    @Autowired
    SubjectService subjectService;
    @Autowired
    CourseService courseService;
    @Autowired
    VideoService videoService;
    @Autowired
    SpeakerService speakerService;
    @RequestMapping("/course.action")
    public String selectSubjectById(Model model,int subjectId){
        Subject subject = subjectService.selectSubjectById(subjectId);
        List<Course> courseList = courseService.selectCouseBySubjectId(subjectId);
        subject.setCourseList(courseList);
        for (Course course : courseList) {
                List<Video> videoList = videoService.selectVideoListByCourseId(course.getId());
                course.setVideoList(videoList);
        }
        model.addAttribute("subject",subject);
        return "before/course";
    }

    @RequestMapping("/showVideo.action")
    public String showVideo (Model model,int videoId,String subjectName){
        Video video = videoService.showVideo(videoId);
        model.addAttribute("video",video);

        Speaker speaker = speakerService.showSpeaker(videoId);
        model.addAttribute("speaker",speaker);

        Course course = courseService.showCourse(videoId);
        model.addAttribute("course",course);
        int id = course.getId();

        List<Video> videoList = videoService.showVideoList(id);
        model.addAttribute("videoList",videoList);

        model.addAttribute("subjectName",subjectName);

        return "before/section";
    }
}
