import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SimpleAudioPlayer {

    Clip clip;

    AudioInputStream audioInputStream;

    // Initialiser les streams et les clips
    public SimpleAudioPlayer()
            throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {

        // Créer AudioInputStream objet
        audioInputStream = AudioSystem
                .getAudioInputStream(new File("sound/RequiemforaDream.wav").getAbsoluteFile());

        // Créer une référence de clip
        clip = AudioSystem.getClip();

        // Ouvrir audioInputStream
        clip.open(audioInputStream);

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void main() {
        try {
            SimpleAudioPlayer audioPlayer = new SimpleAudioPlayer();

            audioPlayer.play();
        }

        catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
    }

    // Jouer le son
    public void play() {
        // Commencer le clip
        clip.start();
    }
}