package UnitTests;

import static org.junit.Assert.*;

import org.junit.*;

import List.IList;

public abstract class ListTestsBase<T extends IList<Object>>
{
	private IList<Object> list;

    protected abstract IList<Object> createInstance();
	
    @Before 
    public void setUp() {
        list = createInstance();
    }
    
	@Test
	public void Count_EmptyList_ReturnsZero() {		
		assertEquals(list.Count(), 0);
	}
	
	@Test
	public void Count_MultipleItemList_ReturnsCorrectCount() {
		int count = 3;
		for (int i = 0; i < count; i++) {
			list.Add(new Object());
		}
		
		assertEquals(list.Count(), count);
	}

	@Test
	public void Get_IndexGreaterThanCount_ThrowsException() {
		try {
			list.Get(0);
			assertTrue(false);
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void Get_IndexZero_ReturnsFirstItem() {
		Object firstObj = new Object();
		list.Add(firstObj);
		Object secondObj = new Object();
		list.Add(secondObj);
		
		assertEquals(list.Get(0), firstObj);
	}
	
	@Test
	public void Get_InBoundsIndex_ReturnsItemAtIndexAndDoesNotRemoveIt() {
		Object firstObj = new Object();
		list.Add(firstObj);
		Object secondObj = new Object();
		list.Add(secondObj);
		Object thirdObj = new Object();
		list.Add(thirdObj);
		
		assertEquals(list.Get(1), secondObj);
		assertEquals(list.Count(), 3);
	}
	
	@Test
	public void Remove_IndexGreaterThanEqualToCount_ThrowsException() {	
		try 
		{
			list.Remove(0);
			assertTrue(false);
		} 
		catch (IndexOutOfBoundsException e) 
		{
			assertTrue(true);
		}
		
		try 
		{
			list.Remove(1);
			assertTrue(false);
		} 
		catch (IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void Remove_IndexZero_ReturnsAndRemovesFirstItem() {
		Object firstObj = new Object();
		list.Add(firstObj);
		Object secondObj = new Object();
		list.Add(secondObj);
		Object thirdObj = new Object();
		list.Add(thirdObj);
		
		assertEquals(list.Remove(0), firstObj);
		assertEquals(list.Count(), 2);
		assertEquals(list.Get(0), secondObj);
	}
	
	@Test
	public void Remove_LastItem_ReturnsAndRemovesLastItem() {
		Object firstObj = new Object();
		list.Add(firstObj);
		Object secondObj = new Object();
		list.Add(secondObj);
		Object thirdObj = new Object();
		list.Add(thirdObj);
		
		assertEquals(list.Remove(2), thirdObj);
		assertEquals(list.Count(), 2);
		
		Object fourthObj = new Object();
		list.Add(fourthObj);
		
		assertEquals(list.Get(2), fourthObj);
		assertEquals(list.Count(), 3);
	}
	
	@Test
	public void Remove_InteriorItem_ReturnsAndRemoveItem() {
		Object firstObj = new Object();
		list.Add(firstObj);
		Object secondObj = new Object();
		list.Add(secondObj);
		Object thirdObj = new Object();
		list.Add(thirdObj);
		
		assertEquals(list.Remove(1), secondObj);
		assertEquals(list.Count(), 2);
		assertEquals(list.Get(0), firstObj);
		assertEquals(list.Get(1), thirdObj);
	}

	@Test
	public void Remove_RemoveAllItems_AddingStillWorks() {
		Object firstObj = new Object();
		list.Add(firstObj);
		
		assertEquals(list.Remove(0), firstObj);
		assertEquals(list.Count(), 0);
		
		Object secondObj = new Object();
		list.Add(secondObj);
		
		assertEquals(list.Count(), 1);
		assertEquals(list.Get(0), secondObj);
	}
	
	@Test
	public void AddAtIndex_IndexGreaterThanCount_ThrowsException()
	{
		Object obj = new Object();
		
		try 
		{
			list.Add(obj, 1);
			assertTrue(false);
		} 
		catch (IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void AddAtIndex_IndexZeroInEmptyList_AddsAsFirstElement()
	{
		Object obj = new Object();
		
		list.Add(obj, 0);
		
		assertEquals(list.Count(), 1);
		assertEquals(list.Get(0), obj);
	}
	
	@Test
	public void AddAtIndex_IndexZeroInPopulatedList_AddsAsFirstElementAndShifts()
	{
		Object firstObj = new Object();
		list.Add(firstObj);
		
		Object secondObj = new Object();
		list.Add(secondObj, 0);
		
		assertEquals(list.Count(), 2);
		assertEquals(list.Get(0), secondObj);
		assertEquals(list.Get(1), firstObj);
	}
	
	@Test
	public void AddAtIndex_IndexEqualToCount_AddsAsLastElement()
	{
		Object firstObj = new Object();
		list.Add(firstObj);
		
		Object secondObj = new Object();
		list.Add(secondObj, 1);
		
		assertEquals(list.Count(), 2);
		assertEquals(list.Get(0), firstObj);
		assertEquals(list.Get(1), secondObj);
	}
	
	@Test
	public void AddAtIndex_InteriorIndex_AddsAsInteriorElement()
	{
		Object firstObj = new Object();
		list.Add(firstObj);
		Object secondObj = new Object();
		list.Add(secondObj);
		Object thirdObj = new Object();
		list.Add(thirdObj);
		
		Object fourthObj = new Object();
		list.Add(fourthObj, 2);
		
		assertEquals(list.Count(), 4);
		assertEquals(list.Get(0), firstObj);
		assertEquals(list.Get(1), secondObj);
		assertEquals(list.Get(2), fourthObj);
		assertEquals(list.Get(3), thirdObj);
	}
}
