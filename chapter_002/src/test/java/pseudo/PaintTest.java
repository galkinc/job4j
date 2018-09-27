package pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PaintTest {
    // get the link to the standard System.out
    private PrintStream stdout = System.out;
    // Create a buffer for System out
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * Change standard System.out into the buffer
     * Executing before method
     */
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Return back standard System.out
     * Executing after method
     */
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * Square drawing test
     */
    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
            out.toString(),
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
    }

    /**
     * Triangle drawing test
     */
    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        assertThat(
            out.toString(),
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
    }

}
