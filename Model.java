public class Model {
    private int currentLevel;
    private static final String[] LEVEL_01 = {
            "!!#####!",
            "###   #!",
            "# $ # ##",
            "# #  . #",
            "#    # #",
            "## #   #",
            "#@  ###!",
            "!#####!!",
    };
    private static final String[] LEVEL_02 = {
            "!!#####!",
            "###   #!",
            "# $ # ##",
            "# #  . #",
            "#    # #",
            "##$#.  #",
            "!#@  ###",
            "!#####!!"
    };

    private static final String[] LEVEL_03 = {
            "######!!",
            "###   #!",
            "# $ # ##",
            "# #  . #",
            "# .  # #",
            "##$#.$ #",
            "!#@  ###",
            "!#####!!"
    };
    private easy02.Puzzle currentPuzzle;
    private static final String[][] LEVELS = {LEVEL_01, LEVEL_02, LEVEL_03};

    Model() {
        currentLevel = 0;
        currentPuzzle = new Puzzle(LEVELS[currentLevel]);
    }

    public void moveLeft() {
        currentPuzzle.moveLeft();
    }

    public void moveRight() {
        currentPuzzle.moveRight();
    }

    public void moveUp() {
        currentPuzzle.moveUp();
    }

    public void moveDown() {
        currentPuzzle.moveDown();
    }
    public int getCurrentLevel(){
        return currentLevel;
    }
    public int getRobotRow() {
        return currentPuzzle.getRobotRow();
    }

    public int getRobotCol() {
        return currentPuzzle.getRobotCol();
    }

    public int getCellWidth() {
        return currentPuzzle.getCellWidth();
    }

    public int getCellHeight() {
        return currentPuzzle.getCellHeight();
    }

    public int elementAt(int i, int j) {
        return currentPuzzle.elementAt(i, j);
    }

    public void nextLevel() {
        currentLevel++;
        if (currentLevel == LEVELS.length) {
            currentLevel = 0;
        }
        currentPuzzle = new easy02.Puzzle(LEVELS[currentLevel]);
        currentPuzzle.setCurrentLevel(currentLevel);
    }

    public void reset() {
        currentPuzzle = new easy02.Puzzle(LEVELS[currentLevel]);
    }
    public int getMoves(){
        return currentPuzzle.getMoves();
    }

    public boolean checkForWin(){
        return currentPuzzle.checkForWin();
    }
}
