package hogwarts.school.service;

import hogwarts.school.exceptions.BadRequestException;
import hogwarts.school.interfaces.StudentService;
import hogwarts.school.model.Student;
import hogwarts.school.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

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
    public Student findStudent(Long id) {
        logger.info("Was invoked method to find {} student", id);
        return studentRepository.findById(id).get();
    }

    @Override
    public void getListStudentThread1() {
        printStudent(1L);
        printStudent(2L);

        new Thread(() -> {
            printStudent(3L);
            printStudent(4L);
        }).start();

        new Thread(() -> {
            printStudent(5L);
            printStudent(6L);
        }).start();
    }

    private void printStudent(Long id){
        System.out.println(studentRepository.findById(id).toString());
    }

    @Override
    public void getListStudentThread2() {
        printStudent2(1L);
        printStudent2(2L);

        new Thread(() -> {
            printStudent2(3L);
            printStudent2(4L);
        }).start();

        new Thread(() -> {
            printStudent2(5L);
            printStudent2(6L);
        }).start();
    }

    private void printStudent2(Long id){
        synchronized (id){
        System.out.println(studentRepository.findById(id).toString());}
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
    public Collection<Student> findByLetter(String letter) {
        return studentRepository.findAllByNameStartsWith(letter).stream()
                .parallel()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }
    @Override
    public Integer findAverageAge(){
        return studentRepository.averageStudentsAge();
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

}
