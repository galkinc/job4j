package ru.job4j.tictactoe;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;

/**
 * Game logic class
 *
 * @author galkinc
 * @version 1.0.0
 *
 */
public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Checking who is winner by all possible vertical lines
     * also checking the size of the sequence
     * @param checkX If it's True - checking for X; If it's False - checking for O
     * @return True/False - Is X or O the winner?
     */
    private boolean checkVerticalWinner(boolean checkX) {
        boolean result = false;
        int size = this.table.length;
        int counter = 0;

        for (int j = 0; j < size; j++) {
            //every new line should set counter to zero
            counter = 0;
            for (int i = 0; i < size -  1; i++) {
                if (checkX) {  //If checkX == true, then X
                    if (this.table[i][j].hasMarkX()) {
                        if (this.table[i][j].hasMarkX() == this.table[i + 1][j].hasMarkX()) {
                            counter++;
                        }
                    }
                } else { //if checkX == false, then O
                    if (this.table[i][j].hasMarkO()) {
                        if (this.table[i][j].hasMarkO() == this.table[i + 1][j].hasMarkO()) {
                            counter++;
                        }
                    }
                }
            }
            if (counter == size - 1) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Checking who is winner by all possible horizontal lines
     * also checking the size of the sequence
     * @param checkX If it's True - checking for X; If it's False - checking for O
     * @return True/False - Is X or O the winner?
     */
    private boolean checkHorizontalWinner(boolean checkX) {
        boolean result = false;
        int size = this.table.length;
        int counter = 0;

        for (int i = 0; i < size; i++) {
            //every new line should set counter to zero
            counter = 0;
            for (int j = 0; j < size -  1; j++) {
                //If checkX == true, then X; if checkX == false, then O
                if (checkX) {
                    if (this.table[i][j].hasMarkX()) {
                        if (this.table[i][j].hasMarkX() == this.table[i][j + 1].hasMarkX()) {
                            counter++;
                        }
                    }
                } else {
                    if (this.table[i][j].hasMarkO()) {
                        if (this.table[i][j].hasMarkO() == this.table[i][j + 1].hasMarkO()) {
                            counter++;
                        }
                    }
                }
            }
            if (counter == size - 1) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Checking who is winner in two main diagonal lines
     * also checking the size of the sequence
     * @param checkX If it's True - checking for X; If it's False - checking for O
     * @return True/False - Is X or O the winner?
     */
    private boolean checkDiagonalWinner(boolean checkX) {
        boolean result = false;
        int size = this.table.length - 1;
        int firstDiagonal = 0;
        int secondDiagonal = 0;

        for (int i = 0; i < size; i++) {
            if (checkX) { //If checkX == true, then X
                if (this.table[i][i].hasMarkX()) {
                    if (this.table[i][i].hasMarkX() == this.table[i + 1][i + 1].hasMarkX()) {
                        firstDiagonal++;
                    }
                }
                if (this.table[size - i][i].hasMarkX()) {
                    if (this.table[size - i][i].hasMarkX() == this.table[size - i - 1][i + 1].hasMarkX()) {
                        secondDiagonal++;
                    }
                }
            } else { //if checkX == false, then O
                if (this.table[i][i].hasMarkO()) {
                    if (this.table[i][i].hasMarkO() == this.table[i + 1][i + 1].hasMarkO()) {
                        firstDiagonal++;
                    }
                }
                if (this.table[size - i][i].hasMarkO()) {
                    if (this.table[size - i][i].hasMarkO() == this.table[size - i - 1][i + 1].hasMarkO()) {
                        secondDiagonal++;
                    }
                }
            }
        }

        //counter can't be smaller then size
        if (firstDiagonal == size || secondDiagonal == size) {
            result = true;
        }

        return result;
    }

    /**
     * Checking winner: X (flag "true" in the matrix)
     * @return True - X is the winner; False - X isn't the winner
     */
    public boolean isWinnerX() {
        boolean result = false;

        if (this.checkDiagonalWinner(true)
                || this.checkVerticalWinner(true)
                || this.checkHorizontalWinner(true)) {
           result = true;
        }

        return result;
    }

    /**
     * Checking winner: O (flag "false" in the matrix)
     * @return True - O is the winner; False - O isn't the winner
     */
    public boolean isWinnerO() {
        boolean result = false;

        if (this.checkDiagonalWinner(false)
                || this.checkVerticalWinner(false)
                || this.checkHorizontalWinner(false)) {
            result = true;
        }

        return result;
    }

    /**
     * Check availability of free places.
     * If there are not places for X or O, then method returns false.
     * @return True - there is minimum one free place, False - there are not free places.
     */
    public boolean hasGap() {
        boolean result = false;
        int size = this.table.length;

        for (int i = 0; !result && i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (this.table[i][j].hasMarkX() == this.table[i][j].hasMarkO()) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }
}
