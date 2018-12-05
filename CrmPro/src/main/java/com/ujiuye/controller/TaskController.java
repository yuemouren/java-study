package com.ujiuye.controller;

import com.ujiuye.bean.ActiveEmployee;
import com.ujiuye.bean.Task;
import com.ujiuye.service.TaskService;
import com.ujiuye.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("task")
public class TaskController {

    @Resource
    private TaskService taskService;

    @RequestMapping("saveTask")
    public @ResponseBody
    Message saveTask(Task task, HttpSession session) {
        //获取登录经理的eid
        ActiveEmployee ae = (ActiveEmployee) session.getAttribute("activeEmployee");
        task.setEmpFk(ae.getEid());
        task.setState(0);
        boolean b = taskService.saveTask(task);
        Message m = new Message();
        if (b) {
            m.setFlag(true);
            m.setMessage("添加成功");
        } else {
            m.setFlag(false);
            m.setMessage("添加失败");
        }
        return m;
    }

    @RequestMapping("getManagerTask")
    public @ResponseBody
    List<Task> getManagerTask(HttpSession session) {
        ActiveEmployee activeEmployee = (ActiveEmployee) session.getAttribute("activeEmployee");
        List<Task> allTask = taskService.getAllTask(activeEmployee.getEid());
        if (allTask != null) {
            return allTask;
        }
        return null;
    }

    @RequestMapping("updateState")
    public @ResponseBody
    Message updateState(Task task) {
        boolean b = taskService.updateState(task);
        Message m = new Message();
        if (b) {
            m.setFlag(true);
            m.setMessage("更新成功");
        } else {
            m.setFlag(false);
            m.setMessage("更新失败");
        }
        return m;
    }

}
