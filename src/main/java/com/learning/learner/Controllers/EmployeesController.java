package com.learning.learner.Controllers;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.learning.learner.Services.EmployeeService;
import com.learning.learner.Repositories.Employees.Employees;

@RestController
public class EmployeesController {

    private final EmployeeService employeeService;

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @GetMapping("/employees")
    public List<Employees> getAllEmployees(@RequestParam(required = false) Integer id) {
        if (id != null) return employeeService.getOne(id);
        else return employeeService.getAll();
    }

    @PostMapping("/employees")
    public String setOneEmployee(@RequestBody Employees employee) {
        employeeService.setOne(employee.getName(), employee.getId());
        return "Successfully Inserted one Employee";
    }

    @PatchMapping("/employees")
    public String updateEmployee(@RequestBody Employees employee) {
        employeeService.setOne(employee.getName(), employee.getId());
        return "Successfully Updated one Employee";
    }

    @DeleteMapping("/employees")
    public String deleteEmployee(@RequestParam Integer id) {
        employeeService.deleteOne(id);
        return "Successfully deleted one Employee";
    }
}
