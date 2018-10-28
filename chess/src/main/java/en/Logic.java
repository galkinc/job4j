package en;

import en.exceptions.*;
import en.models.Cell;
import en.models.Figure;

public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    /**
     * Метод должен проверить
     *    - Что в заданной ячейки есть фигура. если нет. то выкинуть исключение
     *    - Если фигура есть. Проверить может ли она так двигаться. Если нет то упадет исключение
     *    - Проверить что полученный путь. не занят фигурами. Если занят выкинуть исключение
     *    - Если все отлично. Записать в ячейку новое новое положение Figure figure.copy(Cell dest)
     *
     * @param source
     * @param dest
     * @return
     */
    public boolean move(Cell source, Cell dest)
            throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean rst = false;

        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException("There is not a figure on the cell.");
        }

        Cell[] steps = this.figures[index].way(source, dest);
        if (!this.freeWay(steps)) {
            throw new OccupiedWayException("There is minimum one figure on the way.");
        }

        if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
            rst = true;
            this.figures[index] = this.figures[index].copy(dest);
        }

        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    /**
     * Check the way of a figure's moving.
     * @param way Figure way (Array of Cells)
     * @return false - there is minimum one figure on the way; True - there is not figures on the way.
     */
    private boolean freeWay(Cell[] way) {
        boolean result = true;
        for (Cell cell : way) {
            if (this.findBy(cell) != -1) {
                result = false;
                break;
            }
        }
        return result;
    }
}
