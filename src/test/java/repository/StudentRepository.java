package repository;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepository;

import java.util.Collection;


public interface StudentRepository extends JpaRepository<ru.hogwarts.school.model.Student,long> {

    Collection<ru.hogwarts.school.model.Student> findByAge(int age);
}
