<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<html>
<head>
    <title>Student-grade</title>
	
    <link rel="stylesheet" type="text/css" href="style.css">   
</head>
    <body>
    
	<hr size="2">
<div style="height:80px;width:100%;background-color:#00b33c;font-family:calibri;font-size:65px;text-align:center;"> Dashboard
</div>
<hr size="2">

<div class="abc">
  <a href="home.jsp">Home</a>
  <a href="course.html">Course</a>
  <a class="active" href="grade.jsp">Grade</a>
  <div class="abc-right">
    <a href="index.html">Logout</a>
  </div>
</div>
<hr size="2">
<div class="bg-image"></div>
  <%
         try {
            String user_grade=""; 
            HttpSession ss= request.getSession();
            String id=(String)session.getAttribute("s_id");
            Class.forName("com.mysql.jdbc.Driver");
            Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root" ,"");
            String query="select * from grade where userid="+id;
            Statement st=con.createStatement();
            ResultSet rs= st.executeQuery(query);
            
            while(rs.next())
            {
            %><div class="bg-text">
            <h2>Your current CGPA:  <%=rs.getString("grade")%></h2>
			</div>
            <%
            }
        }
        catch (Exception e) {
          out.println("error"+e);
        }
    %>
    
    
    </body>
</html>