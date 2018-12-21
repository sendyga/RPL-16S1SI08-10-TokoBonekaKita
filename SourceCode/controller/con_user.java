/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.FrmUser;
import java.sql.SQLException;

/**
 *
 * @author Garjito
 */
public interface con_user {
    public void Simpan (FrmUser usr) throws SQLException;
    public void Ubah (FrmUser usr) throws SQLException;
    public void Hapus (FrmUser usr) throws SQLException;
    public void Tampil (FrmUser usr) throws SQLException;
    public void Bersih (FrmUser usr) throws SQLException;
    public void KlikTabel (FrmUser usr) throws SQLException;
    public void AutoNomor (FrmUser usr) throws SQLException;
}
