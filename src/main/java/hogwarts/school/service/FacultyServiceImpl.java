package hogwarts.school.service;

import hogwarts.school.interfaces.FacultyService;
import hogwarts.school.model.Faculty;
import hogwarts.school.repositories.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

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
    @Override
    public String getLongestName(){
        Faculty longestName = facultyRepository.findAll().stream()
                .parallel()
                .max(Comparator.comparingInt(e -> e.getName().length()))
                .get();
        return longestName.getName();
    }
    @Override
    public int findIntSum(){
        int intSum = Stream
                .iterate(1, a -> a +1)
                .limit(1_000_000)
                .parallel()
                .reduce(0, (a, b) -> a + b);

        return intSum;
    }
    @Override
    public List<Faculty> findByNameIgnoreCase(String name) {
        return facultyRepository.findByNameIgnoreCase(name);
    }
}
