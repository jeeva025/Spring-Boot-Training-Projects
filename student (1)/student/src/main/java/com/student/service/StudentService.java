package com.student.service;

import com.student.exception.StudentNotFoundException;
import com.student.model.Student;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    long id = 1l;
    List<Student> students = new ArrayList<>();

    public Student addStudent(@Valid Student request) {
        Student student = new Student(id++,
                request.getStudentName(),
                request.getCourseName(),
                request.getEmail(),
                request.getAge());

        students.add(student);
        return student;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(int id) {
        for (Student student : students){
            if (student.getStudentId() == id){
                return student;
            }
        }
        throw new StudentNotFoundException("Student Not Found");
    }

    public String deleteById(int id) {
        Student student = getStudentById(id);

        students.remove(student);
        return "Student removed";
    }

    public Student updateStudent(int id, @Valid Student request) {
        Student student = getStudentById(id);
        student.setStudentName(request.getStudentName());
        student.setCourseName(request.getCourseName());
        student.setEmail(request.getEmail());
        student.setAge(request.getAge());

        return student;
    }
}
