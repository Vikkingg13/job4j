package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SearchAdvancedTest {
    private File root;
    private static final String LINE = System.getProperty("line.separator");

    @Before
    public void setUp() {
        try {
            root = new File(System.getProperty("java.io.tmpdir"), "folder");
            root.mkdir();
            File dir = new File(root, "subFolder");
            dir.mkdir();
            File file = new File(root, "file01.aa");
            file.createNewFile();
            file = new File(root, "file02.bb");
            file.createNewFile();
            file = new File(root, "file03.cc");
            file.createNewFile();
            file = new File(root, "file04.cc");
            file.createNewFile();
            file = new File(dir,  "file05.bb");
            file.createNewFile();
            file = new File(dir, "file06.cc");
            file.createNewFile();
            file = new File(dir, "file07.dd");
            file.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void whenSearchFileByFullNameThenLogHasOneFile() {
        Arguments arguments  = new Arguments(
                new String[] {"-d", root.getPath(), "-f", "-n", "file07.dd", "-o", "src/main/resources/result.log"});
        arguments.init();
        new SearchAdvanced(arguments).search();
        StringJoiner expected = new StringJoiner(LINE);
        expected.add("Найден(о) 1 файл(ов):");
        expected.add("file07.dd");
        assertThat(getLog(), is(expected.toString()));
    }

    @Test
    public void whenSearchFileByMaskNameThenLogHasThreeFile() {
        Arguments arguments  = new Arguments(
                new String[] {"-d", root.getPath(), "-m", "-n", "*.cc", "-o", "src/main/resources/result.log"});
        arguments.init();
        new SearchAdvanced(arguments).search();
        StringJoiner expected = new StringJoiner(LINE);
        expected.add("Найден(о) 3 файл(ов):");
        expected.add("file03.cc");
        expected.add("file04.cc");
        expected.add("file06.cc");
        assertThat(getLog(), is(expected.toString()));
    }

    @Test
    public void whenSearchFileByMaskNameThenLogHasOneFile() {
        Arguments arguments  = new Arguments(
                new String[] {"-d", root.getPath(), "-m", "-n", "fi??05.??", "-o", "src/main/resources/result.log"});
        arguments.init();
        new SearchAdvanced(arguments).search();
        StringJoiner expected = new StringJoiner(LINE);
        expected.add("Найден(о) 1 файл(ов):");
        expected.add("file05.bb");
        assertThat(getLog(), is(expected.toString()));
    }

    @Test
    public void whenSearchFileByRegularThenLogHasFourFile() {
        Arguments arguments  = new Arguments(
                new String[] {"-d", root.getPath(), "-r", "-n", "file\\d{2}.[^c]{2}", "-o", "src/main/resources/result.log"});
        arguments.init();
        new SearchAdvanced(arguments).search();
        StringJoiner expected = new StringJoiner(LINE);
        expected.add("Найден(о) 4 файл(ов):");
        expected.add("file01.aa");
        expected.add("file02.bb");
        expected.add("file05.bb");
        expected.add("file07.dd");
        assertThat(getLog(), is(expected.toString()));
    }

    @Test
    public void whenSearchFileByRegularThenLogHasTwoFile() {
        Arguments arguments  = new Arguments(
                new String[] {"-d", root.getPath(), "-r", "-n", "[A-Za-z]+\\d+.bb", "-o", "src/main/resources/result.log"});
        arguments.init();
        new SearchAdvanced(arguments).search();
        StringJoiner expected = new StringJoiner(LINE);
        expected.add("Найден(о) 2 файл(ов):");
        expected.add("file02.bb");
        expected.add("file05.bb");
        assertThat(getLog(), is(expected.toString()));
    }

    @Test
    public void whenAbsentRequiredOptionsThenPrintHelp() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Arguments arguments  = new Arguments(
                new String[] {"-d", root.getPath(), "-n", "file7.dd", "-o", "src/main/resources/result.log"});
        arguments.init();
        StringJoiner expected = new StringJoiner(LINE);
        expected.add("usage: Search Advanced");
        expected.add(" -d,--directory <arg>   Directory");
        expected.add(" -f                     Full name");
        expected.add(" -m                     Mask");
        expected.add(" -n,--name <arg>        Name, mask or regular");
        expected.add(" -o,--output <arg>      Output");
        expected.add(" -r                     Regular expression" + LINE);
        assertThat(out.toString(), is(expected.toString()));
    }

    private String getLog() {
        StringJoiner joiner = new StringJoiner(LINE);
        try (BufferedReader in = new BufferedReader(new FileReader("src/main/resources/result.log"))) {
            String line;
            while ((line = in.readLine()) != null) {
                joiner.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return joiner.toString();
    }
}
