package en;

import en.models.Cell;
import en.models.Figure;

public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }
    // @TODO throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException
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
    public boolean move(Cell source, Cell dest) {
        boolean rst = false;

        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
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
}
