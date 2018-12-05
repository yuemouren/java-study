package com.ujiuye.controller;

import com.ujiuye.bean.Customer;
import com.ujiuye.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @RequestMapping("saveCustomer")
    public String saveCustomer(Customer customer) {
        boolean b = customerService.saveCustomer(customer);
        if (b) {
            return "redirect:../customer.jsp";
        } else {
            return "redirect:../error.jsp";
        }
    }

    @RequestMapping("getAllCustomer")
    public @ResponseBody
    List<Customer> getAllCustomer() {
        List<Customer> allCustomer = customerService.getAllCustomer(null);
        if (allCustomer != null) {
            return allCustomer;
        } else {
            return null;
        }
    }
}
