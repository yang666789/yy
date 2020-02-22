package com.yy.controller;

import com.yy.Dao.IUserDao;
import com.yy.Dao.impl.UserDaoImpl;
import com.yy.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String uname=request.getParameter("name");
        String upwd=request.getParameter("pwd");
        PrintWriter out=response.getWriter();

        IUserDao userDao=new UserDaoImpl();
        User user=userDao.getUser(uname);
        if(user!=null){
            if(upwd.equals(user.getPassword())){
                //密码正确0
                out.print(0);
            }else {
                //密码错误1
                out.print(1);
            }
        }else {
            //不存在用户2
            out.print(2);
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
