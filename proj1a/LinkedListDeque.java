public class LinkedListDeque<T> {
	private Node sentinel;
	private int size;

	private class Node{
		public Node prev;
		public T item;
		public Node next;

		public Node(Node prev, T item, Node next) {
			this.prev =  prev;
			this.item = item;
			this.next = next;
		}
	}

	public LinkedListDeque() {
		sentinel = new Node(null, null, null);
		sentinel.prev = sentinel;
		sentinel.next = sentinel;;
		size = 0;
	}

	public void addFirst(T item) {
		Node currFirstNode = sentinel.next;
		Node newFirstNode = new Node(sentinel, item, currFirstNode);

		currFirstNode.prev = newFirstNode;
		sentinel.next = newFirstNode;
		size++;
	}

	public T getFirst() {
		return sentinel.next.item;
	}

	public T removeFirst() {
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

	public T getLast() {
		return sentinel.prev.item;
	}

	public T removeLast() {
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
		if(index > size - 1)
			return null;
		Node p = sentinel;
		int i = 1;
		while(i != index) {
			p = p.next;
			i++;
		}
		return p.item;
	}

	private T getRecursive(Node node, int index) {
		if(index == 1)
			return node.item;
		return getRecursive(node.next, index - 1);
	}

	public T getRecursive(int index) {
		return getRecursive(sentinel, index);
	}

	public void printDeque() {
		Node p = sentinel;
		while(p.next!=sentinel) {
			p = p.next;
			System.out.print(p.item + " ");
		} 
	}

	public static void main(String[] args) {
		LinkedListDeque<Double> lst = new LinkedListDeque<>();
		Double a = 1.0;
		Double b = 2.0;
		Double c = 3.0;
		Double d = 4.0;
		Double e = 5.0;
		lst.addFirst(a);
		lst.addLast(b);
		lst.addLast(c);
		lst.addLast(d);
		// System.out.print(lst.get(3));
		// System.out.print(lst.getRecursive(3));
		lst.printDeque();
		System.out.print(lst.removeLast());
		// lst.removeFirst();
		// lst.removeLast();

		// System.out.println(lst.getLast());
		// System.out.println(lst.getSize());
		// System.out.println(lst.getLast());
	}
}