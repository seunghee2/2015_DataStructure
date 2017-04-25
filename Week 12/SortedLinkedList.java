public class SortedLinkedList<T extends Comparable> implements List {
	private static final int DEFAULT_MAX_SIZE = 20;
	private int _maxSize;
	private int _size;
	private Node _head;

	public SortedLinkedList() {
		this._maxSize = this.DEFAULT_MAX_SIZE;
		this._size = 0;
		this._head = null;
	}

	public SortedLinkedList(int aMaxSize) {
		this._maxSize = aMaxSize;
		this._size = 0;
		this._head = null;
	}

	@Override
	public void clear() {
		this._size = 0;
		this._head = null;

	}

	@Override
	public int size() {
		return this._size;
	}

	@Override
	public boolean contains(Object anElement) {
		boolean found = false;
		Node searchNode = this._head;
		while (searchNode != null && !found) {
			if (searchNode.compareTo(anElement) == 0)
				found = true;
			searchNode = searchNode.next();
		}
		return found;

	}

	@Override
	public boolean isFull() {
		return this._maxSize == this._size;
	}

	@Override
	public boolean isEmpty() {
		return this._size == 0;
	}



	@Override
	public T removeMin() {
		if (isEmpty())
			return null;
		else {
			Node headNode = this._head;
			this._head = this._head.next();
			this._size--;
			return (T) headNode.element();
		}
	}

	@Override
	public T removeMax() {
		Node previousNode = null;
		Node currentNode = this._head;

		if (isEmpty())
			return null;
		else {
			for (int i = 0; i < this._size - 1; i++) {
				previousNode = currentNode;
				currentNode = currentNode.next();
			}
			previousNode.setNext(currentNode.next());
		}
		this._size--;
		return (T) currentNode.element();
	}

	@Override
	public T removeFrom(int aPosition) {
		if (aPosition < 0 && aPosition >= this._size)
			return null;
		else {
			Node previousNode = null;
			Node currentNode = this._head;
			if (aPosition == 0)
				this._head = this._head.next();
			else {
				for (int i = 0; i < aPosition; i++) {
					previousNode = currentNode;
					currentNode = currentNode.next();
				}
				previousNode.setNext(currentNode.next());
			}
			this._size--;
			return (T) currentNode.element();
		}
	}

	public ListIterator<T> listIterator() {
		return new ListIterator();
	}

	public class ListIterator<T> implements Iterator {
		private Node _nextNode;

		private ListIterator() {
			this._nextNode = _head;
		}

		public boolean hasNext() {
			return (this._nextNode != null);
		}

		public T next() {
			if (this._nextNode == null) {
				return null;
			} else {
				T element = (T) this._nextNode.element();
				this._nextNode = this._nextNode.next();
				return element;
			}
		}
	}

	@Override
	public boolean add(Object anElement) {
		if (this.contains(anElement))
			return false;
		else {
			Node newNode = new Node((T) anElement);
			Node searchNode = this._head;
			Node previousNode = null;

			while (searchNode != null) {
				if (searchNode.compareTo(anElement) > 0) {
					break;
				} else {
					previousNode = searchNode;
					searchNode = searchNode.next();
				}
			}

			if (searchNode == this._head) {
				newNode.setNext(searchNode);
				this._head = newNode;
			} else {
				newNode.setNext(searchNode);
				previousNode.setNext(newNode);
			}
			this._size++;
			return true;

		}
	}


}
