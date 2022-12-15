package com.example.demo.services;

import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomerRepor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerSer {
    @Autowired private CustomerRepor repor;
    public List<Customer> listAll(){
        return (List<Customer>) repor.findAll();
    }

    public void save(Customer customer) {
        repor.save(customer);
    }

    public Customer get(Integer id) throws UserNotFound {
        Optional<Customer> reporById = repor.findById(id);
        if(reporById.isPresent()){
            return reporById.get();
        }
        throw new UserNotFound("Could not found the one" + id);
    }

    public void delete(Integer id) throws UserNotFound {
        Long count = repor.countById(id);
        if( count == null || count==0){
            throw new UserNotFound("Could not found the one" + id);
        }
        repor.deleteById(id);
    }
}
