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
	
	private int count;
	private SingleLinkedListStackNode<T> topNode;
	
	/**
	 * Initializes a new instance of the stack class.
	 */
	public LinkedListStack()
	{
		count = 0;
	}
	
	/* (non-Javadoc)
	 * @see stack.IStack#push(java.lang.Object)
	 */
	public void push(T item)
	{
		//topNode could be null if this is the first item we're adding
		topNode = new SingleLinkedListStackNode<>(item, topNode);
		count++;
	}
	
	/* (non-Javadoc)
	 * @see stack.IStack#pop()
	 */
	public T pop()
	{
		if (this.topNode == null) { return null; }
		
		T topItem = this.topNode.getItem();
		topNode = this.topNode.getPriorNode();
		count--;
		
		return topItem;
	}
	
	/* (non-Javadoc)
	 * @see stack.IStack#peek()
	 */
	public T peek()
	{
		if (this.topNode == null) { return null; }
		
		return this.topNode.getItem();
	}

	/* (non-Javadoc)
	 * @see stack.IStack#count()
	 */
	public int count()
	{
		return count;
	}
}
