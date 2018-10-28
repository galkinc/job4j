package en.models.black;

import en.exceptions.ImpossibleMoveException;
import en.models.Cell;
import en.models.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * Logic for bishop moving is
     * d = |x2 -x1|
     * y2 = y1 - d || y2 = y1 + d
     *
     * @param source Source Cell
     * @param dest Destination Cell
     * @return Array of passed cells
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int delta = Math.abs(dest.x - source.x);
        if ((dest.y != source.y - delta) && (dest.y != source.y + delta)) {
            throw new ImpossibleMoveException("Impossible move");
        }

        Cell[] steps = new Cell[delta];
        for (int i = 0; i < delta; i++) {
            //right and up
            if (source.x > dest.x && source.y < dest.y) {
                steps[i] = this.findCellBy(source.x - 1 - i, source.y + 1 + i);
            }
            //left and down
            if (source.x < dest.x && source.y > dest.y) {
                steps[i] = this.findCellBy(source.x + 1 + i, source.y - 1 - i);
            }
            //left and up
            if (source.x > dest.x && source.y > dest.y) {
                steps[i] = this.findCellBy(source.x - 1 - i, source.y - 1 - i);
            }
            //right and down
            if (source.x < dest.x && source.y < dest.y) {
                steps[i] = this.findCellBy(source.x + 1 + i, source.y + 1 + i);
            }
        }

        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    //TODO: rewrite it to general class
    /**
     * Returning the cell by the coordinates
     * @param x X coordinate
     * @param y Y coordinate
     * @return Cell
     */
    private Cell findCellBy(int x, int y) {
        Cell rst = Cell.A1;
        for (Cell cell : Cell.values()) {
            if (cell.x == x && cell.y == y) {
                rst = cell;
                break;
            }
        }
        return rst;
    }

}
