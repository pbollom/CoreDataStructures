package test;

import static org.junit.Assert.*;

import list.IList;

public abstract class ListTestsBase
{
	protected IList<Object> list;
	
	protected abstract void setUp();

	protected void Count_EmptyList_ReturnsZero_Base() {		
		assertEquals(list.count(), 0);
	}
	
	protected void Count_MultipleItemList_ReturnsCorrectCount_Base() {
		int count = 3;
		for (int i = 0; i < count; i++) {
			list.add(new Object());
		}
		
		assertEquals(list.count(), count);
	}

	protected void Get_IndexGreaterThanCount_ThrowsException_Base() {
		try {
			list.get(0);
			assertTrue(false);
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	protected void Get_IndexZero_ReturnsFirstItem_Base() {
		Object firstObj = new Object();
		list.add(firstObj);
		Object secondObj = new Object();
		list.add(secondObj);
		
		assertEquals(list.get(0), firstObj);
	}
	
	protected void Get_InBoundsIndex_ReturnsItemAtIndexAndDoesNotRemoveIt_Base() {
		Object firstObj = new Object();
		list.add(firstObj);
		Object secondObj = new Object();
		list.add(secondObj);
		Object thirdObj = new Object();
		list.add(thirdObj);
		
		assertEquals(list.get(1), secondObj);
		assertEquals(list.count(), 3);
	}
	
	protected void Remove_IndexGreaterThanEqualToCount_ThrowsException_Base() {	
		try 
		{
			list.remove(0);
			assertTrue(false);
		} 
		catch (IndexOutOfBoundsException e) 
		{
			assertTrue(true);
		}
		
		try 
		{
			list.remove(1);
			assertTrue(false);
		} 
		catch (IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
	}
	
	protected void Remove_IndexZero_ReturnsAndRemovesFirstItem_Base() {
		Object firstObj = new Object();
		list.add(firstObj);
		Object secondObj = new Object();
		list.add(secondObj);
		Object thirdObj = new Object();
		list.add(thirdObj);
		
		assertEquals(list.remove(0), firstObj);
		assertEquals(list.count(), 2);
		assertEquals(list.get(0), secondObj);
	}
	
	protected void Remove_LastItem_ReturnsAndRemovesLastItem_Base() {
		Object firstObj = new Object();
		list.add(firstObj);
		Object secondObj = new Object();
		list.add(secondObj);
		Object thirdObj = new Object();
		list.add(thirdObj);
		
		assertEquals(list.remove(2), thirdObj);
		assertEquals(list.count(), 2);
		
		Object fourthObj = new Object();
		list.add(fourthObj);
		
		assertEquals(list.get(2), fourthObj);
		assertEquals(list.count(), 3);
	}
	
	protected void Remove_InteriorItem_ReturnsAndRemoveItem_Base() {
		Object firstObj = new Object();
		list.add(firstObj);
		Object secondObj = new Object();
		list.add(secondObj);
		Object thirdObj = new Object();
		list.add(thirdObj);
		
		assertEquals(list.remove(1), secondObj);
		assertEquals(list.count(), 2);
		assertEquals(list.get(0), firstObj);
		assertEquals(list.get(1), thirdObj);
	}

	protected void Remove_RemoveAllItems_AddingStillWorks_Base() {
		Object firstObj = new Object();
		list.add(firstObj);
		
		assertEquals(list.remove(0), firstObj);
		assertEquals(list.count(), 0);
		
		Object secondObj = new Object();
		list.add(secondObj);
		
		assertEquals(list.count(), 1);
		assertEquals(list.get(0), secondObj);
	}
	
	protected void AddAtIndex_IndexGreaterThanCount_ThrowsException_Base()
	{
		Object obj = new Object();
		
		try 
		{
			list.add(obj, 1);
			assertTrue(false);
		} 
		catch (IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
	}
	
	protected void AddAtIndex_IndexZeroInEmptyList_AddsAsFirstElement_Base()
	{
		Object obj = new Object();
		
		list.add(obj, 0);
		
		assertEquals(list.count(), 1);
		assertEquals(list.get(0), obj);
	}
	
	protected void AddAtIndex_IndexZeroInPopulatedList_AddsAsFirstElementAndShifts_Base()
	{
		Object firstObj = new Object();
		list.add(firstObj);
		Object secondObj = new Object();
		list.add(secondObj, 0);
		
		assertEquals(list.count(), 2);
		assertEquals(list.get(0), secondObj);
		assertEquals(list.get(1), firstObj);
	}
	
	protected void AddAtIndex_IndexEqualToCount_AddsAsLastElement_Base()
	{
		Object firstObj = new Object();
		list.add(firstObj);
		Object secondObj = new Object();
		list.add(secondObj, 1);
		
		assertEquals(list.count(), 2);
		assertEquals(list.get(0), firstObj);
		assertEquals(list.get(1), secondObj);
	}
	
	protected void AddAtIndex_InteriorIndex_AddsAsInteriorElement_Base()
	{
		Object firstObj = new Object();
		list.add(firstObj);
		Object secondObj = new Object();
		list.add(secondObj);
		Object thirdObj = new Object();
		list.add(thirdObj);
		Object fourthObj = new Object();
		list.add(fourthObj, 2);
		
		assertEquals(list.count(), 4);
		assertEquals(list.get(0), firstObj);
		assertEquals(list.get(1), secondObj);
		assertEquals(list.get(2), fourthObj);
		assertEquals(list.get(3), thirdObj);
	}
}
