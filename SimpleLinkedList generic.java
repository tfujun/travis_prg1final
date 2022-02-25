public class SimpleLinkedList<E> {

	private Node<E> head;
	private int size;

	public SimpleLinkedList() {
		this.head = null;
		this.size = 0;
	}

	public void add(E data) {
		this.add(this.size, data);
	}

	public void add(int position, E data) {
		if (position < 0 || position > size)
			return;

		if (this.size == 0) {
			this.head = new Node<E>(data);
		} else if (position == 0) {
			this.head = new Node<E>(data, head);
		} else {
			Node<E> current = findNode(position - 1);
			current.setNext(new Node<E>(data, current.getNext()));
		}
		this.size++;
	}

	public E get(int position) {
		if (position >= this.size || position < 0)
			return null;
		else
			return findNode(position).getData();
	}

	public E remove(int position) {
		if (position >= this.size || position < 0)
			return null;
		else if (position == 0) {
			E data = this.head.getData();
			this.head = this.head.getNext();
			this.size--;
			return data;
		} else {
			Node<E> current = findNode(position - 1);
			E data = current.getNext().getData();
			current.setNext(current.getNext().getNext());
			this.size--;
			return data;
		}
	}

	public E set(int position, E data) {
		if (position < this.size && position >= 0) {
			E oldData = this.remove(position);
			this.add(position, data);
			return oldData;
		}
		return null;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	private Node<E> findNode(int position) {
		if (position >= 0 && position < size) {
			int count = 0;
			Node<E> current = this.head;
			while (current != null) {
				if (count == position)
					return current;
				current = current.getNext();
				count++;
			}
		}
		return null;
	}
	
	public boolean contains(E data) {
		return indexOf(data) != -1;
	}
	
	public int indexOf(E data) {
		int currentPosition = 0;
		Node<E> current = head;
		while (current != null) {
			if (current.getData().equals(data)) return currentPosition;
			current = current.getNext();
			currentPosition++;
		}
		return -1;	
	}
	
	public void remove(E data) {
		if (contains(data)) remove(indexOf(data));
	}
	
	@Override
	public String toString() {
		String result = "[";
		Node<E> current = head;
		for (int i = 0; i < size() - 1; ++i) {
			result += current.getData() + ", ";
			current = current.getNext();
		}
		if (size() > 0) result += current.getData();
		result += "]";
		return result;
	}
	
	//@SuppressWarnings("unchecked") //Uncommenting this line may or may not be useful eventually.
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (!(o instanceof SimpleLinkedList)) return false;
		var other = (SimpleLinkedList) o;
		if (size() != other.size()) return false;
		for (int i = 0; i < size(); ++i) if (!get(i).equals(other.get(i))) return false;
		return true;
	}

}
