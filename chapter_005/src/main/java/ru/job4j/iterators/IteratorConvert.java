package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorConvert {
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> outer) {
        return new Iterator<>() {

            private Iterator<Integer> inner = outer.next();

            @Override
            public Integer next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException("No such element.");
                }
                return inner.next();
            }

            @Override
            public boolean hasNext() {
                while (!inner.hasNext() && outer.hasNext()) {
                    inner = outer.next();
                }
                return inner.hasNext();
            }
        };
    }
}
