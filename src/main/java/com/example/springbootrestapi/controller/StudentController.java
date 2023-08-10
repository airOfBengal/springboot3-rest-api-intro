package com.example.springbootrestapi.controller;

import com.example.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                1,
                "Atiq",
                "Rony"
        );
        return ResponseEntity.ok(student);
    }

    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Atiq", "Rony"));
        students.add(new Student(2, "Rony", "Ripu"));
        return  ResponseEntity.ok(students);
    }

    @GetMapping("students/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> getStudentPathVariable(@PathVariable("id") int id,
                                          @PathVariable("first-name") String firstName,
                                          @PathVariable("last-name") String lastName){
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    @GetMapping("students/query")
    public ResponseEntity<Student> getStudentRequestParam(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName){
        Student student =  new Student(id, firstName,lastName);
        return ResponseEntity.ok(student);
    }

    @PostMapping("students/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("students/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int id){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("students/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id){
        return ResponseEntity.ok("Student with id " + id + " deleted successfully!");
    }
}
