package ru.job4j.jdbc;

import org.junit.Test;

import java.io.*;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class StoreXMLTest {

    @Test
    public void whenSaveTwoEntryThenCreatedXMLFileWithTwoEntry() throws IOException {
        File output = new File("./src/main/resources/output.xml");
        StoreXML store = new StoreXML(output);
        store.save(List.of(new XMLUsage.Entry(1), new XMLUsage.Entry(2)));
        String result = readFile(output);
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "<entries>"
                + "    <entry>"
                + "        <field>1</field>"
                + "    </entry>"
                + "    <entry>"
                + "        <field>2</field>"
                + "    </entry>"
                + "</entries>";
        assertThat(result, is(expected));
    }

    public String readFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder builder = new StringBuilder();
        String line = reader.readLine();
        while (line != null) {
            builder.append(line);
            line = reader.readLine();
        }
        return builder.toString();
    }
}
