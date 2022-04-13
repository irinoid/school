package hogwarts.school.service;

import hogwarts.school.exceptions.BadRequestException;
import hogwarts.school.interfaces.StudentService;
import hogwarts.school.model.Student;
import hogwarts.school.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        logger.info("Was invoked method to add student");
        return studentRepository.save(student);
    }

    @Override
    public Student findStudent(long id) {
        logger.info("Was invoked method to find {} student", id);
        return studentRepository.findById(id).get();
    }

    @Override
    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Collection<Student> getListSameAge(int age) {
        return studentRepository.findByAge(age);
    }

    @Override
    public Collection<Student> findByAgeBetween(int minAge, int maxAge) {
        if (minAge <= maxAge) {
            return studentRepository.findByAgeBetween(minAge, maxAge);
        }
        throw new BadRequestException();
    }

    @Override
    public Integer getAmountOfStudents(){
        return studentRepository.getAmountOfStudents();
    }

    @Override
    public Integer averageStudentsAge(){
        return studentRepository.averageStudentsAge();
    }

    @Override
    public Collection<Student> fiveLastStudents(){
        return studentRepository.fiveLastStudents();
    }
}
