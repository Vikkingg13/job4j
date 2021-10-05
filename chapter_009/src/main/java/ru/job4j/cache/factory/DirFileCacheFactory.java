package ru.job4j.cache.factory;

import ru.job4j.cache.Emulator;
import ru.job4j.cache.product.AbstractCache;
import ru.job4j.cache.product.DirFileCache;

public class DirFileCacheFactory extends AbstractCacheFactory<String, String> {

    @Override
    public AbstractCache<String, String> createCache() {
        String dir = input();
        return new DirFileCache(dir);
    }

    private String input() {
        System.out.println("Enter directory: ");
        return Emulator.scanner.nextLine();
    }
}
