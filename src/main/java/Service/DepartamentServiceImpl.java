package Service;

import Exeption.EmployeeNotFoundException;
import model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartamentServiceImpl extends DepartamentService {
    private EmloyeeServiceImpl emloyeeServiceImpl;

    @Override
    public DepartamentServiceImpl() {
        this.emloyeeServiceImpl = emloyeeServiceImpl;
    }

    @Override
    public double sum(int deptId) {
        return emloyeeServiceImpl.getAll().stream().filter(e -> e.getDepartament() == deptId)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    @Override
    public Employee maxSalary(int deptId) {
        return emloyeeServiceImpl.getAll().stream().filter(e -> e.getDepartament() == deptId)
                .max(Comparator.comparingDouble(e -> e.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee minSalary(int deptId) {
        return emloyeeServiceImpl.getAll().stream().filter(e -> e.getDepartament() == deptId)
                .min(Comparator.comparingDouble(e -> e.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> findAllByDept(int deptId) {
        return emloyeeServiceImpl.getAll().stream().filter(e -> e.getDepartament() == deptId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> groopByDept() {
        return emloyeeServiceImpl.getAll().stream().collect(Collectors.groupingBy(Employee::getDepartament));
    }
}