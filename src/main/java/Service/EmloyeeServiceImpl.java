package Service;

import Exeption.EmployeeAllreadyAddedException;
import Exeption.EmployeeNotFoundException;
import Exeption.EmployeeStorageIsFullException;
import model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmloyeeServiceImpl extends EmployeeService {
    private static final int SIZE = 10;
    private final Map<String, Employee> employees = new HashMap<>();


    public void addEmployee(String firstName, String lastName, int departament) {
        if (employees.size() == SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        var key = empKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAllreadyAddedException();
        }

        employees.put(key, new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), departament));

    }

    public Employee findEmployee(String firstName, String lastName, int departament) {
        var emp = employees.get(empKey(firstName, lastName));
        if (emp == null) {
            throw new EmployeeNotFoundException();
        }
        return emp;
    }

    public boolean removeEmployee(String firstName, String lastName, int departament) {
        Employee rem = employees.remove(empKey(firstName, lastName));
        if (rem == null) {
            throw new EmployeeNotFoundException();
        }
        return true;
    }

    public Map<Integer, List<Employee>> getAll() {


        return (Map<Integer, List<Employee>>) employees.values();
    }

    private String empKey(String firstName, String lastName) {
        return (firstName + "_" + lastName).toLowerCase();
    }


}

