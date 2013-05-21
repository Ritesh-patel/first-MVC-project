/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab1.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ritz
 */
public class cust_info 
{
    connection cn=new connection();
    Connection con=null;
    
    public void addData(String name, String cno, String address, String eid)
    {
        PreparedStatement pst=null;  
        //Statement st;
        String str="insert into cust_info(name,c_no,address,email) values(?,?,?,?)";   
        //String str1="insert into cust_info(c_no) values(1234)";   
        //str1+=name+",";
        //str1+=cno+",";
        //str1+=address+",";
        //str1+=eid+")";
        try 
        {                    
            con=cn.connect();
            System.out.println("10");
            pst=con.prepareStatement(str);
            System.out.println("11");
            pst.setString(1, name);
            System.out.println("12");
            pst.setInt(2, Integer.parseInt(cno));
            System.out.println("13");
            pst.setString(3,address);
            System.out.println("14");
            pst.setString(4, eid);
            System.out.println("15");            
            pst.executeUpdate();
            //System.out.println(str1);            
            //st=con.createStatement();
            //System.out.println("16");
            //st.executeUpdate(str1);
            con=cn.disconnect();
            System.out.println("17");
            
            //st.close();
            con.close();
            pst.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(cust_info.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
