package queue;

/**
 * A generic FIFO queue
 * Implemented as a singly linked list
 * 
 * @author pbollom
 *
 * @param <T> type of object to add to the queue
 */
public class LinkedListQueue<T> implements IQueue<T> {
	
	int count;
	private SingleLinkedListQueueNode<T> firstNode;
	private SingleLinkedListQueueNode<T> lastNode;
	
	public LinkedListQueue() 
	{
		count = 0;
	}
	
	/* (non-Javadoc)
	 * @see queue.IQueue#enqueue(java.lang.Object)
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
		count++;
	}
	
	/* (non-Javadoc)
	 * @see queue.IQueue#dequeue()
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
		count--;

		return currentFirstItem;
	}

	/* (non-Javadoc)
	 * @see queue.IQueue#count
	 */
	public int count()
	{
		return count;
	}
}
