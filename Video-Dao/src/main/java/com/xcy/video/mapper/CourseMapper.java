package com.xcy.video.mapper;



import com.xcy.video.pojo.Course;
import com.xcy.video.pojo.Subject;

import java.util.List;

public interface CourseMapper {

    List<Subject> selectAllSubject();

    void deleteCourse(int id);

    void saveCourse(Course course);

    List<Course> selectAllCourse();

    Course updateCourseById(int id);

    void updateCourse(Course course);

    List<Course> selectCouseBySubjectId(int subjectId);

    Course showCourse(int videoId);

    List<Course> selectAll(Course course);

    int getCount(Course course);
}
