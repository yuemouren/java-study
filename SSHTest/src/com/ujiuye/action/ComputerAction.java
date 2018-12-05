package com.ujiuye.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ujiuye.bean.Computer;
import com.ujiuye.service.ComputerService;
import com.ujiuye.util.MessageInfo;
import com.ujiuye.util.Page;
import com.ujiuye.util.WriterJsonUtil;

@Controller
@ParentPackage("struts-default")
@Namespace("/")
public class ComputerAction extends ActionSupport implements ModelDriven<Computer>{
	
	@Resource
	private ComputerService computerService;
	
	private Computer com = new Computer();
	
	private Integer currentPage;// 当前页
	private Integer perPageRows;// 每页的记录数
	
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPerPageRows() {
		return perPageRows;
	}

	public void setPerPageRows(Integer perPageRows) {
		this.perPageRows = perPageRows;
	}

	@Override
	public Computer getModel() {
		// TODO Auto-generated method stub
		return com;
	}
	
	@Action(value="saveComputer",results= {
			@Result(name="success",location="/show.jsp",type="redirect"),
			@Result(name="error",location="error.jsp")
	})
	public String saveComputer() {
		int cid = computerService.saveComputer(com);
		if(cid > 0) {
			return SUCCESS;
		}
		return "error";
	}
	
	@Action(value="getAllInfo")
	public void getAllInfo() {
		Page page = new Page();
		int count = computerService.getCount();
		
		page.setPerPageRows(perPageRows);
		page.setCurrentPage(currentPage);
		int total = (count%page.getPerPageRows() == 0)?(count/page.getPerPageRows()):(count/page.getPerPageRows()+1);
		page.setTotalPages(total);
		page.setTotalRows(count);
		List<Computer> allInfo = computerService.getAllInfo(page);
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		Map<String,Object> map = new HashMap<String,Object>();
 		map.put("computer",allInfo);
 		map.put("page",page);
		if(allInfo != null) {
			WriterJsonUtil.getJson(map, req, resp);
		}else {
			WriterJsonUtil.getJson(null, req, resp);
		}
	}
	
	@Action(value="deleteOneInfo")
	public void deleteOneInfo() {
		
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		int cid =Integer.parseInt(req.getParameter("cid"));
		String info = computerService.deleteOneInfo(cid);
		MessageInfo mi = new MessageInfo();
		
		if(info.equals("success")) {
			mi.setFlag(true);
			mi.setMessage("删除成功");
		}else {
			mi.setFlag(false);
			mi.setMessage("删除失败");
		}
		WriterJsonUtil.getJson(mi, req, resp);
	}
	
	@Action(value="getOneInfo",results= {
			@Result(name="success",location="/update.jsp",type="redirect"),
			@Result(name="error",location="error.jsp")
	})
	public String getOneInfo() {
		HttpServletRequest req = ServletActionContext.getRequest();
		int cid = Integer.parseInt(req.getParameter("cid"));
		Computer oneInfo = computerService.getOneInfo(cid);
		
		if(oneInfo != null) {
			req.getSession().setAttribute("computer",oneInfo);
			return SUCCESS;
		}
		return "error";
	}
	
	@Action(value="updateOneInfo",results= {
			@Result(name="success",location="/show.jsp",type="redirect"),
			@Result(name="error",location="error.jsp")
	})
	public String updateOneInfo() {
		boolean updateOneInfo = computerService.updateOneInfo(com);
		if(updateOneInfo) {
			return SUCCESS;
		}
		return "error";
	}
	
	@Action(value="deleteBatchInfo")
	public void deleteBatchInfo() {
		
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		String ids = req.getParameter("ids");
		boolean batchInfo = computerService.deleteBatchInfo(ids);
		MessageInfo mi = new MessageInfo();
		if(batchInfo) {
			mi.setFlag(true);
			mi.setMessage("删除成功");
		}else {
			mi.setFlag(false);
			mi.setMessage("删除失败");
		}
		WriterJsonUtil.getJson(mi, req, resp);
	}
}
