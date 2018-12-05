package com.ujiuye.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.bean.Product;
import com.ujiuye.service.ProductService;
import com.ujiuye.util.IdUtil;

@SessionAttributes(value= {"onePro","pageInfo","cid","like"})
@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Resource
	private ProductService  productService;
	
	@RequestMapping("getIndex")
	@ResponseBody
	public  Map<String,List<Product>>  getIndex(){
		Map<String,List<Product>> map = new HashMap<String,List<Product>>();
		map.put("hot",productService.getHot());
		map.put("newPro",productService.getNew());
		return map;
	}
	

	@RequestMapping("getPro")
	public  String  getPro(int pid,Model model) {
		Product pro = productService.getPro(pid);
		model.addAttribute("onePro",pro);
		return "redirect:../product_info.jsp";
	}
	
	@RequestMapping("getProByCid")
	public String getProByCid(int cid,Map<String,Object> map,@RequestParam(value="currentPage",required=true,defaultValue="1") int currentPage) {
		PageHelper.startPage(currentPage,12);
		List<Product> proByCid = productService.getProByCid(cid);
		PageInfo<Product> info = new PageInfo<Product>(proByCid);
		map.put("pageInfo",info);
		map.put("cid",cid);
		return "redirect:../product_list.jsp";
	}
	
	@RequestMapping("likeSerach")
	public String likeSerach(String searchinfo,Map<String,Object> map,@RequestParam(value="currentPage",required=true,defaultValue="1") int currentPage) {
		PageHelper.startPage(currentPage,12);
		List<Product> likeSerach = productService.likeSerach(searchinfo);
		PageInfo<Product> info = new PageInfo<Product>(likeSerach);
		map.put("pageInfo",info);
		map.put("like",searchinfo);
		return "redirect:../product_list.jsp";
	}
	
	@RequestMapping("getAllPro")
	@ResponseBody
	public Map<String,Object> getAllPro(int page,int rows){
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<Product> allPro = productService.getAllPro(page,rows);
		int count = productService.getCount(null);
		map.put("rows",allPro);
		map.put("total",count);
		return map;
	}
	
	@RequestMapping("addProduct")
	public String addProduct(Product product,@RequestParam("uploadfile") MultipartFile uploadfile,@RequestParam("cid") int cid) {
		
		String path = "D:\\mypicture\\products\\1\\";
		
		String filename = "";
		if(uploadfile.getSize() > 0) {
			
			filename = IdUtil.getId()+"_"+uploadfile.getOriginalFilename();
			
			File file = new File(path+filename);
			
			try {
				uploadfile.transferTo(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		product.setPdate(new Date());
		product.setPimage("products\\1\\"+filename);
		
		boolean addProduct = productService.addProduct(product, cid);
		if(addProduct) {
			return "redirect:../admin/main.jsp";
		}else {
			return "rediredt:../admin/error.jsp";
		}
	}
}
