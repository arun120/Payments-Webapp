/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Home
 */
public class Account {
    
    private String name;
    private String mobile;
    private String balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
    
    
     public  boolean insert(){
    Connection conn=null;
       Statement stmt=null;
       int update=0;
       try{
           conn=new Dbdetails().getConnection("account");
           stmt=conn.createStatement();
           
           String sql;
        
           sql="insert into customer values(null,'"+name+"','"+mobile+"','"+balance+"')";
       update+=stmt.executeUpdate(sql);
           
     
       
       }catch(Exception e){
       e.printStackTrace();
       }finally{
           try {
               if(stmt!=null)
                   stmt.close();
               if(conn!=null)
                   conn.close();
           } catch (SQLException ex) {
               ex.printStackTrace();
           }
       
       }
       if(update==1)
           return true;
       else
           return false;
    }
    
     
      public  boolean updateBalance(){
    Connection conn=null;
       Statement stmt=null;
       int update=0;
       try{
           conn=new Dbdetails().getConnection("account");
           stmt=conn.createStatement();
           
           String sql;
        
           sql="update customer set balance='"+balance+"' where mobile='"+mobile+"'";
       update+=stmt.executeUpdate(sql);
           
     
       
       }catch(Exception e){
       e.printStackTrace();
       }finally{
           try {
               if(stmt!=null)
                   stmt.close();
               if(conn!=null)
                   conn.close();
           } catch (SQLException ex) {
               ex.printStackTrace();
           }
       
       }
       if(update==1)
           return true;
       else
           return false;
    }
      
      
    public  static Account getbyMobile(String number){
    Connection conn=null;
       Statement stmt=null;
       Account a=null;
       int update=0;
       try{
           conn=new Dbdetails().getConnection("account");
           stmt=conn.createStatement();
           
           String sql;
        
           sql="select * from customer where mobile='"+number+"'";
           
       ResultSet rs=stmt.executeQuery(sql);
       if(rs.next()){
           
           a=new Account();
           a.setName(rs.getString("name"));
           a.setMobile(rs.getString("mobile"));
           a.setBalance(rs.getString("balance"));
       
       }
           
     
       
       }catch(Exception e){
       e.printStackTrace();
       }finally{
           try {
               if(stmt!=null)
                   stmt.close();
               if(conn!=null)
                   conn.close();
           } catch (SQLException ex) {
               ex.printStackTrace();
           }
       
       }
     
           return a;
    }
    
}
