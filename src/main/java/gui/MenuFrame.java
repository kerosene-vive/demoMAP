/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dbmanager.DatabaseManager;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author flava
 */
public class MenuFrame extends javax.swing.JFrame {

    private String pippoKill = ".src/main/java/gui/img/pippoKill.png";
    private File fileImg = new File(pippoKill);

    /**
     * Creates new form JFrame
     */
    public MenuFrame() {
        initComponents();
        initMenu();
        ImageIcon pippo = new ImageIcon(fileImg.getPath());
        JLabel pic = new JLabel(pippo);
        imagePanel.add(pic);

    }

    private void initMenu() {
        setResizable(false);
        setTitle("menu");
        setBackground(Color.yellow);
        setIconImage(Toolkit.getDefaultToolkit().getImage(fileImg.getPath()));
        imagePanel.setVisible(true);
        imagePanel.doLayout();
    }

    private void openGame() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nuovaPartita = new javax.swing.JButton();
        caricaPartita = new javax.swing.JButton();
        imagePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nuovaPartita.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nuovaPartita.setText("Nuova Partita");
        nuovaPartita.setName(""); // NOI18N
        nuovaPartita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nuovaPartitaMouseClicked(evt);
            }
        });
        nuovaPartita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuovaPartitaActionPerformed(evt);
            }
        });

        caricaPartita.setText("Carica Partita");
        caricaPartita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                caricaPartitaMouseClicked(evt);
            }
        });
        caricaPartita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caricaPartitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nuovaPartita)
                        .addGap(37, 37, 37)
                        .addComponent(caricaPartita, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(caricaPartita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nuovaPartita, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuovaPartitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuovaPartitaMouseClicked
        //lancia funzione di nuova partita     
    }//GEN-LAST:event_nuovaPartitaMouseClicked

    private void caricaPartitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_caricaPartitaMouseClicked
        //lancia funzione di carica partita
        DatabaseManager.load();
    }//GEN-LAST:event_caricaPartitaMouseClicked

    private void nuovaPartitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuovaPartitaActionPerformed
        GameFrame game = new GameFrame();
        game.setVisible(true);

        JComponent comp = (JComponent) evt.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();

    }//GEN-LAST:event_nuovaPartitaActionPerformed

    private void caricaPartitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caricaPartitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caricaPartitaActionPerformed

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
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton caricaPartita;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JButton nuovaPartita;
    // End of variables declaration//GEN-END:variables
}
