package ru.job4j.tracker.collection.priority;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяется по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
        if (index == tasks.size()) {
            this.tasks.add(task);
        }

        for (Task element : tasks) {
            if (task.getPriority() < element.getPriority()) {
                this.tasks.add(index, task);
                break;
            }
            index++;
        }
         show();
    }

    public void show() {
        System.out.println("size:" + tasks.size());
        for (Task el : tasks) {
            System.out.print("Tasks: " + el.getDesc());
            System.out.println(" - priority: " + el.getPriority());
        }
    }

    public Task take() {
        return tasks.poll();
    }
}