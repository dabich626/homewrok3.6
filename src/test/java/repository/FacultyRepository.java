package repository;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<ru.hogwarts.school.model.Faculty,long> {

    Collection<ru.hogwarts.school.model.Faculty> findAllByColor(String color);

    Collection<ru.hogwarts.school.model.Faculty> findAllByNameOrColorIgnoreCase(String color, String name);



}
