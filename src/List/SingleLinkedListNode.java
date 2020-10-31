package List;

public class SingleLinkedListNode<T> {

	private SingleLinkedListNode<T> nextNode;
	public SingleLinkedListNode<T> getNextNode()
	{
		return this.nextNode;
	}
	public void setNextNode(SingleLinkedListNode<T> nextNode)
	{
		this.nextNode = nextNode;
	}
	
	private T item;
	public T getItem()
	{
		return this.item;
	}
	
	public SingleLinkedListNode(T item)
	{
		this.item = item;
	}
}
