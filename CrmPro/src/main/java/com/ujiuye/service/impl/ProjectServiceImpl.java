package com.ujiuye.service.impl;

import com.ujiuye.bean.Project;
import com.ujiuye.bean.ProjectExample;
import com.ujiuye.mapper.ProjectMapper;
import com.ujiuye.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public boolean saveProject(Project project) {
        int insert = projectMapper.insert(project);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Project> getAllProject(ProjectExample projectExample) {
        return projectMapper.selectByExample(null);
    }

}
