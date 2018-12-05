package com.ujiuye.controller;

import com.ujiuye.bean.Module;
import com.ujiuye.service.ModuleService;
import com.ujiuye.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("module")
public class ModuleController {

    @Resource
    private ModuleService moduleService;

    @RequestMapping("saveModule")
    public @ResponseBody
    Message saveModule(Module module) {
        boolean b = moduleService.saveModule(module);
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

    public List<Module> getAllModuleByAnFk(int analysisFk) {


        return null;
    }
}
