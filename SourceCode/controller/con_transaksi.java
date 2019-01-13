/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.FrmTransaksi;
import java.sql.SQLException;

/**
 *
 * @author Garjito
 */
public interface con_transaksi {
    public void Simpan (FrmTransaksi tran) throws SQLException;
    public void Ubah (FrmTransaksi tran) throws SQLException;
    public void Hapus (FrmTransaksi tran) throws SQLException;
    public void Tampil (FrmTransaksi tran) throws SQLException;
    public void KlikTabel (FrmTransaksi tran) throws SQLException;
    public void Bersih (FrmTransaksi tran) throws SQLException;
    public void Tanggal (FrmTransaksi tran) throws SQLException;
    public void AutoNomor (FrmTransaksi tran) throws SQLException;
    public void AutoNomorKode (FrmTransaksi tran) throws SQLException;
    public void Total (FrmTransaksi tran) throws SQLException;
    public void Kembalian (FrmTransaksi tran) throws SQLException;
    public void UbahJumlah (FrmTransaksi tran) throws SQLException;
    public void CetakStruk (FrmTransaksi tran) throws SQLException;
}
