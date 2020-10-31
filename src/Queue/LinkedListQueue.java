package Queue;

/**
 * A generic FIFO queue
 * Implemented as a singly linked list
 * 
 * @author pbollom
 *
 * @param <T> type of object to add to the queue
 */
public class LinkedListQueue<T> implements IQueue<T> {
	
	private SingleLinkedListQueueNode<T> firstNode;
	private SingleLinkedListQueueNode<T> lastNode;
	
	public LinkedListQueue() { }
	
	/* (non-Javadoc)
	 * @see Queue.IQueue#Enqueue(java.lang.Object)
	 */
	public void enqueue(T item)
	{
		if (this.lastNode == null) // we want to enqueue the first item
		{
			SingleLinkedListQueueNode<T> initialNode = new SingleLinkedListQueueNode<>(item);
			this.firstNode = initialNode;
			this.lastNode = initialNode;
		}
		else
		{
			this.lastNode.setNextNode(new SingleLinkedListQueueNode<>(item));
			this.lastNode = this.lastNode.getNextNode();
		}
	}
	
	/* (non-Javadoc)
	 * @see Queue.IQueue#Dequeue()
	 */
	public T dequeue()
	{
		if (this.firstNode == null) { return null; }
		
		T currentFirstItem = this.firstNode.getItem();
		this.firstNode = firstNode.getNextNode();
		if (this.firstNode == null) // we just dequeued the last item
		{
			lastNode = null; // also set the last node to null
		}
		
		return currentFirstItem;
	}
}
