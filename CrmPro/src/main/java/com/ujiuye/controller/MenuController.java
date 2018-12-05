package com.ujiuye.controller;

import com.ujiuye.bean.ActiveEmployee;
import com.ujiuye.bean.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MenuController {

    @RequestMapping("showMenu")
    public @ResponseBody
    Map<String, Object> showMenu(HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        ActiveEmployee ae = (ActiveEmployee) session.getAttribute("activeEmployee");
        List<Auth> parents = ae.getParents();
        List<Auth> childs = ae.getChilds();
        for (Auth auth : parents) {
            List<Auth> newlist = new ArrayList<>();
            for (Auth cauth : childs) {
                if (auth.getAuthid() == cauth.getParentid()) {
                    newlist.add(cauth);
                }
            }
            map.put(auth.getAuthname(), newlist);
        }
        return map;
    }
}
