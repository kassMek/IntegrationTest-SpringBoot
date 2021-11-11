package com.kass.integrationtesting;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll () {
        return customerRepository.findAll();
    }

    public Customer findById (int id) {
         return customerRepository.findById(id);
    }
}
