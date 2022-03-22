package hogwarts.school;

import hogwarts.school.controller.StudentController;
import hogwarts.school.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class StudentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    StudentController studentController;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void loadController() throws Exception {
        Assertions.assertNotNull(studentController);
    }

    @Test
    public void returnStudentInfo() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setName("Mirtl");
        Assertions
                .assertNotNull(this.testRestTemplate
                        .getForObject("http://localhost:" + port + "/students/" + student.getId(), String.class));
    }

    @Test
    public void returnStudentSameAge() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setName("Mirtl");
        student.setAge(10);
        Assertions
                .assertNotNull(this.testRestTemplate
                        .getForObject("http://localhost:" + port + "/students/filter/?age=" + student.getAge(), String.class));
    }

    @Test
    public void returnStudentsAgeBetween() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setName("Mirtl");
        student.setAge(10);

        Student student1 = new Student();
        student1.setId(2L);
        student1.setName("Mirtl1");
        student1.setAge(15);

        Student student2 = new Student();
        student2.setId(3L);
        student2.setName("Mirtl2");
        student2.setAge(5);


        Assertions
                .assertNotNull(this.testRestTemplate.getForObject("http://localhost:" + port + "/students/filter/?minAge=7?maxAge=12", String.class));
    }


}

