package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.StringJoiner;

/**
 * Create a method public String pyramid(int h) in Paint class
 * h - height of a pyramid
 * For work with string use StringBuilder class and append(String), String toString().
 */
public class PaintTest {

    /**
     * Test for drawing the 2-level pyramid
     *
     * If height is 2 then:
     *  ^
     * ^^^
     */
    @Test
    public void whenHeightTwoThenRightStructure() {
        Paint paint = new Paint();
        String result = paint.pyramid(2);
        String ln = System.lineSeparator();
        assertThat(result, is(String.format(" ˆ %sˆˆˆ%s", ln, ln)));
    }

    /**
     * Test for drawing the 3-level pyramid
     *
     * If height is 3 then:
     *   ^
     *  ^^^
     * ^^^^^
     */
    @Test
    public void whenHeightThreeThenRightStructure() {
        Paint paint = new Paint();
        String result = paint.pyramid(3);
        assertThat(result,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                            .add("  ˆ  ")
                            .add(" ˆˆˆ ")
                            .add("ˆˆˆˆˆ")
                            .toString()
                )
        );
    }

    /**
     * Test for drawing a right triangles. The right triangle has one 90° angle (left side)
     *
     * Example of drawing:
     * ˆ
     * ˆˆ
     * ˆˆˆ
     */
    @Test
    public void whenSetLeftRightTriangleThenRightStructure() {
        Paint paint = new Paint();
        String result = paint.rightTriangle(3, false);
        assertThat(result,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("ˆ  ")
                                .add("ˆˆ ")
                                .add("ˆˆˆ")
                                .toString()
                )
        );
    }

    /**
     * Test for drawing a right triangles ( side). The right triangle has one 90° angle (right side)
     *
     * Example of drawing:
     *   ˆ
     *  ˆˆ
     * ˆˆˆ
     */
    @Test
    public void whenSetLeftLeftTriangleThenRightStructure() {
        Paint paint = new Paint();
        String result = paint.rightTriangle(3, true);
        assertThat(result,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("  ˆ")
                                .add(" ˆˆ")
                                .add("ˆˆˆ")
                                .toString()
                )
        );
    }
}
