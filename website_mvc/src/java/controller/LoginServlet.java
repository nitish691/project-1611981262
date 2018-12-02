package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import modal.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("LoginServlet called");
        try
        {
        PrintWriter out = response.getWriter();
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
         
        authenDAO adao = new authenDAO();
        adminDAO ad = new adminDAO();
        if(adao.validate(userid, password))
        {
            System.out.println("adao.validate(userid, password) : " + adao.validate(userid, password));
            out.print("Welcome "+ adao.getName()+"\n");
            HttpSession session=request.getSession();
            session.setAttribute("s_id",adao.getUserid());
            session.setAttribute("s_username",adao.getName());
            session.setAttribute("obj",adao.getS());
            response.sendRedirect("home.jsp");
        }
        else if(ad.validate(userid, password))
        {
            response.sendRedirect("admin_home.html"); 
        }
        else
        {
            response.sendRedirect("index.html"); 
        }
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}




