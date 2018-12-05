package com.ujiuye.service;

import com.ujiuye.bean.Function;

import java.util.List;

public interface FunctionService {

    public boolean saveFunction(Function function);

    public List<Function> getFunByModeleFk(Integer modeleFk);
}
