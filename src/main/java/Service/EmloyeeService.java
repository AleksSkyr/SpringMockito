package Service;
import model.Employee;

import java.util.Collection;

public interface EmloyeeService {
    void addEmployee(String lastName, String firstName, double salary, int departamentId);
    Employee findEmployee(String lastName, String firstName);

    boolean removeEmployee(String lastName, String firstName);

    Collection<Employee> getAll();

    default String makeKey(String lastName, String firstName) {
        return (lastName + "_" + firstName).toLowerCase();
    }
}