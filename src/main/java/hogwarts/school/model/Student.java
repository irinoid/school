package hogwarts.school.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int age;
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty studentFaculty;

    public Faculty getStudentFaculty() {
        return studentFaculty;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Student student1 = (Student) other;
        return id == student1.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return name;
    }
}
