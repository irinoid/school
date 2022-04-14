package hogwarts.school.controller;

import hogwarts.school.exceptions.BadRequestException;
import hogwarts.school.interfaces.StudentService;
import hogwarts.school.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public Student getStudentInfo(@PathVariable long id) {

        Student student = studentService.findStudent(id);
        if (student == null) {
            throw new BadRequestException();
        }
        return student;
    }

    @GetMapping
    public Collection<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/filter/sameage")
    public Collection<Student> getStudentSameAge(@RequestParam int age) {
        return studentService.getListSameAge(age);
    }

    @GetMapping("/filter/agebetween")
    public Collection<Student> findByAgeBetween(@RequestParam int minAge, @RequestParam int maxAge) {
        return studentService.findByAgeBetween(minAge, maxAge);
    }
    @GetMapping("/avgage")
    public Integer getAverageAge() {
        return studentService.findAverageAge();
    }

    @GetMapping("/firstletter/{letter}")
    public Collection<Student> findByLetter(@PathVariable String letter) {
        return studentService.findByLetter(letter);
    }
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping
    public Student editStudent(@RequestBody Student student) {
        Student editStudent = studentService.editStudent(student);
        if (editStudent == null) {
            throw new BadRequestException();
        }
        return editStudent;
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}
