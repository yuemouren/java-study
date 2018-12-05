package com.ujiuye.controller;

import com.ujiuye.bean.Role;
import com.ujiuye.service.RoleService;
import com.ujiuye.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @RequestMapping("saveRole")
    public @ResponseBody
    Message saveRole(Role role, String ids) {
        boolean b = roleService.saveRole(role, ids);
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

    @RequestMapping("getAllRole")
    public @ResponseBody
    List<Role> getAllRole() {
        List<Role> allRole = roleService.getAllRole(null);
        if (allRole != null) {
            return allRole;
        }
        return null;
    }


}
