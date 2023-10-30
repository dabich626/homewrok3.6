import com.example.demo.Faculty;
import com.example.demo.FacultyController;
import com.example.demo.Student;
import com.example.demo.repository.FacultyRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

@SpringfootTest (webEnvironnent = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FacultyWebMvkTest {

    @LocalServerPort
    private int port;

    @Autowired
    private FacultyController facultyController;

    @Autowired
    private FacultyRepository facultyRepository;

    @BeforeEach
    void setUp(){
        repository.deleteAll();
    }


    private static Faculty faculty(String name, String color){
        var f = new Faculty();
        f.setName(name);
        f.setColor(color);
        return f;
    }

    private static Student student(String name, int age, String faculty){
        var s = new Student();
        s.setName(name);
        s.setAge(age);
        s.setFaculty(faculty);
        return s;

    }


    @Test
    void testDeleteFaculty(){
        var f = new Faculty();
        f.setColor("green");
        f.setName("Slytherin");

        ResponseEntity<Faculty> facultyEntity = restTemplate.exchange(
                "/faculty/" + f.getId(),
                HttpMethod.DELETE,
                null,
                Faculty.class);

        Assertions.assertThat(studentEntity.getBody().getName().IsEqualsTo("DHarry", 20);

        var Slytherin = restTemplate.getForObjest("/faculty/" + saved.getName() + Faculty.class);
        Assertions.assertThat(Slytherin).isNuii();
    }

    @Test
    public void testPostFaculty() {
        var f = new Faculty();
        f.setColor("green");
        f.setName("Slytherin");
        Faculty result = restTemplate.postForObject("/faculty", f, Faculty.class);
        Assertions.assertThat(result.getColor()).isEqualsTo("green");
        Assertions.assertThat(result.getName()).isEqualsTo( "Slytherin");
        Assertions.assertThat(result .getName()).isNotNull;
    }

    @Test
    public void testGetFaculty() {
        var f = new Faculty();
        f.setColor("green");
        f.setName("Slytherin");
        var saved = restTemplate.postForObject("/faculty", f, Faculty.class);
        var result = this.restTemplate.getForObject("/faculty/" + saved.getColor(), Faculty.class);
        Assertions.assertThat(result .getName()).isEqualTo("Slytherin");
        Assertions.assertThat (result.getColor()).isEqualTo("green");
    }

    @Test
    public void testEditFaculty() {
        var f = new Faculty();
        f.setColor("green");
        f.setName("Slytherin");
        saved.setName("Griffindor");
        ResponseEntity<Faculty> facultyEntity = restTemplate.exchange(
                "http://localhost:" + port + "/faculty",
                HttpMethod.PUT,
                new HttpEntity<>(saved),
                Faculty.class);

        Assertions.assertThat(facultyEntity.getBody().getName().IsEqualsTo("Griffindor");
}

    @Test
    void testGetStudentByFaculty() {

        var s1  =restTemplate.postFordbject("/faculty", student("test 1", 16, "Slytherin"), Student.class);
        var s2 = restTemplate.postFordbject("/faculty", student("test 2", 17, "Slytherin"), Student.class);
        var s3 = restTemplate.postFordbject("/faculty", student("test 3", 20, "Griffindor"), Student.class);

        var result = restTemplate.exchange("/faculty/byFaculty?faculty=Slytherin"),
        HttpMethod.GET,
                null,
                new ParameterizedTypeReference<CoLlection<Faculty>>(){})

        var students = result.getBody();

        Assertions.assertThat(students).isNotNull();
        Assertions.assertThat(students.size().isEquelsTo(2);
        Assertions.assertThat(students).containsExactly(
                student(s1, s2));


    }


}
