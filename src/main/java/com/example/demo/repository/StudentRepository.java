package com.example.demo.repository;

import com.example.demo.Student;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepository;

import java.util.Collection;


public interface StudentRepository extends JpaRepository<Student,long> {

    Collection<Student> findByAge(int age);

    Collection<Student> findAllByAgeBetween(int min, int max);

    @Query(value = "select count(*) from student", nativeQuery = true)
    long getStudentsCount();

    @Query(value = "select avg(age) from student", nativeQuery = true)
    double getAverageAge();

    @Query(value = "select * from student order by id desc limit 5", nativeQuery = true)
    Collection<Student> GetLastFiveStudents();
}
