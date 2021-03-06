import java.util.Iterator;

public class ArrayQueue<Item> implements Iterable<Item> {
    private int head = 0;
    private int tail = 0;
    private Item[] items;

    private class ArrayIterator implements Iterator<Item> {
        private int i = head;

        public boolean hasNext() {
            return i == tail;
        }

        public Item next() {
            return items[i++];
        }
    }

    public ArrayQueue() {
        items = (Item[]) new Object[1];
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public void enqueue(Item item) {
        if (tail == items.length) {
            resize(2 * items.length);
        }

        items[tail++] = item;
    }

    public Item dequeue() {
        Item item = items[head];
        items[head] = null;
        head++;

        if (isEmpty()) {
            head = 0;
            tail = 0;
        }

        if (!isEmpty() && (tail - head) == items.length / 4) {
            resize(items.length / 2);
            tail -= head;
            head = 0;
        }

        return item;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];

        for (int i = head; i < tail; i++) {
            copy[i - head] = items[i];
        }

        items = copy;
    }

    public static void main(String[] args) {
        ArrayQueue<String> queue = new ArrayQueue<>();

        String[] stringList = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};

        for (String word : stringList) {
            if (word.equals("-")) {
                //System.out.print(queue.dequeue() + " ");
            }
            else {
                queue.enqueue(word);
            }
        }

        System.out.print("\n");

        for (String word : queue) {
            System.out.print(word + " ");
        }
    }
}
