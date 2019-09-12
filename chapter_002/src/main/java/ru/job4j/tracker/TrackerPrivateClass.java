package ru.job4j.tracker;

public class TrackerPrivateClass {
    private final Tracker tracker = new Tracker();

    private TrackerPrivateClass() {
    }

    public static TrackerPrivateClass getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public boolean replace(String id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(String id) {
        return tracker.delete(id);
    }

    public Item[] getAll() {
        return tracker.getAll();
    }

    public Item[] findByName(String name) {
        return tracker.findByName(name);
    }

    public Item findById(String id) {
        return tracker.findById(id);
    }

    private static final class Holder {
        private static final TrackerPrivateClass INSTANCE = new TrackerPrivateClass();
    }
}
