package pseudo;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PaintTest {

    @Test
    public void whenDrawSquare() {
        // get the link to the standard System.out
        PrintStream stdout = System.out;
        // Create a buffer for System out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // change standard System.out into the buffer
        System.setOut(new PrintStream(out));
        // execute drawing
        new Paint().draw(new Square());
        // result checking
        assertThat(
            new String(out.toByteArray()),
            is(
                new StringBuilder()
                    .append("+++++++")
                    .append("+     +")
                    .append("+     +")
                    .append("+++++++")
                    .append(System.lineSeparator())
                    .toString()
            )
        );
        // return back standard System.out
        System.setOut(stdout);
    }

    @Test
    public void whenDrawTriangle() {
        // get the link to the standard System.out
        PrintStream stdout = System.out;
        // Create a buffer for System out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // change standard System.out into the buffer
        System.setOut(new PrintStream(out));
        // execute drawing
        new Paint().draw(new Triangle());
        // result checking
        assertThat(
            new String(out.toByteArray()),
            is(
                new StringBuilder()
                    .append("   +   ")
                    .append("  +++  ")
                    .append(" +++++ ")
                    .append("+++++++")
                    .append(System.lineSeparator())
                    .toString()
            )
        );
        // return back standard System.out
        System.setOut(stdout);
    }

}
