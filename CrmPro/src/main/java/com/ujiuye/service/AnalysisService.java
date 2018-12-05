package com.ujiuye.service;

import com.ujiuye.bean.Analysis;

public interface AnalysisService {
    public boolean saveAnalysis(Analysis analysis);

    public Analysis getAnalAndMod(Integer pid);
}
