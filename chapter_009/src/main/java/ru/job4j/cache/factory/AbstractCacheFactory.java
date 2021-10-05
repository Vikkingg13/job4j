package ru.job4j.cache.factory;

import ru.job4j.cache.product.AbstractCache;

public abstract class AbstractCacheFactory<K, V> {

    abstract public AbstractCache<K, V> createCache();
}
