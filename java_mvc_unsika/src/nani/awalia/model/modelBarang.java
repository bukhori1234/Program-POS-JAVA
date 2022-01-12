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
public class modelBarang {
    private int idBarangModel;
    private int hargaBarangModel;
    private String namaBarangModel;
    private int jumlahModel;

     KoneksiDatabase koneksi = new KoneksiDatabase();

    public int getIdBarangModel() {
        return idBarangModel;
    }

    public void setIdBarangModel(int idBarangModel) {
        this.idBarangModel = idBarangModel;
    }

    public String getNamaBarangModel() {
        return namaBarangModel;
    }

    public void setNamaBarangModel(String namaBarangModel) {
        this.namaBarangModel = namaBarangModel;
    }

    public int getHargaBarangModel() {
        return hargaBarangModel;
    }

    public void setHargaBarangModel(int hargaBarangModel) {
        this.hargaBarangModel = hargaBarangModel;
    }

    public int getJumlahModel() {
        return jumlahModel;
    }

    public void setJumlahModel(int jumlah) {
        this.jumlahModel = jumlah;
    }


     
    
        public void simpanDataBarang(){

        String sql = ("INSERT INTO barang (namaBarang,hargaBarang,jumlah)" 
                +"VALUES('"+getNamaBarangModel()+"','"
                +getHargaBarangModel()+"','"+getJumlahModel()+"')");
        try{
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan \n" +ex);
    }
    
}
    public void hapusDataBarang(){

        String sql = "DELETE FROM barang WHERE idBarang = "
                +"'"+getIdBarangModel()+"'";
        
        try{
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus \n" +ex);
    }
        
    }
    
     public void updateDataBarang(){
        KoneksiDatabase koneksi = new KoneksiDatabase();
        String sql = "UPDATE barang SET namaBarang = '"+getNamaBarangModel()+"'"
                +" ,hargaBarang = '"+getHargaBarangModel()+"'"
                +" ,jumlah = '"+getJumlahModel()+"'"
                +"' WHERE idPelanggan = '"+getIdBarangModel()+"'";
        
        try{
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Gagal Diupdate \n" +ex);
        }
    }
    
}
