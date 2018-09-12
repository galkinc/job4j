package ru.job4j.loop;

import java.util.function.BiPredicate;

public class Paint {


    /**
     *
     * Pyramid drawing
     *
     * If height is 2 then:
     *  ^
     * ^^^
     * If height is 4 then:
     *    ^
     *   ^^^
     *  ^^^^^
     * ^^^^^^^
     *
     * @param height
     * @return Pyramid drawing
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }



    /**
     * Drawing a Right or Left side of the pyramid.
     * The right triangle can have one 90° bottom angle on the left side, or one 90° bottom angle on the right side
     *
     * @param height - height of the triangle
     * @param leftside - 0 is left half of the pytamid; 1 is right side;
     * @return Drawing of a half of the pyramid
     */
    public String halfPyramid(int height, boolean leftside) {

        return this.loopBy(
                height,
                height,
                leftside ? (row, column) -> row >= height - column - 1 : (row, column) -> row >= column
        );

    }

    /**
     * Private method for drawing a leftside or right side of the pyramid (right triangle).
     *
     * @param height
     * @param weight
     * @param predict
     * @return right triangle drawing
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {

        StringBuilder screen = new StringBuilder();

        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
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
