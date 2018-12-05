package com.ujiuye.service.impl;

import com.ujiuye.bean.Customer;
import com.ujiuye.bean.CustomerExample;
import com.ujiuye.mapper.CustomerMapper;
import com.ujiuye.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public boolean saveCustomer(Customer customer) {
        int insert = customerMapper.insert(customer);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> getAllCustomer(CustomerExample customerExample) {

        return customerMapper.selectByExample(customerExample);
    }

}
