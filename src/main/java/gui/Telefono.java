/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.Window;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

/**
 *
 * @author PPiC
 */
public class Telefono extends javax.swing.JFrame {
    private static String currentRoom;
    /**
     * Creates new form Telefono
     */
    public Telefono() {
        initComponents();
        setPhone();
    }
    
    private void setPhone() {
        setSize(400, 550);
        setResizable(false);
        ImageIcon phoneIcon = new ImageIcon("images/phone.png");
        setIconImage(phoneIcon.getImage());
        setName("Phone");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        guidaButton = new javax.swing.JButton();
        musicButton = new javax.swing.JButton();
        fotocameraButton = new javax.swing.JButton();
        mapButton = new javax.swing.JButton();

        guidaButton.setText("Guida");
        guidaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guidaButtonMouseClicked(evt);
            }
        });
        guidaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guidaButtonActionPerformed(evt);
            }
        });

        musicButton.setText("Musica");
        musicButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                musicButtonMouseClicked(evt);
            }
        });
        musicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musicButtonActionPerformed(evt);
            }
        });

        fotocameraButton.setText("Fotocamera");
        fotocameraButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fotocameraButtonMouseClicked(evt);
            }
        });
        fotocameraButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fotocameraButtonActionPerformed(evt);
            }
        });

        mapButton.setText("Mappa");
        mapButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mapButtonMouseClicked(evt);
            }
        });
        mapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mapButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(musicButton, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fotocameraButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(guidaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guidaButton)
                    .addComponent(mapButton))
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(musicButton)
                    .addComponent(fotocameraButton))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mapButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapButtonMouseClicked
        
        MapFrame mapFrame = new MapFrame();
        mapFrame.setVisible(true);
        
        JComponent comp = (JComponent) evt.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();
    }//GEN-LAST:event_mapButtonMouseClicked

    private void mapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mapButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mapButtonActionPerformed

    private void guidaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guidaButtonActionPerformed
        

    }//GEN-LAST:event_guidaButtonActionPerformed

    private void guidaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guidaButtonMouseClicked
        GuidaFrame guidaFrame = new GuidaFrame();
        guidaFrame.setVisible(true);
        JComponent comp = (JComponent) evt.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();

    }//GEN-LAST:event_guidaButtonMouseClicked

    private void fotocameraButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fotocameraButtonActionPerformed
        
    }//GEN-LAST:event_fotocameraButtonActionPerformed

    private void fotocameraButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fotocameraButtonMouseClicked
       FotoFrame fotoFrame = new FotoFrame();
       //fotoFrame.setVisibile(true);
        
        JComponent comp = (JComponent) evt.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();
    }//GEN-LAST:event_fotocameraButtonMouseClicked

    private void musicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musicButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_musicButtonActionPerformed

    private void musicButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_musicButtonMouseClicked
        MusicFrame musicFrame = new MusicFrame();
        musicFrame.setVisible(true);
    }//GEN-LAST:event_musicButtonMouseClicked

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
            java.util.logging.Logger.getLogger(Telefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Telefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Telefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Telefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Telefono().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fotocameraButton;
    private javax.swing.JButton guidaButton;
    private javax.swing.JButton mapButton;
    private javax.swing.JButton musicButton;
    // End of variables declaration//GEN-END:variables
}
