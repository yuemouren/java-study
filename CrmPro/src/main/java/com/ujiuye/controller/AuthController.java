package com.ujiuye.controller;

import com.ujiuye.bean.Auth;
import com.ujiuye.bean.AuthExample;
import com.ujiuye.service.AuthService;
import com.ujiuye.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AuthController {

    @Resource
    private AuthService authService;

    @RequestMapping("getAuth")
    public @ResponseBody
    Map<String, List<Auth>> getAuth() {
        Map<String, List<Auth>> map = new HashMap<>();
        List<Auth> allAuth = authService.getAllAuth(null);
        for (Auth pauth : allAuth) {
            if ("open".equals(pauth.getState())) {
                List<Auth> list = new ArrayList<>();
                for (Auth cauth : allAuth) {
                    if (pauth.getAuthid() == cauth.getParentid()) {
                        list.add(cauth);
                    }
                }
                String par = pauth.getAuthid() + "," + pauth.getAuthname();
                map.put(par, list);
            }
        }
        return map;
    }

    @RequestMapping("getParentMenu")
    public @ResponseBody
    List<Auth> getParentMenu() {
        AuthExample ae = new AuthExample();
        AuthExample.Criteria criteria = ae.createCriteria();
        criteria.andParentidIsNull();
        return authService.getAllAuth(ae);
    }

    @RequestMapping("saveAuth")
    public @ResponseBody
    Message saveAuth(Auth auth) {
        boolean b = authService.saveAuth(auth);
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
}
