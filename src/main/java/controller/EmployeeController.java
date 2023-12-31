package controller;


import Exeption.NotArgumentExeption;
import Service.EmloyeeServiceImpl;
import model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmloyeeServiceImpl service;

    public EmployeeController(EmloyeeServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/add")
    public void add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int departament) {
        examination(firstName,lastName);
        service.addEmployee(firstName, lastName, departament, 0);

    }

    @GetMapping("/get")
    public Employee get(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int departament) {
        examination(firstName,lastName);
        return service.findEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public boolean remove(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int departament) {
        examination(firstName,lastName);
        return service.removeEmployee(firstName, lastName);
    }

    @GetMapping("/all")
    public Collection<Employee> getAll() {
        return (Collection<Employee>) service.getAll();
    }

    private void examination(String... args) {
        for(String arg : args) {
            if(!StringUtils.isAlpha(arg)) {
                throw new NotArgumentExeption();
            }
        }
    }

}