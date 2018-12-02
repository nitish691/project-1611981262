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
public class signup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String userid=request.getParameter("sid");
            String name=request.getParameter("name");
            String password=request.getParameter("pwd");
            String mob=request.getParameter("mob");
            String email=request.getParameter("email");
            String fname=request.getParameter("fname");
            String mname=request.getParameter("mname"); 
            Class.forName("com.mysql.jdbc.Driver");
            Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root" ,"");
            String query="insert into authen() values(?,?,?,?,?,?,?)";
            PreparedStatement ps= con.prepareStatement(query);
            ps.setString(1,userid);
            ps.setString(2,name);
            ps.setString(3,password);
            ps.setString(4,mob);
            ps.setString(5,email);
            ps.setString(6,fname);
            ps.setString(7,mname);
            ps.execute();
            response.sendRedirect("admin_home.html");
            con.close();
            }
        catch (Exception e) {
            out.println("error"+e);
        }
    }
}




