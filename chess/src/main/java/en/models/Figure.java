package en.models;

import en.exceptions.*;

/**
 * The class describes abstract chess figure.
 */
public interface Figure {
    /**
     * Current position of the figure
     * @return
     */
    Cell position();

    /**
     * Logic of a figure moving.
     * If figure cant move to the dest Cell, the method throws ImpossibleMoveException
     * @param source Source Cell
     * @param dest Destination Cell
     * @return An array of cells that must pass the figure.
     * @throws ImpossibleMoveException
     */
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    /**
     * Figure image
     * @return
     */
    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    /**
     * Create the new object on the new place (associated a figure with a new cell)
     * @param dest
     * @return
     */
    Figure copy(Cell dest);

}
