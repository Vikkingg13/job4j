package ru.job4j.jdbc;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ParserXMLTest {
    @Test
    public void whenParseXMLWhereSumAttributesEqualToSixThenReturnSix() {
        ParserXML parser = new ParserXML(new File("./src/main/resources/output.xml"));
        parser.parse();
        assertThat(parser.getSum(), is(3));
    }
}
