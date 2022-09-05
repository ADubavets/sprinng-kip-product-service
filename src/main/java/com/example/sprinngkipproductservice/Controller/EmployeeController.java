package com.example.sprinngkipproductservice.Controller;

import com.example.sprinngkipproductservice.Model.Employee;
import com.example.sprinngkipproductservice.Service.CustomerService;
import com.example.sprinngkipproductservice.Service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller
public class EmployeeController {
    private Employee badEmployee = null;
    private final EmployeeService employeeService;
    private final CustomerService customerService;

    public EmployeeController(EmployeeService employeeService,
                              CustomerService customerService) {
        this.employeeService = employeeService;
        this.customerService = customerService;
    }

    // Стартовая: продажи
    @GetMapping(value = "/employees")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employees";
    }

    //Ввод нового сотрудника для организации
    @GetMapping(value = "/add_employee")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("customers", customerService.findAll());
        return "add_employee";
    }

    @GetMapping(value ="/add_employee-error")
    public String addEmployeeError(Model model) {
        model.addAttribute("employee", badEmployee);
        model.addAttribute("employeeError",true);
        return "add_employee";
    }

    @PostMapping(value = "/add_employee")
    public String saveEmployee(Employee employee, HttpServletResponse response) {

        System.out.println("New employee: " + employee);

        System.out.println(employeeService.getEmployeeByName(employee.getName()));

        if (employeeService.getEmployeeByName(employee.getName()) != null) {
            badEmployee = employee;
            return "redirect:/add_employee-error";
        }

        else {
            Employee newEmployee = employeeService.save(employee);
            long id = newEmployee.getId();
            response.addHeader("id", String.valueOf(id));
            return "employees";
        }
    }

    @GetMapping(value = "/delete_employee")
    public String deleteEmployee(@RequestParam(name="id")Long id) {
        employeeService.deleteById(id);
        return "redirect:/employees";
    }
}
