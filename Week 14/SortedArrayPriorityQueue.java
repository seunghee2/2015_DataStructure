public class SortedArrayPriorityQueue<T> implements PriorityQueue<T> {
	private static final int DEFAULT_MAX_SIZE = 50;
	private int _maxSize;
	private int _size;
	private T[] _element;

	public SortedArrayPriorityQueue() {
		this._maxSize = this.DEFAULT_MAX_SIZE;
		this._size = 0;
		this._element = (T[]) new Comparable[this._maxSize];
	}

	public SortedArrayPriorityQueue(int aMaxSize) {
		this._maxSize = aMaxSize;
		this._size = 0;
		this._element = (T[]) new Comparable[this._maxSize];
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
			return (T) this._element[this._size - 1];
	}

	@Override
	public int size() {
		return this._size;
	}

	@Override
	public boolean add(T anElement) {
		if (this.isFull())
			return false;
		else {
			if (this._size == 0)
				this._element[0] = (T) anElement;

			else {
				int i = 0;
				while (this._element[i] != null) {
					if (((Comparable) this._element[i]).compareTo(anElement) > 0)
						break;
					else
						i++;
				}
				for (int j = this._size; j > i; j--)
					this._element[j] = this._element[j - 1];
				this._element[i] = (T) anElement;

			}
			this._size++;
			return true;
		}
	}

	@Override
	public T removeMax() {
		if (isEmpty()) {
			return null;
		} else {
			T removedElement = this._element[this._size - 1];
			this._element[this._size - 1] = null;
			this._size--;
			return removedElement;
		}
	}

	public PriorityQueueIterator<T> priorityQueue() {
		return new PriorityQueueIterator();
	}

	public class PriorityQueueIterator<T> implements Iterator {
		private int _nextPosition;

		private PriorityQueueIterator() {
			this._nextPosition = 0;
		}

		public boolean hasNext() {
			return this._nextPosition < size();
		}

		public T next() {
			if (this._nextPosition == size())
				return null;
			else {
				T nextElement = (T) _element[this._nextPosition];
				this._nextPosition++;
				return nextElement;
			}
		}
	}
}
