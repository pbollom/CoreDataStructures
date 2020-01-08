package Stack;

public interface IStack<T> {
	
	/**
	 * Adds an item to the top of the stack
	 * @param item the item to add to the top of the stack.
	 */
	void Push(T item);
	
	/**
	 * Removes the top item from the stack and returns it.
	 * @return the item that was formerly on the top of the stack
	 */
	T Pop();
	
	/**
	 * Returns a reference to the top item in the stack without removing it.
	 * @return the item currently on the top of the stack
	 */
	T Peek();
}
