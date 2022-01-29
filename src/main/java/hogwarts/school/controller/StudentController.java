package hogwarts.school.controller;

import hogwarts.school.exceptions.BadRequestException;
import hogwarts.school.exceptions.NotFoundException;
import hogwarts.school.model.Student;
import hogwarts.school.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public Student getStudentInfo(@PathVariable long id){

        Student student = studentService.findStudent(id);
        if (student == null){
            throw new BadRequestException();
        }
        return student;
    }
    @GetMapping
    public Collection<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/filter/{age}")
    public Collection<Student> getStudentSameAge(@PathVariable int age){
        return studentService.getListSameAge(age);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping
    public Student editStudent(@RequestBody Student student){
        Student editStudent = studentService.editStudent(student);
        if (editStudent == null){
            throw new BadRequestException();
        }
        return editStudent;
    }

    @DeleteMapping("{id}")
    public Student deleteStudent(@PathVariable long id){
        Student student = studentService.deleteStudent(id);
        if (student == null){
            throw new NotFoundException();
        }
        return student;
    }
}
