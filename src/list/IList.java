package list;

public interface IList<T> {
	
	/**
	 * @return
	 */
	int count();
	
	/**
	 * @param item
	 */
	void add(T item);
	
	/**
	 * @param item
	 * @param index
	 */
	void add(T item, int index);
	
	/**
	 * @param index
	 */
	T get(int index);
	
	/**
	 * @param index
	 * @return
	 */
	T remove(int index);
}
