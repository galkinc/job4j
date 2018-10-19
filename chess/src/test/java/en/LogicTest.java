package en;

import en.exceptions.ImpossibleMoveException;
import en.models.Cell;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import en.models.Figure;

public class LogicTest {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    private class testFigure implements Figure {
        private final Cell position;

        public testFigure(final Cell position) {
            this.position = position;
        }

        @Override
        public Cell position() {
            return this.position;
        }

        @Override
        public Cell[] way(Cell source, Cell dest) {
            Cell[] steps = new Cell[0];
            if (source.y == dest.y + 1 && source.x == dest.x) {
                steps = new Cell[] {dest};
            }
            return steps;
        }

        @Override
        public Figure copy(Cell dest) {
            return new testFigure(dest);
        }
    }

    private Figure figure = new Figure() {
        @Override
        public Cell position() {
            return null;
        }

        @Override
        public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
            return new Cell[0];
        }

        @Override
        public Figure copy(Cell dest) {
            return null;
        }
    };

    @Test
    public void whenAddAFigureThenPossibleToMove(){
        Logic logic = new Logic();
        logic.add(this.figure);
        logic.move()
        assertThat("L", is("k"));

    }

    @Before
    public void defineFigures() {

    }

    @Test
    public void whenThereIsAFigureThenGetIndex(){
    }
}
