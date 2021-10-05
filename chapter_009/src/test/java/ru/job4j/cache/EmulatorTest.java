package ru.job4j.cache;

import org.junit.Test;

import java.io.*;
import java.util.StringJoiner;

import static org.junit.Assert.assertEquals;

public class EmulatorTest {

    private final String ln = System.lineSeparator();

    @Test
    public void whenRunEmulatorThenOutputMessages() {
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        StringJoiner input = new StringJoiner(System.lineSeparator());
        input.add("src/main/resources/text/")
                .add("Names.txt")
                .add("yes")
                .add("Positions.txt")
                .add("no");
        InputStream is = new ByteArrayInputStream(input.toString().getBytes());
        System.setIn(is);

        Emulator emulator = new Emulator();
        emulator.emulate(CacheType.DIR_FILE);

        String output = os.toString();
        String[] result = output.split(System.lineSeparator());
        assertEquals("Enter directory: ", result[0]);
        assertEquals("Enter the key to load and get content: ", result[1]);
        assertEquals("Load", result[2]);
        assertEquals("Genadiy", result[3]);
        assertEquals("Maksim", result[4]);
        assertEquals("Natasha", result[5]);
        assertEquals("Viktor", result[6]);
        assertEquals("Petr", result[7]);
        assertEquals("Dmitriy", result[8]);
        assertEquals("Anna", result[9]);
        assertEquals("Sveta", result[10]);
        assertEquals("Yulia", result[11]);
        assertEquals("Sasha", result[12]);
        assertEquals("Continue? yes/no", result[13]);
        assertEquals("Enter the key to load and get content: ", result[14]);
        assertEquals("Load", result[15]);
        assertEquals("Director", result[16]);
        assertEquals("Manager", result[17]);
        assertEquals("Team Lead", result[18]);
        assertEquals("Developer", result[19]);
        assertEquals("Administrator", result[20]);
        assertEquals("Tester", result[21]);
        assertEquals("DevOps", result[22]);
        assertEquals("Data Analyst", result[23]);
        assertEquals("Web designer", result[24]);
        assertEquals("Continue? yes/no", result[25]);
    }
}
