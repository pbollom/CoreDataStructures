package Queue;

public interface IQueue<T> {
	
	/**
	 * Adds an item to the end of the queue
	 * @param item the object to add to the end of the queue
	 */
	void enqueue(T item);
	
	/**
	 * Returns the first (added) item in the queue
	 * @return the object currently at the front of the queue
	 */
	T dequeue();
}
