package hogwarts.school.service;

import hogwarts.school.model.Faculty;
import hogwarts.school.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final Map<Long, Student> students = new HashMap<>();

    private long lastId = 0;

    public Student addStudent(Student student) {
        student.setId(++lastId);
        students.put(lastId, student);
        return student;
    }

    public Student findStudent(long id) {
        return students.get(id);
    }

    public Student editStudent(Student student) {
        if (students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }
        throw new NotFoundException("такого студента не существует");
    }

    public Student deleteStudent(long id) {
        if (students.containsKey(id)) {
        return students.remove(id);
        }
        throw new NotFoundException("такого студента не существует");
    }

    public Collection<Student> getAllStudents() {
        return new HashSet<>(students.values());
    }

    public Collection<Student> getListSameAge(int age) {
        return students.values()
                .stream()
                .filter(e -> e.getAge() == age)
                .collect(Collectors.toSet());
    }
}
