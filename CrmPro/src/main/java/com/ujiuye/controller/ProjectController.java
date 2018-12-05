package com.ujiuye.controller;

import com.ujiuye.bean.Project;
import com.ujiuye.service.ProjectService;
import com.ujiuye.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("project")
public class ProjectController {

    @Resource
    private ProjectService projectService;

    @RequestMapping("saveProject")
    public @ResponseBody
    Message saveProject(Project project) {
        boolean b = projectService.saveProject(project);
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

    @RequestMapping("getAllProject")
    public @ResponseBody
    List<Project> getAllProject() {
        List<Project> allPrject = projectService.getAllProject(null);
        if (allPrject != null) {
            return allPrject;
        }
        return null;
    }


}
