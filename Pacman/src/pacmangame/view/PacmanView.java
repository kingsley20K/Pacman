
/**
 * The {@code PacmanView} class represents the graphical view of the Pacman game.
 * It handles the visual representation of game elements and interacts with the Pacman controller.
 * This class extends the PApplet class and implements the IPacmanView interface, providing
 * methods for rendering the game window, loading images, and drawing various game elements.
 * <p>
 * The view includes images for Pacman, ghosts, food, blocks, and other game elements. It also
 * manages the rendering of the game state, such as the score, lives, and pause screen.
 * </p>
 * <p>
 * Usage example:
 * <pre>{@code
 * PacmanView pacmanView = new PacmanView(800, 600);
 * pacmanView.setController(pacmanController);
 * }</pre>
 * </p>
 * <p>
 * This class follows Java naming conventions and encapsulates the visual representation of the
 * Pacman game. It includes methods for setting the controller, drawing game elements, loading images,
 * handling key presses, and managing the game window.
 * </p>
 * <p>
 * Note: This class is part of a larger Pacman game implementation and should be used in conjunction
 * with other components such as models and controllers for a complete game experience.
 * </p>
 *
 * @author [Your Name]
 * @version 1.0
 * @see IPacmanView
 * @see PacmanController
 * @see PacmanModel
 */
package pacmangame.view;

import pacmangame.controller.IPacmanController;
import processing.core.PApplet;
import processing.core.PImage;
import pacmangame.MusicPlayer;
/**
 * The view class for the Pacman game. It handles the graphical representation
 * of the game elements and interacts with the Pacman controller.
 */
public class PacmanView extends PApplet implements IPacmanView {

    private MusicPlayer musicPlayer;
    /**
     * Width of the game window.
     */
    private int GAME_WIDTH;
    /**
     * Height of the game window.
     */
    private int GAME_HEIGHT;
    /**
     * Size of each block in the game grid.
     */
    private int BLOCK_SIZE = 24;
    /**
     * Number of blocks in the game grid.
     */
    private int N_BLOCKS = 15;
    /**
     * Total size of the game screen.
     */
    private int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;
    /**
     * Image for Pacman facing downward.
     */
    private PImage down;
    /**
     * Image for Pacman facing upward.
     */
    private PImage up;
    /**
     * Image for Pacman facing leftward.
     */
    private PImage left;
    /**
     * Image for Pacman facing rightward.
     */
    private PImage right;
    /**
     * Image for the ghost character.
     */
    private PImage ghost;
    /**
     * Image for the heart (indicating lives).
     */
    private PImage heart;
    /**
     * Image for the block in the game grid.
     */
    private PImage block;
    /**
     * Image for the background of the game.
     */
    private PImage fond;
    /**
     * Image for the food (dot) in the game.
     */
    private PImage ball;

    private IPacmanController controller;
    /**
     * Sets the Pacman controller for the view.
     *
     * @param controller The Pacman controller to be set.
     */
    public void setController(IPacmanController controller){
        this.controller = controller;
    }
    /**
     * Constructs a PacmanView with the specified game width and height.
     *
     * @param GAME_WIDTH  The width of the game window.
     * @param GAME_HEIGHT The height of the game window.
     */
    public PacmanView(int GAME_WIDTH, int GAME_HEIGHT){
        this.GAME_WIDTH =GAME_WIDTH;
        this.GAME_HEIGHT = GAME_HEIGHT;
    }
    /**
     * Overrides the settings method from PApplet to set the size of the game window.
     */
    @Override
    public void settings(){
        setSize(GAME_WIDTH,GAME_HEIGHT);

    }
    /**
     * Overrides the setup method from PApplet to initialize the frame rate and load images.
     */
    @Override
    public void setup(){
        frameRate(30);
        loadImages();
        // Initialisez et démarrez le lecteur de musique
        musicPlayer = new MusicPlayer(this, "Naruto Shippuden Opening. 14 Size of the Moon (Full version).mp3");
        Thread musicThread = new Thread(musicPlayer);
        musicThread.start();
    }
    @Override
    public void stop() {
        // Arrêtez le lecteur de musique lorsque l'application se ferme
        musicPlayer.stop();
        super.stop();
    }
    /**
     * Overrides the draw method from PApplet to handle the graphical rendering of the game.
     */
    @Override
    public void draw(){
//        background(0);
        imageMode(CORNER);
        image(fond,0,0,width,height);
        controller.nextFrame();

    }
    /**
     * Loads the images used in the game, such as Pacman, ghosts, and items.
     */
    public void loadImages() {
        ball= loadImage("ball.jpg");
        fond= loadImage("fond.jpeg");
        block= loadImage("brique.jpg");
        down = loadImage("down.gif");
        up = loadImage("up.gif");
        left = loadImage("left.gif");
        right = loadImage("right.gif");
        ghost = loadImage("ghost.gif");
        heart = loadImage("heart.png");
    }
    /**
     * Draws a block on the screen at the specified position with a specified size.
     *
     * @param x    The x-coordinate of the block.
     * @param y    The y-coordinate of the block.
     * @param size The size of the block.
     */
    public void drawBlocK(int x, int y,int size ){

        fill(255,0,0);
        stroke(0);
        strokeWeight(1);
        rect(x,y,size,size);
        image(block,x,y,size,size);
    }
    /**
     * Draws food (dots) on the screen at the specified position.
     *
     * @param x The x-coordinate of the food.
     * @param y The y-coordinate of the food.
     */
    public void drawFood(int x, int y){
        fill(255,0,0);
        ellipse(x+10,y+10,10,10);
        image(ball,x+8,y+8,6,6);
    }
    /**
     * Draws the pause screen on the game window.
     */
    public void drawPauseScreen(){
        PImage pause = loadImage("pause.jpeg");
        imageMode(CORNER);
        image(pause,0,0,width,height);
    }
    /**
     * Draws the score and lives information on the game window.
     *
     * @param score The current score.
     * @param lives The number of lives remaining.
     */
    public  void drawScore(int score, int lives) {
        fill(5, 181, 79);
        textSize(14);
        String s = "SCORE: " + score;
        text(s, SCREEN_SIZE / 2 + 96, SCREEN_SIZE + 16);
        for (int i = 0; i < lives; i++) {
            image(heart, i * 28 + 8, SCREEN_SIZE + 1);
        }
    }
    /**
     * Draws the game start screen on the game window.
     */
    public void drawGameStartScreen() {
        PImage startgame = loadImage("Welcome.jpeg");
        imageMode(CORNER);
        image(startgame,0,0,width,height);
    }
    /**
     * Draws a ghost on the screen at the specified position.
     *
     * @param x The x-coordinate of the ghost.
     * @param y The y-coordinate of the ghost.
     */
    public void drawGhost(int x, int y) {
        image(ghost, x, y);
    }
    /**
     * Draws Pacman facing left at the specified position.
     *
     * @param x The x-coordinate of Pacman.
     * @param y The y-coordinate of Pacman.
     */
    public void drawPacmanLeft(int x, int y){
        image(left, x + 1, y + 1);
    }
    /**
     * Draws Pacman facing right at the specified position.
     *
     * @param x The x-coordinate of Pacman.
     * @param y The y-coordinate of Pacman.
     */
    public void drawPacmanRight(int x, int y){image(right, x + 1, y + 1);}
    /**
     * Draws Pacman facing up at the specified position.
     *
     * @param x The x-coordinate of Pacman.
     * @param y The y-coordinate of Pacman.
     */
    public void drawPacmanUp(int x, int y){image(up, x + 1, y + 1);}
    /**
     * Draws Pacman facing down at the specified position.
     *
     * @param x The x-coordinate of Pacman.
     * @param y The y-coordinate of Pacman.
     */
    public void drawPacmanDown(int x, int y){image(down, x + 1, y + 1);}
    /**
     * Overrides the keyPressed method from PApplet to handle key presses and delegate to the controller.
     */
    @Override
    public void keyPressed(){
        controller.handleKeyPressed(key,keyCode);
    }
}
