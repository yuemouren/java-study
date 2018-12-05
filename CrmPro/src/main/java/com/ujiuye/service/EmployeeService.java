package com.ujiuye.service;

import com.ujiuye.bean.ActiveEmployee;
import com.ujiuye.bean.Employee;
import com.ujiuye.bean.EmployeeExample;

import java.util.List;

public interface EmployeeService {

    public boolean saveEmployee(Employee employee, Integer roleid);

    public List<Employee> getAllEmployee();

    public Employee getEmployeeByEid(int eid);

    public boolean updateInfo(Employee employee);

    public List<Employee> getManagerEmployee(EmployeeExample employeeExample);

    public boolean deleteInfo(int eid);

    public boolean deleteBatchInfo(List<Integer> ids);

    public Employee getEmpAndTask(Integer eid);

    public Employee getSendEmpAndEmail(Integer eid);

    public Employee getGiveEmpAndEmail(Integer eid);

    public ActiveEmployee login(String username, String password);
}
