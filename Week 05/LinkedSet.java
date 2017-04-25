public class LinkedSet {
	private static final int DEFAULT_MAX_SIZE = 100;
	private int _maxSize;
	private int _size;
	private Node _head;

	public LinkedSet() {
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
		return (this._size == this._maxSize);
	}

	public boolean doesContain(Star anElement) {
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

	public boolean add(Star anElement) {
		if (this.isFull())
			return false;
		else if (!this.doesContain(anElement)) {
			Node newNode = new Node();
			newNode.setElement(anElement);
			newNode.setNext(this._head);
			this._head = newNode;
			this._size++;
			return true;
		}
		return false;

	}

	public Star remove(Star anElement) {
		if (this.isEmpty()) {
			return null;
		} else {
			Node previousNode = null;
			Node currentNode = this._head;
			boolean found = false;

			while (currentNode != null && !found) {
				if (currentNode.element().equals(anElement)) {
					found = true;
				} else {
					previousNode = currentNode;
					currentNode = currentNode.next();
				}
			}
			if (!found) {
				return null;
			} else {
				if (currentNode == this._head) {
					this._head = this._head.next();
				} else {
					previousNode.setNext(currentNode.next());
				}
				this._size--;
				return currentNode.element();
			}
		}
	}

	public Star removeAny() {
		if (this.isEmpty())
			return null;
		else {
			Star removedElement = this._head.element();
			this._head = this._head.next();
			this._size--;
			return removedElement;
		}
	}

	public void clear() {
		this._size = 0;
		this._head = null;
	}
}
