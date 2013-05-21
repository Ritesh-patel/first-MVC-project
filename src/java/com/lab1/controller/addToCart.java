/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab1.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ritz
 */
public class addToCart {

    static List<Long> id = new ArrayList<Long>();
    static List<Integer> qty = new ArrayList<Integer>();
    connection cn = null;
    Connection con = null;

    public addToCart() {
        System.out.println("enter...Addtocart....");
        cn = new connection();
        //con = cn.connect();
    }

    public void acceptIsbn(Long isbn) {
        if (id.contains(isbn)) {
            int a = id.indexOf(isbn);
            qty.set(a, qty.get(a) + 1);
            //System.out.println(qty.get(a));
        } else {
            id.add(isbn);
            qty.add(1);
        }
    }

    public List<Long> getIsbn() {
        return id;
    }

    public List<Integer> getQty() {
        return qty;
    }

    public int getQty(Long isbn) throws SQLException {

        con = cn.connect();
        Statement st = null;
        ResultSet rs = null;
        st = con.createStatement();
        String str = "select qty from book_info where isbn=" + isbn;
        rs = st.executeQuery(str);
        int a = rs.getInt("qty");
        return a;
    }

    public void removeBook(int qty, Long isbn) {
        try {
            /*connection cn=new connection();
             Connection con=cn.connect();*/

            System.out.println(qty);
            //st.close();
            System.out.println("1");
            //rs.close();
            System.out.println("2");

            String aa = Integer.toString(qty);
            String Isbn = Long.toString(isbn);
            //Statement st1=null;
            PreparedStatement st1;
            //ResultSet rs1=null;

            String str = "update book_info set qty=? where isbn=?";
            //str=str+" where isbn="+isbn;
            st1 = con.prepareStatement(str);
            st1.setString(1, aa);
            st1.setString(2, Isbn);
            st1.executeUpdate();
            System.out.println(str);
            System.out.println("3");
            con = cn.disconnect();
            con.close();
            //st1.executeQuery(str);
            //rs1=st1.executeQuery(str);
            st1.close();
            System.out.println("4");
        } catch (SQLException ex) {
            Logger.getLogger(addToCart.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //con = cn.disconnect();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(addToCart.class.getName()).log(Level.SEVERE, null, ex);
            }
        }




    }
}
