package pro.sky.hw2_8.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hw2_8.model.Employee;
import pro.sky.hw2_8.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping ("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping ("/add")
    public Employee add (@RequestParam("firstName") String firstName,
                         @RequestParam ("lastName") String lastName,
                         @RequestParam ("departmentId") int department,
                         @RequestParam ("salary") double salary) {
        return employeeService.add( firstName, lastName, department, salary);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
                           @RequestParam ("lastName") String lastName,
                           @RequestParam ("departmentId") int department,
                           @RequestParam ("salary") double salary) {
        return employeeService.remove( firstName, lastName, department, salary);
    }

    @GetMapping("/find")
    public Employee find (@RequestParam("firstName") String firstName,
                          @RequestParam ("lastName") String lastName,
                          @RequestParam("departmentId") int department,
                          @RequestParam ("salary") double salary) {
        return employeeService.find(firstName, lastName, department, salary);
    }

    @GetMapping("/print")
    public List<Employee> print() {
        return employeeService.getAllEmployees();
    }

}
