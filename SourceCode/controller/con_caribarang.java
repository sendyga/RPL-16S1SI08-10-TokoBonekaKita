/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.FrmCariBarang;
import java.sql.SQLException;

/**
 *
 * @author Garjito
 */
public interface con_caribarang {
    public void Tampil (FrmCariBarang cb) throws SQLException;
    public void KlikTabel (FrmCariBarang cb) throws SQLException;
    public void Cari (FrmCariBarang cb) throws SQLException;
}
