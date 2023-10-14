package repository;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<ru.hogwarts.school.model.Faculty,long> {

    Collection<ru.hogwarts.school.model.Student> findAllByColor(String color);

    Collection<ru.hogwarts.school.model.Student> findAllByNameOrColorIgnoreCase(String color, String name);

    


}
