package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {
    @Test
    public void whenLogHasTwoPeriods() {
        ArrayList<String> periods = new ArrayList<>();
        String source = Analizy.class.getClassLoader().getResource("server.log").getPath();
        String target = "unavailable.csv";
        new Analizy().unavailable(source, target);
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.equals("")) {
                    periods.add(line);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        assertThat(periods.size(), is(2));
        assertThat(periods.get(0), is("14:37:12;14:37:49"));
        assertThat(periods.get(1), is("14:39:21;14:43:04"));
    }
}