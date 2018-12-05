package com.ujiuye.service;

import com.ujiuye.bean.Role;
import com.ujiuye.bean.RoleExample;

import java.util.List;


public interface RoleService {

    public boolean saveRole(Role role, String ids);

    public List<Role> getAllRole(RoleExample roleExample);
}
