package com.ujiuye.service.impl;

import com.ujiuye.bean.EvaluateVo;
import com.ujiuye.dao.EvaluateDao;
import com.ujiuye.dao.impl.EvaluateDaoImpl;
import com.ujiuye.service.EvaluateService;

public class EvaluateServiceImpl implements EvaluateService {
    private EvaluateDao dao = new EvaluateDaoImpl();
	@Override
	public boolean saveEvaluate(EvaluateVo vo) {
		// TODO Auto-generated method stub
		return dao.saveEvaluate(vo);
	}
}
