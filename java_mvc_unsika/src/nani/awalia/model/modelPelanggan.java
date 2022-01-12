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
public class modelPelanggan {
    private String idPelangganModel;
    private String namaPelangganModel;
    private String nomorHpModel;
    private String jenisKelaminModel;
    private int umur;
    private String alamat;

    public modelPelanggan() {
    }

    public void setIdPelangganModel(String idPelangganModel) {
        this.idPelangganModel = idPelangganModel;
    }
    
    public String getIdPelangganModel() {
        return idPelangganModel;
    }
    
    public String getNamaPelangganModel() {
        return namaPelangganModel;
    }

    public void setNamaPelangganModel(String namaPelangganModel) {
        this.namaPelangganModel = namaPelangganModel;
    }

    public String getNomorHpModel() {
        return nomorHpModel;
    }

    public void setNomorHpModel(String nomorHpModel) {
        this.nomorHpModel = nomorHpModel;
    }

    public String getJenisKelaminModel() {
        return jenisKelaminModel;
    }

    public void setJenisKelaminModel(String jenisKelaminModel) {
        this.jenisKelaminModel = jenisKelaminModel;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
     KoneksiDatabase koneksi = new KoneksiDatabase();
    
    public void simpanDataPelanggan(){
        String sql = ("INSERT INTO pelanggan (namaPelanggan,noHP,jenisKelamin,umur,alamat)" 
                +"VALUES('"+getNamaPelangganModel()+"','"+getNomorHpModel()+"'"+
                ",'"+getJenisKelaminModel()+"','"+getUmur()+"','"+getAlamat()+"')");
        try{
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan \n" +ex);
    }
    
}
    public void hapusDataPelanggan(){

        String sql = "DELETE FROM pelanggan WHERE idPelanggan = "
                +"'"+getIdPelangganModel()+"'";
        
        try{
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus \n" +ex);
    }
        
    }
    
    public void updateDataPelanggan(){

        String sql = "UPDATE pelanggan SET namaPelanggan = '"+getNamaPelangganModel()+"'"
                +" ,noHp = '"+getNomorHpModel()+"'"
                +" ,jenisKelamin = '"+getJenisKelaminModel()+"'"
                +" ,umur = '"+getUmur()+"'"
                +" ,alamat = '"+getAlamat()+"' WHERE idPelanggan = '"+getIdPelangganModel()+"'";
        
        try{
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Gagal Diupdate \n" +ex);
        }
    }

    
}




