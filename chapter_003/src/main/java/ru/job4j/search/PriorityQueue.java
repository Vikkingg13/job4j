package ru.job4j.search;

import java.util.Iterator;
import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int index = this.tasks.size();
        int count = 0;
        for (Task current : tasks) {
            if (task.getPriority() < current.getPriority()) {
                index = count;
                break;
            }
            count++;
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
