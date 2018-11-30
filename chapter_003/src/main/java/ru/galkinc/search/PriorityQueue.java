package ru.galkinc.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Method adds an element by a priority.
     * Priority is a value from 1 to 5, where 5 is the lowest level and 1 is the urgent level.
     * By requirements I have to use add(int index, E value)
     * @param newTask задача
     */
    public void put(Task newTask) {
        int index = 0;
        for (Task task : tasks) {
            if (task.getPriority() >= newTask.getPriority()) {
                break;
            }
            index++;
        }
        tasks.add(index, newTask);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
