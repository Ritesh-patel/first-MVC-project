package com.lab1.controller;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ritz
 */
public class book_data {

    connection cn = null;
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    public book_data() {
        System.out.println("enter...book_data....");
        cn = new connection();
        con = cn.connect();
    }
    String str = "select * from book_info where qty>0;";
    //System.out.println(str);

    public ArrayList<book> getList() {
        ArrayList<book> list = new ArrayList<book>();

        try {
            st = con.createStatement();

            rs = st.executeQuery(str);
            int i = 0;
            while (rs.next()) {
                //book b;
                book b = new book();
                b.setAuthor(rs.getString("author"));
                //System.out.println(b.getAuthor());
                b.setBook_id(rs.getInt("book_id"));
                b.setImage_name(rs.getString("image_name"));
                b.setIsbn(rs.getLong("isbn"));
                b.setPrice(rs.getInt("price"));
                b.setPublisher(rs.getString("publisher"));
                b.setQty(rs.getInt("qty"));
                b.setTitle(rs.getString("title"));
                b.setOrder(i % 2);
                list.add(b);
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(book_data.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        con = cn.disconnect();
        con.close();
    }
}
