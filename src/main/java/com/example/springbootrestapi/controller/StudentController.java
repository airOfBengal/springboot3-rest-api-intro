package com.example.springbootrestapi.controller;

import com.example.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(
                1,
                "Atiq",
                "Rony"
        );
        return student;
    }

    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Atiq", "Rony"));
        students.add(new Student(2, "Rony", "Ripu"));
        return  students;
    }

    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student getStudentPathVariable(@PathVariable("id") int id,
                                          @PathVariable("first-name") String firstName,
                                          @PathVariable("last-name") String lastName){
        return new Student(id, firstName, lastName);
    }

    @GetMapping("students/query")
    public Student getStudentRequestParam(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName){
        return new Student(id, firstName,lastName);
    }

    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student);
        return student;
    }
}
