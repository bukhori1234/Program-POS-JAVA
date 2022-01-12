/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nani.awalia.view;
import nani.awalia.db.KoneksiDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import nani.awalia.controller.controllerTransaksi;

/**
 *
 * @author Bukhori
 */
public class viewListDataTransaksi extends javax.swing.JInternalFrame {
    private controllerTransaksi cT;
    private DefaultTableModel model;   
    /**
     * Creates new form viewListDataTransaksi
     */
    public viewListDataTransaksi() {
        initComponents();
        
        model = new DefaultTableModel();
        viewListDataTransaksi.setModel(model);
        model.addColumn("Id Transaksi");
        model.addColumn("Nama Pelanggan");
        model.addColumn("Nama Barang");
        model.addColumn("Qty");
        model.addColumn("Total Bayar");
        model.addColumn("Uang Bayar");
        
        tampilDataTransaksi();
    }
    
    //membuat methodtampilDataTransaksi()
    private void tampilDataTransaksi(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String sql = "SELECT * FROM transaksi";
        
        try{
            Statement stat = (Statement) KoneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
                //Mengambil hasil query variabel sql
                Object[] hasil;
                hasil = new Object[6]; //terdapat 6 field pada tabel transaksi
                hasil[0] = res.getString("idTransaksi");
                hasil[1] = res.getString("namaPelanggan");
                hasil[2] = res.getString("namaBarang");
                hasil[3] = res.getString("qty");
                hasil[4] = res.getString("totalBayar");
                hasil[5] = res.getString("uangBayar");
                
                model.addRow(hasil);
            }
        } catch(SQLException ex){
            Logger.getLogger(viewPelangganInternal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        viewListDataTransaksi = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        viewListDataTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(viewListDataTransaksi);

        jLabel1.setText("Daftar Transaksi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jLabel1)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable viewListDataTransaksi;
    // End of variables declaration//GEN-END:variables
}