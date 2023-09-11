package controller;

import Service.DepartamentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departament")
public class DepartamentController {

    private final DepartamentService service;

    public DepartamentController(DepartamentService service) {
        this.service = service;
    }

    @GetMapping("/max_selary")
    public double max(@RequestParam int departmentId) {
        return service.maxSelary(departmentId);
    }
}