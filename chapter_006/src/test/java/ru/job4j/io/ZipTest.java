package ru.job4j.io;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ZipTest {

    @Test
    public void testArchive() {
        Zip.main(new String[]{"-d", ".././", "-e", "*.java", "-o", "project.zip"});
        List<File> result = new ArrayList<>();
        File archive = new File(System.getProperty("java.io.tmpdir"), "project.zip");
        try (ZipInputStream zip = new ZipInputStream(new FileInputStream(archive))) {
            ZipEntry entry;
            while ((entry = zip.getNextEntry()) != null) {
                result.add(new File(entry.getName()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        assertThat(result, is((new Zip().seekBy(".././", "*.java"))));
    }
}
