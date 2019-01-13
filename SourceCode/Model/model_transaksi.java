/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import KonkesiDB.koneksi;
import View.FrmTransaksi;
import controller.con_transaksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.TableModel;

/**
 *
 * @author Garjito
 */
public class model_transaksi implements con_transaksi {

    @Override
    public void Simpan(FrmTransaksi tran) throws SQLException {
         try {
            Connection con = koneksi.getKoneksi();
            String sql = "insert transaksibarang values (?,?,?,?,?)";
            PreparedStatement prepare = con.prepareStatement(sql);
            
            prepare.setString(1, tran.idtransaksi.getText()); 
            prepare.setString(2, tran.KodeTransaksi.getText());  
            prepare.setString(3, tran.txtHarga.getText());
            prepare.setString(4, tran.txtBanyak.getText());
            prepare.setString(5, tran.txtTanggal.getText());
            prepare.executeUpdate();
            
            prepare.close();
        } catch (Exception e){
            System.out.println(e);
        }
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "insert detailtransaksi values (?,?)";
            PreparedStatement prepare = con.prepareStatement(sql);
            
            prepare.setString(1, tran.idtransaksi.getText());
            prepare.setString(2, tran.txtKodeBarang.getText());
            prepare.executeUpdate();
           
            prepare.close();
        } catch (Exception e) {
        }
        finally {
            Tampil(tran);
            AutoNomor(tran);
            Total(tran);
            Bersih(tran);
            tran.setLebarKolom();
        }
    }

    @Override
    public void Ubah(FrmTransaksi tran) throws SQLException {
           try {
            Connection con = koneksi.getKoneksi();
            String sql = "update transaksibarang set HargaBarang = '"+tran.txtHarga.getText()+"', "
                    + "JumlahBarang = '"+tran.txtBanyak.getText()+"' "
                    + "where id_transaksi = '"+tran.idtransaksi2.getText()+"'";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.executeUpdate();
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Tampil(tran);
            Bersih(tran);
            tran.txtKodeBarang.requestFocus();
        }
    }

    @Override
    public void Hapus(FrmTransaksi tran) throws SQLException {
         try {
            Connection con = koneksi.getKoneksi();
            String sql = "Delete from transaksibarang where id_transaksi = ?";
            PreparedStatement prepare = con.prepareStatement(sql);
            
            prepare.setString(1, tran.idtransaksi2.getText());
            prepare.executeUpdate();
            
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Tampil(tran);
            AutoNomor(tran);
            Bersih(tran);
            tran.setLebarKolom();
            Total(tran);
        }
    }

    @Override
    public void Tampil(FrmTransaksi tran) throws SQLException {
         tran.tbl.getDataVector().removeAllElements();
        tran.tbl.fireTableDataChanged();
        try {
            Connection con = koneksi.getKoneksi();
            Statement st = con.createStatement();
            String sql = "select a.id_transaksi, c.KodeBarang, c.NamaBarang, c.HargaBarang, a.JumlahBarang, a.HargaBarang from transaksibarang a join detailtransaksi b on b.id_transaksi=a.id_transaksi join barang c on c.KodeBarang=b.KodeBarang where a.NoNota='"+tran.KodeTransaksi.getText()+"' order by a.id_transaksi asc";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] ob = new Object[7];
                ob[0] = rs.getString(1);
                ob[1] = rs.getString(2);
                ob[2] = rs.getString(3);
                ob[3] = rs.getString(4);
                ob[4] = rs.getString(5);
                ob[5] = rs.getString(6);
                tran.tbl.addRow(ob);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void KlikTabel(FrmTransaksi tran) throws SQLException {
           try {
            int pilih = tran.tblTransaksi.getSelectedRow();
            if (pilih == -1) {
                return;
            }
            tran.idtransaksi2.setText(tran.tbl.getValueAt(pilih, 0).toString());
            tran.txtKodeBarang.setText(tran.tbl.getValueAt(pilih, 1).toString());
            tran.txtNamaBarang.setText(tran.tbl.getValueAt(pilih, 2).toString());
            tran.txtHarga.setText(tran.tbl.getValueAt(pilih, 3).toString());
            tran.txtBanyak.setText(tran.tbl.getValueAt(pilih, 4).toString());
        } catch (Exception e) {
        } finally {
            tran.txtBanyak.requestFocus();
            tran.txtBanyak.setText(null);
        }
    }

    @Override
    public void Bersih(FrmTransaksi tran) throws SQLException {
        tran.txtKodeBarang.setText(null);
        tran.txtNamaBarang.setText(null);
        tran.txtHarga.setText(null);
        tran.txtBanyak.setText(null);
        tran.txtKodeBarang.requestFocus();
    }

    @Override
    public void Tanggal(FrmTransaksi tran) throws SQLException {
        java.util.Date sekarang = new java.util.Date();
        java.text.SimpleDateFormat kal = new java.text.SimpleDateFormat("yyyy/MM/dd");
        tran.txtTanggal.setText(kal.format(sekarang));
    }

    @Override
    public void AutoNomor(FrmTransaksi tran) throws SQLException {
         try {
            Connection con = koneksi.getKoneksi();
            
            Statement st = con.createStatement();
            String sql = "select max(id_transaksi) from transaksibarang";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                int a = rs.getInt(1);
                tran.idtransaksi.setText(""+ Integer.toString(a+1));
            }
        } catch (Exception e) {
            System.out.println(""+ e.getMessage());
        }
    }

    @Override
    public void AutoNomorKode(FrmTransaksi tran) throws SQLException {
         try {
            Connection con = koneksi.getKoneksi();
            
            Statement st = con.createStatement();
            String sql = "select max(NoNota) from transaksibarang";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                int a = rs.getInt(1);
                tran.KodeTransaksi.setText(""+ Integer.toString(a+1));
            }
        } catch (Exception e) {
            System.out.println(""+ e.getMessage());
        }
    }

    @Override
    public void Total(FrmTransaksi tran) throws SQLException {
          int JumlahBaris = tran.tblTransaksi.getRowCount();
        int Total = 0;
        int HargaBarang;
        TableModel tableModel;
        tableModel = tran.tblTransaksi.getModel();
        for (int i = 0; i < JumlahBaris; i++) {
            HargaBarang = Integer.parseInt(tableModel.getValueAt(i, 5).toString());
            Total = (Total + HargaBarang);
            tran.txttotal.setText(String.valueOf(Total));
            tran.lblTotal.setText(String.valueOf(Total));
        }
    }

    @Override
    public void Kembalian(FrmTransaksi tran) throws SQLException {
        double total = Double.valueOf(tran.txttotal.getText());
        double bayar = Double.valueOf(tran.txtBayar.getText());
        double kembalian = (bayar-total);
        tran.txtKembalian.setText(String.valueOf(kembalian));
        tran.lblTotal.setText("-" +String.valueOf(kembalian));

    }

    @Override
    public void UbahJumlah(FrmTransaksi tran) throws SQLException {
        double harga = Double.valueOf(tran.txtHarga.getText());
        double jumlah = Double.valueOf(tran.txtBanyak.getText());
        double jumlah_baru = (harga * jumlah);
        tran.txtHarga.setText(String.valueOf(jumlah_baru));
        Ubah(tran);
        Total(tran);
    }

    @Override
    public void CetakStruk(FrmTransaksi tran) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
