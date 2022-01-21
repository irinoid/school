package hogwarts.school.controller;

import hogwarts.school.model.Faculty;
import hogwarts.school.model.Student;
import hogwarts.school.service.FacultyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("faculties")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService){
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public Faculty getFacultyInfo(@PathVariable long id){
        return facultyService.findFaculty(id);
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> getAllFaculties(){
        return ResponseEntity.ok(facultyService.getAllFaculties());
    }

    @GetMapping("filter/{color}")
    public ResponseEntity<Collection<Faculty>> getFacultiesSameColor(@PathVariable String color){
        return ResponseEntity.ok(facultyService.getListSameColor(color));
    }

    @PostMapping
    public Faculty addFaculty(@RequestBody Faculty faculty){
        return facultyService.addFaculty(faculty);
    }

    @PutMapping
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty){
        Faculty editFaculty = facultyService.editFaculty(faculty);
        if (editFaculty ==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(editFaculty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable long id){
        Faculty delFaculty = facultyService.deleteFaculty(id);
        if (delFaculty ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(delFaculty);
    }
}
