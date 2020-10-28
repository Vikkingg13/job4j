package ru.job4j.design.isp;

import java.io.ByteArrayInputStream;
import java.util.*;

public class Task implements Adding, Deleting, Renaming {

    private String prefix = "";
    private String postfix;
    private String title;
    private List<Task> subTasks = new ArrayList<>();

    public Task(String title) {
        this.title = title;
    }

    public Task(String title, List<Task> subTasks) {
        this.title = title;
        this.subTasks = new ArrayList<>(subTasks);
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix + "----";
    }

    public String getPostfix() {
        return postfix;
    }

    public void setPostfix(String postfix) {
        this.postfix = postfix;
    }

    public List<Task> getSubTasks() {
        return subTasks;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        joiner.add(this.prefix + title + " " + postfix);
        for (Task task : subTasks) {
            joiner.add(task.toString());
            }
        return joiner.toString();
    }

    @Override
    public void add(String title) {
        Task task = new Task(title);
        task.setPrefix(prefix);
        task.setPostfix(postfix + "." + (subTasks.size() + 1));
        subTasks.add(task);
    }

    @Override
    public void delete(int index) {
        subTasks.remove(index - 1);
    }

    @Override
    public void rename(String title) {
        this.title = title;
    }

    public static void main(String[] args) {
        ByteArrayInputStream stream = new ByteArrayInputStream(
                "3.1\n1\nnewName\n1\n4".getBytes()
        );
        Task st1 = new Task("Sub Task One");
        Task st3 = new Task("Sub Task Three");
        Task st2 = new Task("Sub Task Two", Arrays.asList(st1, st3));
        Task t1 = new Task("Task One");
        Task t2 = new Task("Task Two");
        Task t3 = new Task("Task Three", Collections.singletonList(st2));
        Menu menu = new Menu(Arrays.asList(t1, t2, t3));
        menu.run();
    }
}
