package List;

public class LinkedList<T> implements IList<T>
{
	
	private int count;
	private SingleLinkedListNode<T> firstNode;
	private SingleLinkedListNode<T> lastNode;
	
	public LinkedList()
	{
		this.count = 0;
	}
	
	public int Count()
	{
		return this.count;
	}

	public void Add(T item)
	{
		SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(item);
		if (this.count == 0)
		{ // new list
			this.firstNode = newNode;
		}
		else
		{
			this.lastNode.SetNextNode(newNode);
		}
		
		this.lastNode = newNode;
		this.count++;
	}

	public void Add(T item, int index)
	{
		if (index > this.count)
		{
			throw new IndexOutOfBoundsException();
		}
		
		SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(item);
		
		if (index == 0) // special case of adding it to the start of the list
		{ 
			newNode.SetNextNode(this.firstNode);
			this.firstNode = newNode;
			if (this.count == 0) // special case where this is the first item we're adding
			{ 
				this.lastNode = newNode;
			}
		}
		else if (index == this.count) // special case of adding it to the end of the list
		{
			this.lastNode.SetNextNode(newNode);
			this.lastNode = newNode;
		}
		else
		{
			// find the nodes that will be prior to and following the new node
			SingleLinkedListNode<T> priorNode = this.firstNode; // index 0
			for (int i = 1; i < index; i++)
			{
				priorNode = priorNode.GetNextNode();
			}
			SingleLinkedListNode<T> followingNode = priorNode.GetNextNode();
			
			// do the relinking with the new node between the nodes we found
			newNode.SetNextNode(followingNode);
			priorNode.SetNextNode(newNode);
		}
		
		this.count++;
	}

	public T Get(int index)
	{
		if (index >= this.count)
		{
			throw new IndexOutOfBoundsException();
		}
		
		SingleLinkedListNode<T> node = this.firstNode; // index 0
		for (int i = 0; i < index; i++)
		{
			node = node.GetNextNode();
		}
		
		return node.GetItem();
	}
	
	public T Remove(int index)
	{
		if (index >= this.count)
		{
			throw new IndexOutOfBoundsException();
		}
		
		T removedItem = null;
		if (index == 0) //special case of removing first element
		{
			removedItem = this.firstNode.GetItem();
			this.firstNode = this.firstNode.GetNextNode();
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
				priorNode = priorNode.GetNextNode();
			}
			SingleLinkedListNode<T> nodeToRemove = priorNode.GetNextNode();
			removedItem = nodeToRemove.GetItem();
			
			// repoint the surrounding nodes
			if (index == this.count - 1) // removing the last item
			{
				priorNode.SetNextNode(null);
				this.lastNode = priorNode;
			}
			else
			{
				SingleLinkedListNode<T> followingNode = nodeToRemove.GetNextNode();
				priorNode.SetNextNode(followingNode);
			}
		}
		
		count--;
		return removedItem;
	}

}
