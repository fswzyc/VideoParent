package com.xcy.video.service;



import com.xcy.video.pojo.Course;
import com.xcy.video.pojo.Subject;

import java.util.List;

public interface CourseService {
    List<Subject> selectAllSubject();

    void deleteCourse(int id);

    void saveCourse(Course course);


    List<Course> selectAllCourse();


    Course updateCourseById(int id);

    List<Course> selectCouseBySubjectId(int subjectId);


    Course showCourse(int videoId);

    List<Course> selectAll(Course course);

    int getCount(Course course);
}
