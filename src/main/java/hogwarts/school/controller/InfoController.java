package hogwarts.school.controller;

import hogwarts.school.interfaces.InfoService;
import hogwarts.school.interfaces.StudentService;
import hogwarts.school.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/getPort")
public class InfoController {
    private final InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }
    @GetMapping
    public int getCurrentPort() {
        return infoService.getCurrentPort();
    }


}
