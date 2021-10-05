package ru.job4j.cache;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.cache.product.DirFileCache;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.junit.Assert.assertEquals;

public class DirFileCacheTest {

    private final String ln = System.lineSeparator();
    private final String dir = "src/main/resources/text/";
    private final ByteArrayOutputStream os = new ByteArrayOutputStream();

    @Before
    public void before() {
        System.setOut(new PrintStream(os));
    }


    @Test
    public void whenUseDirFileCacheThenGetValueFromDirectory() {
        DirFileCache cache = new DirFileCache(dir);
        String result = cache.get("Names.txt");
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        joiner.add("Genadiy")
                .add("Maksim")
                .add("Natasha")
                .add("Viktor")
                .add("Petr")
                .add("Dmitriy")
                .add("Anna")
                .add("Sveta")
                .add("Yulia")
                .add("Sasha");
        String expected = joiner.toString();
        assertEquals(expected, result);
    }

    @Test
    public void whenUseDirFileCacheThenGetValueFromDirectoryTwo() {
        DirFileCache cache = new DirFileCache(dir);
        String result = cache.get("Addresses.txt");
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        joiner.add("Minsk, Pushkina, 34")
                .add("Hrodna, Lenina, 6")
                .add("Gomel, Filipenko, 72")
                .add("Kiev, Vladimirskaya, 11");
        String expected = joiner.toString();
        assertEquals(expected, result);
    }

    @Test
    public void whenUseDirFileCacheThenGetValueFromDirectoryThree() {
        DirFileCache cache = new DirFileCache(dir);
        String result = cache.get("Positions.txt");
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        joiner.add("Director")
                .add("Manager")
                .add("Team Lead")
                .add("Developer")
                .add("Administrator")
                .add("Tester")
                .add("DevOps")
                .add("Data Analyst")
                .add("Web designer");
        String expected = joiner.toString();
        assertEquals(expected, result);
    }

    @Test
    public void whenDirFileCacheEmptyThenLoadData() {
        DirFileCache cache = new DirFileCache(dir);
        cache.get("Salaries.txt");
        String result = os.toString();
        String expected = "Load" + ln;
        assertEquals(expected, result);
    }

    @Test
    public void whenDirFileCacheHasDataThenGetCache() {
        DirFileCache cache = new DirFileCache(dir);
        cache.get("Salaries.txt");
        String result = os.toString();
        String expected = "Load" + ln;
        assertEquals(expected, result);
        os.reset();
        cache.get("Salaries.txt");
        result = os.toString();
        expected = "";
        assertEquals(expected, result);
    }
}
