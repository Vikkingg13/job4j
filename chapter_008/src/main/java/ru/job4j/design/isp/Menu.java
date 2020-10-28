package ru.job4j.design.isp;

import java.io.InputStream;
import java.util.*;

public class Menu {

    private String ln = System.lineSeparator();
    private Scanner scanner = new Scanner(System.in);
    private List<Task> tasks;
    private String message = "Enter command:"
            + ln + "0 - next"
            + ln + "1 - rename current task"
            + ln + "2 - add sub task"
            + ln + "3 - delete sub task";

    public Menu(List<Task> tasks) {
        this.tasks = tasks;
        numerate();
    }

    public void setInput(InputStream input) {
        scanner = new Scanner(input);
    }

    public void numerate() {
        int num = 1;
        for (Task task : tasks) {
            task.setPostfix(String.valueOf(num));
            num++;
        }
        Queue<Task> queue = new LinkedList<>(tasks);
        while (!queue.isEmpty()) {
            Task task = queue.poll();
            num = 1;
            for (Task sTask : task.getSubTasks()) {
                sTask.setPrefix(task.getPrefix());
                sTask.setPostfix(task.getPostfix() + "." + num);
                queue.offer(sTask);
                num++;
            }
        }
    }

    public void display() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public Task select() {
        String line = scanner.nextLine();
        String[] array = line.split("\\.");
        Task t = null;
        List<Task> list = tasks;
        for (String el : array) {
            int num = Integer.parseInt(el);
            t = list.get(num - 1);
            list = t.getSubTasks();
        }
        return t;
    }

    public void run() {
        String answer = "";
        while (!"Yes".equals(answer)) {
            display();
            System.out.println("Select task:");
            Task task = select();
            System.out.println(message);
            answer = scanner.nextLine();
            switch (answer) {
                case "1":
                    System.out.println("Enter title: ");
                    answer = scanner.nextLine();
                    task.rename(answer);
                    break;
                case "2":
                    System.out.println("Enter title for new task: ");
                    answer = scanner.nextLine();
                    task.add(answer);
                    break;
                case "3":
                    System.out.println("Enter index task for delete: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    task.delete(index);
                    break;
            }
            display();
            System.out.println("Exit? Yes/No");
            answer = scanner.nextLine();
        }
    }
}
