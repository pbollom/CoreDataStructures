package Stack;

/**
 * Linked list data structure used internal to the Stack class.
 * 
 * @author pbollom
 *
 * @param <T> the type of object the StackNode holds
 */
public class SingleLinkedListStackNode<T> {
	private SingleLinkedListStackNode<T> priorNode;
	/**
	 * Returns a reference to the prior node in the linked list.
	 * Could be null if this is the last node in the list.
	 * @return reference to the prior node in the list, or null if there is no prior node
	 */
	public SingleLinkedListStackNode<T> GetPriorNode()
	{
		return priorNode;
	}
	
	private T item;
	/**
	 * Returns a reference to the item this node stores.
	 * @return reference to the item this node stores.
	 */
	public T GetItem()
	{
		return this.item;
	}
	
	/**
	 * Initialize a new node in the linked list.
	 * @param item the item to store in the node
	 * @param priorNode reference to the node immediately preceding this node
	 */
	public SingleLinkedListStackNode(T item, SingleLinkedListStackNode<T> priorNode)
	{
		this.item = item;
		this.priorNode = priorNode;
	}
}
