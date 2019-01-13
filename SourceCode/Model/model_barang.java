/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import KonkesiDB.koneksi;
import View.FrmBarang;
import controller.con_barang;
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
public class model_barang implements con_barang {

    @Override
    public void Simpan(FrmBarang brg) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "INSERT into barang values(?,?,?,?,?)";
            PreparedStatement prepare = con.prepareStatement(sql);
            
            prepare.setString(1, brg.txtKode.getText());
            prepare.setString(2, brg.txtNama.getText());
            prepare.setString(3, brg.txtKodeKategori.getText());
            prepare.setString(4, brg.txtHarga.getText());
            prepare.setString(5, brg.txtStok.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Tampil(brg);
            brg.setLebarKolom();
            Bersih(brg);
        } 
    }

    @Override
    public void Ubah(FrmBarang brg) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "update barang set NamaBarang = ?, "
                    + "KodeKategori = ?, "
                    + "HargaBarang = ?, "
                    + "Stok = ? "
                    + "where KodeBarang = ?";
            PreparedStatement prepare = con.prepareStatement(sql);
            
            prepare.setString(1, brg.txtNama.getText());
            prepare.setString(2, brg.txtKodeKategori.getText());
            prepare.setString(3, brg.txtHarga.getText());
            prepare.setString(4, brg.txtStok.getText());
            prepare.setString(5, brg.txtKode.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Tampil(brg);
            brg.setLebarKolom();
            Bersih(brg);
        }
    }

    @Override
    public void Hapus(FrmBarang brg) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "delete from barang where KodeBarang = ?";
            PreparedStatement prepare = con.prepareStatement(sql);
            
            prepare.setString(1, brg.txtKode.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasi Dihapus");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Tampil(brg);
            brg.setLebarKolom();
            Bersih(brg);
        }
    }

    @Override
    public void Tampil(FrmBarang brg) throws SQLException {
            brg.tbl.getDataVector().removeAllElements();
        brg.tbl.fireTableDataChanged();
        try {
            Connection con = koneksi.getKoneksi();
            Statement st = con.createStatement();
            String sql = "select * from barang order by KodeBarang asc";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] ob = new Object[8];
                ob[0] = rs.getString(1);
                ob[1] = rs.getString(2);
                ob[2] = rs.getString(3);
                ob[3] = rs.getString(4);
                ob[4] = rs.getString(5);
                brg.tbl.addRow(ob);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Bersih(FrmBarang brg) throws SQLException {
        brg.txtKode.setText(null);
        brg.txtNama.setText(null);
        brg.cmbkategori.setSelectedItem("Kapsul");
        brg.txtKodeKategori.setText(null);
        brg.txtHarga.setText(null);
        brg.txtStok.setText(null);
        brg.txtKode.requestFocus();
    }

    @Override
    public void KlikTabel(FrmBarang brg) throws SQLException {
        try {
            int pilih = brg.tblBarang.getSelectedRow();
            String s = (String)brg.tblBarang.getModel().getValueAt(pilih, 4);
            if (pilih == -1) {
                return; 
            }
            brg.txtKode.setText(brg.tbl.getValueAt(pilih, 0).toString());
            brg.txtNama.setText(brg.tbl.getValueAt(pilih, 1).toString());
            brg.txtKodeKategori.setText(brg.tbl.getValueAt(pilih, 2).toString());
            brg.txtHarga.setText(brg.tbl.getValueAt(pilih, 3).toString());
            brg.txtStok.setText(brg.tbl.getValueAt(pilih, 4).toString());
        } catch (Exception e) {
        }
        try {
            Connection con = koneksi.getKoneksi();
            Statement st = con.createStatement();
            String sql = "select NamaKategori from kategori where KodeKategori = '"+brg.txtKode.getText()+"'";
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                Object[] ob = new Object[3];
                ob[1] = rs.getString(1);

                brg.cmbkategori.setSelectedItem(rs.getString("NamaKategori"));
            }
            rs.close(); st.close();
        } catch (Exception e) {
        }
    }

    @Override
    public void Combo(FrmBarang brg) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            Statement st = con.createStatement();
            String sql = "select NamaKategori from kategori";
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                Object[] ob = new Object[3];
                ob[1] = rs.getString(1);

                brg.cmbkategori.addItem((String) ob[1]);                                    
            }
            rs.close(); st.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }

    @Override
    public void Combo2(FrmBarang brg) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            Statement st = con.createStatement();
            String sql = "select KodeKategori from kategori where NamaKategori = '"+brg.cmbkategori.getSelectedItem()+"'";
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
                Object[] ob = new Object[3];
                ob[1] = rs.getString(1);

                brg.txtKodeKategori.setText(rs.getString("KodeKategori"));
            }
            rs.close(); st.close();
        } catch (Exception e) {
        }
    }
    
}
