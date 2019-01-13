/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import KonkesiDB.koneksi;
import View.FrmCariBarang;
import View.FrmTransaksi;
import controller.con_caribarang;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Garjito
 */
public class model_caribarang implements con_caribarang {

    @Override
    public void Tampil(FrmCariBarang cb) throws SQLException {
             cb.tbl.getDataVector().removeAllElements();
        cb.tbl.fireTableDataChanged();
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
                cb.tbl.addRow(ob);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void KlikTabel(FrmCariBarang cb) throws SQLException {
        try {
            int pilih = cb.tblCariBarang.getSelectedRow();
            if (pilih == -1) {
                return;
            }
            FrmTransaksi.txtKodeBarang.setText(cb.tbl.getValueAt(pilih, 0).toString());
            FrmTransaksi.txtNamaBarang.setText(cb.tbl.getValueAt(pilih, 1).toString());
            FrmTransaksi.txtHarga.setText(cb.tbl.getValueAt(pilih, 3).toString());
            FrmTransaksi.txtBanyak.setText("1");
            FrmTransaksi.btnProses.requestFocus();
        } catch (Exception e) {
        }
    }

    @Override
    public void Cari(FrmCariBarang cb) throws SQLException {
          cb.tbl.getDataVector().removeAllElements();
        cb.tbl.fireTableDataChanged();
        try {
            Connection con = koneksi.getKoneksi();
            Statement st = con.createStatement();
            String sql = "select * from barang where NamaBarang like '%" + cb.txtCari.getText() + "%'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] ob = new Object[8];
                ob[0] = rs.getString(1);
                ob[1] = rs.getString(2);
                ob[2] = rs.getString(3);
                ob[3] = rs.getString(4);
                ob[4] = rs.getString(5);
                cb.tbl.addRow(ob);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
