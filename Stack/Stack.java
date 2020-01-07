package Stack;

/**
 * A generic LIFO stack.
 * Implemented as a singly linked list.
 * 
 * @author pbollom
 *
 * @param <T> the type of object to add to the stack
 */
public class Stack<T> {
	
	private StackNode<T> topNode;
	
	/**
	 * Initializes a new instance of the stack class.
	 */
	public Stack() { }
	
	/**
	 * Adds an item to the top of the stack
	 * @param item the item to add to the top of the stack.
	 */
	public void Push(T item)
	{
		//topNode could be null if this is the first item we're adding
		topNode = new StackNode<T>(item, topNode);
	}
	
	/**
	 * Removes the top item from the stack and returns it.
	 * @return the item that was formerly on the top of the stack
	 */
	public T Pop()
	{
		if (this.topNode == null) { return null; }
		
		T topItem = this.topNode.getItem();
		topNode = this.topNode.getPriorNode();
		
		return topItem;
	}
	
	/**
	 * Returns a reference to the top item in the stack without removing it.
	 * @return the item currently on the top of the stack
	 */
	public T Peek()
	{
		if (this.topNode == null) { return null; }
		
		return this.topNode.getItem();
	}
}
