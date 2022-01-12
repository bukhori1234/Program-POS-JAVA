/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nani.awalia.controller;

import nani.awalia.view.viewBarangInternal;
import nani.awalia.model.modelBarang;
import javax.swing.JOptionPane;
import nani.awalia.model.modelPelanggan;
import nani.awalia.view.viewPelangganInternal;

/**
 *
 * @author Bukhori
 */
public class controllerBarang {
    private modelBarang mB;
    private viewBarangInternal vB;
    
    public controllerBarang(viewBarangInternal vB){
        this.vB = vB;
    }
    
    public void bersihkan(){
        vB.getIdBarang().setText("");
        vB.getNamaBarang().setText("");
        vB.getHargaBarang().setText("");
        vB.getJumlah().setText("");
    }
    public void kontrolButton(){
        vB.getTombolSimpan().setEnabled(true);
        vB.getTombolUbah().setEnabled(true);
        vB.getTombolHapus().setEnabled(true);
        vB.getTombolBatal().setEnabled(true);
    }
    public void kontrolButtonDua(){
        vB.getTombolSimpan().setEnabled(true);
        vB.getTombolUbah().setEnabled(true);
        vB.getTombolHapus().setEnabled(true);
        vB.getTombolBatal().setEnabled(true);
    }
    public void deleteData(){
        mB = new modelBarang();
        mB.setIdBarangModel(Integer.parseInt(vB.getIdBarang().getText()));
        mB.hapusDataBarang();
        bersihkan();
        kontrolButton();
    }
    public void updateData(){
        mB = new modelBarang();
        mB.setIdBarangModel(Integer.parseInt(vB.getIdBarang().getText()));
        mB.setNamaBarangModel(vB.getNamaBarang().getText());
        mB.setHargaBarangModel(Integer.parseInt(vB.getHargaBarang().getText()));
        mB.setJumlahModel(Integer.parseInt(vB.getJumlah().getText()));
        
        
        mB.updateDataBarang();
        kontrolButton();
    }
    public void simpan(){
        mB = new modelBarang();
        mB.setNamaBarangModel(vB.getNamaBarang().getText());
        mB.setHargaBarangModel(Integer.parseInt(vB.getHargaBarang().getText()));
       
        mB.simpanDataBarang();
        bersihkan();
    }


    
}
