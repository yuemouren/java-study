package com.ujiuye.service.impl;

import com.ujiuye.bean.Analysis;
import com.ujiuye.mapper.AnalysisMapper;
import com.ujiuye.service.AnalysisService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class AnalysisServiceImpl implements AnalysisService {

    @Resource
    private AnalysisMapper analysisMapper;

    @Override
    public boolean saveAnalysis(Analysis analysis) {
        analysis.setAddtime(new Date());
        analysis.setUpdatetime(new Date());
        int insert = analysisMapper.insert(analysis);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Analysis getAnalAndMod(Integer pid) {
        Analysis analysis = analysisMapper.selectByPrimaryKey(pid);
        return analysis;
    }


}
