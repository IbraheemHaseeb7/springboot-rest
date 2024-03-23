package com.learning.learner.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learning.learner.Repositories.Employees.EmployeeRepository;
import com.learning.learner.Repositories.Employees.Employees;

@Service
public class EmployeeService {
    
    private final EmployeeRepository employeeRepository;
    
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employees> getAll() {
        return employeeRepository.findAll();
    }
    public List<Employees> getOne(int id) {
        List<Employees> employees = new ArrayList<>();
        Optional<Employees> result = employeeRepository.findById(id);

        if (result.isPresent()) {
            employees.add(result.get());
        }

        return employees;
    }
    public void setOne(String name, int id) {
        Employees employees = new Employees();
        employees.setId(id);
        employees.setName(name);
        employeeRepository.save(employees);
    }

    public void deleteOne(int id) {
        employeeRepository.deleteById(id);
    }
}
