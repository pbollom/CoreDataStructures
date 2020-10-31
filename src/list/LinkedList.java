package list;

public class LinkedList<T> implements IList<T>
{
	
	private int count;
	private SingleLinkedListNode<T> firstNode;
	private SingleLinkedListNode<T> lastNode;
	
	public LinkedList()
	{
		this.count = 0;
	}
	
	public int count()
	{
		return this.count;
	}

	public void add(T item)
	{
		SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(item);
		if (this.count == 0)
		{ // new list
			this.firstNode = newNode;
		}
		else
		{
			this.lastNode.setNextNode(newNode);
		}
		
		this.lastNode = newNode;
		this.count++;
	}

	public void add(T item, int index)
	{
		if (index > this.count)
		{
			throw new IndexOutOfBoundsException();
		}
		
		SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(item);
		
		if (index == 0) // special case of adding it to the start of the list
		{ 
			newNode.setNextNode(this.firstNode);
			this.firstNode = newNode;
			if (this.count == 0) // special case where this is the first item we're adding
			{ 
				this.lastNode = newNode;
			}
		}
		else if (index == this.count) // special case of adding it to the end of the list
		{
			this.lastNode.setNextNode(newNode);
			this.lastNode = newNode;
		}
		else
		{
			// find the nodes that will be prior to and following the new node
			SingleLinkedListNode<T> priorNode = this.firstNode; // index 0
			for (int i = 1; i < index; i++)
			{
				priorNode = priorNode.getNextNode();
			}
			SingleLinkedListNode<T> followingNode = priorNode.getNextNode();
			
			// do the relinking with the new node between the nodes we found
			newNode.setNextNode(followingNode);
			priorNode.setNextNode(newNode);
		}
		
		this.count++;
	}

	public T get(int index)
	{
		if (index >= this.count)
		{
			throw new IndexOutOfBoundsException();
		}
		
		SingleLinkedListNode<T> node = this.firstNode; // index 0
		for (int i = 0; i < index; i++)
		{
			node = node.getNextNode();
		}
		
		return node.getItem();
	}
	
	public T remove(int index)
	{
		if (index >= this.count)
		{
			throw new IndexOutOfBoundsException();
		}
		
		T removedItem = null;
		if (index == 0) //special case of removing first element
		{
			removedItem = this.firstNode.getItem();
			this.firstNode = this.firstNode.getNextNode();
			if (this.firstNode == null) // special case where the first and last node were the same
			{
				this.lastNode = null;
			}
		}
		else
		{
			SingleLinkedListNode<T> priorNode = this.firstNode; // index 0
			for (int i = 1; i < index; i++)
			{
				priorNode = priorNode.getNextNode();
			}
			SingleLinkedListNode<T> nodeToRemove = priorNode.getNextNode();
			removedItem = nodeToRemove.getItem();
			
			// repoint the surrounding nodes
			if (index == this.count - 1) // removing the last item
			{
				priorNode.setNextNode(null);
				this.lastNode = priorNode;
			}
			else
			{
				SingleLinkedListNode<T> followingNode = nodeToRemove.getNextNode();
				priorNode.setNextNode(followingNode);
			}
		}
		
		count--;
		return removedItem;
	}

}
