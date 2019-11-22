package ru.job4j.list;

public class CycleChecker {

    public boolean hasCycle(Node first) {
        boolean result = false;
        Node slow, fast;
        slow = first;
        fast = first;
        while (slow != null && fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                result = true;
                break;
            }
        }
        return result;
    }
}
