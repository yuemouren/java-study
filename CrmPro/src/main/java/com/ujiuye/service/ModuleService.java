package com.ujiuye.service;

import com.ujiuye.bean.Module;

import java.util.List;

public interface ModuleService {

    public boolean saveModule(Module module);

    public List<Module> getAllModuleByAnFk(int analysisFk);
}
