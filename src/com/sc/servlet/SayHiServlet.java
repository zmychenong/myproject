package com.sc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 类名：${NAME}
 * 描述：一段话描述类的信息
 * 作者：陈龙
 * 日期：2020/9/8 11:19
 * 版本：V1.0
 */
//@WebServlet(name = "SayHiServlet")
public class SayHiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //第一部分：请求处理
        //设置请求字符编码
        request.setCharacterEncoding("UTF-8");
        //获取请求参数值
        String username = request.getParameter("username");
        System.out.println("接收的参数值是："+username);


       //第二部分：响应处理
        //设置响应的文件类型和字符编码
        response.setContentType("text/html;charset=gbk");
        //获取输出流对象
        PrintWriter writer = response.getWriter();
        //输出内容
        writer.println("<h1>你好，"+username+"!</h1>");
        //关闭流
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
