/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Home
 */
public class Dbdetails {
    
    
    final private static String Driver="com.mysql.jdbc.Driver";
    final private static String UserName="root";
    final private static String Pass="1234";
    final private static String  Url="jdbc:mysql://localhost:3306/";
    
     Dbdetails()
    {
    }
   
    

    public String getDriver() {
        return Driver;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPass() {
        return Pass;
    }

    public String getUrl() {
        return Url;
    }
    
     public Connection getConnection(String dbname)
    {
        Connection con=null;
        try {  
             Class.forName(Driver).newInstance();
            con = DriverManager.getConnection(Url+dbname,UserName,Pass);
             
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    return con;
    }
}
