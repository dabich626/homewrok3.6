package com.example.demo;

import java.util.Collection;

import org.springframework.stereotype.Service;
import repository.FacultyRepository;

@Service
public class FacultyService {

    public FacultyService(FacultyRepository repository) {
        this.repository = repository;
    }

    private final FacultyRepository repository;

    public Faculty addFaculty(Faculty faculty) {
        Faculty saved = repository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        return repository.findById(id).orElse(null);
    }

    public Faculty editFaculty(Faculty faculty) {

        repository.findById(faculty.getId())
                .map(
                        entity ->
                        {
                            entity.setColor(faculty.getColor());
                            entity.setName(faculty.getName());
                            return repository.save(entity);


                        }
                ).orElse(null);
    }

    public void  deleteFaculty(long id) {
        return repository.deleteById(id).orElse(null);
    }


    public Collection‹Faculty› findByColor(String color) {

        return repository.findAllByColor(color)

}

public Collection<Faculty> filterByNameOrColor(String name, String color){

        return repository.findAllByNameOrColorIgnoreCase(name, color); 
}

    public Faculty findAllStudentsById(long id){
        return repository.findAllStudentsById;
    }

    public Faculty getFaculty(long id) {

        var studentTemporary = repository.findById(id).orElseThrow(() -> new StudentNotFoundException);

        return studentTemporary.getFaculty();

    }

}