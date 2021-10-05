package ru.job4j.cache.product;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    protected void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public V get(K key) {
        V value;
        if (cache.containsKey(key)) {
            SoftReference<V> ref = cache.get(key);
            value = ref.get() != null ? ref.get() : load(key);
        } else {
            value = load(key);
        }
        return value;
    }

    protected abstract V load(K key);
}
