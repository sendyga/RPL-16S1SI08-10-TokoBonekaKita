/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.model_barang;
import java.awt.Component;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Garjito
 */
public class FrmBarang extends javax.swing.JFrame {

    public DefaultTableModel tbl;
    String header[] = {"Kode Barang", "Nama Barang", "Kategori", "Harga", "Stok"};
    model_barang model = new model_barang();
    /**
     * Creates new form FrmBarang
     */
    public FrmBarang() throws SQLException {
        initComponents();
        tbl = new DefaultTableModel(null, header);
        tblBarang.setModel(tbl);
        tblBarang.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        model.Tampil(this);
        model.Combo(this);
        setLebarKolom();
        txtKodeKategori.setVisible(false);
        txtKode.requestFocus();
    }
    
    public void setColomnWidth(int kolom){
    DefaultTableColumnModel dt = (DefaultTableColumnModel) tblBarang.getColumnModel();
        TableColumn kolomtabel = dt.getColumn(kolom);
        int lebar = 0;
        int margin = 10;
        int a;
        
        TableCellRenderer render = kolomtabel.getHeaderRenderer();
        if (render == null) {
            render = tblBarang.getTableHeader().getDefaultRenderer();
        }
        Component kompo = render.getTableCellRendererComponent(tblBarang, kolomtabel.getHeaderValue(), false, false, 0, 0);
        lebar = kompo.getPreferredSize().width;
        for (a = 0; a < tblBarang.getRowCount(); a++) {
            render = tblBarang.getCellRenderer(a, kolom);
            kompo = render.getTableCellRendererComponent(tblBarang, tblBarang.getValueAt(a, kolom), false, false, a, kolom);
            int lebarKolom = kompo.getPreferredSize().width;
            lebar = Math.max(lebar, lebarKolom);
        }lebar = lebar + margin;
        kolomtabel.setPreferredWidth(lebar);
    }
    
    public void setLebarKolom(){
        int a;
        for (a = 0; a < tblBarang.getColumnCount(); a++) {
            setColomnWidth(a);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtKodeKategori = new javax.swing.JTextField();
        cmbkategori = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtStok = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        pnlKeluar = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel2.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, -1));

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        jPanel2.add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 120, -1));

        btnHapus.setText("Hapus");
        jPanel2.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 120, -1));

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jPanel2.add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 120, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 220, 230));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("NamaBarang");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel7.setText("Kategori");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));
        jPanel3.add(txtKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 160, -1));
        jPanel3.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 160, -1));
        jPanel3.add(txtKodeKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 90, -1));

        cmbkategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Plastik", "Busa", " " }));
        cmbkategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbkategoriActionPerformed(evt);
            }
        });
        jPanel3.add(cmbkategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 90, -1));

        jLabel8.setText("Harga Barang");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        txtHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaActionPerformed(evt);
            }
        });
        jPanel3.add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 160, -1));

        jLabel9.setText("Stok");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        txtStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStokActionPerformed(evt);
            }
        });
        jPanel3.add(txtStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 160, -1));

        jLabel10.setText("KodeBarang");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 370, 250));

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBarang);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 620, 210));

        jLabel1.setText("Form Barang");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        pnlKeluar.setBackground(new java.awt.Color(255, 0, 0));
        pnlKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlKeluarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlKeluarLayout = new javax.swing.GroupLayout(pnlKeluar);
        pnlKeluar.setLayout(pnlKeluarLayout);
        pnlKeluarLayout.setHorizontalGroup(
            pnlKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        pnlKeluarLayout.setVerticalGroup(
            pnlKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(pnlKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 30, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaActionPerformed

    private void txtStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStokActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        try {
            model.Simpan(this);
        } catch (SQLException ex) {
            Logger.getLogger(FrmBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        try {
            model.Bersih(this);
            model.Tampil(this);
        } catch (Exception ex) {
            Logger.getLogger(FrmBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        try {
            model.Ubah(this);
        } catch (SQLException ex) {
            Logger.getLogger(FrmBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void tblBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBarangMouseClicked
        // TODO add your handling code here:
        try {
            model.KlikTabel(this);
        } catch (SQLException ex) {
            Logger.getLogger(FrmBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblBarangMouseClicked

    private void cmbkategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbkategoriActionPerformed
        // TODO add your handling code here:
        try {
            model.Combo2(this);
        } catch (Exception ex) {
            Logger.getLogger(FrmBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbkategoriActionPerformed

    private void pnlKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlKeluarMouseClicked
        // TODO add your handling code here:
        new FrmMainMenu().show();
        dispose();
    }//GEN-LAST:event_pnlKeluarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             try {
                    new FrmBarang().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    public javax.swing.JComboBox<String> cmbkategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlKeluar;
    public javax.swing.JTable tblBarang;
    public javax.swing.JTextField txtHarga;
    public javax.swing.JTextField txtKode;
    public javax.swing.JTextField txtKodeKategori;
    public javax.swing.JTextField txtNama;
    public javax.swing.JTextField txtStok;
    // End of variables declaration//GEN-END:variables
}
