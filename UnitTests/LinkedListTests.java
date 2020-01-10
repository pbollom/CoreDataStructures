package UnitTests;

import List.LinkedList;

public class LinkedListTests extends ListTestsBase<LinkedList<Object>> {

	@Override
	protected LinkedList<Object> createInstance()
	{
		return new LinkedList<Object>();
	}
}
