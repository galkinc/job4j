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
     * @param h
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
     * Drawing a Right Triangle.
     * The right triangle can have one 90° bottom angle on the left side, or one 90° bottom angle on the right side
     *
     * @param h - height of the triangle
     * @param rightSide - 0 is left side triangle; 1 is right side triangle;
     * @return Drawing of a right side triangle
     */
    public String rightTriangle(int h, boolean rightSide) {

        return this.loopBy(
                h,
                h,
                rightSide ? (row, column) -> row >= h - column - 1 : (row, column) -> row >= column
        );

    }

    /**
     * Private method for drawing a right triangle.
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
