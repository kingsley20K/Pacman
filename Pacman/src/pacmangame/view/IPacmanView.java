package pacmangame.view;
/**
 * Interface for the Pacman game view, responsible for rendering game visuals.
 */
public interface IPacmanView {
    /**
     * Draws a block at the specified position with the given size.
     *
     * @param x     The x-coordinate of the block.
     * @param y     The y-coordinate of the block.
     * @param size  The size of the block.
     */
    void drawBlocK(int x, int y,int size );
    /**
     * Draws food at the specified position.
     *
     * @param x  The x-coordinate of the food.
     * @param y  The y-coordinate of the food.
     */
    void drawFood(int x, int y);
    /**
     * Displays the pause screen.
     */
    void drawPauseScreen();
    /**
     * Draws the player's score and remaining lives.
     *
     * @param score  The player's current score.
     * @param lives  The number of lives remaining.
     */
    void drawScore(int score, int lives);
    /**
     * Draws a ghost at the specified position.
     *
     * @param x  The x-coordinate of the ghost.
     * @param y  The y-coordinate of the ghost.
     */
    void drawGhost(int x, int y);
    /**
     * Draws Pacman facing left at the specified position.
     *
     * @param x  The x-coordinate of Pacman.
     * @param y  The y-coordinate of Pacman.
     */
    void drawPacmanLeft(int x, int y);
    /**
     * Draws Pacman facing right at the specified position.
     *
     * @param x  The x-coordinate of Pacman.
     * @param y  The y-coordinate of Pacman.
     */
    void drawPacmanRight(int x, int y);
    /**
     * Draws Pacman facing up at the specified position.
     *
     * @param x  The x-coordinate of Pacman.
     * @param y  The y-coordinate of Pacman.
     */
    void drawPacmanUp(int x, int y);
    /**
     * Draws Pacman facing down at the specified position.
     *
     * @param x  The x-coordinate of Pacman.
     * @param y  The y-coordinate of Pacman.
     */
    void drawPacmanDown(int x, int y);
    /**
     * Displays the game start screen.
     */
    void drawGameStartScreen();
    /**
     * Loads images used for rendering.
     */
    void loadImages();






}


