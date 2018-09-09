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

    @Test
    /**
     * If height is 2 then:
     *  ^
     * ^^^
     */
    public void whenHeightTwoThenRightStructure() {
        Paint paint = new Paint();
        String result = paint.pyramid(2);
        String ln = System.lineSeparator();
        assertThat(result, is(String.format(" ˆ %sˆˆˆ%s", ln, ln)));
    }

    @Test
    /**
     * If height is 3 then:
     *   ^
     *  ^^^
     * ^^^^^
     */
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

}
