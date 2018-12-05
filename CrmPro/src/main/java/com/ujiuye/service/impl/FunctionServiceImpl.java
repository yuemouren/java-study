package com.ujiuye.service.impl;

import com.ujiuye.bean.Function;
import com.ujiuye.bean.FunctionExample;
import com.ujiuye.mapper.FunctionMapper;
import com.ujiuye.service.FunctionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FunctionServiceImpl implements FunctionService {

    @Resource
    private FunctionMapper functionMapper;

    @Override
    public boolean saveFunction(Function function) {
        int insert = functionMapper.insert(function);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Function> getFunByModeleFk(Integer modeleFk) {
        FunctionExample fe = new FunctionExample();
        FunctionExample.Criteria criteria = fe.createCriteria();
        criteria.andModeleFkEqualTo(modeleFk);
        return functionMapper.selectByExample(fe);
    }
}
