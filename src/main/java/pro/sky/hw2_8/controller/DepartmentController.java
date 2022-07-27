package pro.sky.hw2_8.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hw2_8.model.Employee;
import pro.sky.hw2_8.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("/max-salary")
    public Employee findMaxSalary (@RequestParam ("departmentId") int department) {
        return departmentService.findMaxSalary(department);

    }

    @GetMapping("/min-salary")
    public Employee findMinSalary (@RequestParam ("departmentId") int department) {
        return departmentService.findMinSalary(department);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> findAllEmployeesOfDepartment (@RequestParam ("departmentId") int department) {
        return departmentService.findEmployeesOfDepartment(department);

    }

    @GetMapping("/all")
    public Map<Integer,List<Employee> > findAllEmployees (@RequestParam ("departmentId") int department) {
        return departmentService.findAllEmployees();

    }
}
