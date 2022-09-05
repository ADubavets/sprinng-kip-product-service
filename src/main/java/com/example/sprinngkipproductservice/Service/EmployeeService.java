package com.example.sprinngkipproductservice.Service;

import com.example.sprinngkipproductservice.Model.Employee;
import com.example.sprinngkipproductservice.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }

    public Optional<Employee> employeeFindById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee getEmployeeByName(String name) {
        return employeeRepository.getEmployeeByName(name);
    }

    public List<Employee> searchEmployeeByFirm(String firm) {
        employeeRepository.searchEmployeeByFirm(firm);
        return employeeRepository.findAll();
    }
}
