public interface PriorityQueue<T> {
	public boolean isEmpty();

	public boolean isFull();

	public T max();

	public int size();

	public boolean add(T anElement);

	public T removeMax();

}
