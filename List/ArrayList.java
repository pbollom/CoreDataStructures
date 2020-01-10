package List;

public class ArrayList<T> implements IList<T>
{
	private int count;
	private T[] items;
	
	@SuppressWarnings("unchecked")
	public ArrayList()
	{
		this.count = 0;
		this.items = (T[])(new Object[2]); // pick something small for testing, but should be optimized
	}
	
	@Override
	public int Count()
	{
		return this.count;
	}

	@Override
	public void Add(T item)
	{
		this.ResizeIfNecessaryWhenAdding();
		this.items[this.count] = item;
		this.count++;
	}

	@Override
	public void Add(T item, int index)
	{
		if (index > this.count)
		{
			throw new IndexOutOfBoundsException();
		}
		
		this.ResizeIfNecessaryWhenAdding();
		for (int i = this.count - 1; i >= index; i--)
		{
			this.items[i+1] = this.items[i];
		}
		this.items[index] = item;
		this.count++;
	}

	@Override
	public T Get(int index)
	{
		if (index >= this.count)
		{
			throw new IndexOutOfBoundsException();
		}
		
		return this.items[index];
	}

	@Override
	public T Remove(int index)
	{
		if (index >= this.count)
		{
			throw new IndexOutOfBoundsException();
		}
		
		T itemAtIndex = this.items[index];
		for (int i = index + 1; i < this.count; i++)
		{
			this.items[i-1] = this.items[i];
		}
		count--;
		return itemAtIndex;
	}
	
	@SuppressWarnings("unchecked")
	private void ResizeIfNecessaryWhenAdding()
	{
		if (this.count == this.items.length)
		{
			// just do the naive implementation for now. can be optimized
			T[] newItems = (T[])(new Object[this.items.length * 2 + 1]); // safe to do because we're only doing this internally
			for (int i = 0; i < this.count; i++)
			{
				newItems[i] = this.items[i];
			}
			this.items = newItems; 
		}
	}
}
