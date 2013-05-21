/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lab1.controller;

import java.sql.*;


/**
 *
 * @author Ritz
 */
public class connection 
{
    Connection con=null;
        
    public Connection connect()
    {
                
        try
        {
            
            Class.forName("org.sqlite.JDBC");
            con= DriverManager.getConnection("jdbc:sqlite:R:\\SQLiteDB\\book_store.db");  
            System.out.println("connected");                
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
    
    public Connection disconnect() throws SQLException
    {
        con.close();
        System.out.println("Disconnected");                
        return con;
    }
    
    ResultSet getData(String query){
        ResultSet rs=null;
        return rs;
    }
    
   // boolean setData(String query){
        
        
    //}
    
}
