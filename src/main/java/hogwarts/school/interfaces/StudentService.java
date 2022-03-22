package hogwarts.school.interfaces;

import hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentService {
    Student addStudent(Student student);
    Student findStudent(long id);
    Student editStudent(Student student);
    void deleteStudent(long id);
    Collection<Student> getAllStudents();
    Collection<Student> getListSameAge(int age);
    Collection<Student> findByAgeBetween(int minAge, int maxAge);
    Integer getAmountOfStudents();
    Integer averageStudentsAge();
    Collection<Student> fiveLastStudents();
}
