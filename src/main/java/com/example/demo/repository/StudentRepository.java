package com.example.demo.repository;

import com.example.demo.Student;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepository;

import java.util.Collection;


public interface StudentRepository extends JpaRepository<Student,long> {

    Collection<Student> findByAge(int age);

    Collection<Student> findAllByAgeBetween(int min, int max);
}
