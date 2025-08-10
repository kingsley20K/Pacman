
/**
 * The {@code PacmanModel} class represents the model for a Pacman game,
 * managing game state, player, and ghost positions, as well as other game-related logic.
 * This class encapsulates the core functionality of the Pacman game, providing methods
 * to initialize the game, update the game state, and retrieve information about the game's elements.
 * The game consists of a player (Pacman) navigating a labyrinth, collecting points, and avoiding ghosts.
 * This class handles the game's internal state, including player and ghost positions, scores, lives, and
 * various game parameters. It also provides methods for moving Pacman, updating the game state,
 * and checking for collisions.
 *
 *
 * Usage example:
 * <pre>{@code
 * PacmanModel pacmanGame = new PacmanModel();
 * pacmanGame.initGame();
 * }</pre>
 *
 *
 * This class follows Java naming conventions and provides encapsulation of game-related data and behavior.
 * It includes methods for initializing the game, moving game elements, handling collisions, and retrieving
 * information about the game state.
 *
 * <p>
 * Note: This class is part of a larger Pacman game implementation and should be used in conjunction with
 * other components such as views and controllers for a complete game experience.
 * </p>
 *
 * @author [Your Name]
 * @version 1.0
 * @see PacmanView
 * @see PacmanController
 */

package pacmangame.model;

import java.util.Arrays;

/**
 * The {@code PacmanModel} class represents the model for a Pacman game,
 * handling game state, player, and ghost positions, and other game-related logic.
 */

public class PacmanModel {
    /**
     * Array representing the screen data for the first and second level.
     */
    private  short[] screenData,screenData2;
    /**
     * Number of blocks to construct the Labyrinth.
     */
    public static final int N_BLOCKS = 15;
    /**
     * Number of lives in the Game.
     */
    private int lives;
    /**
     * Number of punkt in the Game .
     */
    private int score;
    /**
     * To indicate if the player is dead. True if dead, false otherwise.
     */
    private  boolean dying = false;
    /**
     * Speed of the player (Pacman) from 1 to 6.
     */
    private int[] validSpeeds;

    /**
     * say the max number of ghost in the Game
     */
    public static int MAX_GHOSTS = 12;
    /**
     * speed of the player to 1 to 6
     */
    public static int PACMAN_SPEED = 6;
    /**
     * Number of ghosts per level, initially 5, level 2 is 6.
     */
    private static int N_GHOSTS ;
    /**
     * Array to structure the direction.
     * dx[] for horizontal direction.
     * dy[] for vertical direction.
     */
    private int[] dx, dy;
    /**
     * Arrays representing ghost positions and their movement.
     */
    private int[] ghost_x, ghost_y, ghost_dx, ghost_dy, ghostSpeed;
    /**
     * Player (Pacman) position and movement.
     */
    private int pacman_x;
    private int pacman_y;
    /**
     *pacmand_x: Represents the movement of Pacman along the horizontal (x) axis. It can take values such as -1 (left), 0 (no horizontal movement), or 1 (right), indicating the direction in which Pacman should move horizontally.
     */
    public int pacmand_x;
    /**
     *  pacmand_y: Represents the movement of Pacman along the vertical (y) axis. It can take values such as -1 (up), 0 (no vertical movement), or 1 (down), indicating the direction in which Pacman should move vertically.
     */
    public int pacmand_y;
    /**
     * Requested direction for player movement.
     */
    private int req_dx, req_dy;
    /**
     * Indicates if the game is paused.
     */
    private boolean paused;
    /**
     * Indicates if the game is currently in progress.
     */
    private boolean inGame;
    /**
     * Current speed of the game.
     */
    public static int currentSpeed;
    /**
     * Size of each block in the game grid.
     */
     public static final int BLOCK_SIZE = 24;
    /**
     * Size of the game screen.
     */
    private int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;
    /**
     * Level data for the first and second levels.
     */
    private short[] levelData1;
    private short[] levelData2;
    /**
     * Default constructor for the PacmanModel class.
     * Initializes arrays and other variables, and sets up the initial game state.
     */
    public PacmanModel(){
        screenData = new short[N_BLOCKS*N_BLOCKS];
        screenData2 = new short[N_BLOCKS*N_BLOCKS];
        initVariables();
        initilaiseLevelData();
        inGame = false;
        paused = false;
        initGame();
        initGame2();
    }
    /**
     * Initializes variables used in the class.
     */
    public void initVariables() {
        ghost_x = new int[MAX_GHOSTS];
        ghost_dx = new int[MAX_GHOSTS];
        ghost_y = new int[MAX_GHOSTS];
        ghost_dy = new int[MAX_GHOSTS];
        ghostSpeed = new int[MAX_GHOSTS];
        dx = new int[4];
        dy = new int[4];
        validSpeeds = new int[]{1, 2, 3, 4, 6, 8};
    }
    /**
     * Initializes the game state for the first level.
     */
    public void initGame() {
        lives = 3;
        score = 0;
        initLevel1();
        N_GHOSTS = 6;
        currentSpeed = 3;
    }
    /**
     * Initializes the game state for the second level.
     */
    public void initGame2() {
        lives = 3;
        score = 0;
        initLevel2();
        N_GHOSTS = 8;
        currentSpeed = 3;
    }
    /**
     * Initializes the data for the first and second level.
     */
    public void  initilaiseLevelData(){
        levelData1 = new short[]{
                19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
                25, 24, 24, 24, 16, 24, 16, 16, 16, 24, 24, 24, 16, 16, 20,
                0,  0,  0,  0, 17, 16, 16, 16, 20,  0,  0,  0, 17, 16, 20,
                19, 18, 22,  0, 17, 16, 16, 24, 16, 22,  0, 19, 16, 16, 20,
                17, 16, 20,  0, 17, 16, 20,  0, 17, 16, 18, 16, 16, 16, 20,
                17, 16, 16, 18, 24, 24, 28,  0, 25, 24, 16, 16, 16, 16, 20,
                17, 24, 16, 20,  0,  0,  0,  0,  0,  0, 17, 16, 16, 16, 20,
                21,  0, 25, 16, 18, 18, 18, 18, 22,  0, 17, 16, 24, 16, 20,
                21,  0,  0, 17, 16, 24, 16, 16, 16, 18, 16, 20,  0, 25, 20,
                17, 18, 18, 16, 20,  0, 17, 16, 16, 16, 16, 20,  0,  0, 21,
                17, 16, 16, 16, 20,  0, 25, 16, 24, 24, 24, 16, 18, 18, 20,
                17, 16, 16, 16, 20,  0,  0, 21,  0,  0,  0, 25, 24, 16, 20,
                17, 16, 16, 24, 28,  0, 19, 16, 18, 22,  0,  0,  0, 17, 20,
                17, 16, 20,  0,  0,  0, 17, 16, 16, 16, 18, 22,  0, 17, 20,
                25, 24, 24, 26, 26, 26, 24, 24, 24, 24, 24, 24, 26, 24, 28
        };
        levelData2 = new short[] {
                19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
                17, 16, 16, 16, 16, 24, 16, 16, 16, 16, 16, 16, 16, 16, 20,
                25, 24, 24, 24, 28, 0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
                0,  0,  0,  0,  0,  0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
                19, 18, 18, 18, 18, 18, 16, 16, 16, 16, 24, 24, 24, 24, 20,
                17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
                17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
                17, 16, 16, 16, 24, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
                17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 18, 18, 18, 18, 20,
                17, 24, 24, 28, 0, 25, 24, 24, 16, 16, 16, 16, 16, 16, 20,
                21, 0,  0,  0,  0,  0,  0,   0, 17, 16, 16, 16, 16, 16, 20,
                17, 18, 18, 22, 0, 19, 18, 18, 16, 16, 16, 16, 16, 16, 20,
                17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
                17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
                25, 24, 24, 24, 26, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28
        };
    }
    /**
     * Initializes the Game for the first level.
     */
    public void initLevel1() {
        int i;
        for (i = 0; i < N_BLOCKS * N_BLOCKS; i++) {
            screenData[i] = levelData1[i];
        }
        continueLevel();
    }
    /**
     * Initializes the Game for the second level.
     */
    public void initLevel2(){
        int i;
        for (i = 0; i < N_BLOCKS * N_BLOCKS; i++) {
            screenData2[i] = levelData2[i];
        }
        continueLevel();
    }

    /**
     * to continue after the player ist death
     */
    public void continueLevel() {

        int dx = 1;
        int random;

        for (int i = 0; i < N_GHOSTS; i++) {

            ghost_y[i] = 4 * BLOCK_SIZE; //start position
            ghost_x[i] = 4 * BLOCK_SIZE;
            ghost_dy[i] = 0;
            ghost_dx[i] = dx;
            dx = -dx;
            random = (int) (Math.random() * (currentSpeed + 1));

            if (random > currentSpeed) {
                random = currentSpeed;
            }

            ghostSpeed[i] = validSpeeds[random];
        }
        pacman_x = 7 * BLOCK_SIZE;  //start position
        pacman_y = 11 * BLOCK_SIZE;
        pacmand_x = 0;	//reset direction move
        pacmand_y = 0;
        req_dx = 0;		// reset direction controls
        req_dy = 0;
        dying = false;
    }

    /**
     * to count the number of lives and start again after having lost all the lives
     */
    public void death() {
        lives--;

        if (lives == 0) {
            inGame = false;
        }
        continueLevel();
    }
    /**
     * Moves Pacman based on user input and checks for collisions in level one.
     * @param x position x
     * @param y position y
     */
    public void movePacman(int x,int y) {
        int pos;
        short ch;
        x=req_dx;
        y=req_dy;

        if(pacman_x % BLOCK_SIZE == 0 && pacman_y % BLOCK_SIZE == 0) {
            pos = pacman_x / BLOCK_SIZE + N_BLOCKS * (int) (pacman_y / BLOCK_SIZE);
            ch = screenData[pos];
            if ((ch & 16) != 0) {
                screenData[pos] = (short) (ch & 15);
                score++;
            }
            if (req_dx != 0 || req_dy != 0) {
                if (!((req_dx == -1 && req_dy == 0 && (ch & 1) != 0)
                        || (req_dx == 1 && req_dy == 0 && (ch & 4) != 0)
                        || (req_dx == 0 && req_dy == -1 && (ch & 2) != 0)
                        || (req_dx == 0 && req_dy == 1 && (ch & 8) != 0))) {
                    pacmand_x = req_dx;
                    pacmand_y = req_dy;
                }
            }

            // Check for standstill
            if ((pacmand_x == -1 && pacmand_y == 0 && (ch & 1) != 0)
                    || (pacmand_x == 1 && pacmand_y == 0 && (ch & 4) != 0)
                    || (pacmand_x == 0 && pacmand_y == -1 && (ch & 2) != 0)
                    || (pacmand_x == 0 && pacmand_y == 1 && (ch & 8) != 0)) {
                pacmand_x = 0;
                pacmand_y = 0;
            }
        }
        pacman_x = pacman_x + PACMAN_SPEED * pacmand_x;
        pacman_y = pacman_y + PACMAN_SPEED * pacmand_y;
    }

    /**
     * Moves Pacman for the second level based on user input and checks for collisions in level 2.
     * @param x  the move for pacman in x and wust use to play in jshell
     * @param y the move for pacman in xwust use to play in jshell
     */
    public void movePacman2(int x,int y) {
        int pos;
        short ch;
        x=req_dx;
        y=req_dy;

        if(pacman_x % BLOCK_SIZE == 0 && pacman_y % BLOCK_SIZE == 0) {
            pos = pacman_x / BLOCK_SIZE + N_BLOCKS * (int) (pacman_y / BLOCK_SIZE);
            ch = screenData2[pos];
            if ((ch & 16) != 0) {
                screenData2[pos] = (short) (ch & 15);
                score++;
            }
            if (req_dx != 0 || req_dy != 0) {
                if (!((req_dx == -1 && req_dy == 0 && (ch & 1) != 0)
                        || (req_dx == 1 && req_dy == 0 && (ch & 4) != 0)
                        || (req_dx == 0 && req_dy == -1 && (ch & 2) != 0)
                        || (req_dx == 0 && req_dy == 1 && (ch & 8) != 0))) {
                    pacmand_x = req_dx;
                    pacmand_y = req_dy;
                }
            }

            // Check for standstill
            if ((pacmand_x == -1 && pacmand_y == 0 && (ch & 1) != 0)
                    || (pacmand_x == 1 && pacmand_y == 0 && (ch & 4) != 0)
                    || (pacmand_x == 0 && pacmand_y == -1 && (ch & 2) != 0)
                    || (pacmand_x == 0 && pacmand_y == 1 && (ch & 8) != 0)) {
                pacmand_x = 0;
                pacmand_y = 0;
            }
        }
        pacman_x = pacman_x + PACMAN_SPEED * pacmand_x;
        pacman_y = pacman_y + PACMAN_SPEED * pacmand_y;
    }

    /**
     * hift die collision zwischen Ghost, Pacman und die Wand
     * @return if the collision wust right
     */
    public boolean collision(){
        for (int i = 0; i < N_GHOSTS; i++) {
            if (pacman_x > (ghost_x[i]-12) && pacman_x < (ghost_x[i]+12) && pacman_y > (ghost_y[i]-12) && pacman_y < (ghost_y[i]+12)&& isInGame()) {

                setDying(true);
                System.out.println("you have lose one live");
            }
        }
        return isDying();
    }
    /**
     * Returns the size of the game screen.
     *
     * @return The size of the game screen.
     */
    public int getSCREEN_SIZE(){
      return SCREEN_SIZE;
    }
    /**
     * Returns the size of a block in the game.
     *
     * @return The size of a block in the game.
     */
    public int getBLOCK_SIZE(){
      return BLOCK_SIZE;
    }
    /**
     * Returns the data from the first level in the game.
     *
     * @return the data from the first level in the game.
     */
    public short[] getLevelData1(){
      return levelData1;
    }
    /**
     * Returns the data from the second level in the game.
     *
     * @return the data from the second level in the game.
     */
    public short[] getLevelData2(){
      return  levelData2;
    }
    /**
     * Returns the screen of data from the first level in the game.
     *
     * @return the screen of data from the first level in the game.
     */
    public short[] getScreenData(){
      return screenData;
    }
    /**
     * Returns the screen of data from the second level in the game.
     *
     * @return the screen of data from the second level in the game.
     */
    public short[] getScreenData2(){
        return screenData2;
    }
    /**
     * Returns the value true if the game ist paused and false if it is not.
     *
     * @return the value true if the game ist paused and false if it is not.
     */
    public boolean getPaused(){
      return paused;
    }
    /**
     * Number of block to construct the Labyrithn .
     * @return the Number of block to construct the Labyrithn in game.
     */
    public int getN_BLOCKS(){
      return N_BLOCKS;
    }
//    public void setGhost_x(int[] ghost_x){
//        this.ghost_x=ghost_x;
//    }
    /**
     * Returns the position in x of the GHost in game
     *
     * @return the position in x of the GHost in game
     */
    public int[] getGhost_x(){
      return ghost_x;
    }
    /**
     * Returns the initiale position in x of the GHost in game
     *
     * @return the initiale position in x of the GHost in game
     */
    public int[] getGhost_dx(){
      return ghost_dx;
    }
    /**
     * Returns the position in y of the GHost in game
     *
     * @return the position in y of the GHost in game
     */
    public int[] getGhost_y(){
      return ghost_y;
    }
    /**
     * Returns the initiale position in x of the Player in game
     *
     * @return the initiale position in x of the Player in game
     */
    public int[] getDx(){
      return dx;
    }
    /**
     * Returns the initiale position in y of the Player in game
     *
     * @return the initiale position in y of the Player in game
     */
    public int[] getDy(){
      return dy;
    }
    /**
     * Returns the Number of Ghost in game
     *
     * @return the Number of Ghost in game
     */
    public static int getN_GHOSTS(){return N_GHOSTS;}

    /**
     * Returns the initiale position in y of the GHost in game
     *
     * @return the initiale position in y of the GHost in game
     */
    public int[] getGhost_dy(){
      return ghost_dy;
    }

    /**
     * return the Speed of the player
     * @return the Speed of the player
     */
    public int[] getValidSpeeds(){
      return validSpeeds;
    }
    /**
     * Returns the speed of the Ghost in game
     *
     * @return the speed of the Ghost in game
     */
    public int[] getGhostSpeed(){
      return ghostSpeed;
    }
    /**
     * Returns the position in x of the Player in game
     *
     * @return the position in x of the Player in game
     */
    public int getPacman_x(){
      return pacman_x;
    }

    /**
     * position x de pacman
     * @param pacman_x position de pacman sur x
     */
    public void setPacman_x(int pacman_x){this.pacman_x=pacman_x;}
    /**
     * Returns the position in x of the Player in game
     * @return the position in x of the Player in game
     */
    public int getPacman_y(){
      return pacman_y;
    }
    /**
     * la position de pacman sur y
     * @param pacman_y pour position pour y
     */
    public void setPacman_y(int pacman_y){this.pacman_y=pacman_y;}
    /**
     * Returns true if the Game ist in playing
     * @return true if the Game ist in playing
     */
    public boolean isInGame(){
      return inGame;
    }
    /**
     * Returns true if the player ist death
     * @return true if the Player ist death
     */
    public boolean isDying(){
      return dying;
    }
    /**
     * Sets the dying state of the object.<br>
     * @param isDying A boolean value representing the new dying state to be set.
     * If true, the object is marked as dying; if false, it is not*/
    public void setDying(boolean isDying){
      this.dying = isDying;
    }
    /** Retrieves the current required x-direction value.
     * @return The current required x-direction value.
     */
    public int getReq_dx(){
      return req_dx;
    }
    /** Retrieves the current required Y-direction value.
     * @return The current required Y-direction value.
     */
    public int getReq_dy(){
      return req_dy;
    }
    /** Sets the required X-direction value
     *  @param req_dx The new required y-direction value to be set.
     *  */
    public void setReq_dx(int req_dx){
      this.req_dx = req_dx;
    }
    /** Sets the required X-direction value
     *  @param req_dy The new required y-direction value to be set.
     *  */
    public void setReq_dy(int req_dy){
      this.req_dy = req_dy;
    }
    /**Sets the paused state of the game or object.<br>
     * @param isPaused A boolean value that determines the new paused state.
     * If true, the game or object is set to be paused; if false, it resumes.
     * */
    public void setPaused(boolean isPaused){
      this.paused = isPaused;
    }
    /**Sets the in-game state of the object.
     * @param isInGame A boolean value that determines the new in-game state.
     * If true, the object is marked as being in the game; if false, it is not */
    public void setInGame(boolean isInGame){
      this.inGame = isInGame;
    }
    /**
     * Returns the score of the Player in game
     *
     * @return the score the Player in game
     */
    public int getScore(){
      return score;
    }
    /**
     * Returns the number of the Player in game
     *
     * @return the number of the Player in game
     */
    public int getLives(){
      return lives;
    }

    /**
     * the toString method return , what of the terminal to see is
     * @return the position from pacman and ghosts in terminal
     */
    public String toString(){
        System.out.println();
        return "Player1: (" + pacman_x+ "," + pacman_y + ")\n"+"GHOST\n ("+ Arrays.toString(ghost_x) +" \n  "+ Arrays.toString(ghost_y) +")" ;
    }
    /**
     * Sets the number of lives for the player in the game.
     *
     * @param i The new number of lives to be set.
     * @return The updated number of lives after the set operation.
     */
    public int setLives(int i) {
        return lives;
    }

}