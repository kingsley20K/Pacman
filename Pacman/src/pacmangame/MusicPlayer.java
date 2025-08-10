package pacmangame;

import processing.core.PApplet;
import ddf.minim.*;
/**
 * The {@code MusicPlayer} class provides functionality to play audio in a separate thread using the Minim library.
 * It implements the {@link Runnable} interface for concurrent execution.
 */
public class MusicPlayer implements Runnable {
    /**Reference to the PApplet object (Processing environment)*/
    private PApplet parent;// Reference to the PApplet object (Processing environment)
    private AudioPlayer player; // AudioPlayer object from the Minim library
    /**
     * Constructs a new {@code MusicPlayer} with the specified PApplet parent and the path to the music file.
     *
     * @param parent          The PApplet object representing the Processing environment.
     * @param musicFilePath   The path to the audio file to be loaded and played.
     */
    public MusicPlayer(PApplet parent, String musicFilePath) {
        this.parent = parent;
        Minim minim = new Minim(parent);
        player = minim.loadFile(musicFilePath);
    }
    /**
     * Runs the audio playback in a loop when the thread is started.
     * This method is part of the {@link Runnable} interface.
     */
    public void run() {
        player.loop();
    }
    /**
     * Stops the audio playback by closing the AudioPlayer object.
     */
    public void stop() {
        player.close();
    }
}

