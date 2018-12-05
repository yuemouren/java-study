package com.ujiuye.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/CodeServlet")
public class CodeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("image/jpeg;charset=UTF-8");
		
		BufferedImage buffer = new BufferedImage(100,30,BufferedImage.TYPE_INT_RGB );
	
		Graphics gra = buffer.getGraphics();
		
		gra.setColor(Color.GRAY);
		gra.fillRect(0, 0, 100,30);
		
		gra.setColor(Color.RED);
		gra.drawRect(0, 0,100-1,30-1);
		
		String str = "按时打算担没收到吗三对三拉上看到啦SD卡啥时放假卡时间开放阿拉上看到啦SD卡阿拉山口到拉萨阿萨德克拉斯柯达奥斯卡大拉手快点啦";
		String code = "";
		for(int i = 0;i < 4;i++) {
			code += str.charAt(new Random().nextInt(str.length()));
		}
		req.getSession().setAttribute("code",code);
		System.out.println(code);
		gra.setColor(Color.GREEN);
		gra.setFont(new Font("宋体",Font.ITALIC,20));
		gra.drawString(code, 7, 20);
		
		ImageIO.write(buffer, "jpg",resp.getOutputStream());
	}
	
}
