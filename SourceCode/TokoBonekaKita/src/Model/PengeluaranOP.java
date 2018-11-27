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
public class PengeluaranOP {
    private String kd_pengeluaran;
    private String jenis;
    private int nominal;
    private int total;
    private Datetime tgl;

    public String getKd_pengeluaran() {
        return kd_pengeluaran;
    }

    public void setKd_pengeluaran(String kd_pengeluaran) {
        this.kd_pengeluaran = kd_pengeluaran;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Datetime getTgl() {
        return tgl;
    }

    public void setTgl(Datetime tgl) {
        this.tgl = tgl;
    }

    private static class Datetime {

        public Datetime() {
        }
    }
}
