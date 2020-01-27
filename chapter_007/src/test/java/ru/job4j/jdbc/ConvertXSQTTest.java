package ru.job4j.jdbc;

import org.junit.After;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConvertXSQTTest {
    @After
    public void init() throws IOException {
        String source = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<entries>" +
                "    <entry>" +
                "        <field>1</field>" +
                "    </entry>" +
                "    <entry>" +
                "        <field>2</field>" +
                "    </entry>" +
                "</entries>";
        String scheme = "<?xml version=\"1.0\"?>" +
                "    <xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">" +
                "        <xsl:template match=\"/\">" +
                "            <entries>" +
                "                <xsl:for-each select=\"entries/entry\">" +
                "                    <entry>" +
                "                        <xsl:attribute name=\"field\">" +
                "                            <xsl:value-of select=\"field\"/>" +
                "                        </xsl:attribute>" +
                "                    </entry>" +
                "                </xsl:for-each>" +
                "            </entries>" +
                "        </xsl:template>" +
                "    </xsl:stylesheet>";
        writeFile("./src/main/resources/source.xml", source);
        writeFile("./src/main/resources/scheme.xml", scheme);
    }

    @Test
    public void testConvertFirstFormatXMLToSecondFormatXMLUsingScheme() throws IOException {
        ConvertXSQT convert = new ConvertXSQT();
        convert.convert(
                new File("./src/main/resources/source.xml"),
                new File("./src/main/resources/output.xml"),
                new File("./src/main/resources/scheme.xml")
        );
        String result = readFile(new File("./src/main/resources/output.xml"));
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<entries>" +
                "    <entry field=\"1\"/>" +
                "    <entry field=\"2\"/>" +
                "</entries>";
        assertThat(result, is(expected));
    }

    public void writeFile(String path, String xml) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(xml);
        writer.close();

    }
    public String readFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder builder = new StringBuilder();
        String line = reader.readLine();
        while(line != null) {
            builder.append(line);
            line = reader.readLine();
        }
        return builder.toString();
    }

}
