package com.ujiuye.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.general.DefaultPieDataset;

import com.ujiuye.bean.Category;
import com.ujiuye.bean.OrderItemVo;
import com.ujiuye.bean.Orders;
import com.ujiuye.bean.Product;
import com.ujiuye.dao.OrderItemDao;
import com.ujiuye.dao.impl.OrderItemDaoImpl;
import com.ujiuye.service.CategoryService;
import com.ujiuye.service.OrdersService;
import com.ujiuye.service.ProductService;
import com.ujiuye.service.impl.CategoryServiceImpl;
import com.ujiuye.service.impl.OrdersServiceImpl;
import com.ujiuye.service.impl.ProductServiceImpl;
import com.ujiuye.util.CharUtil;
import com.ujiuye.util.IdUtil;
import com.ujiuye.util.MessageInfo;
import com.ujiuye.util.WriterJsonUtil;

@WebServlet(urlPatterns= {"/servlet/AdminServlet"})
public class AdminServlet extends HttpServlet {
	
	private ProductService service = new ProductServiceImpl();
	private CategoryService cservice  = new CategoryServiceImpl();
	private OrdersService oservice = new OrdersServiceImpl();
	private OrderItemDao odao = new OrderItemDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		System.out.println(method);
		if(method == null) {
			method = "addPro";
		}
		try {
			Method methods = AdminServlet.class.getDeclaredMethod(method,HttpServletRequest.class,HttpServletResponse.class);
			methods.invoke(this,req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	protected void Login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		MessageInfo mi = new MessageInfo();
		System.out.println("============");
		if("admin".equals(username)&&"admin".equals(password)) {
			mi.setFlag(true);
			mi.setMessage("admin/main");
		}else {
			mi.setFlag(false);
			mi.setMessage("admin/error");
		}
		WriterJsonUtil.getJson(mi, req, resp);
	}
	protected void showPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int start = Integer.parseInt(req.getParameter("rows"));//一次显示多少行
		int pagesize = Integer.parseInt(req.getParameter("page"));//从哪开始显示
		
		List<Product> allInfo = service.getAllInfo(pagesize, start);
		
		int count = service.getCount(null,null);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("rows",allInfo);
		map.put("total",count);
		WriterJsonUtil.getJson(map, req, resp);
	}
	
	protected void showCate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Category> allInfo = cservice.getAllInfo();
		WriterJsonUtil.getJson(allInfo, req, resp);
	}
	
	protected void addPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "D:\\mypicture";
		String truepath = "";
		File file = new File("path");;
		if(!file.exists()) {
			file.mkdirs();
		}
		
		// 构建一个上传文件的缓存区域
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 上传工具类
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 设置上传文件的字符编码集
		upload.setHeaderEncoding("UTF-8");
		
		// 统一接收表单数据
		Product product = new Product();
		product.setPid(IdUtil.getId());
		product.setPdate(new Date());
		String filename = null;
		int cid = 0;
		String name=null;
		try {
			List<FileItem> list = upload.parseRequest(req);
			System.out.println(list);
			for(FileItem f:list) {
				if(f.isFormField()) {
					if("pname".equals(f.getFieldName())) {
						product.setPname(f.getString("UTF-8").trim());
					}
					if("ishot".equals(f.getFieldName())) {
						product.setIshot(Integer.parseInt(f.getString("UTF-8").trim()));
					}
					if("marketprice".equals(f.getFieldName())) {
						product.setMarketprice(Double.parseDouble(f.getString("UTF-8").trim()));
					}
					if("shopprice".equals(f.getFieldName())) {
						product.setShopprice(Double.parseDouble(f.getString("UTF-8").trim()));
					}
					if("cid".equals(f.getFieldName())) {
						cid = Integer.parseInt(f.getString("UTF-8").trim());
					}
					if("pdesc".equals(f.getFieldName())) {
						product.setPdesc(f.getString("UTF-8").trim());
					}
					
				}else {
					name = f.getName();
					String uu = UUID.randomUUID().toString().replaceAll("-","");
					filename = uu+"_"+name;
					truepath = path+"/"+filename;
					
					FileOutputStream fos = new FileOutputStream(truepath);
					
					InputStream is = f.getInputStream();
					int count = 0;
					byte[] by = new byte[1024];
					while((count=(is.read(by)))!= -1) {
						fos.write(by,0,count);
					}
					
					is.close();
					fos.flush();
					fos.close();
				}
			}
			product.setPimage(filename);
			boolean flag = service.savePro(product, cid);
		    if(flag) {
				resp.sendRedirect(req.getContextPath()+"/admin/main.jsp");
			}else {
				resp.sendRedirect(req.getContextPath()+"/admin/error.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void createExcel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 构建一组数据
		 * 
		 * */   	
    	List<Orders> orderByUid = oservice.getOrderByUid(null);
    	
    	//创建新excel文档，07版本之前均可以这么写
    	HSSFWorkbook workBook = new HSSFWorkbook();
    	//新建工作表
    	HSSFSheet sheet = workBook.createSheet("第一页");  
    	//设置单元格的高度
        sheet.setColumnWidth(0, 2500);  
        sheet.setColumnWidth(1, 5000);
        
        //新建行
        HSSFRow row = sheet.createRow(0);  
        
        HSSFCell cell[] = new HSSFCell[8];  
        for(int i = 0; i < cell.length; i++){ 
        	 //取第一行第一列
            cell[i] = row.createCell(i);  
        } 
        //给第一行所有列赋值
        cell[0].setCellValue("订单编号");  
        cell[1].setCellValue("购买人");  
        cell[2].setCellValue("电话");  
        cell[3].setCellValue("收货地址");  
        cell[4].setCellValue("总金额");  
        cell[5].setCellValue("订单生成时间");
        cell[6].setCellValue("支付方式");
       
  
        for(int i = 0; i < orderByUid.size(); i++){  
            Orders or = orderByUid.get(i);  
            HSSFRow dataRow = sheet.createRow(i+1);  
            //创建盛放所有列的数组
            HSSFCell dataCell[] = new HSSFCell[8];  
            for(int j = 0; j < dataCell.length; j++){  	
            	//取得第一行所有列
                dataCell[j] = dataRow.createCell(j);  
            }  
            dataCell[0].setCellValue(or.getOid());  
            dataCell[1].setCellValue(or.getName());  
            dataCell[2].setCellValue(or.getTelephone());  
            dataCell[3].setCellValue(or.getAddress());  
            dataCell[4].setCellValue(or.getTotal());         
            dataCell[5].setCellValue(or.getOrdertime());
            dataCell[6].setCellValue(or.getState());
   
            //创建样式
            HSSFCellStyle cellStyle = workBook.createCellStyle();
            //日期
            HSSFDataFormat format= workBook.createDataFormat();
            cellStyle.setDataFormat(format.getFormat("yyyy年MM月dd日"));
            dataCell[5].setCellStyle(cellStyle); 
            
            //小数
            HSSFCellStyle cellStyle1 = workBook.createCellStyle();
            HSSFDataFormat format1= workBook.createDataFormat();
            cellStyle1.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
            //货币格式
            //cellStyle1.setDataFormat(format1.getFormat("¥#,##0"));
            dataCell[6].setCellStyle(cellStyle1);
            
            //百分比
            HSSFCellStyle cellStyle2 = workBook.createCellStyle();
            HSSFDataFormat format2= workBook.createDataFormat();
            cellStyle2.setDataFormat(format2.getFormat("0%"));
            dataCell[7].setCellStyle(cellStyle2);
                                    
        } 
        
        File file = new File("D:\\Desktop\\orders.xls");  
        FileOutputStream fos = new FileOutputStream(file);  
        workBook.write(fos);  
        fos.close(); 
        
        resp.sendRedirect(req.getContextPath()+"/admin/main.jsp");
        
	}
	
	protected void showOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Orders> orderByUid = oservice.getOrderByUid(null);
		req.getSession().setAttribute("orderList", orderByUid);
		resp.sendRedirect(req.getContextPath()+"/admin/order/list.jsp");
	}
	
	protected void cartogram(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DefaultPieDataset dataset = new DefaultPieDataset();  
		
		List<OrderItemVo> list = odao.getOv();
		for(OrderItemVo ov:list ) {
			 dataset.setValue(ov.getPname(),ov.getCount());  
		}
       
        CharUtil.setChartTheme();
        //平面饼状图
        /*JFreeChart chart = ChartFactory.createPieChart("水果产量比率图", dataset,  
                true, true, false);*/
        
        //3D饼状图
        JFreeChart chart = ChartFactory.createPieChart3D("商品销售比率图", dataset,  
                true, true, false);  

        CharUtil.setAntiAlias(chart);
       
        String fileName= ServletUtilities.saveChartAsPNG(chart,400, 400, req.getSession());
       // String imageURL=req.getContextPath() + "/chart?filename="+fileName;
        //将数据存放到session中
       // req.getSession().setAttribute("image", imageURL); 
        ChartUtilities.writeChartAsPNG(resp.getOutputStream(), chart,500, 300);
        
       
	}
	
}
