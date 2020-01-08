package Queue;

public class QueueNode<T> {
	private QueueNode<T> nextNode;
	/**
	 * Returns a reference to the next node in the linked list.
	 * Could be null if this is the last node in the list.
	 * @return reference to the next node in the list, or null if there is no next node
	 */
	public QueueNode<T> GetNextNode()
	{
		return nextNode;
	}
	/**
	 * ***pbollom TODO
	 * @param nextNode
	 */
	public void SetNextNode(QueueNode<T> nextNode)
	{
		this.nextNode = nextNode;
	}
	
	private T item;
	/**
	 * Returns a reference to the item this node stores.
	 * @return reference to the item this node stores.
	 */
	public T GetItem()
	{
		return item;
	}
	
	/**
	 * Initialize a new node in the linked list.
	 * @param item the item to store in the node
	 * @param nextNode reference to the node immediately preceding this node
	 */
	public QueueNode(T item)
	{
		this.item = item;
	}
}
