package com.example.demo;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public Student getStudentInfo(@PathVariable Long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            return Student.notFound().build();
        }
        return Student.ok(student);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping
    public Student editStudent(@RequestBody Student student, @PathVariable long id) {
        Student foundStudent = studentService.editStudent(student);
        if (foundStudent == null) {
            return Student.status(HttpStatus.BAD_REQUEST).build();
        }
        return Student.ok(foundStudent);
    }

    @DeleteMapping("{id}")
    public Student deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return Student.ok().build();
    }


    @GetMapping
    public Student findStudents(@RequestParam(required = false) int age) {
        if (age › 0) {
            return Student.ok(studentService.findByAge(age));
        }
        return Student.ok(Collections.emptyList());
    }

    @GetMapping ("/byAgeBetween")
    public Collection<Student> byAgeBetween(@RequestParam int min, @RequestParam int max){

        return service.filteredByAgeBetween(min, max);
    }

}
