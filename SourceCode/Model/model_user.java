/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import KonkesiDB.koneksi;
import View.FrmUser;
import controller.con_user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Garjito
 */
public class model_user implements con_user {

    @Override
    public void Simpan(FrmUser usr) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "INSERT user values (?,?,?,?)";
            PreparedStatement prepare = con.prepareStatement(sql);
            
            prepare.setString(1, usr.txt_iduser.getText());
            prepare.setString(2, usr.txtusername.getText());
            prepare.setString(3, usr.txtpass.getText());
            prepare.setString(4, usr.cmbLevel.getSelectedItem().toString());
            prepare.executeUpdate();
            
            
            prepare.close();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            Tampil(usr);
            usr.setLebarKolom();
            Bersih(usr);
            AutoNomor(usr);
        }
    }

    @Override
    public void Ubah(FrmUser usr) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "UPDATE user set username = ?, "
                    + "password = ?, "
                    + "level = ? "
                    + "where id_user = ?";
            PreparedStatement prepare = con.prepareStatement(sql);
            
            prepare.setString(1, usr.txtusername.getText());
            prepare.setString(2, usr.txtpass.getText());
            prepare.setString(3, usr.cmbLevel.getSelectedItem().toString());
            prepare.setString(4, usr.txt_iduser.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Tampil(usr);
            usr.setLebarKolom();
            Bersih(usr);
            AutoNomor(usr);
        }
    }

    @Override
    public void Hapus(FrmUser usr) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "DELETE from user where id_user = ?";
            PreparedStatement prepare = con.prepareStatement(sql);
            
            prepare.setString(1, usr.txt_iduser.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            prepare.close();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            Tampil(usr);
            usr.setLebarKolom();
            Bersih(usr);
            AutoNomor(usr);
        }
    }

    @Override
    public void Tampil(FrmUser usr) throws SQLException {
        usr.tbl.getDataVector().removeAllElements();
        usr.tbl.fireTableDataChanged();
        try {
            Connection con = koneksi.getKoneksi();
            Statement st = con.createStatement();
            String sql = "SELECT * from user order by id_user asc";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] ob = new Object[8];
                ob[0] = rs.getString(1);
                ob[1] = rs.getString(2);
                ob[2] = rs.getString(3);
                ob[3] = rs.getString(4);
                usr.tbl.addRow(ob);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Bersih(FrmUser usr) throws SQLException {
        usr.txt_iduser.setText(null);
        usr.txtusername.setText(null);
        usr.txtpass.setText(null);
        usr.cmbLevel.setSelectedItem("Level");
        usr.txtusername.requestFocus();
    }

    @Override
    public void KlikTabel(FrmUser usr) throws SQLException {
        try {
            int pilih = usr.tblUser.getSelectedRow();
            if (pilih == -1) {
                return;
            }
            usr.txt_iduser.setText(usr.tbl.getValueAt(pilih, 0).toString());
            usr.txtusername.setText(usr.tbl.getValueAt(pilih, 1).toString());
            usr.txtpass.setText(usr.tbl.getValueAt(pilih, 2).toString());
            usr.cmbLevel.setSelectedItem(usr.tbl.getValueAt(pilih, 3).toString());
        } catch (Exception e) {
            
        }
    }

    @Override
    public void AutoNomor(FrmUser usr) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            
            Statement st = con.createStatement();
            String sql = "SELECT max(id_user) from user";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                int a = rs.getInt(1);
                usr.txt_iduser.setText(""+ Integer.toString(a+1));
            }
        } catch (Exception e) {
            System.out.println(""+ e.getMessage());
        }
    }
    }
    

