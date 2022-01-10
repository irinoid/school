package hogwarts.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@SpringBootApplication
public class SchoolApplication {
    public ArrayList<Faculty> listFaculty = new ArrayList<>();
    public ArrayList<Student> listStudent = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);



    }

    @PostConstruct
    public void init() {
        listFaculty.add(new Faculty(1L, "Gryffindor", "Scarlet and gold"));
        listFaculty.add(new Faculty(2L, "Slytherin", "Green and silver"));
        listFaculty.add(new Faculty(3L, "Ravenclaw", "Blue and bronze"));

        listStudent.add(new Student(1L, "Garry Potter", 7));
        listStudent.add(new Student(2L, "Ron Weasley", 7));
        listStudent.add(new Student(3L, "Germiona Granger", 7));
        System.out.println(listFaculty.toString());
        System.out.println(listStudent.toString());

    }

}
