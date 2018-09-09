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
}
