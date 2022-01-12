/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nani.awalia.controller;

import nani.awalia.model.modelTransaksi;
import nani.awalia.view.viewTransaksi;

/**
 *
 * @author Bukhori
 */
public class controllerTransaksi {
    private modelTransaksi mT;
    private viewTransaksi vT;
    
    public controllerTransaksi(viewTransaksi vT){
        this.vT = vT;
    }
    
    public void simpanTransaksi(){
    mT = new modelTransaksi();
    mT.setIdPelanggan(vT.getIdPelanggan().getText());
    mT.setNamaPelanggan(vT.getNamaPelanggan().getText());
    mT.setNamaBarang(vT.getNamaBarang().getText());
    mT.setQty(vT.getQty().getText());
    mT.setTotalBayar(vT.getTotalBayar().getText());
    mT.setUangBayar(vT.getUangBayar().getText());
    
    mT.simpanTransaksi();
    
}
    
    public void bersihkan(){
        vT.getIdPelanggan().setText("");
        vT.getNamaPelanggan().setText("");
        vT.getAlamatPelanggan().setText("");
        vT.getNomorHp().setText("");
        vT.getJenisKelamin().setText("");
        vT.getNamaBarang().setText("");
        vT.getHargaBarang().setText("");
        vT.getQty().setText("");
        vT.getTotalBayar().setText("");
        vT.getUangBayar().setText("");

    }
    
   
}
