package UnitTests;

import List.IList;

public interface IListTests {
	void Count_EmptyList_ReturnsZero();
	
	void Count_MultipleItemList_ReturnsCorrectCount();

	void Get_IndexGreaterThanCount_ThrowsException();
	
	void Get_IndexZero_ReturnsFirstItem();
	
	void Get_InBoundsIndex_ReturnsItemAtIndexAndDoesNotRemoveIt();
	
	void Remove_IndexGreaterThanEqualToCount_ThrowsException();
	
	void Remove_IndexZero_ReturnsAndRemovesFirstItem();
	
	void Remove_LastItem_ReturnsAndRemovesLastItem();
	
	void Remove_InteriorItem_ReturnsAndRemoveItem();

	void Remove_RemoveAllItems_AddingStillWorks();
	
	void AddAtIndex_IndexGreaterThanCount_ThrowsException();
	
	void AddAtIndex_IndexZeroInEmptyList_AddsAsFirstElement();
	
	void AddAtIndex_IndexZeroInPopulatedList_AddsAsFirstElementAndShifts();
	
    void AddAtIndex_IndexEqualToCount_AddsAsLastElement();
	
	void AddAtIndex_InteriorIndex_AddsAsInteriorElement();
}