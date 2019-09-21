package ru.job4j.tracker;

import java.util.List;

public enum TrackerEnum {
    INSTANCE;
    private  Tracker tracker = new Tracker();

    public Item add(Item item) {
        return tracker.add(item);
    }

    public boolean replace(String id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(String id) {
        return tracker.delete(id);
    }

    public List<Item> getAll() {
        return tracker.getAll();
    }

    public List<Item> findByName(String name) {
        return tracker.findByName(name);
    }

    public Item findById(String id) {
        return tracker.findById(id);
    }
}
