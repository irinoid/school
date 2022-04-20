package hogwarts.school.interfaces;

import hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student addStudent(Student student);
    Student findStudent(Long id);
    Student editStudent(Student student);
    void deleteStudent(long id);
    Collection<Student> getAllStudents();
    Collection<Student> getListSameAge(int age);
    Collection<Student> findByAgeBetween(int minAge, int maxAge);
    Collection<Student> findByLetter(String letter);
    Integer findAverageAge();
    void getListStudentThread1();
    void getListStudentThread2();
}
