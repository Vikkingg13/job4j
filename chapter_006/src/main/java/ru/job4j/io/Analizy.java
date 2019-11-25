package ru.job4j.io;

import java.io.*;

public class Analizy {

    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new FileOutputStream(target))) {
            StringBuilder builder = new StringBuilder();
            String line;
            boolean available = true;
            while ((line = reader.readLine()) != null) {
                String[] data  = line.split("\\s");
                if (available && (data[0].equals("400") || data[0].equals("500"))) {
                    builder.append(data[1]);
                    builder.append(";");
                    available = false;
                } else if (!available && (data[0].equals("200") || data[0].equals("300"))) {
                    builder.append(data[1]);
                    builder.append(System.lineSeparator());
                    available = true;
                }
            }
            writer.println(builder.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
