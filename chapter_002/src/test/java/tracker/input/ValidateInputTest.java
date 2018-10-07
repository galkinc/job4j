package tracker.input;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import tracker.MenuOutException;

/**
 * Test class which receives data from the system until entering of the correct characters.
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));

    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    //@TODO Write the TEST
    @Test(expected = MenuOutException.class)
    public void whenInvalidInput() {
        throw new MenuOutException("Out of the range.");
    }
}