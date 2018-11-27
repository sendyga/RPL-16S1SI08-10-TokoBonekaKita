/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Garjito
 */
public class Karyawan {
    private String kd_karyawan;
    private String user_id;
    private String nama_kar;
    private String alamat;
    private String password;

    public String getKd_karyawan() {
        return kd_karyawan;
    }

    public void setKd_karyawan(String kd_karyawan) {
        this.kd_karyawan = kd_karyawan;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getNama_kar() {
        return nama_kar;
    }

    public void setNama_kar(String nama_kar) {
        this.nama_kar = nama_kar;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
