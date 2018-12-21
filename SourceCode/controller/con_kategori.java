/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.FrmKategori;
import java.sql.SQLException;

/**
 *
 * @author Garjito
 */
public interface con_kategori {
    public void Simpan (FrmKategori kt) throws SQLException;
    public void Ubah (FrmKategori kt) throws SQLException;
    public void Hapus (FrmKategori kt) throws SQLException;
    public void Tampil (FrmKategori kt) throws SQLException;
    public void Bersih (FrmKategori kt) throws SQLException;
    public void KlikTabel (FrmKategori kt) throws SQLException;
    public void AutoNomor (FrmKategori kt) throws SQLException;
}
