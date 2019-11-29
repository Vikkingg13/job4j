package ru.job4j.io;

import java.io.File;
import java.util.*;

public class Search {

    public List<File> files(String parent, List<String> exts) {
        ArrayList<File> result = new ArrayList<>();
        Queue<File> data = new LinkedList<>();
        data.offer(new File(parent));
        while (!data.isEmpty()) {
            File current = data.poll();
            if (current.isDirectory()) {
                for (File child : current.listFiles()) {
                    data.offer(child);
                }
            } else if (exts.stream().anyMatch(ext -> current.getName().endsWith(ext))) {
                result.add(current);
                }
            }
        return result;
    }
}
