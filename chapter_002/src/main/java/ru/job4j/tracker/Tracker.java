package ru.job4j.tracker;

import java.util.*;

public class Tracker {

    private final List<Item> items = new ArrayList<>();


    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        int index = 0;
        for (Item current : items) {
            if (current.getId().equals(id)) {
                item.setId(current.getId());
                this.items.set(index, item);
                result = true;
                break;
            }
            index++;
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        int index = 0;
        for (Item current : items) {
            if (current.getId().equals(id)) {
                items.remove(index);
                result = true;
                break;
            }
            index++;
        }
        return result;
    }

    public List<Item> getAll() {
        return this.items;
    }

    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        for (Item current : items) {
            if (current.getName().equals(name)) {
                result.add(current);
            }
        }
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        for (Item current : items) {
            if (current.getId().equals(id)) {
                result = current;
                break;
            }
        }
        return result;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

}