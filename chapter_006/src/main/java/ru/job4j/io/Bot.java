package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Bot implements Input {

    private ArrayList<String> answers = new ArrayList<>();

    public Bot() {
        String path = getClass().getClassLoader().getResource("answers.txt").getPath();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                answers.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String write() {
        int index = (int) (Math.random() * answers.size());
        String text = answers.get(index);
        System.out.println(text);
        return text;
    }
}
