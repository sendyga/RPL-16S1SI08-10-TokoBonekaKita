/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.FrmLogin;
import java.sql.SQLException;

/**
 *
 * @author Garjito
 */
public interface con_login {
    public void Login (FrmLogin lgn) throws SQLException;
    public void Bersih (FrmLogin lgn) throws SQLException;
}
