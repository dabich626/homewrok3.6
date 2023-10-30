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
}
