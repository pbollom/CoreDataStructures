package test;

import static org.junit.Assert.*;

import List.IList;

public abstract class ListTestsBase
{
	protected IList<Object> list;
	
	protected abstract void SetUp();

	protected void Count_EmptyList_ReturnsZero_Base() {		
		assertEquals(list.Count(), 0);
	}
	
	protected void Count_MultipleItemList_ReturnsCorrectCount_Base() {
		int count = 3;
		for (int i = 0; i < count; i++) {
			list.Add(new Object());
		}
		
		assertEquals(list.Count(), count);
	}

	protected void Get_IndexGreaterThanCount_ThrowsException_Base() {
		try {
			list.Get(0);
			assertTrue(false);
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	protected void Get_IndexZero_ReturnsFirstItem_Base() {
		Object firstObj = new Object();
		list.Add(firstObj);
		Object secondObj = new Object();
		list.Add(secondObj);
		
		assertEquals(list.Get(0), firstObj);
	}
	
	protected void Get_InBoundsIndex_ReturnsItemAtIndexAndDoesNotRemoveIt_Base() {
		Object firstObj = new Object();
		list.Add(firstObj);
		Object secondObj = new Object();
		list.Add(secondObj);
		Object thirdObj = new Object();
		list.Add(thirdObj);
		
		assertEquals(list.Get(1), secondObj);
		assertEquals(list.Count(), 3);
	}
	
	protected void Remove_IndexGreaterThanEqualToCount_ThrowsException_Base() {	
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
	
	protected void Remove_IndexZero_ReturnsAndRemovesFirstItem_Base() {
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
	
	protected void Remove_LastItem_ReturnsAndRemovesLastItem_Base() {
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
	
	protected void Remove_InteriorItem_ReturnsAndRemoveItem_Base() {
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

	protected void Remove_RemoveAllItems_AddingStillWorks_Base() {
		Object firstObj = new Object();
		list.Add(firstObj);
		
		assertEquals(list.Remove(0), firstObj);
		assertEquals(list.Count(), 0);
		
		Object secondObj = new Object();
		list.Add(secondObj);
		
		assertEquals(list.Count(), 1);
		assertEquals(list.Get(0), secondObj);
	}
	
	protected void AddAtIndex_IndexGreaterThanCount_ThrowsException_Base()
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
	
	protected void AddAtIndex_IndexZeroInEmptyList_AddsAsFirstElement_Base()
	{
		Object obj = new Object();
		
		list.Add(obj, 0);
		
		assertEquals(list.Count(), 1);
		assertEquals(list.Get(0), obj);
	}
	
	protected void AddAtIndex_IndexZeroInPopulatedList_AddsAsFirstElementAndShifts_Base()
	{
		Object firstObj = new Object();
		list.Add(firstObj);
		
		Object secondObj = new Object();
		list.Add(secondObj, 0);
		
		assertEquals(list.Count(), 2);
		assertEquals(list.Get(0), secondObj);
		assertEquals(list.Get(1), firstObj);
	}
	
	protected void AddAtIndex_IndexEqualToCount_AddsAsLastElement_Base()
	{
		Object firstObj = new Object();
		list.Add(firstObj);
		
		Object secondObj = new Object();
		list.Add(secondObj, 1);
		
		assertEquals(list.Count(), 2);
		assertEquals(list.Get(0), firstObj);
		assertEquals(list.Get(1), secondObj);
	}
	
	protected void AddAtIndex_InteriorIndex_AddsAsInteriorElement_Base()
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
