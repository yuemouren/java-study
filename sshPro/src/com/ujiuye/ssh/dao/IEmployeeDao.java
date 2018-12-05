package com.ujiuye.ssh.dao;

import com.ujiuye.ssh.domain.Employee;

public interface IEmployeeDao {

	Employee findEmployeeByName(String name);

}
