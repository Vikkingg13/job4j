package ru.job4j.jdbc;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.List;

/**
 * Created XML file by ArrayList entries.
 * @author Viktor
 * @version 1.0
 */
public class StoreXML {
    private final File target;

    public StoreXML(File target) {
        this.target = target;
    }

    /**
     * Create XML file.
     * @param list ArrayList with entries.
     */
    public void save(List<XMLUsage.Entry> list) {
        try {
            JAXBContext context = JAXBContext.newInstance(XMLUsage.Entries.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            BufferedWriter out = new BufferedWriter(new FileWriter(target));
            marshaller.marshal(new XMLUsage.Entries(list), out);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
