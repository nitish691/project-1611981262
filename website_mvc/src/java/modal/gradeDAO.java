/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Hp-user
 */
public class gradeDAO {
    public boolean insert(String userid, String grade)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false","root" ,"");
            String query="insert into grade(userid,grade) values (?, ?);";
            PreparedStatement ps= con.prepareStatement(query);
            ps.setString(1,userid);
            ps.setString(2,grade);
            ps.execute();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
}
