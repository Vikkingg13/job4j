package ru.job4j.jdbc;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Parser for getting sum field attributes.
 * @author Viktor
 * @version 1.0
 */
public class ParserXML {
    private int sum = 0;
    private final File file;

    public ParserXML(File file) {
        this.file = file;
    }

    /**
     * Create and start parser.
     */
    public void parse() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(file, new XmlHandler());
            System.out.println(sum);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Listener for parser.
     */
    private class XmlHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equals("entry")) {
                sum += Integer.parseInt(attributes.getValue("field"));
            }
        }
    }

    /**
     *
     * @return sum all field attribute.
     */
    public int getSum() {
        return sum;
    }
}
