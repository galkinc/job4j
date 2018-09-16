package ru.job4j.tictactoe;

/**
 * Game logic class
 *
 * @author galkinc
 * @version 0.0.1
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
     * @param hasMarkX If True - checking for X; If False - checking for O
     * @return True/False - Is hasMarkX winner?
     */
    public boolean whenHasXVerticalWinner(boolean hasMarkX) {
        boolean result = false;
        int size = this.table.length;
        int counter = 0;

        for (int j = 0; j < size; j++) {
            if (counter < size - 1) {
                //every new line should set counter to zero
                counter = 0;
                //column - should be equal о < size
                for (int i = 0; i < size -  1; i++) {
                    boolean markX = this.table[i][j].hasMarkX();
                    boolean markO = this.table[i][j].hasMarkO();

                    //We should check hasMarkX and the presence of the value (X or O) in the point
                    if (markX != markO && markX == hasMarkX) {
                        //Comparing current point and next one by vertical line
                        if (markX == this.table[i + 1][j].hasMarkX()) {
                            //increase counter of the sequence
                            counter++;
                        }
                    }
                }
            } else {
                result = true;
            }
        }
        return result;
    }

    /**
     * Checking who is winner by all possible horizontal lines
     * also checking the size of the sequence
     * @param hasMarkX If True - checking for X; If False - checking for O
     * @return True/False - Is hasMarkX winner?
     */
    public boolean whenHasXHorizontalWinner(boolean hasMarkX) {
        boolean result = false;
        int size = this.table.length;
        int counter = 0;

        //rows - should be equal i < size - 1, because we don't want to go out of the array
        for (int i = 0; i < size; i++) {
            //if counter should be less of size - 1, or it means wining
            if (counter < size - 1) {
                counter = 0;
                for (int j = 0; j < size - 1; j++) {
                    boolean markX = this.table[i][j].hasMarkX();
                    boolean markO = this.table[i][j].hasMarkO();

                    if (markX != markO && markX == hasMarkX) {
                        if (markX == this.table[i][j + 1].hasMarkX()) {
                            counter++;
                        }
                    }
                }
            } else {
                result = true;
            }
        }
        return result;
    }

    /**
     * Checking who is winner by all possible vertical lines
     * also checking the size of the sequence
     * @param hasMarkX If True - checking for X; If False - checking for O
     * @return True/False - Is hasMarkX winner?
     */
    public boolean whenHasXDiagonalWinner(boolean hasMarkX) {
        boolean result = false;
        int size = this.table.length - 1;
        int firstDiagonal = 0;
        int secondDiagonal = 0;

        for (int i = 0; i < size; i++) {
            boolean markX = this.table[i][i].hasMarkX();
            boolean markO = this.table[i][i].hasMarkO();

            if (markX != markO && markX == hasMarkX) {
                if (markX == this.table[i + 1][i + 1].hasMarkX()) {
                    firstDiagonal++;
                }
                if (this.table[size - i][i].hasMarkX() != this.table[size - i - 1][i + 1].hasMarkX()) {
                    secondDiagonal++;
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
     * X - True
     * @return
     */
    public boolean isWinnerX() {
        boolean result = false;

        return result;
    }

    /**
     * 0 - False
     * @return
     */
    public boolean isWinnerO() {
        return false;
    }

    /**
     * Think about it tomorrow
     * @return
     */
    public boolean hasGap() {
        return true;
    }
}
