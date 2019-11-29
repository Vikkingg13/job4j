package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SearchTest {

    private File root;

    @Before
    public void setUp() {
        try {
            root = new File(System.getProperty("java.io.tmpdir"), "root");
            root.mkdir();
            File dir = new File(root, "dir");
            dir.mkdir();
            File file = new File(root, "file1.aa");
            file.createNewFile();
            file = new File(root, "file2.bb");
            file.createNewFile();
            file = new File(root, "file3.cc");
            file.createNewFile();
            file = new File(root, "file4.cc");
            file.createNewFile();
            file = new File(dir,  "file5.bb");
            file.createNewFile();
            file = new File(dir, "file6.cc");
            file.createNewFile();
            file = new File(dir, "file7.dd");
            file.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void whenSearchedFilesWithExtensionAaBbCcThenShouldReturn6Files() {
        Search searcher = new Search();
        List<File> result = searcher.files(root.getPath(), List.of(".aa", ".bb", ".cc"));
        assertThat(result.size(), is(6));
    }

    @Test
    public void whenSearchFileWithExtensionCcThenShouldReturn4Files() {
        Search searcher = new Search();
        List<File> result = searcher.files(root.getPath(), List.of(".cc"));
        assertThat(result.size(), is(3));
    }

    @Test
    public void whenSearchFileWithExtensionZzThenShouldReturn1Files() {
        Search searcher = new Search();
        List<File> result = searcher.files(root.getPath(), List.of(".dd"));
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getName(), is("file7.dd"));
    }
}
