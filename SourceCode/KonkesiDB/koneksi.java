/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KonkesiDB;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Garjito
 */
public class koneksi {
    public static void main(String[] args){
        new koneksi().getKoneksi();
    }
    private static Connection koneksi;
    
    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/db_kasir";
                String username = "root";
                String pass = "";
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, username, pass);
                System.out.println("Koneksi Database Sukses");
            } catch (Exception e) {
                System.out.println(e);
            }
        }return koneksi;
    }
}
