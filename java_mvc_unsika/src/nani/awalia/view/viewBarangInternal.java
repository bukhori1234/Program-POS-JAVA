/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nani.awalia.view;



import javax.swing.JToggleButton;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import nani.awalia.controller.controllerBarang;
import nani.awalia.db.KoneksiDatabase;

/**
 *
 * @author Bukhori
 */
public class viewBarangInternal extends javax.swing.JInternalFrame {
    private controllerBarang cB;

    /**
     * Creates new form viewListDataBarang
     */
      
    private DefaultTableModel model;
    public viewBarangInternal() {
        initComponents();
        
        cB = new controllerBarang(this);
        model = new DefaultTableModel();
        tabelBarang.setModel(model);
        model.addColumn("ID");
        //model.addColumn("JENIS");
        //model.addColumn("NAMA");
        //model.addColumn("JUMLAH");
        model.addColumn("NAMA");
        model.addColumn("HARGA");
        model.addColumn("QTY");
         idBarang.disable();
      
        tampilDataBarang();
        cB.kontrolButton();
    }

    public JTextField getHargaBarang() {
        return hargaBarang;
    }

    public JTextField getIdBarang() {
        return idBarang;
    }

    public JTextField getJumlah() {
        return jumlah;
    }

    public JTextField getNamaBarang() {
        return namaBarang;
    }


    public JToggleButton getTombolBatal() {
        return tombolBatal;
    }

    public JToggleButton getTombolHapus() {
        return tombolHapus;
    }

    public JToggleButton getTombolSimpan() {
        return tombolSimpan;
    }

    public JToggleButton getTombolUbah() {
        return tombolUbah;
    }

    public void setHargaBarang(JTextField hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public void setIdBarang(JTextField idBarang) {
        this.idBarang = idBarang;
    }

    public void setJumlah(JTextField jumlah) {
        this.jumlah = jumlah;
    }

    public void setNamaBarang(JTextField namaBarang) {
        this.namaBarang = namaBarang;
    }




    
      private void tampilDataBarang(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String sql = "SELECT * FROM barang";
        
        try {
            Statement stat = (Statement) KoneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
                //mengambil hasil query variable sql
                Object[] hasil;
                hasil = new Object[6]; //ada 6 field ditabel pelanggan
                hasil[0] = res.getString("idBarang");
                hasil[1] = res.getString("namaBarang");
                hasil[2] = res.getString("hargaBarang");
                hasil[3] = res.getString("jumlahBarang");
                
                model.addRow(hasil);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(viewPelangganInternal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
      private void ambilDataTabel(){
        int index = tabelBarang.getSelectedRow();
        
        String id = String.valueOf(tabelBarang.getValueAt(index, 0));
        String nama = String.valueOf(tabelBarang.getValueAt(index, 1));
        String harga = String.valueOf(tabelBarang.getValueAt(index, 2));
        String jml = String.valueOf(tabelBarang.getValueAt(index, 3));
        
        //mengisi nilai kedalam textfield
        idBarang.setText(id);
        namaBarang.setText(nama);
        hargaBarang.setText(harga);
        jumlah.setText(jml);
       
        cB.kontrolButtonDua();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idBarang = new javax.swing.JTextField();
        hargaBarang = new javax.swing.JTextField();
        jumlah = new javax.swing.JTextField();
        namaBarang = new javax.swing.JTextField();
        tombolBatal = new javax.swing.JToggleButton();
        tombolHapus = new javax.swing.JToggleButton();
        tombolUbah = new javax.swing.JToggleButton();
        tombolSimpan = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID Barang");

        jLabel2.setText("Harga Barang");

        jLabel3.setText("Nama Barang");

        jLabel4.setText("Jumlah");

        tombolBatal.setText("BATAL");
        tombolBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolBatalActionPerformed(evt);
            }
        });

        tombolHapus.setText("HAPUS");
        tombolHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusActionPerformed(evt);
            }
        });

        tombolUbah.setText("UBAH");
        tombolUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolUbahActionPerformed(evt);
            }
        });

        tombolSimpan.setText("SIMPAN");
        tombolSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSimpanActionPerformed(evt);
            }
        });

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelBarang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(tombolBatal)
                        .addGap(18, 18, 18)
                        .addComponent(tombolHapus)
                        .addGap(30, 30, 30)
                        .addComponent(tombolUbah)
                        .addGap(18, 18, 18)
                        .addComponent(tombolSimpan)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(hargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolBatal)
                    .addComponent(tombolHapus)
                    .addComponent(tombolUbah)
                    .addComponent(tombolSimpan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void tombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanActionPerformed
        // TODO add your handling code here:
         cB.simpan();
        tampilDataBarang();
    }//GEN-LAST:event_tombolSimpanActionPerformed

    private void tombolUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahActionPerformed
        // TODO add your handling code here:
        cB.updateData();
        tampilDataBarang(); //merefresh*/
    }//GEN-LAST:event_tombolUbahActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        // TODO add your handling code here:
        cB.deleteData();
        tampilDataBarang();
    }//GEN-LAST:event_tombolHapusActionPerformed

    private void tombolBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolBatalActionPerformed
        // TODO add your handling code here:
        cB.kontrolButton();
        cB.bersihkan();
    }//GEN-LAST:event_tombolBatalActionPerformed

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        // TODO add your handling code here:
        ambilDataTabel();
    }//GEN-LAST:event_tabelBarangMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField hargaBarang;
    private javax.swing.JTextField idBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField namaBarang;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JToggleButton tombolBatal;
    private javax.swing.JToggleButton tombolHapus;
    private javax.swing.JToggleButton tombolSimpan;
    private javax.swing.JToggleButton tombolUbah;
    // End of variables declaration//GEN-END:variables




}
