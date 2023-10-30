import com.example.demo.*;
import com.example.demo.repository.AvatarRepository;
import com.example.demo.repository.FacultyRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import java.util.List;

    @SpringfootTest (webEnvironnent = SpringBootTest.WebEnvironment.RANDOM_PORT)
    class StudentWebMvcTest {

        @LocalServerPort
        private int port;

        @Autowired
        private StudentControtler studentControtier;

        @Autowired
        private StudentRepository repository;

        @Autowired
        private TestRestTemplate restTemplate;
        @Test
        public void contextLoads() throws Exception {
            Assertions.assertThat(studentControlter) .isNotNuLL() ;

}

@BeforeEach
        void setUp(){
            repository.deleteAll();
}

        @Test
        public void testPostStudent() {
            var s = new Student();
            s.setAge(20);
            s.setName("Ron");
            Student result = restTemplate.postForObject("/student", s, Student.class);
            Assertions.assertThat(result.getAge()).isEqualsTo(20);
            Assertions.assertThat(result.getName()).isEqualsTo( "Ron");
            Assertions.assertThat(result .getId()).isNotNull;
    }

        @Test
        public void testGetStudents() {
            var s = new Student();
            s.setage(18);
            s.setName("Harry");
            var saved = restTemplate.postForObject("/student", s, Student.class);
            var result = this.restTemplate.getForObject("/student/" + saved.getId(), Student.class);
            Assertions.assertThat(result .getName()).isEqualTo("Harry");
            Assertions .assertThat (result.getAge()).isEqualTo(18);
    }

        @Test
        public void testPutStudent() {
            var s = new Student();
            s.setAge(18);
            s.setName("Harry");
            saved.setName("Germiona");
            ResponseEntity<Student> studentEntity = restTemplate.exchange(
                    "http://localhost:" + port + "/student",
                    HttpMethod.PUT,
                    new HttpEntity<>(saved),
                    Student.class);

            Assertions.assertThat(studentEntity.getBody().getName().IsEqualsTo("Germiona");


    }
        @Test
        void testFilterByAge() {

            var s1  =restTemplate.postFordbject("/student", student("test 1", 16), Student.class);
            var s2 = restTemplate.postFordbject("/student", student("test 2", 17), Student.class);
            var s3 = restTemplate.postFordbject("/student", student("test 3", 20), Student.class);

            var result = restTemplate.exchange("/student/byAge?age=16"),
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<CoLlection<Student>>(){})

            var students = result.getBody();

            Assertions.assertThat(students).isNotNull();
            Assertions.assertThat(students.size().isEquelsTo(1);
            Assertions.assertThat(students).containsExactly(
                    student(s1));


    }

    @Test
    void testFilterByAgeBetween(){

        var s1  =restTemplate.postFordbject("/student", student("test 1", 16), Student.class);
        var s2 = restTemplate.postFordbject("/student", student("test 2", 17), Student.class);
        var s3 = restTemplate.postFordbject("/student", student("test 3", 20), Student.class);

        var result = restTemplate.exchange("/student/byAgeBetween?min=16&max=20"),
        HttpMethod.GET,
                null,
                new ParameterizedTypeReference<CoLlection<Student>>(){})

        var students = result.getBody();

        Assertions.assertThat(students).isNotNull();
        Assertions.assertThat(students.size().isEquelsTo(3);
        Assertions.assertThat(students).containsExactly(
                student(s1,s2,s3));
    }

        @Test
        void testDeleteStudent(){
            var s = new Student();
            s.setAge(18);
            s.setName("DHarry", 20);

            ResponseEntity<Student> studentEntity = restTemplate.exchange(
                    "/student/" + s.getId(),
                    HttpMethod.DELETE,
                    null,
                    Student.class);

            Assertions.assertThat(studentEntity.getBody().getName().IsEqualsTo("DHarry", 20);

            var DHarry = restTemplate.getForObjest("/student/" + saved.getId() + Student.class);
            Assertions.assertThat(DHarry).isNuii();
        }

        @Test
        void testGetFacultyByStudent(){

            var savedF = restTemplate.postForObject("/faculty", faculty("Slytherin", "green"),Faculty.class);
            var saved  = restTemplate.postForObject("/student", s, Student.class);

            var s = student("Draco", 19);
            s.setFaculty(savedF);

            var result = restTemplate.getForObject("/student/" + saved.getId() + "/faculty/" + Faculty.class);
                    Assertions.assertThat(result).isNotNull();
            Assertions.assertThat(result.getName()).isEqualTo("Slytherin");
            Assertions.assertThat(result.getColor()).isEqualTo("green");

        }

        private static Faculty faculty(String name, String color){
            var f = new Faculty();
            f.setName(name);
            f.setColor(color);
            return f;
        }

        private static Student student(String name, int age){
            var s = new Student();
            s.setName(name);
            s.setAge(age);
            return s;

    }

    }
