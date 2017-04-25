public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T> {
	private static final int DEFAULT_MAX_SIZE = 50;
	private int _maxSize;
	private int _size;
	private Node _head;

	public SortedLinkedPriorityQueue() {
		this._head = null;
		this._size = 0;
		this._maxSize = DEFAULT_MAX_SIZE;
	}

	public SortedLinkedPriorityQueue(int aMaxSize) {
		this._head = null;
		this._size = 0;
		this._maxSize = aMaxSize;
	}

	@Override
	public boolean isEmpty() {
		return this._size == 0;
	}

	@Override
	public boolean isFull() {
		return this._size == this._maxSize;
	}

	@Override
	public T max() {
		if (this.isEmpty())
			return null;
		else
			return (T) this._head.element();
	}

	@Override
	public int size() {
		return this._size;
	}

	@Override
	public boolean add(T anElement) {
		if (this.isFull()) {
			return false;
		} else {
			Node searchNode = this._head;
			Node previousNode = null;
			Node newNode = new Node((Comparable) anElement);

			while (searchNode != null) {
				if (searchNode.compareTo(anElement) < 0) {
					break;
				} else {
					previousNode = searchNode;
					searchNode = searchNode.next();
				}
			}

			if (searchNode == this._head) {
				newNode.setNext(this._head);
				this._head = newNode;
			} else {
				newNode.setNext(searchNode);
				previousNode.setNext(newNode);
			}
			this._size++;
			return true;
		}
	}

	@Override
	public T removeMax() {
		if (this.isEmpty())
			return null;
		else {
			Node removedNode = this._head;
			this._head = this._head.next();
			this._size--;
			return (T) removedNode.element();
		}
	}
	public PriorityQueueIterator<T> priorityQueue() {
		return new PriorityQueueIterator();
	}

	public class PriorityQueueIterator<T> implements Iterator {
		private Node _nextPosition;

		private PriorityQueueIterator() {
			this._nextPosition = _head;
		}

		public boolean hasNext() {
			return (this._nextPosition != null);
		}

		public T next() {
			if (this._nextPosition == null) {
				return null;
			} else {
				T t = (T) _nextPosition.element();
				this._nextPosition = _nextPosition.next();
				return t;
			}
		}
	}
}
