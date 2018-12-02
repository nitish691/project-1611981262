/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hp-user
 */
public class authenDAO {
    private String name;
    private String userid;
    private authen S;
    
    public boolean validate(String userid, String password)
    {
        System.out.println("validate() called.");
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false","root" ,"");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from authen;");
            
            while(rs.next())
            {          
                String s1=rs.getString(1);               
                String s2=rs.getString(3);
                System.out.println("s1 : " + s1 + " s2 : " + s2);
                if(userid.equals(s1) && password.equals(s2))
                {
                    this.name = rs.getString(2);
                    this.userid = rs.getString(1);
                    
                    S = new authen();
                    S.setUserid(rs.getString(1));
                    S.setName(rs.getString(2));
                    S.setPassword(rs.getString(3));
                    S.setMob(rs.getString(4));
                    S.setEmail(rs.getString(5));
                    S.setFname(rs.getString(6));
                    S.setMname(rs.getString(7));
                    return true;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getUserid()
    {
        return userid;
    }
    
    public authen getS()
    {
        return S;
    }
}
