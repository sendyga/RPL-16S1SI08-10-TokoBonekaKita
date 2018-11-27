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
public class Member {
    private String kd_member;
    private String nama;
    private int no_tlp;
    private String alamat;

    public String getKd_member() {
        return kd_member;
    }

    public void setKd_member(String kd_member) {
        this.kd_member = kd_member;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNo_tlp() {
        return no_tlp;
    }

    public void setNo_tlp(int no_tlp) {
        this.no_tlp = no_tlp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
