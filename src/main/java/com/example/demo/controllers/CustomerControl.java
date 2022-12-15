package com.example.demo.controllers;

import com.example.demo.models.Customer;
import com.example.demo.services.CustomerSer;
import com.example.demo.services.UserNotFound;
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
    @GetMapping("/editCustomer{id}")
    public String editCustomer(@PathVariable("id") Integer id, Model model) throws UserNotFound {
        try {
            Customer customer = customerSer.get(id);
            model.addAttribute("customer", customer);
            return "addCustomer";
        } catch (UserNotFound e) {
            throw new UserNotFound("All good");
        }
    }
    @GetMapping("/deleteCustomer{id}")
    public String deleteCustomer(@PathVariable("id") Integer id, Model model) throws UserNotFound {
        try {
            customerSer.delete(id);
        } catch (UserNotFound e) {
            throw new UserNotFound("All good");
        }
        return "index";
    }
}
