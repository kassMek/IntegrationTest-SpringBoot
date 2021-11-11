package com.kass.integrationtesting;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAllCustomer")
    public List<Customer> getCustomer(){
         return customerService.findAll();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id){
        Customer cust=customerService.findById(id);
         if(cust==null){
             return new ResponseEntity<>(cust, HttpStatus.NOT_FOUND);
         }
         return new ResponseEntity<>(cust,HttpStatus.OK);
    }

}
