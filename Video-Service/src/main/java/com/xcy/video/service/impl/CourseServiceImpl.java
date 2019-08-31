package com.xcy.video.service.impl;


import com.xcy.video.mapper.CourseMapper;
import com.xcy.video.pojo.Course;
import com.xcy.video.pojo.Subject;
import com.xcy.video.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper mapper;
    public List<Course> selectAllCourse() {

        List<Course> courseList = mapper.selectAllCourse();
        return courseList;
    }



    public Course updateCourseById(int id) {

        Course course = mapper.updateCourseById(id);
        return course;

    }

    public List<Course> selectCouseBySubjectId(int subjectId) {
        List<Course> courseList = mapper.selectCouseBySubjectId(subjectId);
        return courseList;
    }

    public Course showCourse(int videoId) {
        Course course = mapper.showCourse(videoId);
        return course;
    }

    public List<Course> selectAll(Course course) {
        List<Course> courseList = mapper.selectAll(course);
        return courseList;
    }

    public int getCount(Course course) {
        return mapper.getCount(course);

    }


    public List<Subject> selectAllSubject() {

         List<Subject> subjectList = mapper.selectAllSubject();
         return subjectList;
    }

    public void deleteCourse(int id) {

        mapper.deleteCourse(id);

    }

    public void saveCourse(Course course) {

        System.out.println(course);
        if(course.getId()!= 0){
            mapper.updateCourse(course);
        }else{
            mapper.saveCourse(course);

        }

    }


}
