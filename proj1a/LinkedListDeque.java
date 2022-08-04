public class LinkedListDeque<T> {
    private Node sentinel;
    private int size;

    private class Node {
        private Node prev;
        private T item;
        private Node next;

        public Node(Node prev, T item, Node next) {
            this.prev =  prev;
            this.item = item;
            this.next = next;
        }
    }

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        Node currFirstNode = sentinel.next;
        Node newFirstNode = new Node(sentinel, item, currFirstNode);

        currFirstNode.prev = newFirstNode;
        sentinel.next = newFirstNode;
        size++;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T removeItem = sentinel.next.item;
        Node newFirstNode = sentinel.next.next;
        newFirstNode.prev = sentinel;
        sentinel.next = newFirstNode;
        size--;
        return removeItem;
    }

    public void addLast(T item) { 
        Node currLastNode = sentinel.prev;
        Node newLastNode = new Node(sentinel.prev, item, sentinel); 

        currLastNode.next = newLastNode;
        sentinel.prev = newLastNode;
        size++;
    }


    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T removeItem = sentinel.prev.item;
        Node newLastNode = sentinel.prev.prev;
        newLastNode.next = sentinel;
        sentinel.prev = newLastNode;
        size--;
        return removeItem;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        if (index > size - 1) {
            return null;
        }
        Node p = sentinel.next;
        int i = 0;
        while (i != index) {
            p = p.next;
            i++;
        }
        return p.item;
    }

    private T getRecursive(Node node, int index) {
        if (index == 0) {
            return node.item;
        }
        return getRecursive(node.next, index - 1);
    }

    public T getRecursive(int index) {
        return getRecursive(sentinel.next, index);
    }

    public void printDeque() {
        Node p = sentinel;
        while (p.next != sentinel) {
            p = p.next;
            System.out.print(p.item + " ");
        } 
    }

    // public static void main(String[] args) {
    //      LinkedListDeque LinkedListDeque = new LinkedListDeque();
 //         LinkedListDeque.addLast(0);
 //         LinkedListDeque.removeLast();     
 //         LinkedListDeque.addLast(3);
 //         System.out.print(LinkedListDeque.getRecursive(0));
    // }
}
