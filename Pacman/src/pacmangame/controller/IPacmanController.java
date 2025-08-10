package pacmangame.controller;
/**
 * Interface for the Pacman game controller.
 */
public interface IPacmanController {
    /**
     * Handles key presses for controlling Pacman's movement.
     *
     * @param key      The character representation of the pressed key.
     * @param keyCode  The numeric code representing the pressed key.
     */
    void handleKeyPressed(char key, int keyCode);
    /**
     * Advances the game to the next frame, updating the game state and visuals.
     */
    void nextFrame();
}
