package com.ujiuye.service.impl;

import com.ujiuye.bean.Auth;
import com.ujiuye.bean.AuthExample;
import com.ujiuye.mapper.AuthMapper;
import com.ujiuye.service.AuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private AuthMapper authMapper;

    @Override
    public List<Auth> getAllAuth(AuthExample authExample) {
        return authMapper.selectByExample(authExample);
    }

    @Override
    public boolean saveAuth(Auth auth) {

        int i = authMapper.insertSelective(auth);
        if (i > 0) {
            return true;
        }
        return false;
    }

}
