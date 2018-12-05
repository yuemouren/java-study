package com.ujiuye.controller;

import com.ujiuye.bean.Function;
import com.ujiuye.service.FunctionService;
import com.ujiuye.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("function")
public class FunctionController {

    @Resource
    private FunctionService functionService;

    @RequestMapping("saveFunction")
    public @ResponseBody
    Message saveFunction(Function function) {
        boolean b = functionService.saveFunction(function);
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

    @RequestMapping("getFunByModeleFk")
    public @ResponseBody
    List<Function> getFunByModeleFk(int modeleFk) {

        List<Function> funByModeleFk = functionService.getFunByModeleFk(modeleFk);
        if (funByModeleFk != null) {
            return funByModeleFk;
        }
        return null;
    }

}
