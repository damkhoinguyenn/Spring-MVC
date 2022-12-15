package com.example.demo.services;

import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomerRepor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerSer {
    @Autowired private CustomerRepor repor;
    public List<Customer> listAll(){
        return (List<Customer>) repor.findAll();
    }

    public void save(Customer customer) {
        repor.save(customer);
    }
}
