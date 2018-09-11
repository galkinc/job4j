package ru.job4j.loop;

public class Paint {


    /**
     *
     * Pyramid drawing
     *
     * If height is 2 then:
     *  ^
     * ^^^
     *If height is 3 then:
     *   ^
     *  ^^^
     * ^^^^^
     * If height is 4 then:
     *    ^
     *   ^^^
     *  ^^^^^
     * ^^^^^^^
     *
     * @param h
     * @return
     */
    public String pyramid(int h) {

        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();

        int w = 2 * h - 1;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i >= (h - j - 1) && j <= (i + h - 1)) {
                    screen.append("ˆ");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }

        return screen.toString();
    }

    /**
     * Drawing a Right Triangle.
     * The right triangle can have one 90° angle on the left side, or one 90° angle on the right side
     *
     * @param h - height of the triangle
     * @param rightSide - 0 is left side triangle; 1 is right side triangle;
     * @return Drawing of a right side triangle
     */
    public String rightTriangle(int h, boolean rightSide) {

        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j != h; j++) {
                if ((i >= j) && !rightSide || (i >= (h - j - 1) && rightSide)) {
                    screen.append("ˆ");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

}
