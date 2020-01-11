package List;

public class SingleLinkedListNode<T> {

	private SingleLinkedListNode<T> nextNode;
	public SingleLinkedListNode<T> GetNextNode()
	{
		return this.nextNode;
	}
	public void SetNextNode(SingleLinkedListNode<T> nextNode)
	{
		this.nextNode = nextNode;
	}
	
	private T item;
	public T GetItem()
	{
		return this.item;
	}
	
	public SingleLinkedListNode(T item)
	{
		this.item = item;
	}
}
