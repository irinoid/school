package hogwarts.school.service;

import hogwarts.school.exceptions.NotFoundException;
import hogwarts.school.model.Faculty;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<>();
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
        throw new NotFoundException();
    }

    public Faculty deleteFaculty(long id){

        if (faculties.containsKey(id)) {
            return faculties.remove(id);
        }
        throw new NotFoundException();
    }

    public Collection<Faculty> getAllFaculties() {
        return new HashSet<>(faculties.values());
    }

    public Collection<Faculty> getListSameColor(String color){
        return faculties.values()
                .stream()
                .filter(e -> e.getColor() == color)
                .collect(Collectors.toSet());
    }
}
