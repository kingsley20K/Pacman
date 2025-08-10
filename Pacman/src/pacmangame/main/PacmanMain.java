
/**
 * The {@code PacmanMain} class acts as an entry point for the Pacman application.
 * It initializes the essential components, including the model,
 * the user interface (View), and the controller to start the game.
 * The most important processes and connections between model, view, and controller are defined here.
 * The class uses the Processing Core library (PApplet) for the user interface.
 * The game window size is set to a fixed width and height (359 x 400 pixels).
 *
 * @author Kingsley
 * @version 1.0
 */
package pacmangame.main;

import pacmangame.controller.PacmanController;
import pacmangame.model.PacmanModel;
import pacmangame.view.PacmanView;
import processing.core.PApplet;

/**
 * The MyMain class acts as an entry point for the Pacman application.
 * It initializes the essential components, including the model,
 * the user interface (View) and the controller to start the game.
 * The most important processes and connections between model, view and controller are defined here.
 * The class uses the Processing Core library (PApplet) for the user interface.
 * The game window size is set to a fixed width and height (359 x 400 pixels).
 * @author Kingsley
 * @version 1.0
 */
public class PacmanMain {

    /**
     * The main method that starts the Java program and initializes the game components.
     * Instances for the model, UI and controller are created here.
     * The connections between Model, View and Controller are established.
     * Finally, the Processing application will start.
     *
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args){

        //Definition of the game window width
        final int GAME_WIDTH = 359;
        // Definition of the game window height
        final int GAME_HEIGHT = 400;
        // Instantiation of Model, View and Controller
        var model = new PacmanModel();
        var view = new PacmanView(GAME_WIDTH,GAME_HEIGHT);
        var controller = new PacmanController();
        // Connection from Model, View and Controller
        // Connect M, V and C
        controller.setModel(model);
        controller.setView(view);
        view.setController(controller);
        // Start the Processing-Anwendung
        PApplet.runSketch(new String[]{"PacmanView"},view);
    }
}
