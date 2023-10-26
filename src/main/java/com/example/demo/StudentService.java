package com.example.demo;

import java.util.Collection;

import org.springframework.stereotype.Service;
import repository.FacultyRepository;
import repository.StudentRepository;

@Service
public class StudentService {

    @Value("${avatars.dir.path}")
    private String avatarsDir;


    private final AvatarRepository aRepository;

    public StudentService(StudentRepository repository, AvatarRepository aRepository) {
        this.studentRepository = repository;
        this.avatarRepository = aRepository;
    }


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

    public Collection<Student> filteredByAgeBetween(int min, int max){

        return repository.findAllByAgeBetween(min, max);
    }

    public Avatar findAvatar(long studentId) {
        return aRepository.findByStudentId(studentId).orElseThrow();
    }

    public void uploadAvatar(Long studentId, MultipartFile file) throws IOException {
        Student student = findStudent(studentId);

        Path filePath = Path.of(avatarsDir, studentId + "." + getExtension(file.getOriginalFilename()));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);

        try (InputStream is = file.getInputStream();
             OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
             BufferedInputStream bis = new BufferedInputStream(is, 1024);
             BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
        ) {
            bis.transferTo(bos);
        }

        Avatar avatar = aRepository.findByStudentId(studentId).orElseGet(Avatar::new);
        avatar.setStudent(student);
        avatar.setFilePath(filePath.toString());
        avatar.setFileSize(file.getSize());
        avatar.setMediaType(file.getContentType());
        avatar.setData(file.getBytes());

        aRepository.save(avatar);
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}

