package en.models.black;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import en.models.Cell;
import en.models.black.BishopBlack;


public class BishopBlackTest {

    @Test
    public void whenTheFigureMoveFromC1ToA3() {
        Cell source = Cell.H1;
        Cell dest = Cell.F3;
        //Cell[] cells = new Cell[3];
        Cell[] cells = new BishopBlack.way(source, dest);
        //assertThat(, is());
    }
}
