/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mediaPlayer;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Classe per la gestione concorrente della musica in gioco. Estende la classe
 * Thread.
 *
 * @author Piersilvio Spicoli
 * @author Francesco Pio Scoglietti
 * @author Giulio Russo
 */
public class MediaPlayerThread implements Runnable {

    private static final String musicpath = "musics/mario.wav";

    /**
     * metodo per la gestione concorrente della musica in gioco.
     */
    @Override
    public void run() {

        try {
            File musicPath = new File(musicpath);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.print("Errore nella lettura del file");
            }
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println("Errore nell'avvio della musica");
        }

    }

}
