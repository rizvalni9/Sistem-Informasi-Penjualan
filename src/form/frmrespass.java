package form;

import config.rootdb;
import config.pasgenchiper;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.ResultSet;

public class frmrespass extends javax.swing.JFrame {
    
    private ResultSet result;
    private rootdb rooting = new rootdb();
    private Date sekarang = new Date();
    private SimpleDateFormat tgl = new SimpleDateFormat("yyyy/MM/dd");
    private String tanggal = String.valueOf(tgl.format(sekarang));
    private String gender,hashpass;
    private pasgenchiper keyGen = new pasgenchiper();
    
    private void clear(){
        txtusnm.setText(null);
        txtpass.setText(null);
        txtcompass.setText(null);
        txtmail.setText(null);
    }
    
    public frmrespass() {
        rooting.root();
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        lbusnm = new javax.swing.JLabel();
        lbpass = new javax.swing.JLabel();
        lbcompass = new javax.swing.JLabel();
        lbmail = new javax.swing.JLabel();
        txtusnm = new javax.swing.JTextField();
        txtpass = new javax.swing.JTextField();
        txtcompass = new javax.swing.JTextField();
        txtmail = new javax.swing.JTextField();
        btnreg = new javax.swing.JButton();
        lbicontitle = new javax.swing.JLabel();
        lbbackground = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        lbtitle = new javax.swing.JLabel();
        lbext = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbusnm.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        lbusnm.setText("Username                   :");
        body.add(lbusnm, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 95, 160, 20));

        lbpass.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        lbpass.setText("Password                    :");
        body.add(lbpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 135, 160, 20));

        lbcompass.setFont(new java.awt.Font("Sitka Text", 1, 13)); // NOI18N
        lbcompass.setText("Konfirmasi Password   :");
        body.add(lbcompass, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 175, 160, 20));

        lbmail.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        lbmail.setText("Email                          :");
        body.add(lbmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 215, 160, 20));
        body.add(txtusnm, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 95, 130, -1));
        body.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 135, 150, -1));
        body.add(txtcompass, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 175, 150, -1));
        body.add(txtmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 215, 150, -1));

        btnreg.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnreg.setText("RESET");
        btnreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregActionPerformed(evt);
            }
        });
        body.add(btnreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 255, 320, 40));

        lbicontitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconpassreset.png"))); // NOI18N
        body.add(lbicontitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 15, -1, 62));

        lbbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/backgroundreg.jpg"))); // NOI18N
        body.add(lbbackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 332, 300));

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 332, 300));

        header.setBackground(new java.awt.Color(51, 156, 215));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbtitle.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lbtitle.setText("RESET PASSWORD");
        lbtitle.setPreferredSize(new java.awt.Dimension(81, 25));
        header.add(lbtitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 160, 30));

        lbext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        lbext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbextMouseClicked(evt);
            }
        });
        header.add(lbext, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 5, -1, -1));

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 332, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregActionPerformed
        if(txtusnm.getText().isEmpty()||txtpass.getText().isEmpty()||txtcompass.getText().isEmpty()||
           txtmail.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "PASTIKAN SELURUH DATA TERISI !", "CAUTION", JOptionPane.WARNING_MESSAGE);
        }else if(!(txtcompass.getText().equals(txtpass.getText()))){
            JOptionPane.showMessageDialog(this, "KONFIRMASI PASSWORD HARUS SAMA !","CAUTION",JOptionPane.WARNING_MESSAGE);
        }else{
            try{
                result = rooting.adapter.executeQuery("SELECT * FROM person WHERE id ='"+txtusnm.getText()+"'");
                if(!result.next()){
                    JOptionPane.showMessageDialog(this, "USERNAME TIDAK ADA !","INFO",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    int question = JOptionPane.showConfirmDialog(this, "APAKAH ANDA YAKIN MERESET PASSWORD AKUN INI ?", "QUESTION", JOptionPane.YES_NO_OPTION);
                    if(question==JOptionPane.YES_OPTION){
                        rooting.adapter.executeUpdate("UPDATE person SET pass ='"+keyGen.enkripsi(txtpass.getText())+"' WHERE id ='"+txtusnm.getText()+"'");
                        JOptionPane.showMessageDialog(this, "PASSWORD TERESET, SILAHKAN LOGIN !!!", "INFO", JOptionPane.INFORMATION_MESSAGE);
                        clear();
                    }else{
                        clear();
                    }
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"DATABASE TIDAK TERKONEKSI !!!","ERROR",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }//GEN-LAST:event_btnregActionPerformed

    private void lbextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbextMouseClicked
        this.dispose();
        new frlog().show();
    }//GEN-LAST:event_lbextMouseClicked

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
            java.util.logging.Logger.getLogger(frmrespass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmrespass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmrespass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmrespass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmrespass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JButton btnreg;
    private javax.swing.JPanel header;
    private javax.swing.JLabel lbbackground;
    private javax.swing.JLabel lbcompass;
    private javax.swing.JLabel lbext;
    private javax.swing.JLabel lbicontitle;
    private javax.swing.JLabel lbmail;
    private javax.swing.JLabel lbpass;
    private javax.swing.JLabel lbtitle;
    private javax.swing.JLabel lbusnm;
    private javax.swing.JTextField txtcompass;
    private javax.swing.JTextField txtmail;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField txtusnm;
    // End of variables declaration//GEN-END:variables
}
