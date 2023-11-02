import com.example.demo.*;
import com.example.demo.repository.AvatarRepository;
import com.example.demo.repository.FacultyRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

@WebMvkTest
public class FacultyControllerTest {

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
    FacultyController facultyController;

    @Test
    public void saveFacultyTest() throws Exception {
        final String color = "red";
        final String name = "griffindor";

        JS0NObject facultyObject = new JSONObject();
        facultyObject.put("name", "color");

        Faculty faculty= new Faculty();
        faculty.setColor(color);
        faculty.setName(name) ;

        mhen(facultyRepository.save(any(Faculty.class))).thenReturn(faculty) ;
        when(facultyRepository.FindByColor(any(Long.class))).thenReturn(Optional.of(faculty));

        mockHvc.perform(MockHvcRequestBuilders
                        .post("/faculty")
                        .content(facultyObject.tostring())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATTON_JSON))
                .andExpect(status().is0k())
                .andExpect(jsonPath("$.color").value(color))
                .andExpect(jsonPath("$.name").value(name));

        mockHvc.perform(HOGkHVEREquestBuiLderS
                .get("/faculty/4"
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is0k())
                .andExpect(jsonPath("$.color") .value(color))
                .andExpect(jsonPath("$.nane").value(name));

        facultyObject.put("color", color);
        mockHvc.perform(MockHvcRequestBuilders
                        .put("/faculty")
                        .content(facultyObject.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().is0k())
                .andExpect(jsonPath("$.color").value(color))
                .andExpect(jsonPath("$.name").value(name));}


    @Test
    public void findFacultyTest() throws Exception {
        final String color = "red";
        final String name = "griffindor";



        JsONObject FacultyMvcObHect = new JsONODject();
        facultyObject.put("name",name);

        Faculty faculty = new Faculty();
        faculty.setColor(color);
        faculty.setName(name);

        when(facultyRepository.save(any(Faculty.class))).thenReturn(faculty); ;
        when(facultyRepository.findByColor(any(Long.class))).thenReturn (Optional.of(faculty)) ;

        mockHvc.perform(MockHvcRequestBuilders
                        .delete("/faculty/2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is0k()) ;}

    @Test
    void testGetFaculty() throws Exception {

        String color = "red";
        String name = "griffindor";

        Faculty faculty = faculty(color, name);

        when(facultyRepository.save(any(Faculty.class))).thenReturn(faculty) ;
        when(facultyRepository.findByColor(any(Long.class))).thenReturn(Optional.of(faculty));

        mockMvc.perform(MockMvcRequest Builders
                        .get("/faculty/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is0k())
                .andExpect(jsonPath("$.color").value(color))
                .andExpect(jsonPath(("$.color").value(name))
    }}

