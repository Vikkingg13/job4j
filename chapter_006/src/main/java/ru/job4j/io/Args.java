package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class Args {

    private Map<String, String> map = new HashMap<>();

    public Args(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            map.put(args[i], args[i + 1]);
        }
    }

    public String directory() {
        return map.get("-d");
    }

    public String exclude() {
        return map.get("-e");
    }

    public String output() {
        return map.get("-o");
    }
}
