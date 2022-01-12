/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nani.awalia.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import nani.awalia.db.KoneksiDatabase;

/**
 *
 * @author Bukhori
 */
public class modelTransaksi {
    private String namaPelanggan;
    private String idPelanggan;
    private String totalBayar;
    private String uangBayar;
    private String qty;
    private String idTransaksiDetail;
    private String idTransaksi;
    private String namaBarang;
    private String subTotal;

    
    public modelTransaksi() {
    }
    
    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(String totalBayar) {
        this.totalBayar = totalBayar;
    }

    public String getUangBayar() {
        return uangBayar;
    }

    public void setUangBayar(String uangBayar) {
        this.uangBayar = uangBayar;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getIdTransaksiDetail() {
        return idTransaksiDetail;
    }

    public void setIdTransaksiDetail(String idTransaksiDetail) {
        this.idTransaksiDetail = idTransaksiDetail;
    }
    
    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }
    
    
    
    KoneksiDatabase koneksi = new KoneksiDatabase();
    
    public void simpanTransaksi(){
        String sql = "INSERT INTO transaksi (namaPelanggan, namaBarang, qty, totalBayar, uangBayar)"
                +"VALUES ('"+getNamaPelanggan()+"','"+getNamaBarang()+"','"+getQty()+"','"+getTotalBayar()+"',"
                + " '"+getUangBayar()+"')";
        
        try{
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan \n" +ex);
    }
    
}
}

