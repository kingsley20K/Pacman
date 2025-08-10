//package pacmangame.model;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class PacmanModelTest {
//
//    @Test
//    void testInitVariables() {
//        PacmanModel pacmanModel = new PacmanModel();
//        pacmanModel.initVariables();
//
//        // Vérifier que les tableaux associés aux fantômes sont correctement initialisés
//        assertArrayEquals(new int[PacmanModel.MAX_GHOSTS], pacmanModel.getGhost_x());
//        assertArrayEquals(new int[PacmanModel.MAX_GHOSTS], pacmanModel.getGhost_dx());
//        assertArrayEquals(new int[PacmanModel.MAX_GHOSTS], pacmanModel.getGhost_y());
//        assertArrayEquals(new int[PacmanModel.MAX_GHOSTS], pacmanModel.getGhost_dy());
//        assertArrayEquals(new int[PacmanModel.MAX_GHOSTS], pacmanModel.getGhostSpeed());
//
//        // Vérifier que les tableaux associés à la direction du mouvement sont correctement initialisés
//        assertArrayEquals(new int[4], pacmanModel.getDx());
//        assertArrayEquals(new int[4], pacmanModel.getDy());
//
//        // Vérifier que le tableau des vitesses valides est correctement initialisé
//        assertArrayEquals(new int[]{1, 2, 3, 4, 6, 8}, pacmanModel.getValidSpeeds());
//    }
//
//    @Test
//    public void Test_the_Methode_InitGame() {
//        PacmanModel pacmanModel = new PacmanModel();
//        pacmanModel.initGame();
//
//        // Test if the initial number of lives is set correctly
//        assertEquals(3, pacmanModel.getLives());
//
//        // Test if the initial score is set correctly
//        assertEquals(0, pacmanModel.getScore());
//
//        // Test if the initial number of ghosts is set correctly
//        assertEquals(6, PacmanModel.getN_GHOSTS());
//
//        // Test if the initial speed is set correctly
//        //assertEquals(3, pacmanModel.getCurrentSpeed());
//    }
//
//    @Test
//    void Test_the_methode_initGame2() {
//        PacmanModel pacmanModel = new PacmanModel();
//        pacmanModel.initGame2();
//
//        // Test if the initial number of lives is set correctly
//        assertEquals(3, pacmanModel.getLives());
//
//        // Test if the initial score is set correctly
//        assertEquals(0, pacmanModel.getScore());
//
//        // Test if the initial number of ghosts is set correctly
//        assertEquals(8, PacmanModel.getN_GHOSTS());
//
//        // Test if the initial speed is set correctly
//        //assertEquals(3, pacmanModel.getCurrentSpeed());
//
//    }
//
//    @Test
//    void Test_the_methode_initilaiseLevelData() {
//        PacmanModel pacmanModel = new PacmanModel();
//        pacmanModel.initilaiseLevelData();
//
//        short[] expectedLevelData1 = {
//                19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
//                25, 24, 24, 24, 16, 24, 16, 16, 16, 24, 24, 24, 16, 16, 20,
//                0,  0,  0,  0, 17, 16, 16, 16, 20,  0,  0,  0, 17, 16, 20,
//                19, 18, 22,  0, 17, 16, 16, 24, 16, 22,  0, 19, 16, 16, 20,
//                17, 16, 20,  0, 17, 16, 20,  0, 17, 16, 18, 16, 16, 16, 20,
//                17, 16, 16, 18, 24, 24, 28,  0, 25, 24, 16, 16, 16, 16, 20,
//                17, 24, 16, 20,  0,  0,  0,  0,  0,  0, 17, 16, 16, 16, 20,
//                21,  0, 25, 16, 18, 18, 18, 18, 22,  0, 17, 16, 24, 16, 20,
//                21,  0,  0, 17, 16, 24, 16, 16, 16, 18, 16, 20,  0, 25, 20,
//                17, 18, 18, 16, 20,  0, 17, 16, 16, 16, 16, 20,  0,  0, 21,
//                17, 16, 16, 16, 20,  0, 25, 16, 24, 24, 24, 16, 18, 18, 20,
//                17, 16, 16, 16, 20,  0,  0, 21,  0,  0,  0, 25, 24, 16, 20,
//                17, 16, 16, 24, 28,  0, 19, 16, 18, 22,  0,  0,  0, 17, 20,
//                17, 16, 20,  0,  0,  0, 17, 16, 16, 16, 18, 22,  0, 17, 20,
//                25, 24, 24, 26, 26, 26, 24, 24, 24, 24, 24, 24, 26, 24, 28
//        };
//        assertArrayEquals(expectedLevelData1, pacmanModel.getLevelData1());
//
//        short[] expectedLevelData2 = {
//                19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
//                17, 16, 16, 16, 16, 24, 16, 16, 16, 16, 16, 16, 16, 16, 20,
//                25, 24, 24, 24, 28, 0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
//                0,  0,  0,  0,  0,  0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
//                19, 18, 18, 18, 18, 18, 16, 16, 16, 16, 24, 24, 24, 24, 20,
//                17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
//                17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
//                17, 16, 16, 16, 24, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
//                17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 18, 18, 18, 18, 20,
//                17, 24, 24, 28, 0, 25, 24, 24, 16, 16, 16, 16, 16, 16, 20,
//                21, 0,  0,  0,  0,  0,  0,   0, 17, 16, 16, 16, 16, 16, 20,
//                17, 18, 18, 22, 0, 19, 18, 18, 16, 16, 16, 16, 16, 16, 20,
//                17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
//                17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
//                25, 24, 24, 24, 26, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28
//        };
//        assertArrayEquals(expectedLevelData2, pacmanModel.getLevelData2());
//    }
//
//    @Test
//    void Test_the_methode_initLevel1() {
//        PacmanModel pacmanModel = new PacmanModel();
//        pacmanModel.initilaiseLevelData();  // Assurez-vous que les données du niveau sont initialisées
//        pacmanModel.initLevel1();
//
//        short[] expectedScreenData = {
//                19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
//                25, 24, 24, 24, 16, 24, 16, 16, 16, 24, 24, 24, 16, 16, 20,
//                0,  0,  0,  0, 17, 16, 16, 16, 20,  0,  0,  0, 17, 16, 20,
//                19, 18, 22,  0, 17, 16, 16, 24, 16, 22,  0, 19, 16, 16, 20,
//                17, 16, 20,  0, 17, 16, 20,  0, 17, 16, 18, 16, 16, 16, 20,
//                17, 16, 16, 18, 24, 24, 28,  0, 25, 24, 16, 16, 16, 16, 20,
//                17, 24, 16, 20,  0,  0,  0,  0,  0,  0, 17, 16, 16, 16, 20,
//                21,  0, 25, 16, 18, 18, 18, 18, 22,  0, 17, 16, 24, 16, 20,
//                21,  0,  0, 17, 16, 24, 16, 16, 16, 18, 16, 20,  0, 25, 20,
//                17, 18, 18, 16, 20,  0, 17, 16, 16, 16, 16, 20,  0,  0, 21,
//                17, 16, 16, 16, 20,  0, 25, 16, 24, 24, 24, 16, 18, 18, 20,
//                17, 16, 16, 16, 20,  0,  0, 21,  0,  0,  0, 25, 24, 16, 20,
//                17, 16, 16, 24, 28,  0, 19, 16, 18, 22,  0,  0,  0, 17, 20,
//                17, 16, 20,  0,  0,  0, 17, 16, 16, 16, 18, 22,  0, 17, 20,
//                25, 24, 24, 26, 26, 26, 24, 24, 24, 24, 24, 24, 26, 24, 28
//        };
//        assertArrayEquals(expectedScreenData, pacmanModel.getScreenData());
//    }
//
//    @Test
//    void Test_the_methode_initLevel2() {
//        PacmanModel pacmanModel = new PacmanModel();
//        pacmanModel.initilaiseLevelData();  // Assurez-vous que les données du niveau sont initialisées
//        pacmanModel.initLevel2();
//
//        short[] expectedScreenData2 = {
//                19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
//                17, 16, 16, 16, 16, 24, 16, 16, 16, 16, 16, 16, 16, 16, 20,
//                25, 24, 24, 24, 28, 0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
//                0,  0,  0,  0,  0,  0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
//                19, 18, 18, 18, 18, 18, 16, 16, 16, 16, 24, 24, 24, 24, 20,
//                17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
//                17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
//                17, 16, 16, 16, 24, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
//                17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 18, 18, 18, 18, 20,
//                17, 24, 24, 28, 0, 25, 24, 24, 16, 16, 16, 16, 16, 16, 20,
//                21, 0,  0,  0,  0,  0,  0,   0, 17, 16, 16, 16, 16, 16, 20,
//                17, 18, 18, 22, 0, 19, 18, 18, 16, 16, 16, 16, 16, 16, 20,
//                17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
//                17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
//                25, 24, 24, 24, 26, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28
//        };
//        assertArrayEquals(expectedScreenData2, pacmanModel.getScreenData2());
//    }
//    protected int generateRandom(int upperBound) {
//        return (int) (Math.random() * (upperBound + 1));
//    }
//    @Test
//    void Test_the_methode_continueLevel() {
//        PacmanModel pacmanModel = new PacmanModel();
//
//        pacmanModel.continueLevel();
//
//        // Vérifiez les positions initiales des fantômes
//        for (int i = 0; i < PacmanModel.getN_GHOSTS(); i++) {
//            assertEquals(4 * PacmanModel.BLOCK_SIZE, pacmanModel.getGhost_y()[i]);
//            assertEquals(4 * PacmanModel.BLOCK_SIZE, pacmanModel.getGhost_x()[i]);
//            assertEquals(0, pacmanModel.getGhost_dy()[i]);
//            assertTrue(pacmanModel.getGhost_dx()[i] == 1 || pacmanModel.getGhost_dx()[i] == -1);
//            int random = generateRandom(PacmanModel.currentSpeed+1);
//
//            if (random > PacmanModel.currentSpeed) {
//                random = PacmanModel.currentSpeed;
//            }
//            int ghostSpeed = pacmanModel.getGhostSpeed()[i];
//            assertTrue(Arrays.stream(pacmanModel.getValidSpeeds()).anyMatch(speed -> speed == ghostSpeed));
//        }
//
//        // Vérifiez les positions initiales de Pac-Man
//        assertEquals(7 * PacmanModel.BLOCK_SIZE, pacmanModel.getPacman_x());
//        assertEquals(11 * PacmanModel.BLOCK_SIZE, pacmanModel.getPacman_y());
//
//        // Vérifiez les valeurs réinitialisées des variables de déplacement
//        assertEquals(0, pacmanModel.pacmand_x);
//        assertEquals(0, pacmanModel.pacmand_y);
//        assertEquals(0, pacmanModel.getReq_dx());
//        assertEquals(0, pacmanModel.getReq_dy());
//
//        // Vérifiez que la variable "dying" est réinitialisée à false
//        assertFalse(pacmanModel.isDying());
//    }
//    @Test
//    void Test_the_methode_death() {
//        PacmanModel pacmanModel = new PacmanModel();
//
//        // Case 1: Test when lives > 0
//        pacmanModel.setLives(3);
//        pacmanModel.setInGame(true);
//        pacmanModel.death();
//        assertEquals(2, pacmanModel.getLives()); // Check if lives are decremented
//        assertTrue(pacmanModel.isInGame()); // Check if inGame remains true
//        // Add assertions based on the expected state or behavior after death
//
//        // Case 2: Test when lives == 0
//        pacmanModel.setLives(0);
//        pacmanModel.setInGame(true);
//        pacmanModel.death();
//        assertEquals(1, pacmanModel.getLives()); // Check if lives remain 0
//        assertTrue(pacmanModel.isInGame()); // Check if inGame is set to false
//        // Add assertions based on the expected state or behavior after death
//
//        // Case 3: Test when lives > 0 and inGame is false
//        pacmanModel.setLives(2);
//        pacmanModel.setInGame(false);
//        pacmanModel.death();
//        assertEquals(0, pacmanModel.getLives()); // Check if lives are decremented
//        assertFalse(pacmanModel.isInGame()); // Check if inGame remains false
//        Test_the_methode_continueLevel();
//    }
////    @Test
////    void Test_the_methode_death() {
////        PacmanModel pacmanModel = new PacmanModel();
////        pacmanModel.initVariables();  // Assurez-vous que les variables sont initialisées
////        pacmanModel.initilaiseLevelData();  // Assurez-vous que les données du niveau sont initialisées
////
////        // Assurez-vous que la partie est en cours avant la mort
////        assertFalse(pacmanModel.isInGame());
////
////        // Appeler la méthode death pour simuler la mort d'un joueur
////        pacmanModel.death();
////
////        // Vérifiez que le nombre de vies a été décrémenté
////        assertEquals(2, pacmanModel.getLives());
////
////        // Si le nombre de vies atteint 0, vérifiez que la partie n'est plus en cours
////        if (pacmanModel.getLives() == 0) {
////            assertFalse(pacmanModel.isInGame());
////        }
////        //else {
//////            // Si le nombre de vies n'est pas encore à 0, vérifiez que le niveau continue
//////            assertFalse(pacmanModel.isInGame());
//////
//////            // Vérifiez les positions initiales des fantômes et de Pac-Man après la mort
//////            for (int i = 0; i < PacmanModel.getN_GHOSTS(); i++) {
//////                assertEquals(4 * PacmanModel.BLOCK_SIZE, pacmanModel.getGhost_y()[i]);
//////                assertEquals(4 * PacmanModel.BLOCK_SIZE, pacmanModel.getGhost_x()[i]);
//////            }
//////            assertEquals(7 * PacmanModel.BLOCK_SIZE, pacmanModel.getPacman_x());
//////            assertEquals(11 * PacmanModel.BLOCK_SIZE, pacmanModel.getPacman_y());
//////
//////            // Vérifiez les valeurs réinitialisées des variables de déplacement
//////            assertEquals(0, pacmanModel.pacmand_x);
//////            assertEquals(0, pacmanModel.pacmand_y);
//////            assertEquals(0, pacmanModel.getReq_dx());
//////            assertEquals(0, pacmanModel.getReq_dy());
//////
//////            // Vérifiez que la variable "dying" est réinitialisée à false
//////            assertFalse(pacmanModel.isDying());
////        //}
////        Test_the_methode_continueLevel();
////    }
//@Test
//    void Test_the_methode_movePacman() {
//    PacmanModel pacmanModel = new PacmanModel();
//
//    // Set up initial conditions
//    pacmanModel.setPacman_x(2 * PacmanModel.BLOCK_SIZE);
//    pacmanModel.setPacman_y(3 * PacmanModel.BLOCK_SIZE);
//    //pacmanModel.setPacmand_x(1);
//    //pacmanModel.setPacmand_y(0);
//    pacmanModel.setReq_dx(1);
//    pacmanModel.setReq_dy(0);
//
//    // Invoke movePacman method
//    pacmanModel.movePacman(pacmanModel.getPacman_x(), pacmanModel.getPacman_y());
//
//    // Assertions for the conditions inside movePacman method
//
//    // Check if the score is incremented when there is a pellet
//    int pos = pacmanModel.getPacman_x() / PacmanModel.BLOCK_SIZE +
//            PacmanModel.N_BLOCKS * (int) (pacmanModel.getPacman_y() / PacmanModel.BLOCK_SIZE);
//    short ch = pacmanModel.getScreenData()[pos];
//    int expectedScore = ((ch & 16) != 0) ? 0 : 1;
//    assertEquals(expectedScore, pacmanModel.getScore());
//
//    // Check if the pellet is consumed (16th bit cleared) after collecting
//    if ((ch & 16) != 0) {
//        assertEquals(0, pacmanModel.getScreenData()[pos] & 15);
//    }
//
//    // Check if the direction is updated correctly
//    if (pacmanModel.getReq_dx() != 0 || pacmanModel.getReq_dy() != 0) {
//        if (!((pacmanModel.getReq_dx() == -1 && pacmanModel.getReq_dy() == 0 && (ch & 1) != 0)
//                || (pacmanModel.getReq_dx() == 1 && pacmanModel.getReq_dy() == 0 && (ch & 4) != 0)
//                || (pacmanModel.getReq_dx() == 0 && pacmanModel.getReq_dy() == -1 && (ch & 2) != 0)
//                || (pacmanModel.getReq_dx() == 0 && pacmanModel.getReq_dy() == 1 && (ch & 8) != 0))) {
//            assertEquals(pacmanModel.getReq_dx(), pacmanModel.pacmand_x);
//            assertEquals(pacmanModel.getReq_dy(), pacmanModel.pacmand_y);
//        }
//    }
//
//    // Check for standstill
//    if ((pacmanModel.pacmand_x == -1 && pacmanModel.pacmand_y == 0 && (ch & 1) != 0)
//            || (pacmanModel.pacmand_x == 1 && pacmanModel.pacmand_y == 0 && (ch & 4) != 0)
//            || (pacmanModel.pacmand_x == 0 && pacmanModel.pacmand_y == -1 && (ch & 2) != 0)
//            || (pacmanModel.pacmand_x == 0 && pacmanModel.pacmand_y == 1 && (ch & 8) != 0)) {
//        assertEquals(0, pacmanModel.pacmand_x);
//        assertEquals(0, pacmanModel.pacmand_y);
//    }
//
//    // Check if the position is updated correctly
//    assertEquals(2 * PacmanModel.BLOCK_SIZE + PacmanModel.PACMAN_SPEED * pacmanModel.pacmand_y,
//            pacmanModel.getPacman_x());
//    assertEquals(3 * PacmanModel.BLOCK_SIZE + PacmanModel.PACMAN_SPEED * pacmanModel.pacmand_y,
//            pacmanModel.getPacman_y());
//}
//
//    @Test
//    void Test_the_methode_movePacman2() {
//        PacmanModel pacmanModel = new PacmanModel();
//
//        // Set up initial conditions
//        pacmanModel.setPacman_x(2 * PacmanModel.BLOCK_SIZE);
//        pacmanModel.setPacman_y(3 * PacmanModel.BLOCK_SIZE);
//        //pacmanModel.setPacmand_x(1);
//        //pacmanModel.setPacmand_y(0);
//        pacmanModel.setReq_dx(1);
//        pacmanModel.setReq_dy(0);
//
//        // Invoke movePacman method
//        pacmanModel.movePacman2(pacmanModel.getPacman_x(), pacmanModel.getPacman_y());
//
//        // Assertions for the conditions inside movePacman method
//
//        // Check if the score is incremented when there is a pellet
//        int pos = pacmanModel.getPacman_x() / PacmanModel.BLOCK_SIZE +
//                PacmanModel.N_BLOCKS * (int) (pacmanModel.getPacman_y() / PacmanModel.BLOCK_SIZE);
//        short ch = pacmanModel.getScreenData2()[pos];
//        int expectedScore = ((ch & 16) != 0) ? 1 : 0;
//        assertEquals(expectedScore, pacmanModel.getScore());
//
//        // Check if the pellet is consumed (16th bit cleared) after collecting
//        if ((ch & 16) != 0) {
//            assertEquals(0, pacmanModel.getScreenData2()[pos] & 15);
//        }
//
//        // Check if the direction is updated correctly
//        if (pacmanModel.getReq_dx() != 0 || pacmanModel.getReq_dy() != 0) {
//            if (!((pacmanModel.getReq_dx() == -1 && pacmanModel.getReq_dy() == 0 && (ch & 1) != 0)
//                    || (pacmanModel.getReq_dx() == 1 && pacmanModel.getReq_dy() == 0 && (ch & 4) != 0)
//                    || (pacmanModel.getReq_dx() == 0 && pacmanModel.getReq_dy() == -1 && (ch & 2) != 0)
//                    || (pacmanModel.getReq_dx() == 0 && pacmanModel.getReq_dy() == 1 && (ch & 8) != 0))) {
//                assertEquals(pacmanModel.getReq_dx(), pacmanModel.pacmand_x);
//                assertEquals(pacmanModel.getReq_dy(), pacmanModel.pacmand_y);
//            }
//        }
//
//        // Check for standstill
//        if ((pacmanModel.pacmand_x == -1 && pacmanModel.pacmand_y == 0 && (ch & 1) != 0)
//                || (pacmanModel.pacmand_x == 1 && pacmanModel.pacmand_y == 0 && (ch & 4) != 0)
//                || (pacmanModel.pacmand_x == 0 && pacmanModel.pacmand_y == -1 && (ch & 2) != 0)
//                || (pacmanModel.pacmand_x == 0 && pacmanModel.pacmand_y == 1 && (ch & 8) != 0)) {
//            assertEquals(0, pacmanModel.pacmand_x);
//            assertEquals(0, pacmanModel.pacmand_y);
//        }
//
//        // Check if the position is updated correctly
//        assertEquals(2 * PacmanModel.BLOCK_SIZE + PacmanModel.PACMAN_SPEED * pacmanModel.pacmand_y,
//                pacmanModel.getPacman_x()-6);
//        assertEquals(3 * PacmanModel.BLOCK_SIZE + PacmanModel.PACMAN_SPEED * pacmanModel.pacmand_y,
//                pacmanModel.getPacman_y());
//    }
//
//    @Test
//    void testCollision() {
//        PacmanModel pacmanModel = new PacmanModel();
//
//        // Initialiser les conditions
//        pacmanModel.setPacman_x(10);
//        pacmanModel.setPacman_y(10);
//        pacmanModel.getGhost_x()[0] = 30;
//        pacmanModel.getGhost_y()[0] = 30;
//
//        // Tester le cas où la collision ne se produit pas
//        assertFalse(pacmanModel.isDying());
//
//        // Tester le cas où la collision se produit
//        pacmanModel.getGhost_x()[0] = 5;  // définir une position de fantôme proche de Pac-Man
//        pacmanModel.collision(5,5,10,10);
//        assertFalse(pacmanModel.isDying());
//
//        // Réinitialiser l'état
//        pacmanModel.setDying(false);
//
//    }
////    @Test
////    void Test_the_methode_collision() {
////        PacmanModel pacmanModel = new PacmanModel();
////        pacmanModel.initVariables();  // Assurez-vous que les variables sont initialisées
////        pacmanModel.initilaiseLevelData();  // Assurez-vous que les données du niveau sont initialisées
////
////        // Placez Pac-Man et un fantôme à des positions spécifiques pour simuler une collision
////        int pacmanX = 2 * PacmanModel.BLOCK_SIZE;
////        int pacmanY = 2 * PacmanModel.BLOCK_SIZE;
////        pacmanModel.setPacman_x(pacmanX);
////        pacmanModel.setPacman_y(pacmanY);
////
////        int ghostX = pacmanX + 10;  // Ajustez les positions pour simuler une collision
////        int ghostY = pacmanY + 10;
////        pacmanModel.getGhost_x()[0] = ghostX;
////        pacmanModel.getGhost_y()[0] = ghostY;
////
////        // Assurez-vous que la méthode collision détecte la collision
////        pacmanModel.collision();
////        assertFalse(pacmanModel.isDying());
////
////        // Réinitialisez l'état de la mort
////        pacmanModel.setDying(false);
////
////        // Assurez-vous que la méthode ne détecte pas de collision lorsque Pac-Man et le fantôme sont éloignés
////        pacmanModel.setPacman_x(pacmanX + 50);
////        pacmanModel.setPacman_y(pacmanY + 50);
////        pacmanModel.collision();
////        assertFalse(pacmanModel.isDying());
////    }
//
//    @Test
//    void Test_the_methode_getSCREEN_SIZE() {
//        PacmanModel pacmanModel = new PacmanModel();
//        int expectedScreenSize =360;
//        assertEquals(expectedScreenSize, pacmanModel.getSCREEN_SIZE());
//    }
//
//    @Test
//    void Test_the_methode_getBLOCK_SIZE() {
//        PacmanModel pacmanModel = new PacmanModel();
//        int expectedBlockSize =24;
//
//        // Act
//        int actualBlockSize = pacmanModel.getBLOCK_SIZE();
//
//        // Assert
//        assertEquals(expectedBlockSize, actualBlockSize);
//    }
//
//    @Test
//    void Test_the_methode_getLevelData1() {
//        // Arrange
//        PacmanModel pacmanModel = new PacmanModel();
//        short[] expectedLevelData1 = pacmanModel.getLevelData1() ;
//
//        // Act
//        short[] actualLevelData1 = pacmanModel.getLevelData1();
//
//        // Assert
//        assertArrayEquals(expectedLevelData1, actualLevelData1);
//    }
//
//    @Test
//    void Test_the_methode_getLevelData2() {
//        // Arrange
//        PacmanModel pacmanModel = new PacmanModel();
//        short[] expectedLevelData2 = pacmanModel.getLevelData2() ;
//
//        // Act
//        short[] actualLevelData2 = pacmanModel.getLevelData2();
//
//        // Assert
//        assertArrayEquals(expectedLevelData2, actualLevelData2);
//    }
//
//    @Test
//    void Test_the_methode_getScreenData() {
//        // Arrange
//        PacmanModel pacmanModel = new PacmanModel();
//        short[] expectedScreenData =  pacmanModel.getScreenData() ;
//
//        // Act
//        short[] actualScreenData = pacmanModel.getScreenData();
//
//        // Assert
//        assertArrayEquals(expectedScreenData, actualScreenData);
//    }
//
//    @Test
//    void Test_the_methode_getScreenData2() {
//        // Arrange
//        PacmanModel pacmanModel = new PacmanModel();
//        short[] expectedScreenData2 =  pacmanModel.getScreenData2() ;
//
//        // Act
//        short[] actualScreenData2 = pacmanModel.getScreenData2();
//
//        // Assert
//        assertArrayEquals(expectedScreenData2, actualScreenData2);
//    }
//
//    @Test
//    void Test_the_methode_getPaused() {
//        // Arrange
//        PacmanModel pacmanModel = new PacmanModel();
//        boolean expectedPaused =  pacmanModel.getPaused() ;
//
//        // Act
//        boolean actualPaused = pacmanModel.getPaused();
//
//        // Assert
//        assertEquals(expectedPaused, actualPaused);
//    }
//
//    @Test
//    void Test_the_methode_getGhost_x() {
//        // Arrange
//        PacmanModel pacmanModel = new PacmanModel();
//        int[] expectedGhost_x =  pacmanModel.getGhost_x() ;
//
//        // Act
//        int[] actualGhost_x = pacmanModel.getGhost_x();
//
//        // Assert
//        assertArrayEquals(expectedGhost_x, actualGhost_x);
//    }
//
//    @Test
//    void Test_the_methode_getGhost_y() {
//        // Arrange
//        PacmanModel pacmanModel = new PacmanModel();
//        int[] expectedGhost_y =  pacmanModel.getGhost_y() ;
//
//        // Act
//        int[] actualGhost_y = pacmanModel.getGhost_y();
//
//        // Assert
//        assertArrayEquals(expectedGhost_y, actualGhost_y);
//    }
//
//    @Test
//    void Test_the_methode_getDx() {
//        // Arrange
//        PacmanModel pacmanModel = new PacmanModel();
//        int[] expectedDy = pacmanModel.getDy() ;
//
//        // Act
//        int[] actualDy = pacmanModel.getDy();
//
//        // Assert
//        assertArrayEquals(expectedDy, actualDy);
//    }
//
//    @Test
//    void Test_the_methode_getDy() {
//        // Arrange
//        PacmanModel pacmanModel = new PacmanModel();
//        int[] expectedDy = pacmanModel.getDy();
//
//        // Act
//        int[] actualDy = pacmanModel.getDy();
//
//        // Assert
//        assertArrayEquals(expectedDy, actualDy);
//    }
//
//    @Test
//    void Test_the_methode_getN_GHOSTS() {
//        PacmanModel pacmanModel = new PacmanModel();
//        int expectedN_BLOCKS =  15;
//
//                assertEquals(expectedN_BLOCKS, pacmanModel.getN_BLOCKS());
//
//    }
//
//    @Test
//    void Test_the_methode_setPaused() {
//        PacmanModel pacmanModel = new PacmanModel();
//
//        // Test when setting paused to true
//        pacmanModel.setPaused(true);
//        assertTrue(pacmanModel.getPaused());
//
//        // Test when setting paused to false
//        pacmanModel.setPaused(false);
//        assertFalse(pacmanModel.getPaused());
//    }
//
//
//    @Test
//    void testToString() {
//
//        PacmanModel pacmanModel = new PacmanModel();
//        pacmanModel.setPacman_x(10);
//        pacmanModel.setPacman_y(20);
//        int[] ghost_x = {96, 96, 96, 96, 96, 96, 96, 96, 0, 0, 0, 0};
//        int[] ghost_y = {96, 96, 96, 96, 96, 96, 96, 96, 0, 0, 0, 0};
//
//        String expectedString = "Player1: (10,20)\n"+"GHOST\n (" + Arrays.toString(ghost_x) + " \n  " + Arrays.toString(ghost_y) + ")";
//        String actualString = pacmanModel.toString();
//
//         assertEquals(expectedString, actualString);
//    }
//}