package ru.job4j.cache.factory;

import ru.job4j.cache.product.AbstractCache;

public class DatabaseCacheFactory extends AbstractCacheFactory<String, String> {

    @Override
    public AbstractCache<String, String> createCache() {
        return null;
    }
}
