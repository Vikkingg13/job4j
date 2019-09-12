package ru.job4j.tracker;

public class TrackerStaticFinal {
    private static final TrackerStaticFinal INSTANCE = new TrackerStaticFinal();
    private final Tracker tracker = new Tracker();

    private TrackerStaticFinal() {
    }

    public static TrackerStaticFinal getInstance() {
        return INSTANCE;
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
}
