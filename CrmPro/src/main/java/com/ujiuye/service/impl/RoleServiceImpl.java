package com.ujiuye.service.impl;

import com.ujiuye.bean.Role;
import com.ujiuye.bean.RoleAuth;
import com.ujiuye.bean.RoleExample;
import com.ujiuye.mapper.RoleAuthMapper;
import com.ujiuye.mapper.RoleMapper;
import com.ujiuye.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RoleAuthMapper roleAuthMapper;

    @Override
    @Transactional
    public boolean saveRole(Role role, String ids) {
        int insert = roleMapper.insert(role);
        String[] split = ids.split(",");
        List<RoleAuth> list = new ArrayList<>();
        for (String str : split) {
            RoleAuth ra = new RoleAuth();
            ra.setRoleid(role.getRoleid());
            ra.setAuthid(Integer.parseInt(str));
            list.add(ra);
        }
        boolean flag = true;
        int i = roleAuthMapper.batchInsert(list);
        if (i < 0) {
            flag = false;
        }
        return flag;
    }

    @Override
    public List<Role> getAllRole(RoleExample roleExample) {

        return roleMapper.selectByExample(roleExample);
    }
}
