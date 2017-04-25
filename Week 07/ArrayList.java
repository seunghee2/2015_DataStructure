public class ArrayList<T> implements Stack<T> {

	private static final int DEFAULT_MAX_STACK_SIZE = 5;
	private int _maxSize;
	private int _top;
	private T[] _elements;

	@SuppressWarnings("unchecked")
	public ArrayList() {
		this._maxSize = DEFAULT_MAX_STACK_SIZE;
		this._top = -1;
		this._elements = (T[]) new Object[this.DEFAULT_MAX_STACK_SIZE];
	}

	public ArrayList(int maxSize) {
		this._maxSize = maxSize;
		this._top = -1;
		this._elements = (T[]) new Object[this.DEFAULT_MAX_STACK_SIZE];
	}

	public boolean isEmpty() {
		return this._top == -1;
	}

	public boolean isFull() {
		return this._top == DEFAULT_MAX_STACK_SIZE-1;
	}

	public int size() {
		return this._top+1;
	}

	@Override
	public boolean push(T anElement) {
		if (this.isFull())
			return false;
		else {
			this._top++;
			this._elements[this._top]=anElement;
			return true;

		}
	}

	@Override
	public T pop() {
		if (this.isEmpty())
			return null;
		else {
			this._top--;
			return this._elements[this._top+1];
		}

	}

	@Override
	public T peek() {
		if (this.isEmpty())
			return null;
		else {
			return this._elements[this._top];
		}
	}

	public void clear() {
		this._top = -1;
		this._elements = null;
	}

	public T elementAt(int order) {
		return this._elements[order];
	}

}
