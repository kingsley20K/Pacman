
/**
 * This package contains the controller class for the Pacman game.
 * The controller manages the interaction between the Pacman model and view,
 * as well as handling the game's logic. It includes methods for advancing
 * the game frame, playing different levels, moving ghosts, and handling user input.
 * <p>
 * The {@link PacmanController} class serves as the central component for controlling
 * the flow of the Pacman game, updating the score, lives, and managing the game state.
 * </p>
 * <p>
 * The package includes the following classes:
 * <ul>
 *     <li>{@link PacmanController}: The main controller class for the Pacman game.</li>
 * </ul>
 * </p>
 * <p>
 * The controller collaborates with the {@link pacmangame.model.PacmanModel} for game data
 * and the {@link pacmangame.view.IPacmanView} for displaying the game.
 * </p>
 * <p>
 * To use the controller, create an instance of {@link PacmanController}, set the
 * Pacman model and view using {@code setModel()} and {@code setView()}, and then
 * call the {@code nextFrame()} method to advance the game frame.
 * </p>
 * <p>
 * The package structure is designed to provide a clear separation of concerns between
 * the model, view, and controller components of the Pacman game implementation.
 * </p>
 */
package pacmangame.controller;

import pacmangame.model.PacmanModel;
import pacmangame.view.IPacmanView;

/**
 * The controller class for the Pacman game. It handles the interaction between
 * the Pacman model and the view, as well as the game's logic.
 */
public class  PacmanController implements IPacmanController{
    // Fields
    private PacmanModel model;
    private IPacmanView view;
    /**
     * Sets the Pacman model for the controller.
     * @param model The Pacman model to be set.
     */
    public void setModel(PacmanModel model){
        this.model = model;
    }
    /**
     * Sets the Pacman view for the controller.
     * @param view The Pacman view to be set.
     */
    public void setView(IPacmanView view){
        this.view = view;
    }
    /**
     * Advances the game to the next frame, updating the score, lives, and
     * drawing the maze based on the game state.
     */
    public void nextFrame(){
        if(model.getScore()<181){
            view.drawScore(model.getScore(),model.getLives());
            displayMaze();
            if (!model.getPaused()){
                if(!model.isInGame()){
                    view.drawGameStartScreen();
                }
                if (model.isInGame()){
                    playGame();
                }
            }
        } else {
            view.drawScore(model.getScore(),model.getLives());
            displayMaze2();
            if (!model.getPaused()){
                if(!model.isInGame()){
                    view.drawGameStartScreen();
                }
                if (model.isInGame()){
                    playGame2();
                }
            }
        }
    }
    /**
     * Handles the game logic for playing the first level.
     */
    public void playGame(){
        if (model.isDying()) {
            model.death();
        }else {
            model.movePacman(model.getReq_dx(), model.getReq_dy());
            displayMovePacMan();
            moveGhosts();
        }
    }
    /**
     * Handles the game logic for playing the second level.
     */
    public void playGame2(){
        if (model.isDying()) {
            model.death();
        }else {
            model.movePacman2(model.getReq_dx(), model.getReq_dy());
            displayMovePacMan();
            moveGhosts2();
        }
    }
    /**
     * Displays the maze for the first level, including blocks and food.
     */
    public void displayMaze(){
        short i = 0;
        int x, y;
        for (y = 0; y < model.getSCREEN_SIZE(); y += model.getBLOCK_SIZE()) {
            for (x = 0; x < model.getSCREEN_SIZE(); x += model.getBLOCK_SIZE()) {
                //pour la desssiner les blocks
                if ((model.getLevelData1()[i] == 0)) {
                    view.drawBlocK(x,y,model.getBLOCK_SIZE());
                }
                //pour la couleur et la forme de la nourriture
                if ((model.getScreenData()[i] & 16) != 0) {
                    view.drawFood(x,y);
                }
                i++;
            }
        }
        // Si le jeu est en pause, afficher un message
        if (model.getPaused()) {
            view.drawPauseScreen();
        }
    }
    /**
     * Displays the maze for the second level, including blocks and food.
     */
    public void displayMaze2(){
        short i = 0;
        int x, y;
        for (y = 0; y < model.getSCREEN_SIZE(); y += model.getBLOCK_SIZE()) {
            for (x = 0; x < model.getSCREEN_SIZE(); x += model.getBLOCK_SIZE()) {
                //pour la desssiner les blocks
                if ((model.getLevelData2()[i] == 0)) {
                    view.drawBlocK(x,y,model.getBLOCK_SIZE());
                }
                //pour la couleur et la forme de la nourriture
                if ((model.getScreenData2()[i] & 16) != 0) {
                    view.drawFood(x,y);
                }
                i++;
            }
        }
        // Si le jeu est en pause, afficher un message
        if (model.getPaused()) {
            view.drawPauseScreen();
        }
    }
    /**
     * Moves the ghosts based on the game logic for the first level.
     */
    void moveGhosts() {
        int pos;
        int count;

        for (int i = 0; i < model.getN_GHOSTS(); i++) {
            if (model.getGhost_x()[i] % model.getBLOCK_SIZE()== 0 && model.getGhost_y()[i] % model.getBLOCK_SIZE()== 0) {
                pos = model.getGhost_x()[i] / model.getBLOCK_SIZE() + model.getN_BLOCKS() * (int) (model.getGhost_y()[i] / model.getBLOCK_SIZE());

                count = 0;

                if ((model.getScreenData()[pos] & 1) == 0 && model.getGhost_dx()[i] != 1) {
                    model.getDx()[count] = -1;
                    model.getDy()[count] = 0;
                    count++;
                }
                if ((model.getScreenData()[pos] & 2) == 0 && model.getGhost_dy()[i] != 1) {
                    model.getDx()[count] = 0;
                    model.getDy()[count] = -1;
                    count++;
                }

                if ((model.getScreenData()[pos] & 4) == 0 && model.getGhost_dx()[i] != -1) {
                    model.getDx()[count] = 1;
                    model.getDy()[count] = 0;
                    count++;
                }

                if ((model.getScreenData()[pos] & 8) == 0 && model.getGhost_dy()[i] != -1) {
                    model.getDx()[count] = 0;
                    model.getDy()[count] = 1;
                    count++;
                }

                if (count == 0) {

                    if ((model.getScreenData()[pos] & 15) == 15) {
                        model.getGhost_dx()[i] = 0;
                        model.getGhost_dy()[i] = 0;
                    } else {
                        model.getGhost_dx()[i] = -model.getGhost_dx()[i];
                        model.getGhost_dy()[i] = -model.getGhost_dy()[i];
                    }

                } else {

                    count = (int) (Math.random() * count);

                    if (count > 3) {
                        count = 3;
                    }

                    model.getGhost_dx()[i] = model.getDx()[count];
                    model.getGhost_dy()[i] = model.getDy()[count];
                }

            }

            model.getGhost_x()[i] = model.getGhost_x()[i] + (model.getGhost_dx()[i] * model.getGhostSpeed()[i]);
            model.getGhost_y()[i] = model.getGhost_y()[i] + (model.getGhost_dy()[i] * model.getGhostSpeed()[i]);
            view.drawGhost(model.getGhost_x()[i] + 1, model.getGhost_y()[i] + 1);

//            if (model.getPacman_x() > (model.getGhost_x()[i] - 12) && model.getPacman_x() < (model.getGhost_x()[i] + 12) && model.getPacman_y() > (model.getGhost_y()[i] - 12)
//                    && model.getPacman_y() < (model.getGhost_y()[i] + 12) && model.isInGame()) {
//                model.setDying(true);
//            }
            model.collision();
        }
    }
    /**
     * Moves the ghosts based on the game logic for the second level.
     */
    void moveGhosts2() {
        int pos;
        int count;

        for (int i = 0; i < 8; i++) {
            if (model.getGhost_x()[i] % model.getBLOCK_SIZE()== 0 && model.getGhost_y()[i] % model.getBLOCK_SIZE()== 0) {
                pos = model.getGhost_x()[i] / model.getBLOCK_SIZE() + model.getN_BLOCKS() * (int) (model.getGhost_y()[i] / model.getBLOCK_SIZE());

                count = 0;

                if ((model.getScreenData2()[pos] & 1) == 0 && model.getGhost_dx()[i] != 1) {
                    model.getDx()[count] = -1;
                    model.getDy()[count] = 0;
                    count++;
                }
                if ((model.getScreenData2()[pos] & 2) == 0 && model.getGhost_dy()[i] != 1) {
                    model.getDx()[count] = 0;
                    model.getDy()[count] = -1;
                    count++;
                }

                if ((model.getScreenData2()[pos] & 4) == 0 && model.getGhost_dx()[i] != -1) {
                    model.getDx()[count] = 1;
                    model.getDy()[count] = 0;
                    count++;
                }

                if ((model.getScreenData2()[pos] & 8) == 0 && model.getGhost_dy()[i] != -1) {
                    model.getDx()[count] = 0;
                    model.getDy()[count] = 1;
                    count++;
                }

                if (count == 0) {

                    if ((model.getScreenData2()[pos] & 15) == 15) {
                        model.getGhost_dx()[i] = 0;
                        model.getGhost_dy()[i] = 0;
                    } else {
                        model.getGhost_dx()[i] = -model.getGhost_dx()[i];
                        model.getGhost_dy()[i] = -model.getGhost_dy()[i];
                    }

                }else {

                    count = (int) (Math.random() * count);

                    if (count > 3) {
                        count = 3;
                    }

                    model.getGhost_dx()[i] = model.getDx()[count];
                    model.getGhost_dy()[i] = model.getDy()[count];
                }
            }

            model.getGhost_x()[i] = model.getGhost_x()[i] + (model.getGhost_dx()[i] * model.getGhostSpeed()[i]);
            model.getGhost_y()[i] = model.getGhost_y()[i] + (model.getGhost_dy()[i] * model.getGhostSpeed()[i]);
            view.drawGhost(model.getGhost_x()[i] + 1, model.getGhost_y()[i] + 1);
            //gerer la collision
//            if (model.getPacman_x() > (model.getGhost_x()[i] - 12) && model.getPacman_x() < (model.getGhost_x()[i] + 12) && model.getPacman_y() > (model.getGhost_y()[i] - 12)
//                    && model.getPacman_y() < (model.getGhost_y()[i] + 12) && model.isInGame()) {
//                model.setDying(true);
//            }
            model.collision();
        }
    }
    /**
     * Displays the movement of Pacman based on the current direction.
     */
    public void displayMovePacMan(){
        if (model.getReq_dx() == -1){
            view.drawPacmanLeft(model.getPacman_x(),model.getPacman_y());
        } else if (model.getReq_dx()== 1) {
            view.drawPacmanRight(model.getPacman_x(),model.getPacman_y());
        } else if (model.getReq_dy() == -1 ) {
            view.drawPacmanUp(model.getPacman_x(),model.getPacman_y());
        } else  {
            view.drawPacmanDown(model.getPacman_x(),model.getPacman_y());
        }
    }
    /**
     * Handles key presses to control Pacman's movement or pause the game.
     * @param key     The character representation of the pressed key.
     * @param keyCode The integer representation of the pressed key.
     */
    public void handleKeyPressed(char key, int keyCode){
        if (model.isInGame()){
            if (keyCode == 37){
                model.setReq_dx(-1);
                model.setReq_dy(0);
                System.out.println(model.toString());
            }else if (keyCode == 39){
                model.setReq_dx(1);
                model.setReq_dy(0);
                System.out.println(model.toString());
            } else if (keyCode == 38) {
                model.setReq_dx(0);
                model.setReq_dy(-1);
                System.out.println(model.toString());
            } else if (keyCode ==40 ) {
                model.setReq_dx(0);
                model.setReq_dy(1);
                System.out.println(model.toString());
            } else if (keyCode == 10) {
                model.setPaused(!model.getPaused());
                //Enter druecken, um zu pausieren
            }
        }else {
            if (key == ' ' && !model.getPaused()){
                model.setInGame(true);
                model.initGame();
                if (model.getScore()>10){
                    model.initGame2();
                }
            }
        }
    }
}