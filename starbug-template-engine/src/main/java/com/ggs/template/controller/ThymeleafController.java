package com.ggs.template.controller;

import com.ggs.template.po.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author lianghaohui
 * @Date 2022/2/25 9:39
 * @Description
 */
@RestController
public class ThymeleafController {

    @GetMapping("/getStudents")
    public ModelAndView getStudent() {
        List<Student> students = new LinkedList<>();
        Student student = new Student();
        student.setId(1);
        student.setName("全栈学习笔记");
        student.setAge(21);
        Student student1 = new Student();
        student1.setId(2);
        student1.setName("张三");
        student1.setAge(22);
        students.add(student);
        students.add(student1);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", students);
        modelAndView.setViewName("students");
        return modelAndView;
    }

}
