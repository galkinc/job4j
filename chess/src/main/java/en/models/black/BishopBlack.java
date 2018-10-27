package en.models.black;

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
     * y2 = y1 - d || y2 = y2 + d
     *
     * @param source Source Cell
     * @param dest Destination Cell
     * @return Array of passed cells
     */
    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        int delta = Math.abs(dest.x - source.x);
        if ((dest.y == source.y - delta) || (dest.y == source.y + delta)) {
            steps = new Cell[] {dest};
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
