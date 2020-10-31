package queue;

/**
 * Linked list data structure used internal to the Queue class.
 * 
 * @author pbollom
 *
 * @param <T> the type of object the QueueNode holds
 */
public class SingleLinkedListQueueNode<T> {
	private SingleLinkedListQueueNode<T> nextNode;
	/**
	 * Returns a reference to the next node in the linked list.
	 * Could be null if this is the last node in the list.
	 * @return reference to the next node in the list, or null if there is no next node
	 */
	public SingleLinkedListQueueNode<T> getNextNode()
	{
		return nextNode;
	}
	
	/**
	 * Updates this node's pointer to the next node in the linked list
	 * @param nextNode reference to the next node to point to
	 */
	public void setNextNode(SingleLinkedListQueueNode<T> nextNode)
	{
		this.nextNode = nextNode;
	}
	
	private T item;
	/**
	 * Returns a reference to the item this node stores.
	 * @return reference to the item this node stores.
	 */
	public T getItem()
	{
		return item;
	}
	
	/**
	 * Initialize a new node in the linked list.
	 * @param item the item to store in the node
	 * @param nextNode reference to the node immediately preceding this node
	 */
	public SingleLinkedListQueueNode(T item)
	{
		this.item = item;
	}
}
