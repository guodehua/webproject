package org.lanqiao.controller;

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
import javax.servlet.http.HttpSession;


@WebServlet(name = "imagServlet", urlPatterns = { "/imag.do" })
public class ImagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imag = "ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuioplkjhgfdsazxcvbnm0123456789";
		//生成一个0-61之间的随机数
		Random rand = new Random();
		//生成一个4位 的验证码code
		StringBuilder sb = new StringBuilder();
		char[] c = new char[4];
		for (int i = 0; i < 4; i++) {
			int randNum = rand.nextInt(62);
			char chars =  imag.charAt(randNum);
			c[i] = chars;
			sb.append(c[i]);
		}
		String code = sb.toString();
		//生成一个内存中的图片，在图片中写入字符
		//创建一个内存中的图片
		BufferedImage bufferImage = new BufferedImage(100,40,BufferedImage.TYPE_INT_RGB);
		//绘制图片
		//拿到一个画笔 --> 绘制图片及图片内容
		Graphics g = bufferImage.getGraphics();
		//画边框
		g.setColor(Color.WHITE);
		g.drawRect(0, 0, 100-2, 40-2);
		g.setColor(Color.RED);//画笔的颜色
		
		g.setFont(new Font("宋体",Font.BOLD,20));
		//画验证符
		g.drawString(code, 10, 30);
		//输出图片；
		//指定输出为图片的数据格式
		//图片保存在Session
		HttpSession  session = request.getSession();
		session.setAttribute("code", code);
		response.setContentType("image/jpeg");
		ImageIO.write(bufferImage, "jpg", response.getOutputStream());
		response.getOutputStream().flush();
		//request.getRequestDispatcher("/WEB-INF/imag.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
