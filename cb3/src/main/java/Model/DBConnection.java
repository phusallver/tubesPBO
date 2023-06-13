/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class DBConnection {
    private final static String user = "uname2";
    private final static String pass = "2emanu";
    private final static String url = "jdbc:mysql://localhost:3306/perpus";
    public static Connection conn;
    
    public static void connect(){
        try{
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Berhasil melakukan koneksi");
        } catch (SQLException ex) {
            System.out.println("Gagal melakukan koneksi"+ ex);
        }
        
    }
}
