package ru.job4j.tracker;

import java.util.*;

public class Tracker {

    private final Item[] items = new Item[100];
    private int position = 0;

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index != position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                item.setId(this.items[index].getId());
                this.items[index] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index != position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                System.arraycopy(this.items, index + 1, this.items, index, this.position - index);
                this.position--;
                result = true;
                break;
            }
        }
        return result;
    }

    public Item[] getAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    public Item[] findByName(String name) {
        Item[] result = new Item[this.position];
        int ind = 0;
        for (int index = 0; index != this.position; index++) {
            if (items[index] != null && items[index].getName().equals(name)) {
                result[ind++] = items[index];
            }
        }
        return Arrays.copyOf(result, ind);
    }

    public Item findById(String id) {
        Item result = null;
        for (int index = 0; index != this.position; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                result = items[index];
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