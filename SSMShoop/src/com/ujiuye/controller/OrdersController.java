package com.ujiuye.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ujiuye.bean.Cart;
import com.ujiuye.bean.OrderitemVo;
import com.ujiuye.bean.Orders;
import com.ujiuye.bean.User;
import com.ujiuye.service.OrdersService;
import com.ujiuye.util.CharUtil;

@Controller
@RequestMapping("/orders")
@SessionAttributes(value = { "orders", "orderList" })
public class OrdersController {

	@Resource
	private OrdersService ordersService;

	@RequestMapping("saveOrders")
	public String saveOrders(Orders orders, HttpSession session) {

		User user = (User) session.getAttribute("activeuser");
		orders.setUid(user.getUid());
		orders.setOrdertime(new Date());
		Cart cart = (Cart) session.getAttribute("cart");

		boolean saveOrders = ordersService.saveOrders(orders, cart);

		if (saveOrders) {
			return "redirect:../index.jsp";
		} else {
			return "redirect:../error.jsp";
		}

	}

	@RequestMapping("getOrders")
	public String getOrders(HttpSession session, Model model) {
		User user = (User) session.getAttribute("activeuser");
		List<Orders> orders = ordersService.getAllOrders(user.getUid());
		model.addAttribute("orders", orders);
		if (orders != null) {
			return "redirect:../order_list.jsp";
		} else {
			return "redirect:../error.jsp";
		}
	}

	@RequestMapping("getAllOrders")
	public String getAllOrders(Model model) {
		List<Orders> allOrders = ordersService.getAllOrders();
		model.addAttribute("orderList", allOrders);
		if (allOrders != null) {
			return "redirect:../admin/order/list.jsp";
		} else {
			return "redirect:../admin/error.jsp";
		}
	}

	@RequestMapping("craeteTable")
	public String craeteTable() {
		List<Orders> allOrders = ordersService.getAllOrders();
		if (allOrders != null) {
			// 创建新excel文档，07版本之前均可以这么写
			HSSFWorkbook workBook = new HSSFWorkbook();
			// 新建工作表
			HSSFSheet sheet = workBook.createSheet("第一页");
			// 设置单元格的高度
			sheet.setColumnWidth(0, 2500);
			sheet.setColumnWidth(1, 5000);

			// 新建行
			HSSFRow row = sheet.createRow(0);

			HSSFCell cell[] = new HSSFCell[8];
			for (int i = 0; i < cell.length; i++) {
				// 取第一行第一列
				cell[i] = row.createCell(i);
			}
			// 给第一行所有列赋值
			cell[0].setCellValue("订单编号");
			cell[1].setCellValue("购买人");
			cell[2].setCellValue("电话");
			cell[3].setCellValue("收货地址");
			cell[4].setCellValue("总金额");
			cell[5].setCellValue("订单生成时间");
			cell[6].setCellValue("支付方式");

			for (int i = 0; i < allOrders.size(); i++) {
				Orders or = allOrders.get(i);
				HSSFRow dataRow = sheet.createRow(i + 1);
				// 创建盛放所有列的数组
				HSSFCell dataCell[] = new HSSFCell[8];
				for (int j = 0; j < dataCell.length; j++) {
					// 取得第一行所有列
					dataCell[j] = dataRow.createCell(j);
				}
				dataCell[0].setCellValue(or.getOid());
				dataCell[1].setCellValue(or.getName());
				dataCell[2].setCellValue(or.getTelephone());
				dataCell[3].setCellValue(or.getAddress());
				dataCell[4].setCellValue(or.getTotal());
				dataCell[5].setCellValue(or.getOrdertime());
				dataCell[6].setCellValue(or.getState());

				// 创建样式
				HSSFCellStyle cellStyle = workBook.createCellStyle();
				// 日期
				HSSFDataFormat format = workBook.createDataFormat();
				cellStyle.setDataFormat(format.getFormat("yyyy年MM月dd日"));
				dataCell[5].setCellStyle(cellStyle);

				// 小数
				HSSFCellStyle cellStyle1 = workBook.createCellStyle();
				HSSFDataFormat format1 = workBook.createDataFormat();
				cellStyle1.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
				// 货币格式
				// cellStyle1.setDataFormat(format1.getFormat("¥#,##0"));
				dataCell[6].setCellStyle(cellStyle1);

				// 百分比
				HSSFCellStyle cellStyle2 = workBook.createCellStyle();
				HSSFDataFormat format2 = workBook.createDataFormat();
				cellStyle2.setDataFormat(format2.getFormat("0%"));
				dataCell[7].setCellStyle(cellStyle2);

			}

			File file = new File("D:\\Desktop\\orders.xls");
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(file);
				workBook.write(fos);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (fos != null) {
					try {
						fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return "redirect:../admin/main.jsp";
		} else {
			return "redirect:../admin/error.jsp";
		}
	}

	@RequestMapping("cartogram")
	public void cartogram(HttpServletResponse resp,HttpServletRequest req) throws IOException {

		DefaultPieDataset dataset = new DefaultPieDataset();

		List<OrderitemVo> vo = ordersService.getOrderitemVo();
		for (OrderitemVo ov : vo) {
			dataset.setValue(ov.getPname(), ov.getCount());
		}

		CharUtil.setChartTheme();
		// 平面饼状图
		/*
		 * JFreeChart chart = ChartFactory.createPieChart("水果产量比率图", dataset, true,
		 * true, false);
		 */

		// 3D饼状图
		JFreeChart chart = ChartFactory.createPieChart3D("商品销售比率图", dataset, true, true, false);

		CharUtil.setAntiAlias(chart);

		String fileName = ServletUtilities.saveChartAsPNG(chart, 400, 400, req.getSession());
		// String imageURL=req.getContextPath() + "/chart?filename="+fileName;
		// 将数据存放到session中
		// req.getSession().setAttribute("image", imageURL);
		ChartUtilities.writeChartAsPNG(resp.getOutputStream(), chart, 500, 300);
	}

}
