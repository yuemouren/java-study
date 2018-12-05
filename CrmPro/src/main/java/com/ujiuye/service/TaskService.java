package com.ujiuye.service;

import com.ujiuye.bean.Task;

import java.util.List;

public interface TaskService {

    public boolean saveTask(Task task);

    public List<Task> getAllTask(Integer eid);

    public boolean updateState(Task task);
}
