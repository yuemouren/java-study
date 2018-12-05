package com.ujiuye.service.impl;

import com.ujiuye.bean.Employee;
import com.ujiuye.bean.EmployeeExample;
import com.ujiuye.bean.Task;
import com.ujiuye.bean.TaskExample;
import com.ujiuye.mapper.EmployeeMapper;
import com.ujiuye.mapper.TaskMapper;
import com.ujiuye.service.TaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Resource
    private TaskMapper taskMapper;
    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public boolean saveTask(Task task) {
        int insert = taskMapper.insert(task);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Task> getAllTask(Integer eid) {
        TaskExample te = new TaskExample();
        TaskExample.Criteria criteria1 = te.createCriteria();
        criteria1.andEmpFkEqualTo(eid);
        List<Task> tasks = taskMapper.selectByExample(te);

        for (Task task : tasks) {
            Employee employee = employeeMapper.selectByPrimaryKey(task.getEmpFk2());
            task.setEmployee(employee);
        }

        return tasks;
    }

    @Override
    public boolean updateState(Task task) {
        int i = taskMapper.updateByPrimaryKeySelective(task);
        if (i > 0) {
            return true;
        }
        return false;
    }
}
