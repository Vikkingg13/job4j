package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void pack(List<File> source, File target) {
        File archive = new File(System.getProperty("java.io.tmpdir"), target.getPath());
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(archive)))) {
            for (File file : source) {
                String path = file.getPath();
                zip.putNextEntry(new ZipEntry(path));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public List<File> seekBy(String root, String ext) {
        ext = ext.startsWith("*") ? ext.substring(1) : ext;
        ArrayList<File> result = new ArrayList<>();
        Queue<File> data = new LinkedList<>();
        data.offer(new File(root));
        while (!data.isEmpty()) {
            File current = data.poll();
            if (current.isDirectory()) {
                for (File child : current.listFiles()) {
                    data.offer(child);
                }
            } else if (!current.getName().endsWith(ext)) {
                result.add(current);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Args params = new Args(args);
        new Zip().pack(new Zip().seekBy(params.directory(), params.exclude()), new File(params.output()));
    }
}
