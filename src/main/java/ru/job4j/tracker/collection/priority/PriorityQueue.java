package ru.job4j.tracker.collection.priority;

import java.util.LinkedList;

/**
 * PriorityQueue
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяется по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        var index = 0;
        if (index == tasks.size()) {
            this.tasks.add(task);
        }

        for (var element : tasks) {
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
        for (var el : tasks) {
            System.out.print("Tasks: " + el.getDesc());
            System.out.println(" - priority: " + el.getPriority());
        }
    }

    public Task take() {
        return tasks.poll();
    }
}