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

public class uploadmarks extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String user_name=request.getParameter("sid");  
        String user_grade=request.getParameter("cgpa");  
        gradeDAO gdao = new gradeDAO();
        if(gdao.insert(user_name, user_grade))
        {
            out.println("<script> alert(\"Marks updated successfully!\") </script>");
        }
        else
        {
            out.println("<script> alert(\"Some error occurred!\") </script>");
        }
        response.sendRedirect("admin_home.html");
    }
}




