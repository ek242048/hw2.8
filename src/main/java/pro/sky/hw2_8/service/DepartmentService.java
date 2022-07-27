package pro.sky.hw2_8.service;

import org.springframework.stereotype.Service;
import pro.sky.hw2_8.exceptions.EmployeeNotFoundException;
import pro.sky.hw2_8.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public Employee findMaxSalary(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee findMinSalary(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingDouble(employee -> employee.getSalary()))
                .orElseThrow(()-> new EmployeeNotFoundException());
    }

    public List<Employee> findEmployeesOfDepartment(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> findAllEmployees() {
        return employeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
