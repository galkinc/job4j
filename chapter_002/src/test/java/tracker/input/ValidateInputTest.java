package tracker.input;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import tracker.controller.input.ValidateInput;
import tracker.controller.input.StubInput;

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

    //@TODO Write TEST
    @Test
    public void whenInvalidInput() {

    /*    ValidateInput input = new ValidateInput(new StubInput(new String[] {"invalid", "1"}));
    input.ask("Enter");
    assertThat(this.mem.toString(), is(String.format("Please input key from the menu.")));
    */
    }
}