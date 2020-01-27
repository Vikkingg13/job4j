package ru.job4j.jdbc;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Classes for description entries.
 * @author Viktor
 * @version 1.0
 */
public class XMLUsage {

    @XmlRootElement
    public static class Entries {
        private List<Entry> entry;

        public Entries() {

        }

        public Entries(List<Entry> entry) {
            this.entry = entry;
        }

        public List<Entry> getEntry() {
            return entry;
        }

        public void setEntry(List<Entry> entry) {
            this.entry = entry;
        }
    }

    @XmlRootElement
    public static class Entry {
        private int field;

        public Entry() {

        }

        public Entry(int field) {
            this.field = field;
        }

        public int getField() {
            return field;
        }

        public void setField(int field) {
            this.field = field;
        }
    }
}