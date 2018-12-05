package com.ujiuye.service;

import com.ujiuye.bean.Auth;
import com.ujiuye.bean.AuthExample;

import java.util.List;

public interface AuthService {

    public List<Auth> getAllAuth(AuthExample authExample);

    public boolean saveAuth(Auth auth);
}
