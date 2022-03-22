package hogwarts.school;

import hogwarts.school.controller.FacultyController;
import hogwarts.school.interfaces.FacultyService;
import hogwarts.school.model.Faculty;
import hogwarts.school.repositories.FacultyRepository;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class FacultyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FacultyRepository facultyRepository;

    @SpyBean
    private FacultyService facultyService;

    @InjectMocks
    private FacultyController facultyController;

    @Test
    public void getFacultyInfoTest() throws Exception {
        final String name = "abcdefg";
        final String color = "red";
        final long id = 1;
        /*final String name1 = "hijklmnop";
        final String color1 = "blue";
        final long id1 = 2;
        final List<Faculty> faculties = new ArrayList<>();*/

        JSONObject facultyObject = new JSONObject();
        facultyObject.put("name", name);
        facultyObject.put("color", color);

        Faculty faculty = new Faculty();
        faculty.setId(id);
        faculty.setName(name);
        faculty.setColor(color);

        /*faculties.add(faculty);

        //when(facultyRepository.findByColor(color)).thenReturn(faculties);
        //when(facultyRepository.findByNameIgnoreCase(name)).thenReturn(faculties);
        when(facultyService.findFaculty(any(Long.class))).thenReturn(faculty);*/

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/faculties/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.color").value(color));

    }


}
