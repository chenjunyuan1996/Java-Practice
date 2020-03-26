package Queue;

import java.util.*;

public class Queue {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enQueue(5);
        q.enQueue(3);
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }

        q.deQueue();
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }

        q.deQueue();
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }
    }
}

class MyQueue {
    private List<Integer> data;
    private int p_start;

    public MyQueue() {
        data = new ArrayList<Integer>();
        p_start = 0;
    }

    public void enQueue(int x) {
        data.add(x);
    }

    public void deQueue() {
        if (isEmpty()) {
            return;
        }
        p_start++;
    }

    public int Front() {
        return data.get(p_start);
    }

    public boolean isEmpty() {
        return p_start >= data.size();
    }
}
