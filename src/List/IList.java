package List;

public interface IList<T> {
	
	/**
	 * @return
	 */
	int Count();
	
	/**
	 * @param item
	 */
	void Add(T item);
	
	/**
	 * @param item
	 * @param index
	 */
	void Add(T item, int index);
	
	/**
	 * @param index
	 */
	T Get(int index);
	
	/**
	 * @param index
	 * @return
	 */
	T Remove(int index);
}
