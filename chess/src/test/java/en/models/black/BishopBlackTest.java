package en.models.black;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import en.models.Cell;
import en.exceptions.*;


public class BishopBlackTest {

    @Test
    public void whenTheFigureMoveFromH1ToF3() {
        Cell source = Cell.H1;
        Cell dest = Cell.F3;
        Cell[] expected = new Cell[] {Cell.G2, Cell.F3};
        BishopBlack bishopBlack = new BishopBlack(source);
        Cell[] cells = bishopBlack.way(source, dest);
        assertThat(cells, is(expected));
    }

    @Test
    public void whenTheFigureMoveFromF3ToH1() {
        Cell source = Cell.F3;
        Cell dest = Cell.H1;
        Cell[] expected = new Cell[] {Cell.G2, Cell.H1};
        BishopBlack bishopBlack = new BishopBlack(source);
        Cell[] cells = bishopBlack.way(source, dest);
        assertThat(cells, is(expected));
    }

    @Test
    public void whenTheFigureMoveFromH8ToF6() {
        Cell source = Cell.H8;
        Cell dest = Cell.F6;
        Cell[] expected = new Cell[] {Cell.G7, Cell.F6};
        BishopBlack bishopBlack = new BishopBlack(source);
        Cell[] cells = bishopBlack.way(source, dest);
        assertThat(cells, is(expected));
    }

    @Test
    public void whenTheFigureMoveFromF6ToH8() {
        Cell source = Cell.F6;
        Cell dest = Cell.H8;
        Cell[] expected = new Cell[] {Cell.G7, Cell.H8};
        BishopBlack bishopBlack = new BishopBlack(source);
        Cell[] cells = bishopBlack.way(source, dest);
        assertThat(cells, is(expected));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenImpossibleMoveThenException() {
        Cell source = Cell.F3;
        Cell dest = Cell.H8;
        BishopBlack bishopBlack = new BishopBlack(source);
        Cell[] cells = bishopBlack.way(source, dest);
    }

}
