package stack;

public interface IStack<T> {
	
	/**
	 * Adds an item to the top of the stack
	 * @param item the item to add to the top of the stack.
	 */
	void push(T item);
	
	/**
	 * Removes the top item from the stack and returns it.
	 * @return the item that was formerly on the top of the stack
	 */
	T pop();
	
	/**
	 * Returns a reference to the top item in the stack without removing it.
	 * @return the item currently on the top of the stack
	 */
	T peek();

	/**
	 * Returns the count of items in the stack
	 * @return the count of items in the stack
	 */
	int count();
}
