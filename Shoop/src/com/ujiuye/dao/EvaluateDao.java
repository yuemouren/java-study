package com.ujiuye.dao;

import java.util.List;

import com.ujiuye.bean.EvaluateVo;

public interface EvaluateDao {
	
	public boolean saveEvaluate(EvaluateVo vo);
	
	public List<EvaluateVo> getEvalByPid(int pid);
}
