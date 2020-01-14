package Audio;

import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author reece
 */
public class Play {

    //Create a new input stream for audio
    AudioInputStream audioInputStream;
    //Clip is to use .wav files and pay audio.
    Clip clip;
    //This boolean must ALWAYS be false when this is first loaded, so shouldn't be modified
    boolean loaded = false;

    public void sound(boolean start) {
        
        //If the load value is false, the load the alarm wave file, otherwise it's already loaded.
        if (!loaded) {
            load();
            loaded = true;
        }
        if (start) {
            clip.start();
            clip.loop(100);
        } else {
            clip.stop();
            clip.setFramePosition(0);
        }
    }

    private void load() {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(Play.class.getResourceAsStream("alarm.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
            System.out.println("Something went wrong, here's what happened:\n" + ex);
        }
    }
}
