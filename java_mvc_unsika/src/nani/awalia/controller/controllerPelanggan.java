/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nani.awalia.controller;
import nani.awalia.model.modelPelanggan;
import nani.awalia.view.viewPelangganInternal;


/**
 *
 * @author Bukhori
 */
public class controllerPelanggan {
    private modelPelanggan mP;
    private viewPelangganInternal vP;
    
    public controllerPelanggan(viewPelangganInternal vP){
        this.vP=vP;
    }
    
    public void bersihkan(){
        vP.getIdPelangganView().setText("");
        vP.getNamaPelangganView().setText("");
        vP.getNoHpView().setText("");
        vP.getAlamatView().setText("");
        vP.getUmurView().setText("");
    }
    public void kontrolButton(){
        vP.getTomboSimpan().setEnabled(true);
        vP.getTomboEdit().setEnabled(true);
        vP.getTomboHapus().setEnabled(true);
        vP.getTomboBatal().setEnabled(true);
    }
    public void kontrolButtonDua(){
        vP.getTomboSimpan().setEnabled(true);
        vP.getTomboEdit().setEnabled(true);
        vP.getTomboHapus().setEnabled(true);
        vP.getTomboBatal().setEnabled(true);
    }
    public void deleteData(){
        mP = new modelPelanggan();
        mP.setIdPelangganModel(vP.getIdPelangganView().getText());
        mP.hapusDataPelanggan();
        bersihkan();
        kontrolButton();
    }
    public void updateData(){
        mP = new modelPelanggan();
        mP.setIdPelangganModel(vP.getIdPelangganView().getText());
        mP.setNamaPelangganModel(vP.getNamaPelangganView().getText());
        mP.setNomorHpModel(vP.getNoHpView().getText());
        
        if(vP.getPriaView().isSelected()){
            mP.setJenisKelaminModel("Pria");
        }else if (vP.getWanitaView().isSelected()){
            mP.setJenisKelaminModel("Wanita");
        }
        mP.setUmur(Integer.parseInt(vP.getUmurView().getText()));
        mP.setAlamat(vP.getAlamatView().getText());
        
        mP.updateDataPelanggan();
        kontrolButton();
    }
    public void simpan(){
        mP = new modelPelanggan();
        mP.setNamaPelangganModel(vP.getNamaPelangganView().getText());
        mP.setNomorHpModel(vP.getNoHpView().getText());
        
        if(vP.getPriaView().isSelected()){
            mP.setJenisKelaminModel("Pria");
        }else if (vP.getWanitaView().isSelected()){
            mP.setJenisKelaminModel("Wanita");
        }
        mP.setUmur(Integer.parseInt(vP.getUmurView().getText()));
        mP.setAlamat(vP.getAlamatView().getText());
        mP.simpanDataPelanggan();
        bersihkan();
    }
}
