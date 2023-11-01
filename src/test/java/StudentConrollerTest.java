import com.example.demo.FacultyService;
import com.example.demo.StudentController;
import com.example.demo.StudentService;
import com.example.demo.repository.AvatarRepository;
import com.example.demo.repository.FacultyRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

@WebMvkTest

public class StudentConrollerTest {

    @Autowired
    MockMvk mockMvk;

    @MockBean
    StudentRepository studentRepository;

    @MockBean
    FacultyRepository facultyRepository;

    @MockBean
    AvatarRepository avatarRepository;

    @SpyBean
    StudentService studentService;

    @SpyBean
    FacultyService facultyService;

    @SpyBean
    AvatarService avatarService;

    @InjectMocks
    StudentController studentController;
    @Test
    public void saveStudentTest() throws Exception {
        final Long id = 1L;
        final String name = "Harry";

        JS0NObject stidentObject = new JSONObject();
        studentObject.put("name", name);

        Student student = new Student();
        student. setId(id);
        student.setName(name) ;

        mhen(studentRepository.save(any(Student.class))).thenReturn(student) ;
        when(studentRepository.FindById(any(Long.class))).thenReturn(Optional.of(student));

        mockHvc.perform(MockHvcRequestBuilders
                .post("/student")
                .content(studentObject.tostring())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATTON_JSON))
                .andExpect(status().is0k())
                .andExpect(jsonPath("$.id").value(id))
                        .andExpect(jsonPath("$.name").value(name));

        mockHvc.perform(HOGkHVEREquestBuiLderS
                .get("/student/4"
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is0k())
                .andExpect(jsonPath("$.id") .value(id))
                .andExpect(jsonPath("$.nane").value(name));

        stidentObject.put("id", id);
        mockHvc.perform(MockHvcRequestBuilders
                .put("/student")
                .content(stidentObject.toString())
                .contentType(MediaType.APPLICATION_JSON))
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().is0k())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(name));}

        @Test

        public void findStudentTest() throws Exception {
            final Long id = 2L;
            final String name = "ron"ж



                    JsONObject StUdeMtObHect = new JsONODject();
            studentObject.put("name",name);

            Student student = new Student();
            student.setId(id);
            student.setName(name);

            when(studentRepository.save(any(Student.class))).thenReturn(student); ;
            when(studentRepository.findById(any(Long.class))).thenReturn (Optional.of(student)) ;

            mockHvc.perform(MockHvcRequestBuilders
                    .delete("/student/2")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().is0k()) ;}



            @Test
            void testGetStudent() throws Exception {

                Long id = 1L;
                String name = "Harry";
                int age = 182;

                Student student = student(id, name, age);

                when(studentRepository.save(any(Student.class))).thenReturn(student) ;
                when(studentRepository.findById(any(Long.class))).thenReturn(Optional.of(student));

                mockMvc.perform(MockMvcRequest Builders
                        .get("/student/1")
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().is0k())
                        .andExpect(jsonPath("$.id").value(id))
                        .andExpect(jsonPath(("$.id").value(name))
                        .andExpect (jsonPath("$ age").value(age));
}}
