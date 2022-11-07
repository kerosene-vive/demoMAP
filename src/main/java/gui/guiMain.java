/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gui;

import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author PPiC
 */
public class guiMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame =  new JFrame();
        frame.setVisible(true);
        frame.setTitle("Il Segreto Del Piano Meno Due");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(420,420);
        
        ImageIcon icon = new ImageIcon("images/pippoKill.png");
        frame.setIconImage(icon.getImage());
    }
    
}
