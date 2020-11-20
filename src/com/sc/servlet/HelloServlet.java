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
 * 日期：2020/9/8 10:50
 * 版本：V1.0
 */
//配置servlet的url地址，访问路径：http://localhost:8080/jsp_2/hello
//@WebServlet(name = "HelloServlet")
public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("1.初始化Servlet");
    }

    //如果是地址栏填写地址和超链接请求，是get方法请求，重写doGet方法
    //如果是表单提交，由method属性的值是get还是post方法，对用重写doGet或doPost方法
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("2.处理get方法的请求");

        //设置响应的文件类型和字符编码
        response.setContentType("text/html;charset=gbk");
        //获取输出流对象
        PrintWriter writer = response.getWriter();
        //输出内容
        writer.println("<h1>你好，servlet!</h1>");
        //关闭流
        writer.close();
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("3.销毁Servlet");
    }
}
