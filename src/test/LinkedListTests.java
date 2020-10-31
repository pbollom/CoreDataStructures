package test;

import org.junit.*;
import List.LinkedList;

public class LinkedListTests extends ListTestsBase implements IListTests {
    
    @Before
	public void setUp()
	{
		this.list = new LinkedList<Object>();
	}

	@Override
	@Test
	public void Count_EmptyList_ReturnsZero() {
		this.Count_EmptyList_ReturnsZero_Base();
	}

	@Override
	@Test
	public void Count_MultipleItemList_ReturnsCorrectCount() {
		this.Count_MultipleItemList_ReturnsCorrectCount_Base();
	}

	@Override
	@Test
	public void Get_IndexGreaterThanCount_ThrowsException() {
		this.Get_IndexGreaterThanCount_ThrowsException_Base();
	}

	@Override
	@Test
	public void Get_IndexZero_ReturnsFirstItem() {
		this.Get_IndexZero_ReturnsFirstItem_Base();
	}

	@Override
	public void Get_InBoundsIndex_ReturnsItemAtIndexAndDoesNotRemoveIt() {
		this.Get_InBoundsIndex_ReturnsItemAtIndexAndDoesNotRemoveIt_Base();
	}

	@Override
	@Test
	public void Remove_IndexGreaterThanEqualToCount_ThrowsException() {
		this.Remove_IndexGreaterThanEqualToCount_ThrowsException_Base();
	}

	@Override
	@Test
	public void Remove_IndexZero_ReturnsAndRemovesFirstItem() {
		this.Remove_IndexZero_ReturnsAndRemovesFirstItem_Base();
	}

	@Override
	@Test
	public void Remove_LastItem_ReturnsAndRemovesLastItem() {
		this.Remove_LastItem_ReturnsAndRemovesLastItem_Base();
	}

	@Override
	@Test
	public void Remove_RemoveAllItems_AddingStillWorks() {
		this.Remove_RemoveAllItems_AddingStillWorks_Base();
	}

	@Override
	@Test
	public void AddAtIndex_IndexGreaterThanCount_ThrowsException() {
		this.AddAtIndex_IndexGreaterThanCount_ThrowsException_Base();
	}

	@Override
	@Test
	public void AddAtIndex_IndexZeroInEmptyList_AddsAsFirstElement() {
		this.AddAtIndex_IndexZeroInEmptyList_AddsAsFirstElement_Base();
	}

	@Override
	@Test
	public void AddAtIndex_IndexZeroInPopulatedList_AddsAsFirstElementAndShifts() {
		this.AddAtIndex_IndexZeroInPopulatedList_AddsAsFirstElementAndShifts_Base();
	}

	@Override
	@Test
	public void AddAtIndex_IndexEqualToCount_AddsAsLastElement() {
		this.AddAtIndex_IndexEqualToCount_AddsAsLastElement_Base();
	}

	@Override
	@Test
	public void AddAtIndex_InteriorIndex_AddsAsInteriorElement() {
		this.AddAtIndex_InteriorIndex_AddsAsInteriorElement_Base();
	}

	@Override
	@Test
	public void Remove_InteriorItem_ReturnsAndRemoveItem() {
		this.Remove_InteriorItem_ReturnsAndRemoveItem_Base();
	}
}
