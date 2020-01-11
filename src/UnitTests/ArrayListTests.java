package UnitTests;

import List.ArrayList;

public class ArrayListTests extends ListTestsBase<ArrayList<Object>> {

	@Override
	protected ArrayList<Object> createInstance()
	{
		return new ArrayList<Object>();
	}
}