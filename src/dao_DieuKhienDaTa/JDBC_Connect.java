/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_DieuKhienDaTa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PC ACER
 */
public class JDBC_Connect {
    public static Connection getCon(){
        final String url = "jdbc:mysql://localhost:3306/quanlysinhvien ";
        final String user = "root";
        final String pass = "";
        try{
            Connection con = DriverManager.getConnection(url, user, pass);
            return con;
        }
        catch(SQLException e){
            System.out.println("Loi ket noi DB");
        }
        return null;
    }
}
