/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import KonkesiDB.UserID;
import KonkesiDB.koneksi;
import View.FrmLogin;
import View.FrmMainMenu;
import View.FrmTransaksi;
import controller.con_login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Garjito
 */
public class model_login implements con_login {

    @Override
    public void Login(FrmLogin lgn) throws SQLException {
    try {
            Connection con = koneksi.getKoneksi();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM user where username='"+lgn.txtUsername.getText()+"' and password = '"+lgn.txtPass.getText()+"'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                UserID.setUserLogin(lgn.txtUsername.getText());
                if(rs.getString(4).equals("Admin")){
                    new FrmMainMenu().show();
                    lgn.dispose();
                }else if(rs.getString(4).equals("Kasir")){
                    new FrmTransaksi().show();
                    lgn.dispose();
                } else {
                    JOptionPane.showMessageDialog(lgn, "Password Anda Salah");
                    Bersih(lgn);
                }
            } else {
                JOptionPane.showMessageDialog(lgn, "Username Belum Terdaftar");
                Bersih(lgn);
                lgn.txtUsername.requestFocus();
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void Bersih(FrmLogin lgn) throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        lgn.txtUsername.setText(null);
        lgn.txtPass.setText(null);
        lgn.txtUsername.requestFocus();
    }
    
}
