/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab1.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ritz
 */
public class getBookName 
{
    connection cn=new connection();
    Connection con=null;
    Statement st;
    ResultSet rs;
    List<String> name=new ArrayList<String>();
    String nm;
     long tamt=0;
    int amt;
    public List<String> getName(List<Long> isbn) throws SQLException
    {
        con=cn.connect();
        System.out.println("enter...getBoookName....");
        Iterator i=isbn.iterator();
        while(i.hasNext())
        {            
            String str="select title from book_info where isbn="+i.next();
            str=str+";";
            st=con.createStatement();
            rs=st.executeQuery(str);            
            nm=rs.getString("title"); 
            if(name.contains(nm))
            {
                
            }
            else
            {
                name.add(nm);
            }
                
            //System.out.println(nm);
        }
        con=cn.disconnect();
        con.close();
        return name;
        
    }
    
    public long getAmount(List<Long> isbn, List<Integer> qty)
    {
        tamt=0;
        Iterator i=isbn.iterator();
        int j=0;
        con=cn.connect();
        while(i.hasNext())
        {      
            con=cn.connect();
            String str="select price from book_info where isbn="+i.next();
            str=str+";";
            try 
            {
                st=con.createStatement();
                rs=st.executeQuery(str);
                amt=rs.getInt("price");
                int qt=qty.get(j++);
                tamt=tamt+(amt*qt);
                con=cn.disconnect();
                con.close();
                //System.out.println(tamt);
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(getBookName.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                try {
                    con=cn.disconnect();
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(getBookName.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        return tamt;
    }
}
