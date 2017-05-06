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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Home
 */
public class Transaction {
 
    private String number;
    private String amount;
    private String acc;
    private String ifsc;
    private String status;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }
    public  boolean insert(){
    Connection conn=null;
       Statement stmt=null;
       int update=0;
       try{
           conn=new Dbdetails().getConnection("account");
           stmt=conn.createStatement();
           
           String sql;
        
           sql="insert into transaction values(null,'"+number+"','"+acc+"','"+ifsc+"','"+amount+"','New')";
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

    public String getStatus() {
        return status;
    }
    
    
     public static List<Transaction> getAll(){
        List<Transaction> list=new ArrayList<Transaction>();
        Connection conbatch=null;
        Statement stmt=null;
        try{
         conbatch = new Dbdetails().getConnection("Axis");
                     stmt = conbatch.createStatement();
                    ResultSet rs=stmt.executeQuery("select * from transaction");
                    
                    rs.beforeFirst();
                    while(rs.next())
                    {
                    Transaction t=new Transaction();
                    t.setAcc(rs.getString("accnum"));
                    t.setAmount(rs.getString("amount"));
                    t.setIfsc(rs.getString("ifsc"));
                    t.setNumber(rs.getString("number"));
                    t.setStatus(rs.getString("status"));
                    list.add(t);
                    }
        }catch(Exception e){
        e.printStackTrace();
        }
        finally{
            try {
                if(stmt!=null)
                    stmt.close();
                if(conbatch!=null)
                    conbatch.close();
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
        
        return list;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
