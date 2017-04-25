public class ArraySet {
	private static final int DEFAULT_MAX_SIZE = 100;
	private int _maxSize;
	private int _size;
	private Star _elements[];

	public ArraySet() {
		this._maxSize = DEFAULT_MAX_SIZE;
		this._elements = new Star[this._maxSize];
		this._size = 0;
	}

	public ArraySet(int aMaxSize) {
		this._maxSize = aMaxSize;
		this._elements = new Star[this._maxSize];
		this._size = 0;
	}

	public int size() {
		return this._size;
	}

	public boolean isEmpty() {
		if (this._size == 0)
			return true;
		else
			return false;
	}

	public boolean isFull() {
		if (this._size == this._maxSize)
			return true;
		else
			return false;
	}

	public boolean doesContain(Star anElement) {
		boolean found = false;
		for (int i = 0; i < this._size && !found; i++) {
			if (this._elements[i].equals(anElement))
				found = true;
		}
		return found;
	}

	public boolean add(Star anElement) {
		if (this.isFull() == true)
			return false;
		else if (!this.doesContain(anElement)) {
			this._elements[this._size] = anElement;
			this._size++;
			return true;
		}
		return false;
	}

	public Star remove(Star aStar) {
		Star removeStar = null;
		if (this.isEmpty() == true)
			return null;
		else {
			for (int i = 0; i < this._size; i++) {
				if (this._elements[i].equals(aStar)) {
					removeStar = this._elements[i];
					for (int j = i; j < this._size - 1; j++) {
						this._elements[j] = this._elements[j + 1];
					}
				}
			}
			this._elements[this._size - 1] = null;
			this._size--;
			return removeStar;
		}
	}

	public Star removeAny() {
		Star removeAnyStar = null;
		if (this.isEmpty())
			return null;
		else {
			removeAnyStar = this._elements[this._size - 1];
			this._elements[this._size - 1] = null;
			this._size--;
			return removeAnyStar;
		}
	}

	public void clear() {
		for (int i = 0; i < this._size; i++) {
			this._elements[i] = null;
		}
		this._size = 0;
	}
}
