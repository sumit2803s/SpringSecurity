package com.friday.SpringSecurity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.friday.SpringSecurity.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

    private List<Student> students=new ArrayList<>(List.of(
            new Student(1,"Steve",85),new Student(
                    2,"Tony",95)));
    @GetMapping("/Students")
    public List<Student> getStudents()
    {
          return students;
    }
    @GetMapping("/csrf-token")
    public CsrfToken grtcsrftoken(HttpServletRequest request){
    return (CsrfToken) request.getAttribute("_csrf");
    }
    @PostMapping("/Students")
    public Student addstudent(@RequestBody Student student )
    {
        students.add(student);
        return student;
    }
}
