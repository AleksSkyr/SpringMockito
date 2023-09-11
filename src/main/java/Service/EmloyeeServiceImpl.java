package Service;
import Exeption.EmployeeAllreadyAddedException;
import Exeption.EmployeeNotFoundException;
import Exeption.EmployeeStorageIsFullException;
import model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.util.StringUtils.capitalize;

@Service
public class EmloyeeServiceImpl implements EmloyeeService {
    private static final int SIZE = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public void addEmployee(String lastName, String firstName, double salary, int departamentId) {
        if (employees.size() == SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        var key = makeKey(lastName, firstName);
        if (employees.containsKey(key)) {
            throw new EmployeeAllreadyAddedException();
        }
        employees.put(key, new Employee(capitalize(firstName), capitalize(lastName), salary, departamentId));
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) {
        var emp = employees.get(makeKey(lastName, firstName));
        if (emp == null) {
            throw new EmployeeNotFoundException();
        }
        return emp;
    }

    @Override
    public boolean removeEmployee(String lastName, String firstName) {
        Employee removed = employees.remove(makeKey(lastName, firstName));
        var employee = new Employee(lastName, firstName);
        if (removed == null) {
            throw new EmployeeNotFoundException();
        }
        return true;
    }

    @Override
    public Collection<Employee> getAll() {
        return employees.values();
    }

}