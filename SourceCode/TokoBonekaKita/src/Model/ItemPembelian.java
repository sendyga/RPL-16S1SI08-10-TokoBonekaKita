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
public class ItemPembelian {
    private String id_itempem;
    private int jumlah;
    private int harga;

    public String getId_itempem() {
        return id_itempem;
    }

    public void setId_itempem(String id_itempem) {
        this.id_itempem = id_itempem;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
