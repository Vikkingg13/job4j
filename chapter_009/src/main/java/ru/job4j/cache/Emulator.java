package ru.job4j.cache;

import ru.job4j.cache.factory.AbstractCacheFactory;
import ru.job4j.cache.factory.DatabaseCacheFactory;
import ru.job4j.cache.factory.DirFileCacheFactory;
import ru.job4j.cache.factory.QueueCacheFactory;
import ru.job4j.cache.product.AbstractCache;

import java.util.Scanner;

public class Emulator {

    public static Scanner scanner = new Scanner(System.in);
    private AbstractCache<String, String> cache;
    private AbstractCacheFactory<String, String> factory;

    public void emulate(CacheType type) {
        switch (type) {
            case DIR_FILE:
                factory = new DirFileCacheFactory();
                break;
            case DATABASE:
                factory = new DatabaseCacheFactory();
                break;
            case QUEUE:
                factory = new QueueCacheFactory();
                break;
            default:
                throw new RuntimeException("Cache type not found");
        }
        cache = factory.createCache();
        String state;
        do {
            System.out.println("Enter the key to load and get content: ");
            String key = scanner.nextLine();
            String value = cache.get(key);
            System.out.println(value);
            System.out.println("Continue? yes/no");
            state = scanner.nextLine();
        } while (state.equals("yes"));

    }

}
