<%-- 
    Document   : home
    Created on : 22 Nov, 2018, 1:12:39 PM
    Author     : Hp-user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, modal.*"%>
<%@ page import="java.util.*"%>
<html>
<head>
    <title>Student-home</title>
	
    <link rel="stylesheet" type="text/css" href="style.css">   
</head>
    <body>
    
	<hr size="2">
<div style="height:80px;width:100%;background-color:#00b33c;font-family:calibri;font-size:65px;text-align:center;"> Dashboard
</div>
<hr size="2">
<%
    if(session.getAttribute("s_id") == null)
    {
        System.out.println("s_id" + session.getAttribute("s_id"));
        response.sendRedirect("index.html");
    }
    else
    {
%>
         
  <div class="abc">
  <a class="active" href="home.jsp">Home</a>
  <a href="course.html">Course</a>
  <a href="grade.jsp">Grade</a>
   <div class="abc-right">
       
    <a href="index.html">Logout</a>
  </div>
</div>

<hr size="2">
    
	<div class="bg-image"></div>
	
<div class="bg-text">
  <h2>Hi  <%=session.getAttribute("s_username")%> (<%=session.getAttribute("s_id")%>)!</h2>
  <%
	authen S = (authen)session.getAttribute("obj");
  %>
  <table>
	<tr>
		<td>
			<h3>ID : </h3>
		</td>
		<td>
			<%=S.getUserid()%>
		</td>
	</tr>
	<tr>
		<td>
			<h3>Name : </h3>
		</td>
		<td>
			<%=S.getName()%>
		</td>
	</tr>
	<tr>
		<td>
			<h3>Mobile Number : </h3>
		</td>
		<td>
			<%=S.getMob()%>
		</td>
	</tr>
	<tr>
		<td>
			<h3>Email ID : </h3>
		</td>
		<td>
			<%=S.getEmail()%>
		</td>
	</tr>
	<tr>
		<td>
			<h3>Father's Name : </h3>
		</td>
		<td>
			<%=S.getFname()%>
		</td>
	</tr>
	<tr>
		<td>
			<h3>Mother's Name : </h3>
		</td>
		<td>
			<%=S.getMname()%>
		</td>
	</tr>
  </table>
</div>

    </body>
</html>
<%
    }
%>