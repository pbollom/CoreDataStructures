package test;

import static org.junit.Assert.*;
import org.junit.Test;
import Stack.LinkedListStack;

public class LinkedListStackTests {

	@Test
	public void Peek_EmptyStack_ReturnsNull() {
		LinkedListStack<Object> stack = new LinkedListStack<Object>();
		assertNull(stack.Peek());
	}
	
	@Test
	public void Peek_SingleItemStack_ReturnsReferenceToSameObject()
	{
		LinkedListStack<Object> stack = new LinkedListStack<Object>();
		Object obj = new Object();
		stack.Push(obj);
		
		assertEquals(obj, stack.Peek());
	}
	
	@Test
	public void Peek_CalledMultipleTimes_DoesNotRemoveTopObject()
	{
		LinkedListStack<Object> stack = new LinkedListStack<Object>();
		Object obj = new Object();
		stack.Push(obj);
		
		assertEquals(obj, stack.Peek());
		assertEquals(obj, stack.Peek());
		assertEquals(obj, stack.Peek());
	}
	
	@Test
	public void Pop_EmptyStack_ReturnsNull() {
		LinkedListStack<Object> stack = new LinkedListStack<Object>();
		assertNull(stack.Pop());
	}
	
	@Test
	public void Pop_SingleItemStack_ReturnsReferenceToSameObject()
	{
		LinkedListStack<Object> stack = new LinkedListStack<Object>();
		Object obj = new Object();
		stack.Push(obj);
		
		assertEquals(obj, stack.Pop());
	}
	
	@Test
	public void Pop_MultiItemStack_ReturnsObjectsLIFO()
	{
		LinkedListStack<Object> stack = new LinkedListStack<Object>();
		Object firstIn = new Object();
		stack.Push(firstIn);
		Object secondIn = new Object();
		stack.Push(secondIn);
		Object thirdIn = new Object();
		stack.Push(thirdIn);
		
		assertEquals(thirdIn, stack.Pop());
		assertEquals(secondIn, stack.Pop());
		assertEquals(firstIn, stack.Pop());
		assertNull(stack.Pop());
	}

}
