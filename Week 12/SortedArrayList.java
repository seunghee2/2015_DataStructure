public class SortedArrayList<T extends Comparable> implements List {
	private static final int DEFAULT_MAX_SIZE = 20;
	private int _maxSize;
	private int _size;
	private T[] _element;

	public SortedArrayList() {
		this._maxSize = this.DEFAULT_MAX_SIZE;
		this._size = 0;
		this._element = (T[]) new Comparable[this._maxSize];
	}

	public SortedArrayList(int aMaxSize) {
		this._maxSize = aMaxSize;
		this._size = 0;
		this._element = (T[]) new Comparable[this._maxSize];

	}

	@Override
	public void clear() {
		this._size = 0;
		this._element = (T[]) new Comparable[this._maxSize];

	}

	@Override
	public int size() {
		return this._size;
	}

	@Override
	public boolean contains(Object anElement) {
		boolean found = false;
		for (int i = 0; i < this._size; i++)
			if (this._element[i].compareTo(anElement) == 0)
				found = true;

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
	public boolean add(Object anElement) {
		if (!this.contains(anElement)) {
			if (!isFull()) {
				if (this._size == 0) {
					this._element[0] = (T) anElement;
				} else {
					int i = 0;
					while (this._element[i] != null) {
						if (this._element[i].compareTo(anElement) > 0)
							break;
						else
							i++;
					}
					for (int j = this._size; j > i; j--)
						this._element[j] = this._element[j - 1];
					this._element[i] = (T) anElement;

					this._size++;
					return true;
				}
			}
		}
		return false;

	}

	@Override
	public Object removeMin() {
		if (this.isEmpty())
			return null;
		else {
			T removedElement = this._element[0];
			for (int i = 0; i < this._size; i++)
				this._element[i] = this._element[i + 1];
			this._size--;
			return removedElement;
		}
	}

	@Override
	public Object removeMax() {
		if (isEmpty())
			return null;
		else {
			T removedElement = this._element[this._size - 1];
			this._element[this._size - 1] = null;
			this._size--;
			return removedElement;
		}
	}

	@Override
	public Object removeFrom(int aPosition) {
		if (isEmpty())
			return null;
		else {
			T removedElement = this._element[aPosition];
			for (int i = aPosition; i < this._size; i++)
				this._element[i] = this._element[i + 1];
			this._element[this._size] = null;
			this._size--;
			return removedElement;
		}
	}

	public ListIterator<T> listIterator() {
		return new ListIterator();
	}

	public class ListIterator<T> implements Iterator {
		private int _nextPosition;

		private ListIterator() {
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
