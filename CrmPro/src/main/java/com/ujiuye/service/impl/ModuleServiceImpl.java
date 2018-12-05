package com.ujiuye.service.impl;

import com.ujiuye.bean.Module;
import com.ujiuye.mapper.ModuleMapper;
import com.ujiuye.service.ModuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Resource
    private ModuleMapper moduleMapper;

    @Override
    public boolean saveModule(Module module) {
        int insert = moduleMapper.insert(module);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Module> getAllModuleByAnFk(int analysisFk) {

        return null;
    }
}
