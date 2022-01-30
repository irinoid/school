package hogwarts.school.interfaces;

import hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.List;

public interface FacultyService {
    Faculty addFaculty(Faculty faculty);
    Faculty findFaculty(long id);
    Faculty editFaculty(Faculty faculty);
    void deleteFaculty(long id);
    Collection<Faculty> getAllFaculties();
    List<Faculty> findByColor(String color);
    List<Faculty> findByNameIgnoreCase(String name);
}
