package com.ujiuye.service.impl;

import com.ujiuye.bean.*;
import com.ujiuye.mapper.*;
import com.ujiuye.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;
    @Resource
    private TaskMapper taskMapper;
    @Resource
    private EmailMapper emailMapper;
    @Resource
    private AuthMapper authMapper;
    @Resource
    private UserRoleMapper userRoleMapper;


    @Override
    public boolean saveEmployee(Employee employee, Integer roleid) {
        int insert = employeeMapper.insert(employee);
        UserRole ur = new UserRole();
        ur.setRoleid(roleid);
        ur.setUserid(employee.getEid());
        int insert1 = userRoleMapper.insert(ur);
        if (insert + insert1 > 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> getAllEmployee() {

        return employeeMapper.getAllEmployee();
    }

    @Override
    public Employee getEmployeeByEid(int eid) {
        EmployeeExample ee = new EmployeeExample();
        EmployeeExample.Criteria criteria = ee.createCriteria();
        criteria.andEidEqualTo(eid);
        return employeeMapper.selectByExample(ee).get(0);
    }

    @Override
    public boolean updateInfo(Employee employee) {
        int i = employeeMapper.updateByPrimaryKeySelective(employee);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> getManagerEmployee(EmployeeExample employeeExample) {

        return employeeMapper.selectByExample(employeeExample);
    }

    @Override
    public boolean deleteInfo(int eid) {
        int i = employeeMapper.deleteByPrimaryKey(eid);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBatchInfo(List<Integer> ids) {
        EmployeeExample ee = new EmployeeExample();
        EmployeeExample.Criteria criteria = ee.createCriteria();
        criteria.andEidIn(ids);
        int i = employeeMapper.deleteByExample(ee);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Employee getEmpAndTask(Integer eid) {
        Employee employee = employeeMapper.selectByPrimaryKey(eid);
        TaskExample te = new TaskExample();
        TaskExample.Criteria criteria = te.createCriteria();
        criteria.andEmpFk2EqualTo(employee.getEid());
        criteria.andStateNotEqualTo(0);
        List<Task> tasks = taskMapper.selectByExample(te);
        employee.setTasks(tasks);
        return employee;
    }

    @Override
    public Employee getSendEmpAndEmail(Integer eid) {
        Employee employee = employeeMapper.selectByPrimaryKey(eid);
        EmailExample ee = new EmailExample();
        EmailExample.Criteria criteria = ee.createCriteria();
        criteria.andReceiveEmpFkEqualTo(employee.getEid());
        List<Email> emails = emailMapper.selectByExample(ee);
        for (Email email : emails) {
            Employee employee1 = employeeMapper.selectByPrimaryKey(email.getSendEmpFk());
            email.setEmployee(employee1);
        }
        employee.setEmails(emails);
        return employee;
    }

    @Override
    public Employee getGiveEmpAndEmail(Integer eid) {
        Employee employee = employeeMapper.selectByPrimaryKey(eid);
        EmailExample ee = new EmailExample();
        EmailExample.Criteria criteria = ee.createCriteria();
        criteria.andSendEmpFkEqualTo(employee.getEid());
        List<Email> emails = emailMapper.selectByExample(ee);
        for (Email email : emails) {
            Employee employee1 = employeeMapper.selectByPrimaryKey(email.getReceiveEmpFk());
            email.setEmployee(employee1);
        }
        employee.setEmails(emails);
        return employee;
    }

    @Override
    public ActiveEmployee login(String username, String password) {
        Employee employee = employeeMapper.login(username, password);
        ActiveEmployee ae = new ActiveEmployee();
        if (employee != null) {
            ae.setEid(employee.getEid());
            ae.setName(employee.getEname());
            List<Auth> parents = authMapper.getParents(employee.getEid());
            List<Auth> childs = authMapper.getChilds(employee.getEid());
            ae.setParents(parents);
            ae.setChilds(childs);
        }
        return ae;
    }
}
