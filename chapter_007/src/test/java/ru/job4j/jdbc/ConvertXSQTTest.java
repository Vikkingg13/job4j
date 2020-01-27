package ru.job4j.jdbc;

import org.junit.After;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConvertXSQTTest {
    @Test
    public void testConvertFirstFormatXMLToSecondFormatXMLUsingScheme() throws IOException {
        ConvertXSQT convert = new ConvertXSQT();
        convert.convert(
                new File("./src/test/resources/firstFormat.xml"),
                new File("./src/main/resources/secondFormat.xml"),
                new File("./src/test/resources/scheme.xml")
        );
        String result = readFile(new File("./src/main/resources/secondFormat.xml"));
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<entries>"
                + "    <entry field=\"1\"/>"
                + "    <entry field=\"2\"/>"
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
