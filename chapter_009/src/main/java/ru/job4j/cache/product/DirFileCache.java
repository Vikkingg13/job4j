package ru.job4j.cache.product;

import java.io.File;
import java.lang.ref.SoftReference;
import java.util.Scanner;
import java.util.StringJoiner;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        System.out.println("Load");
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        File file = new File(cachingDir + key);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                joiner.add(scanner.nextLine());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        String value = joiner.toString();
        cache.put(key, new SoftReference<>(value));
        return value;
    }

}
