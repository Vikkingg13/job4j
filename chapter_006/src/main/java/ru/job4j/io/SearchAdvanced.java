package ru.job4j.io;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;


public class SearchAdvanced {
    private final String directory;
    private final String name;
    private final String output;
    private final char flag;

    public SearchAdvanced(Arguments args) {
        this.directory = args.directory();
        this.name = args.name();
        this.output = args.output();
        this.flag = args.flag();
    }

    public void search() {
        List<File> list = files(directory, filter(flag, name));
        createLog(list, output);
    }

    public List<File> files(String parent, Predicate<File> filter) {
        ArrayList<File> result = new ArrayList<>();
        Queue<File> data = new LinkedList<>();
        data.offer(new File(parent));
        while (!data.isEmpty()) {
            File current = data.poll();
            if (current.isDirectory()) {
                for (File child : current.listFiles()) {
                    data.offer(child);
                }
            } else if (filter.test(current)) {
                    result.add(current);
                }
        }
        return result;
    }

    private Predicate<File> filter(char flag, String name) {
        Predicate<File> filter;
        switch (flag) {
            case 'm':
                filter = (file) -> {
                    String regular = name.replace("*", "(.*)");
                    regular = regular.replace("?", "(.?)");
                    return file.getName().matches(regular);
                };
                break;
            case 'r':
                filter = (file) -> file.getName().matches(name);
                break;
            default:
                filter = (file) -> file.getName().equals(name);
                break;
        }
        return filter;
    }


    private void createLog(List<File> list, String output) {
        Collections.sort(list);
        StringJoiner joiner = new StringJoiner(System.getProperty("line.separator"));
        list.forEach(file -> joiner.add(file.getName()));
        try (FileWriter writer = new FileWriter(output)) {
            writer.write(String.format(
                    "Найден(о) %d файл(ов):%s", list.size(), System.getProperty("line.separator"))
            );
            writer.write(joiner.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Arguments arguments = new Arguments(args);
        arguments.init();
        new SearchAdvanced(arguments).search();
    }
}
