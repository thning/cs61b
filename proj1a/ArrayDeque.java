public class ArrayDeque<T>{
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
	public void resize() {
		T[] newItems = (T[]) new Object[size * 2];
		int firstIndex = (nextFirstIndex + 1 + items.length) % items.length;
		for(int i = 0; i < size; i++) { 
			if(i >= firstIndex)
				newItems[i - firstIndex] = items[i];
			else
				newItems[size - firstIndex + i] = items[i];
		}
		nextFirstIndex = newItems.length - 1;
		nextLastIndex = size;
		items = newItems;
	}

	public void addFirst(T item) {
		items[nextFirstIndex] = item;
		nextFirstIndex = (nextFirstIndex - 1 + items.length) % items.length;
		size++;
		if(size==items.length)
			resize();
	}

	public T getFirst() {
		int firstIndex = (nextFirstIndex + 1 + items.length) % items.length;
		return items[firstIndex];
	}

	public void removeFirst() {
		T item = getFirst();
		item = null;
		nextFirstIndex = (nextFirstIndex + 1 + items.length) % items.length;
		size--;
	}

	public void addLast(T item) {
		items[nextLastIndex] = item;
		nextLastIndex = (nextLastIndex + 1 + items.length) % items.length;
		size++;
		if(size==items.length)
			resize();
	}

	public T getLast() {
		int lastIndex = (nextLastIndex - 1 + items.length) % items.length;
		return items[lastIndex];
	}

	public void removeLast() {
		T item = getLast();
		item = null;
		nextLastIndex = (nextLastIndex - 1 + items.length) % items.length;
		size--;
	}

	public int size() {
		return size;
	}

	public T get(int i) {
		int firstIndex = (nextFirstIndex + 1 + items.length) % items.length;
		int count = 0;
		int returnIndex = firstIndex;
		while(count != i) {
			count++;
			returnIndex = (returnIndex + 1 + items.length) % items.length;
		}
		return items[returnIndex];
	}

	public static void main(String[] args) {
		ArrayDeque lst = new ArrayDeque();
		for(int i = 0; i < 5; i++){
			lst.addLast(i);
		}
		for(int i = 0; i < 5; i++){
			lst.addFirst(i);
		}
		System.out.print(lst.get(9));
	}
}
