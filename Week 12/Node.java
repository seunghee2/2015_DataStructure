public class Node<T extends Comparable>implements Comparable {
	private T _element;
	private Node<T> _next;

	public Node() {
		this._element = null;
		this._next = null;
	}

	public Node(T anElement) {
		this._element = anElement;
	}

	public Node(T anElement, Node<T> aNode) {
		this._element = anElement;
		this._next = aNode;
	}

	public T element() {
		return this._element;
	}

	public Node<T> next() {
		return this._next;
	}

	public void setElement(T anElement) {
		this._element = anElement;
	}

	public void setNext(Node<T> aNode) {
		this._next = aNode;
	}
	
	@Override
	public int compareTo(Object arg0){
		return (_element.compareTo(arg0));
	}
	
	
}
