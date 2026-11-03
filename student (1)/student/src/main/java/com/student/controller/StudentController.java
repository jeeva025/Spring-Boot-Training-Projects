package com.student.controller;

import com.student.model.Student;
import com.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students/")

public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public Student getById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @PutMapping("{id}")
    public Student updateStudent(@PathVariable int id,@Valid @RequestBody Student request){
        return studentService.updateStudent(id, request);
    }

    @DeleteMapping("{id}")
    public String deleteById(@PathVariable int id){
        return studentService.deleteById(id);
    }
}
