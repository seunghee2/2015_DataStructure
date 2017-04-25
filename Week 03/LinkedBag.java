public class LinkedBag {
	private int _size;
	private Node _head; // LinkedBag의 원소들을 담을 Linked Chain

	public LinkedBag() {
		this._size = 0;
		this._head = null;
	}

	public int size() {
		return this._size;
	}

	public boolean isEmpty() {
		return (this._size == 0);
	}

	public boolean isFull() {
		return false;
	}

	public boolean doesContain(Coin anElement) {
		boolean found = false;

		Node searchNode = this._head;
		while (searchNode != null && !found) {
			if (searchNode.element().equals(anElement))
				found = true;
			else
				searchNode = searchNode.next();
		}
		return found;
	}

	public int frequencyOf(Coin anElement) {
		int frequencyCount = 0;
		Node currentNode = this._head;
		while (currentNode != null) {
			if (currentNode.element().equals(anElement))
				frequencyCount++;
			currentNode = currentNode.next();
		}
		return frequencyCount;
	}

	public void clear() {
		this._size = 0;
		this._head = null;
	}

	public int maxElementValue() {
		int maxValue = 0;
		Node searchNode = this._head;
		for (int i = 0; i < this._size; i++) {
			if (maxValue < searchNode.element().value())
				maxValue = searchNode.element().value();
			searchNode = searchNode.next();
		}
		return maxValue;
	}

	public int sumElementValues() {
		int sumValues = 0;
		Node searchNode = this._head;
		for (int i = 0; i < this._size; i++) {
			sumValues += searchNode.element().value();
			searchNode = searchNode.next();
		}
		return sumValues;

	}

	public Coin any() {
		if (this.isEmpty())
			return null;
		else
			return this._head.element();
	}

	public boolean add(Coin anElement) {
		if (this.isFull())
			return false;
		else {
			Node newNode = new Node();
			newNode.setElement(anElement);
			newNode.setNext(this._head);
			this._head = newNode;
			this._size++;
			return true;
		}

	}

	public boolean remove(Coin anElement) {
		if (this.isEmpty())
			return false;
		else {
			Node previousNode = null;
			Node currentNode = _head;
			boolean found = false;

			while (currentNode != null && !found) {
				if (currentNode.element().equals(anElement)) {
					found = true;
				} else {
					previousNode = currentNode;
					currentNode = currentNode.next();
				}
			}

			if (!found)
				return false;
			else {
				if (currentNode == this._head)
					this._head = this._head.next();
				else
					previousNode.setNext(currentNode.next());
				this._size--;
				return true;
			}
		}
	}

	public Coin removeAny() {
		if (this.isEmpty())
			return null;
		else {
			Coin removedElement = this._head.element();
			this._head = this._head.next();
			this._size--;
			return removedElement;
		}
	}
}
