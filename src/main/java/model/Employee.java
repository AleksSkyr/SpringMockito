package model;

import java.util.Objects;
import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private int departament;
    private int salary;

    public Employee(String firstName, String lastName, int departament) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departament = departament;
    }

    public Employee(String firstName, String lastName, int departament, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departament = departament;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDepartament() {
        return departament;
    }

    public void setDepartament(int departament) {
        this.departament = departament;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departament=" + departament +
                "salary" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == o
                && departament == employee.departament
                && Objects.equals(firstName, employee firstName)
                && Objects.equals(lastName, employee lastName);

    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getDepartament(), getSalary());
    }
}