package Queue;

/**
 * A generic FIFO queue
 * Implemented as a singly linked list
 * 
 * @author pbollom
 *
 * @param <T> type of object to add to the queue
 */
public class Queue<T> implements IQueue<T> {
	
	private QueueNode<T> firstNode;
	private QueueNode<T> lastNode;
	
	public Queue() { }
	
	/* (non-Javadoc)
	 * @see Queue.IQueue#Enqueue(java.lang.Object)
	 */
	public void Enqueue(T item)
	{
		if (this.lastNode == null) // we want to enqueue the first item
		{
			QueueNode<T> initialNode = new QueueNode<T>(item);
			this.firstNode = initialNode;
			this.lastNode = initialNode;
		}
		else
		{
			this.lastNode.SetNextNode(new QueueNode<T>(item));
			this.lastNode = this.lastNode.GetNextNode();
		}
	}
	
	/* (non-Javadoc)
	 * @see Queue.IQueue#Dequeue()
	 */
	public T Dequeue()
	{
		if (this.firstNode == null) { return null; }
		
		T currentFirstItem = this.firstNode.GetItem();
		this.firstNode = firstNode.GetNextNode();
		if (this.firstNode == null) // we just dequeued the last item
		{
			lastNode = null; // also set the last node to null
		}
		
		return currentFirstItem;
	}
}
