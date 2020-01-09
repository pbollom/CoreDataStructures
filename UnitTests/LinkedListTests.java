package UnitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import List.LinkedList;

public class LinkedListTests {

	@Test
	public void Count_EmptyList_ReturnsZero() {
		LinkedList<Object> list = new LinkedList<Object>();
		
		assertEquals(list.Count(), 0);
	}
	
	@Test
	public void Count_MultipleItemList_ReturnsCorrectCount() {
		LinkedList<Object> list = new LinkedList<Object>();
		int count = 3;
		for (int i = 0; i < count; i++) {
			list.Add(new Object());
		}
		
		assertEquals(list.Count(), count);
	}

	@Test
	public void Get_IndexGreaterThanCount_ThrowsException() {
		LinkedList<Object> list = new LinkedList<Object>();
		
		try {
			list.Get(0);
			assertTrue(false);
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void Get_IndexZero_ReturnsFirstItem() {
		LinkedList<Object> list = new LinkedList<Object>();
		Object firstObj = new Object();
		list.Add(firstObj);
		Object secondObj = new Object();
		list.Add(secondObj);
		
		assertEquals(list.Get(0), firstObj);
	}
	
	@Test
	public void Get_InBoundsIndex_ReturnsItemAtIndexAndDoesNotRemoveIt() {
		LinkedList<Object> list = new LinkedList<Object>();
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
		LinkedList<Object> list = new LinkedList<Object>();
		
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
		LinkedList<Object> list = new LinkedList<Object>();
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
		LinkedList<Object> list = new LinkedList<Object>();
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
		LinkedList<Object> list = new LinkedList<Object>();
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
		LinkedList<Object> list = new LinkedList<Object>();
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
		LinkedList<Object> list = new LinkedList<Object>();
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
		LinkedList<Object> list = new LinkedList<Object>();
		Object obj = new Object();
		
		list.Add(obj, 0);
		
		assertEquals(list.Count(), 1);
		assertEquals(list.Get(0), obj);
	}
	
	@Test
	public void AddAtIndex_IndexZeroInPopulatedList_AddsAsFirstElementAndShifts()
	{
		LinkedList<Object> list = new LinkedList<Object>();
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
		LinkedList<Object> list = new LinkedList<Object>();
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
		LinkedList<Object> list = new LinkedList<Object>();
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
