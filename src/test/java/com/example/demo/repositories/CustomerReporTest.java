package com.example.demo.repositories;

import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomerRepor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CustomerReporTest {
    @Autowired private CustomerRepor repor;
    @Test
    public void testAdd(){
        Customer customer= new Customer();
        customer.setName("Nguyen2");
        customer.setAddress("HCM City");
        repor.save(customer);
    }
    @Test
    public void testListAll(){
        Iterable<Customer> customers = repor.findAll();
        for (Customer customer : customers){
            System.out.println(customer);
        }
    }
    @Test
    public  void testUpdate(){
        Integer cusID = 1;
        Optional<Customer> optionalCustomer = repor.findById(cusID);
        Customer customer= optionalCustomer.get();
        customer.setName("Test");
        repor.save(customer);
        Iterable<Customer> customers = repor.findAll();
        for (Customer customerAll : customers){
            System.out.println(customerAll);
        }
    }
    @Test
    public void testGet(){
        Integer cusID = 1;
        Optional<Customer> optionalCustomer = repor.findById(cusID);
        System.out.println(optionalCustomer.get().getName());
    }
    @Test
    public void testDelete(){
        Integer cusID = null;
//        repor.deleteById(cusID);
        Iterable<Customer> customers = repor.findAll();
        for (Customer customerAll : customers){
            System.out.println(customerAll);
        }
    }
}
