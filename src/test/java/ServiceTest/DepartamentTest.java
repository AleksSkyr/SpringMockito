package ServiceTest;


import Exeption.EmployeeNotFoundException;
import Service.DepartamentServiceImpl;
import Service.EmloyeeServiceImpl;
import model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

    @ExtendWith(MockitoExtension.class)
    class DepartamentTest {
        @Mock
        EmloyeeServiceImpl emloyeeService;
        @InjectMocks
        DepartamentServiceImpl departamentService;

        @BeforeEach
        void setUp() {
            var employees = List.of(
                    new Employee("test", "test_test",10, 1),
                    new Employee("test1", "test_test1",20, 2),
                    new Employee("test2", "test_test2",30, 1),
                    new Employee("test3", "test_test3",40, 4),
                    new Employee("test4", "test_test4",50, 5));

            when(emloyeeService.getAll()).thenReturn((Map<Integer, List<Employee>>) employees);
        }

        @Test
        void sum() {
            Assertions.assertThat(departamentService.sum(1)).isEqualTo(40d);
        }
        @Test
        void maxSalary() {
            var employees = List.of(
                    new Employee("test", "test_test",10, 1),
                    new Employee("test1", "test_test1",20, 2),
                    new Employee("test2", "test_test2",30, 3),
                    new Employee("test3", "test_test3",40, 4),
                    new Employee("test4", "test_test4",50, 5));

            when(emloyeeService.getAll()).thenReturn((Map<Integer, List<Employee>>) employees);
            Assertions.assertThat(departamentService.maxSalary(2)).isEqualTo(employees.get(1));
        }
        @Test
        void minSalary() {
            var employees = List.of(
                    new Employee("test", "test_test",10, 1),
                    new Employee("test1", "test_test1",20, 2),
                    new Employee("test2", "test_test2",30, 3),
                    new Employee("test3", "test_test3",40, 4),
                    new Employee("test4", "test_test4",50, 5));

            when(emloyeeService.getAll()).thenReturn((Map<Integer, List<Employee>>) employees);
            Assertions.assertThat(departamentService.minSalary(1)).isEqualTo(employees.get(0));
        }

        @Test
        void whenEmployeesIsEmpty() {
            when(emloyeeService.getAll()).thenReturn((Map<Integer, List<Employee>>) Collections.emptyList());
            Assertions.assertThatThrownBy (()->departamentService.minSalary(1))
                    .isInstanceOf(EmployeeNotFoundException.class);
            Assertions.assertThatThrownBy (()->departamentService.maxSalary(1))
                    .isInstanceOf(EmployeeNotFoundException.class);
            Assertions.assertThat(departamentService.sum(1)).isEqualTo(0d);
        }

        @Test
        void allByDept() {
            var employee = departamentService.findAllByDept(5);
            Assertions.assertThat(employee.size()).isEqualTo(1);
            Assertions.assertThat(employee.get(0)).isEqualTo(new Employee("test4", "test_test4",50, 5));
        }

        @Test
        void groopByDept() {
            Map <Integer, List<Employee>> actual = departamentService.groopByDept();
            Assertions.assertThat(actual.keySet()).containsExactly(1,2,4,5);

        }
    }

