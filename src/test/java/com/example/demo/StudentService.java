package ru.hogwarts.school.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import repository.FacultyRepository;
import repository.StudentRepository;
import ru.hogwarts.school.model.Student;

@Service
public class StudentService {

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    private final StudentRepository repository;

    public StudentRepository addStudent(Student student) {
        Student saved = repository.save(student);
    }

    public Student findStudent(int age) {
        return repository.findByAge(age).orElse(null);
    }

    public Student editStudent(Student student) {

        repository.findByAge(student.getAge())
                .map(
                        entity ->
                        {
                            entity.setColor(student.getAge());
                            entity.setName(student.getName());
                            return repository.save(entity);


                        }
                ).orElse(null);
    }

    public void  deleteStudent(int age) {
        return repository.deleteByAge(age).orElse(null);
    }


    public Collection‹Student› findByAge(int age) {
        return repository.findByAge(age);
    }
}
