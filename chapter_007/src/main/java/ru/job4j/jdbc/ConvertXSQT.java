package ru.job4j.jdbc;

import java.io.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Converted XML file by scheme to other XML format.
 * @author Viktor
 * @version 1.0
 */
public class ConvertXSQT {
    /**
     * Converted.
     * @param source source file.
     * @param dest output file
     * @param scheme scheme for convert.
     */
    public void convert(File source, File dest, File scheme) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(
                    new StreamSource(new FileInputStream(scheme)));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
            transformer.transform(
                    new StreamSource(new FileInputStream(source)),
                    new StreamResult(new FileOutputStream(dest)));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
