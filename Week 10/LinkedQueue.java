public class LinkedQueue<T> {
	private int _size;
	private Node<T> _rear;
	private Node<T> _front;

	public LinkedQueue() {
		this._rear = null;
		this._size = 0;
		this._front = null;
	}

	public int size() {
		return this._size;
	}

	public boolean isEmpty() {
		return this._front == this._rear && this._front == null;

	}

	public int maxsize() {
		return this._size;
	}

	public T frontElement() {
		if (isEmpty())
			return null;
		else
			return this._front.element();
	}

	public boolean enQueue(T anElement) {
		if (isFull())
			return false;
		else {
			Node<T> newNode = new Node<T>(anElement, null);
			if (isEmpty()) {
				this._front = newNode;
			} else {
				this._rear.setNext(newNode);
			}
			this._rear = newNode;
			this._size++;
			return true;
		}

	}

	public boolean isFull() {
		return false;
	}

	public T deQueue() {
		T frontElement = null;
		if (!isEmpty()) {
			frontElement = this._front.element();
			this._front = this._front.next();
			if (this._front == null)
				this._rear = null;
			this._size--;
		}
		return frontElement;
	}

	public void clear() {
		this._front = null;
		this._rear = null;
		this._size = 0;
	}

	public T elementAt(int givenPosition) {
		Node frontElement = this._front;

		if (givenPosition == 0)
			return this._front.element();
		else {
			for (int i = 0; i < givenPosition; i++) {
				if (frontElement == this._rear)
					break;
				else
					frontElement = frontElement.next();
			}
			return (T) frontElement.element();
		}
	}

}
