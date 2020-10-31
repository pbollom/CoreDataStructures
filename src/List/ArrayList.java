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
	public int count()
	{
		return this.count;
	}

	@Override
	public void add(T item)
	{
		this.resizeIfNecessaryWhenAdding();
		this.items[this.count] = item;
		this.count++;
	}

	@Override
	public void add(T item, int index)
	{
		if (index > this.count)
		{
			throw new IndexOutOfBoundsException();
		}
		
		this.resizeIfNecessaryWhenAdding();
		for (int i = this.count - 1; i >= index; i--)
		{
			this.items[i+1] = this.items[i];
		}
		this.items[index] = item;
		this.count++;
	}

	@Override
	public T get(int index)
	{
		if (index >= this.count)
		{
			throw new IndexOutOfBoundsException();
		}
		
		return this.items[index];
	}

	@Override
	public T remove(int index)
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
	private void resizeIfNecessaryWhenAdding()
	{
		if (this.count == this.items.length)
		{
			// just do the naive implementation for now. can be optimized
			T[] newItems = (T[])(new Object[this.items.length * 2 + 1]); // safe to do because we're only doing this internally
			System.arraycopy(this.items, 0, newItems, 0, this.count);
			this.items = newItems; 
		}
	}
}
