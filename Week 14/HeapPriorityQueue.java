public class HeapPriorityQueue<T> implements PriorityQueue<T> {
	private static final int DEFAULT_CAPACITY = 100;
	private static final int ROOT = 1;
	private int _maxSize;
	private int _size;
	private T[] _tree;

	public HeapPriorityQueue() {
		this._maxSize = this.DEFAULT_CAPACITY;
		this._size = 0;
		this._tree = (T[]) new Object[this._maxSize + 1];
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
			return (T) this._tree[this.ROOT];
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
			if (!(anElement instanceof Comparable))
				throw new IllegalArgumentException();
			this._size++;
			int i = this._size;
			Comparable<T> x = (Comparable<T>) anElement;
			while ((i > ROOT) && (x.compareTo((T) this._tree[i / 2]) > 0)) {
				this._tree[i] = this._tree[i / 2];
				i /= 2;
			}
			this._tree[i] = anElement;
			return true;
		}
	}

	@Override
	public T removeMax() {
		if (this.isEmpty())
			return null;
		T rootElement = (T) this._tree[ROOT];
		this._size--;
		if (this._size > 0) {
			// 삭제한 후에 적어도 하나의 원소가 남아 있다.
			// 그러므로 마지막 위치 (this._size+1)의 원소를 떼어내어,
			// Root 위치 (1) 로부터 아래쪽으로 새로운 위치를 찾아 내려간다.

			T lastElement = (T) this._tree[this._size + 1];
			int parent = ROOT;
			int biggerChild;
			while ((parent * 2) <= this._size) {
				// child가 존재. left, right 중에서 더 key값을 갖는 child를 biggerChild로 설정
				biggerChild = parent * 2;
				Comparable<T> comparable = (Comparable<T>) this._tree[biggerChild];
				if ((biggerChild < this._size)
						&& (comparable.compareTo(this._tree[biggerChild + 1]) < 0)) {
					biggerChild++;
				}
				Comparable<T> comparable2 = (Comparable<T>) lastElement;
				if (comparable2.compareTo((T) this._tree[biggerChild]) >= 0)
					break;
				this._tree[parent] = this._tree[biggerChild];
				parent = biggerChild;

			}
			this._tree[parent] = lastElement;
		}
		return rootElement;
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
				T nextElement = (T) _tree[this._nextPosition + 1];
				this._nextPosition++;
				return nextElement;
			}
		}
	}
}
