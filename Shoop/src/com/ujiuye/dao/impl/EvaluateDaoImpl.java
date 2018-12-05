package com.ujiuye.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ujiuye.bean.EvaluateVo;
import com.ujiuye.dao.EvaluateDao;
import com.ujiuye.util.C3P0DataSource;

public class EvaluateDaoImpl implements EvaluateDao {

	@Override
	public boolean saveEvaluate(EvaluateVo vo) {
		String sql="insert into evaluate (dis,etime,uid,pid) values(?,SYSDATE(),?,?)";
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			int count = qr.update(sql,vo.getDis(),vo.getUid(),vo.getPid());
			if(count > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<EvaluateVo> getEvalByPid(int pid) {
		String sql="select * from evaluate where pid=?";
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			return qr.query(sql,new BeanListHandler<EvaluateVo>(EvaluateVo.class),pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
