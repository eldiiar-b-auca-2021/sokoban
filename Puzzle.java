package easy02;

import javax.swing.*;

public class Puzzle {
    private int robotRow;
    private int robotCol;
    private int cellWidth;
    private int cellHeight;
    private char[][] data;

    int moves;
    private int currentLevel;
    private int[] storageForGoalCoordinatesR = new int[3];
    private int[] storageForGoalCoordinatesC = new int[3];

    Puzzle(String[] level){
        int index = 0;
        cellWidth = level[0].length();
        cellHeight = level.length;
        data = new char[cellWidth][level.length];
        for (int r = 0; r < level.length; r++){
            for (int c = 0; c < level[r].length(); c++){
                data[r][c] = level[r].charAt(c);
                if (data[r][c] == '@'){
                    robotRow = r;
                    robotCol = c;
                }
                if (data[r][c] == '.'){
                    storageForGoalCoordinatesR[index] = r;
                    storageForGoalCoordinatesC[index] = c;
                    index++;
                }
            }
        }
    }
    public void moveLeft() {
        if (checkForWalAndBox((robotRow), (robotCol-1))){
            robotCol--;
            data[robotRow][robotCol] = '@';
            if (checkCoordinates(robotRow,(robotCol+1))) {
                data[robotRow][robotCol + 1] = '.';
            }else {
                data[robotRow][robotCol + 1] = ' ';
            }
        }else if (data[robotRow][robotCol-1] == '$' && data[robotRow][robotCol-2] != '#'){
            robotCol--;
            data[robotRow][robotCol] = '@';
            if (checkCoordinates(robotRow, (robotCol+1))){
                data[robotRow][robotCol+1] = '.';
            }else {
                data[robotRow][robotCol+1] = ' ';
            }
            data[robotRow][robotCol-1] = '$';
        }
        moves++;
        checkForWin();
    }

    public void moveRight() {
        if (checkForWalAndBox((robotRow), (robotCol+1))){
            robotCol++;
            data[robotRow][robotCol] = '@';
            if (checkCoordinates(robotRow,(robotCol-1))){
                data[robotRow][robotCol-1] = '.';
            }else {
                data[robotRow][robotCol-1] = ' ';
            }
        }else if (data[robotRow][robotCol+1] == '$' && data[robotRow][robotCol+2] != '#'){
            robotCol++;
            data[robotRow][robotCol] = '@';
            if (checkCoordinates(robotRow,(robotCol-1))){
                data[robotRow][robotCol-1] = '.';
            }else {
                data[robotRow][robotCol-1] = ' ';
            }
            data[robotRow][robotCol+1] = '$';
        }
        moves++;
        checkForWin();
    }

    public void moveUp() {
        if (checkForWalAndBox((robotRow-1), (robotCol))) {
            robotRow--;
            data[robotRow][robotCol] = '@';
            if (checkCoordinates((robotRow + 1),robotCol)) {
                data[robotRow + 1][robotCol] = '.';
            } else {
                data[robotRow + 1][robotCol] = ' ';
            }
        } else if (data[robotRow - 1][robotCol] == '$' && data[robotRow - 2][robotCol] != '#') {
            robotRow--;
            data[robotRow][robotCol] = '@';
            if (checkCoordinates((robotRow + 1),robotCol)) {
                data[robotRow + 1][robotCol] = '.';
            } else {
                data[robotRow + 1][robotCol] = ' ';
            }
            data[robotRow - 1][robotCol] = '$';
        }
        moves++;
        checkForWin();
    }

    public void moveDown() {
        if (checkForWalAndBox((robotRow+1), (robotCol))) {
            robotRow++;
            data[robotRow][robotCol] = '@';
            if (checkCoordinates((robotRow-1), robotCol)) {
                data[robotRow - 1][robotCol] = '.';
            } else {
                data[robotRow - 1][robotCol] = ' ';
            }
        } else if (data[robotRow + 1][robotCol] == '$' && data[robotRow + 2][robotCol] != '#') {
            robotRow++;
            data[robotRow][robotCol] = '@';
            if (checkCoordinates((robotRow-1), robotCol)) {
                data[robotRow - 1][robotCol] = '.';
            } else {
                data[robotRow - 1][robotCol] = ' ';
            }
            data[robotRow + 1][robotCol] = '$';
        }
        moves++;
        checkForWin();
    }

    private boolean checkCoordinates(int r, int c) {
        for (int i = 0; i < 3; i++){
            if (storageForGoalCoordinatesR[i] == r &&
                    storageForGoalCoordinatesC[i] == c){
                return true;
            }
        }
        return false;
    }
    public boolean checkForWalAndBox(int r, int c){
        if (data[r][c] != '#' && data[r][c] != '$'){
            return true;
        }
        return false;
    }
    public int getRobotRow() {
        return robotRow;
    }

    public int getRobotCol() {
        return robotCol;
    }

    public int getCellWidth() {
        return cellWidth;
    }

    public int getCellHeight() {
        return cellHeight;
    }

    public char elementAt(int r, int c) {
        return data[r][c];
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getMoves() {
        return moves;
    }


    public boolean checkForWin(){
        int countNumForLevel = 0;
        for (int i = 0; i < cellHeight; i++){
            for (int j = 0; j< cellWidth; j++){
                if (data[i][j] == '$') {
                    for (int k = 0; k < 3; k++){
                        if (storageForGoalCoordinatesR[k] == i && storageForGoalCoordinatesC[k] == j){
                            countNumForLevel++;
                        }
                    }
                }
            }
        }
        if (countNumForLevel == currentLevel+1){
            return true;
        }
        return false;
    }

}
