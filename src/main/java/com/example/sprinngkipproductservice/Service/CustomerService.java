package com.example.sprinngkipproductservice.Service;

import com.example.sprinngkipproductservice.Model.Customer;
import com.example.sprinngkipproductservice.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer getCustomerByFirm(String firm) {
        return customerRepository.getCustomerByName(firm);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteById(long id) {
        customerRepository.deleteById(id);
    }

    public Optional<Customer> customerFindById(Long id) {
        return customerRepository.findById(id);
    }


}
