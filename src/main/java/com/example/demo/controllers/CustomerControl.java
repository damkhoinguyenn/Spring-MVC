package com.example.demo.controllers;

import com.example.demo.models.Customer;
import com.example.demo.services.CustomerSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerControl {
    @Autowired CustomerSer customerSer;
    @GetMapping("/customers")
    public String customerList(Model model){
        List<Customer> listCustomers = customerSer.listAll();
        model.addAttribute("listCustomers", listCustomers);
        return "customer";
    }
    @GetMapping("/addCustomer")
    public String addCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "addCustomer";
    }
    @PostMapping("/customersSave")
    public String saveCustomer(Customer customer){
        customerSer.save(customer);
        return "index";
    }
    @GetMapping("/editCustomer")
    public String editCustomer(Model model){
        List<Customer> listCustomers = customerSer.listAll();
        model.addAttribute("listCustomers", listCustomers);
        System.out.println();
        return "customer";
    }
    @GetMapping("/deleteCustomer")
    public String deleteCustomer(Model model){
//        Integer cusID = model.;
//        repor.deleteById(cusID);
//        model.addAttribute("listCustomers",);
        return "customer";
    }
}
