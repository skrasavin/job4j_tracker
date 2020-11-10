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
        if (tasks.size() == 0) {
            this.tasks.add(task);
        }
//        for (Task element : tasks) {
//            System.out.println("priority: " + element.getPriority());
//            System.out.println("priorityTask: " + task.getPriority());
//            if (task.getPriority() < element.getPriority()) {
//                this.tasks.add(0, task);
//                break;
//            }
//        }
        for (int i = 0; i < tasks.size(); i++) {
            if (task.getPriority() < tasks.get(i).getPriority()) {
                this.tasks.add(i, task);
                break;
            }
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