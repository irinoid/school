package hogwarts.school.service;

import hogwarts.school.interfaces.FacultyService;
import hogwarts.school.model.Faculty;
import hogwarts.school.repositories.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
    @Override
    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
    @Override
    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).get();
    }
    @Override
    public Faculty editFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
    @Override
    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }
    @Override
    public Collection<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }
    @Override
    public Collection<Faculty> findByColor(String color) {
        return facultyRepository.findByColor(color);
    }
}
