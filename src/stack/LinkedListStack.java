package stack;

/**
 * A generic LIFO stack.
 * Implemented as a singly linked list.
 * 
 * @author pbollom
 *
 * @param <T> the type of object to add to the stack
 */
public class LinkedListStack<T> implements IStack<T> {
	
	private SingleLinkedListStackNode<T> topNode;
	
	/**
	 * Initializes a new instance of the stack class.
	 */
	public LinkedListStack() { }
	
	/* (non-Javadoc)
	 * @see Stack.IStack#Push(java.lang.Object)
	 */
	public void push(T item)
	{
		//topNode could be null if this is the first item we're adding
		topNode = new SingleLinkedListStackNode<>(item, topNode);
	}
	
	/* (non-Javadoc)
	 * @see Stack.IStack#Pop()
	 */
	public T pop()
	{
		if (this.topNode == null) { return null; }
		
		T topItem = this.topNode.getItem();
		topNode = this.topNode.getPriorNode();
		
		return topItem;
	}
	
	/* (non-Javadoc)
	 * @see Stack.IStack#Peek()
	 */
	public T peek()
	{
		if (this.topNode == null) { return null; }
		
		return this.topNode.getItem();
	}
}