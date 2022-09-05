package com.example.sprinngkipproductservice.Controller;

import com.example.sprinngkipproductservice.Model.Customer;
import com.example.sprinngkipproductservice.Model.Employee;
import com.example.sprinngkipproductservice.Service.CustomerService;
import com.example.sprinngkipproductservice.Service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class CustomerController {
    private Customer badCustomer = null;
    private final CustomerService customerService;
    private final EmployeeService employeeService;

    public CustomerController(CustomerService customerService,
                              EmployeeService employeeService) {
        this.customerService = customerService;
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/customers")
    public String findAll(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customers";
    }

    //Ввод нового предприятия
    @GetMapping(value = "/add_customer")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "add_customer";
    }

    @GetMapping(value = "/add_customer-error")
    public String add_customerError(Model model) {
        model.addAttribute("customerError", true);
        model.addAttribute("customer", badCustomer);
        return "add_customer";
    }

    @PostMapping(value = "/add_customer")
    public String saveCustomer(Customer customer, HttpServletResponse response) {
        System.out.println(customer);
        if (customerService.getCustomerByFirm(customer.getFirm()) != null) {
            badCustomer = customer;
            return "redirect:/add_customer-error";
        }
        else {
            for (Employee employee: employeeService.findAll())
                customer.addEmployee(employee);
            Customer newCustomer = customerService.save(customer);
            long id = newCustomer.getId();
            response.addHeader("id", String.valueOf(id));
            return "customers";
        }
    }
    /*
    @PostMapping("/libraries")
    private long saveLibrary(@RequestBody Map<String, Object> payload) {
    Library library = new Library();
    library.setName(payload.get("name").toString());

    @SuppressWarnings("unchecked")
    List<Map<String, Object>> books = (List<Map<String, Object>>) payload.get("books");
    for (Map<String, Object> bookObj : books) {
        Book book = new Book();
        book.setTitle(bookObj.get("title").toString());
        book.setIsbn(bookObj.get("isbn").toString());
        library.addBook(book);
    }

    libraryService.saveOrUpdate(library);

    return library.getId();
}
    */

    @GetMapping(value = "/delete_customer")
    public String deleteCustomer(@RequestParam(name = "id") Long id) {
        customerService.deleteById(id);
        return "redirect:/customers";
    }

    @GetMapping(value = "/edit_customer")
    public String editCustomer(Model model, @RequestParam(name = "id") Long id) {
        Optional<Customer> customer = customerService.customerFindById(id);
        model.addAttribute("customer", customer);
        return "edit_customer";
    }

    @PutMapping(value = "/edit_customer")
    public String editUser(Customer newCustomer, Model model) {

        return customerService.customerFindById(newCustomer.getId()).map(customer -> {

            customer.setEmail(newCustomer.getEmail());
            customer.setTelephone(newCustomer.getTelephone());
            customer.setLeaderManager(newCustomer.getLeaderManager());
            customerService.save(customer);
            model.addAttribute("customers", customerService.findAll());
            return "redirect:/customers";
        }).orElseGet(() -> {
            customerService.save(newCustomer);
            model.addAttribute("customers", customerService.findAll());
            return "redirect:/customers";
        });
    }
}
