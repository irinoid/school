package hogwarts.school.service;

import hogwarts.school.model.Faculty;
import hogwarts.school.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final HashMap<Long, Faculty> faculties = new HashMap<>();
    private long lastId = 0;

    public Faculty addFaculty(Faculty faculty) {
        faculty.setId(++lastId);
        faculties.put(lastId, faculty);
        return faculty;
    }

    public Faculty findFaculty(long id){
        return faculties.get(id);
    }

    public Faculty editFaculty(Faculty faculty){
        if (faculties.containsKey(faculty.getId())) {
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }

    public Faculty deleteFaculty(long id){

        if (faculties.containsKey(id)) {
            return faculties.remove(id);
        }
        return null;
    }

    public Collection<Faculty> getAllFaculties() {
        return faculties.values();
    }

    public Collection<Faculty> getListSameColor(String color){
        return faculties.values()
                .stream()
                .filter(e -> e.getColor() == color)
                .collect(Collectors.toList());
    }
}
