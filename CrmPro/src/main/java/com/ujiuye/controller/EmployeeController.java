package com.ujiuye.controller;

import com.ujiuye.bean.ActiveEmployee;
import com.ujiuye.bean.Employee;
import com.ujiuye.bean.EmployeeExample;
import com.ujiuye.service.EmployeeService;
import com.ujiuye.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @RequestMapping("saveEmployee")
    public String saveEmployee(Employee employee, int roleid) {
        boolean b = employeeService.saveEmployee(employee, roleid);
        if (b) {
            return "redirect:../user.jsp";
        } else {
            return "redirect:../error.jsp";
        }
    }

    @RequestMapping("getAllEmployee")
    public @ResponseBody
    List<Employee> getAllEmployee() {
        List<Employee> allEmployee = employeeService.getAllEmployee();
        if (allEmployee != null) {
            return allEmployee;
        } else {
            return null;
        }
    }

    @RequestMapping("getEmployeeByEid")
    public @ResponseBody
    Employee getEmployeeByEid(HttpSession session, Integer eid) {

        if (eid == null) {
            ActiveEmployee activeEmployee = (ActiveEmployee) session.getAttribute("activeEmployee");
            eid = activeEmployee.getEid();
        }
        Employee employeeByEid = employeeService.getEmployeeByEid(eid);
        if (employeeByEid != null) {
            return employeeByEid;
        } else {
            return null;
        }
    }

    @RequestMapping("getManagerEmployee")
    public @ResponseBody
    List<Employee> getManagerEmployee(Integer eid) {
        EmployeeExample ee = new EmployeeExample();
        EmployeeExample.Criteria criteria = ee.createCriteria();
        if (eid != null) {
            criteria.andPFkEqualTo(1);
        } else {
            criteria.andPFkEqualTo(2);
        }
        List<Employee> managerEmployee = employeeService.getManagerEmployee(ee);
        if (managerEmployee != null) {
            return managerEmployee;
        } else {
            return null;
        }
    }

    @RequestMapping("updateInfo")
    public @ResponseBody
    Message updateInfo(Employee employee) {
        boolean b = employeeService.updateInfo(employee);
        System.out.println(employee.getEid());
        Message m = new Message();
        if (b) {
            m.setFlag(true);
            m.setMessage("修改成功");
        } else {
            m.setFlag(false);
            m.setMessage("修改失败");
        }
        return m;
    }

    @RequestMapping("deleteInfo")
    public @ResponseBody
    Message deleteInfo(int eid) {
        boolean b = employeeService.deleteInfo(eid);
        Message m = new Message();
        if (b) {
            m.setFlag(true);
            m.setMessage("删除成功");
        } else {
            m.setFlag(false);
            m.setMessage("删除失败");
        }
        return m;
    }

    @RequestMapping("deleteBatchInfo")
    public @ResponseBody
    Message deleteBatchInfo(@RequestParam("eids") List<Integer> eids) {
        boolean b = employeeService.deleteBatchInfo(eids);
        Message m = new Message();
        if (b) {
            m.setFlag(true);
            m.setMessage("删除成功");
        } else {
            m.setFlag(false);
            m.setMessage("删除失败");
        }
        return m;
    }

    @RequestMapping("getEmpAndTask")
    public @ResponseBody
    Employee getEmpAndTask(HttpSession session) {
        //获取登录用户的eid
        ActiveEmployee activeEmployee = (ActiveEmployee) session.getAttribute("activeEmployee");
        Employee empAndTask = employeeService.getEmpAndTask(activeEmployee.getEid());
        if (empAndTask != null) {
            return empAndTask;
        }
        return null;
    }

    @RequestMapping("getSendEmpAndEmail")
    public @ResponseBody
    Employee getSendEmpAndEmail(HttpSession session) {
        //获取登录用户的eid
        ActiveEmployee activeEmployee = (ActiveEmployee) session.getAttribute("activeEmployee");
        Employee empAndTask = employeeService.getSendEmpAndEmail(activeEmployee.getEid());
        if (empAndTask != null) {
            return empAndTask;
        }
        return null;
    }

    @RequestMapping("getGiveEmpAndEmail")
    public @ResponseBody
    Employee getGiveEmpAndEmail(HttpSession session) {
        //获取登录用户的eid
        ActiveEmployee activeEmployee = (ActiveEmployee) session.getAttribute("activeEmployee");
        Employee empAndTask = employeeService.getGiveEmpAndEmail(activeEmployee.getEid());
        if (empAndTask != null) {
            return empAndTask;
        }
        return null;
    }

    @RequestMapping("login")
    public @ResponseBody
    Message login(HttpSession session, String username, String password) {
        ActiveEmployee login = employeeService.login(username, password);
        Message m = new Message();
        if (login != null) {
            session.setAttribute("activeEmployee", login);
            m.setMessage("index");
        } else {
            m.setMessage("login");
        }
        return m;
    }

}
