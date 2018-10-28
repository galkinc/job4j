package en;

import en.exceptions.*;
import en.models.Cell;
import en.models.black.BishopBlack;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {

    @Test
    public void whenMoveBishopFromF8ToH6() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        assertThat(logic.move(Cell.F8, Cell.H6), is(true));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenBishopImpossibleMoveThenException() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        logic.move(Cell.F8, Cell.F7);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenNoFigureThenException() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        logic.move(Cell.C1, Cell.A3);
    }

    @Test(expected = OccupiedWayException.class)
    public void whenIsAFigureOnTheWayThenException() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        logic.add(new BishopBlack(Cell.G7));
        logic.move(Cell.F8, Cell.H6);
    }

}
