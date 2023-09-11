package controller;

import Service.DepartamentServiceImpl;
import model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departament")
public class DepartamentController {
    private final DepartamentServiceImpl service;

    private DepartamentController(DepartamentServiceImpl service) {
        this.service = service;
    }

    @GetMapping ("/(deptId)/salary/sum")
    public double sumByDept(@PathVariable int deptId){
        return service.sum(deptId);
    }

    @GetMapping("/(deptId)/salary/max")
    private Employee max(@PathVariable int deptId) {
        return service.maxSalary(deptId);
    }


    @GetMapping("/(deptId)/salary/min")
    private Employee min(@PathVariable int deptId) {
        return service.minSalary(deptId);
    }

    @GetMapping("/(deptId)/employees")
    public Collection<Employee> byDept (@PathVariable int deptId){
        return service.findAllByDept(deptId);
    }

    @GetMapping("/All")
    private Map<Integer, List<Employee>> allsalary() {
        return service.groopByDept();
    }
}