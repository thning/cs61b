public class ArrayDeque<T> {
    private T[] items;
    private int size; 
    private int nextFirstIndex, nextLastIndex;
    private double ratio;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirstIndex = 0;
        nextLastIndex = 1;
    }


    // nextlast = currfirst 
    private void resize() {
        T[] newItems = (T[]) new Object[size * 2];
        int index = (nextFirstIndex + 1 + items.length) % items.length;
        int count = 0;
        while (count < size) {
            newItems[count] = items[index];
            index = (index + 1 + items.length) % items.length;
            count++;
        }
        nextFirstIndex = newItems.length - 1;
        nextLastIndex = size;
        items = newItems;
    }

    public void addFirst(T item) {
        items[nextFirstIndex] = item;
        nextFirstIndex = (nextFirstIndex - 1 + items.length) % items.length;
        size++;
        if (size == items.length) {
            resize();
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        int firstIndex = (nextFirstIndex + 1 + items.length) % items.length;
        T removeItem = items[firstIndex];
        items[firstIndex] = null;
        nextFirstIndex = (nextFirstIndex + 1 + items.length) % items.length;
        size--;

        if ((items.length > size * 4) && (items.length >= 16)) {
            resize();
        }
        return removeItem;
    }

    public void addLast(T item) {
        items[nextLastIndex] = item;
        nextLastIndex = (nextLastIndex + 1 + items.length) % items.length;
        size++;
        if (size == items.length) {
            resize();
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        int lastIndex = (nextLastIndex - 1 + items.length) % items.length;
        T removeItem = items[lastIndex];
        items[lastIndex] = null;
        nextLastIndex = (nextLastIndex - 1 + items.length) % items.length;
        size--;
        if ((items.length > size * 4) && (items.length >= 16)) {
            resize();
        }
        return removeItem;
    }

    public int size() {
        return size;
    }

    public T get(int i) {
        if (i > size - 1) {
            return null;
        }
        int firstIndex = (nextFirstIndex + 1 + items.length) % items.length;
        int count = 0;
        int returnIndex = firstIndex;
        while (count != i) {
            count++;
            returnIndex = (returnIndex + 1 + items.length) % items.length;
        }
        return items[returnIndex];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        int firstIndex = (nextFirstIndex + 1 + items.length) % items.length;
        int count = 0;
        int i = firstIndex;
        while (count < size) {
            System.out.print(items[i] + " ");
            i = (i + 1 + items.length) % items.length;
            count++;
        }
    }

    // public static void main(String[] args) {
    //     ArrayDeque lst = new ArrayDeque();
    //     for (int i = 0; i < 100; i++) {
    //         lst.addLast(i);
    //     }
    //     for (int i = 0; i < 90; i++) {
    //         lst.removeLast();
    //     }
    //     System.out.print(lst.get(9));
    //     System.out.print(lst.size());
    // }
}
