package com.xcy.video.controller;


import com.xcy.video.pojo.Course;
import com.xcy.video.pojo.Subject;
import com.xcy.video.service.CourseService;
import com.xcy.video.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CourseManage {
    @Autowired
    CourseService courseService;
    @RequestMapping("/coursemanage")
    public String e(Model model,Course course) {

        course.setBegin((course.getPage() - 1) * course.getRows() );
        List<Course> course1 = courseService.selectAll(course);
        Page<Course> page = new Page<Course>();
        page.setPage(course.getPage());
        page.setSize(course.getRows());
        page.setTotal(courseService.getCount(course));
        page.setRows(course1);
        model.addAttribute("page",page);

        List<Course> courses = courseService.selectAllCourse();
        model.addAttribute("course",courses);
        return "behind/coursemanage";
    }

    @RequestMapping("/deleteCourse")
    public String delete(int id){
        courseService.deleteCourse(id);
        return "redirect:/coursemanage";
    }

    @RequestMapping("/addcourse")
    public String f(Model model) {
        List<Subject> subjectList = courseService.selectAllSubject();
        model.addAttribute("subjectList",subjectList);
        return "behind/addcourse";
    }

    @RequestMapping("/updateCourse")
    public String updateCourse(int id,Model model){
        Course course = courseService.updateCourseById(id);
        model.addAttribute("course",course);

        List<Subject> subjectList = courseService.selectAllSubject();
        model.addAttribute("subjectList",subjectList);
        return "behind/addcourse";
    }

    @RequestMapping("saveCourse")
    public String saveCourse(Course course){
        courseService.saveCourse(course);


        return "redirect:/coursemanage";
    }

}