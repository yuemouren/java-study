package com.ujiuye.service;

import com.ujiuye.bean.Project;
import com.ujiuye.bean.ProjectExample;

import java.util.List;

public interface ProjectService {

    public boolean saveProject(Project project);

    public List<Project> getAllProject(ProjectExample projectExample);

}
