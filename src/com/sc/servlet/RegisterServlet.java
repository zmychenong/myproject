package com.sc.servlet;

import com.mysql.jdbc.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * 类名：${NAME}
 * 描述：一段话描述类的信息
 * 作者：陈龙
 * 日期：2020/9/8 11:39
 * 版本：V1.0
 */
//@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //第一部分：请求处理
        //设置请求字符编码
        request.setCharacterEncoding("UTF-8");
        //获取请求参数值
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String userAge = request.getParameter("userAge");
        String userSex = request.getParameter("userSex");
        System.out.println("接收的参数值是："+userName+" "+userPassword+" "+userAge+" "+userSex);

        //数据库操作start
        boolean isSuccess=false;//默认失败
        try {

            //1、注册Mysql数据库驱动
            Class.forName("com.mysql.jdbc.Driver");//名称不需要记住，导入后复制
            System.out.println("注册Mysql数据库驱动成功");
            //主要协议:次要协议://主机名称:端口号/数据库名称
            String url = "jdbc:mysql://localhost:3306/db202001";
            String username = "root";
            String password = "root";
            //2、通过驱动管理器获取连接对象，需传入url地址，用户名和密码
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("连接Mysql数据库成功");
            //3、通过连接对象创建预编译陈述对象
            String sql = "insert into userinfo values(null,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //4、执行之前，一定要给每个问好设置值
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,userPassword);
            preparedStatement.setInt(3,Integer.parseInt(userAge));
            preparedStatement.setString(4,userSex);
            //5、通过编译陈述对象执行sql语句
            preparedStatement.executeUpdate();//不再设置sql
            System.out.println("执行更新成功！");
            //6、依次关闭陈述对象、连接对象
            preparedStatement.close();
            connection.close();
            System.out.println("关闭资源成功！");
            isSuccess=true;//执行成功
        }catch (Exception e){
            System.out.println("数据库操作失败");
            e.printStackTrace();
        }
        //数据库操作end

        //第二部分：响应处理
        //设置响应的文件类型和字符编码
        response.setContentType("text/html;charset=gbk");
        //获取输出流对象
        PrintWriter writer = response.getWriter();
        //输出内容
        if(isSuccess) {
            writer.println("<center><h1>恭喜你，注册成功!</h1></center>");
        }else{
            writer.println("<center><h1>对不起，注册失败!</h1></center>");
        }
        //关闭流
        writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
