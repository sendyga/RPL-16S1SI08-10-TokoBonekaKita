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
public class ItemPenjualan {
    private String id_itempenjualan;
    private int jumlah;
    private int harga;

    public String getId_itempenjualan() {
        return id_itempenjualan;
    }

    public void setId_itempenjualan(String id_itempenjualan) {
        this.id_itempenjualan = id_itempenjualan;
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
