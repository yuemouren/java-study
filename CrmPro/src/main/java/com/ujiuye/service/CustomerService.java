package com.ujiuye.service;

import com.ujiuye.bean.Customer;
import com.ujiuye.bean.CustomerExample;

import java.util.List;

public interface CustomerService {

    public boolean saveCustomer(Customer customer);

    public List<Customer> getAllCustomer(CustomerExample customerExample);

}
