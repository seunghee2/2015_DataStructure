public class UnsortedArrayBag {

	private static final int DEFAULT_MAX_SIZE = 100;
	private long _maxSize;
	private int _size;
	private Coin _elements[];

	public void UnsortedArraryBag() {
		this._maxSize = DEFAULT_MAX_SIZE;
		this._elements = new Coin[(int) this._maxSize];
		this._size = 0;
	}

	public UnsortedArrayBag(long givenMaxSize) {
		this._maxSize = givenMaxSize;
		this._elements = new Coin[(int) this._maxSize];
		this._size = 0;
	}

	public int size() {

		return _size;
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

	public boolean doesContain(Coin anElement) {
		boolean found = false;
		for (int i = 0; i < this._size && found == true; i++) {
			if (this._elements[i].equals(anElement))
				found = true;
		}
		return found;
	}

	public int frequencyOf(Coin anElement) {
		int frequencyCount = 0;
		for (int i = 0; i < this._size; i++) {
			if (this._elements[i].equals(anElement))
				frequencyCount++;
		}
		return frequencyCount;

	}

	public int sumElementValue() {
		int sumValue = 0;
		for (int i = 0; i < this._size; i++) {
			sumValue += this._elements[i].value();
		}
		return sumValue;

	}

	public boolean add(Coin anElement) {
		if (this.isFull() == true)
			return false;
		else {
			this._elements[this._size] = anElement;
			this._size++;
			return true;
		}
	}

	public boolean remove(Coin anElement) {
		if (this.isEmpty() == true)
			return false;
		else {
			for (int i = 0; i < this._size; i++) {
				if (this._elements[i].equals(anElement)) {
					this._elements[i] = null;
					for (int j = i; j < this._size - 1; j++) {
						this._elements[j] = this._elements[j + 1];
					}
					this._size--;

				}
			}
			return true;
		}
	}

	public void clear() {
		this._size = 0;
	}

	public long maxCoinValues() {
		long maxValue = 0;
		for (int i = 0; i < this._size; i++) {
			if (maxValue < this._elements[i].value())
				maxValue = this._elements[i].value();
		}
		return maxValue;
	}
}
