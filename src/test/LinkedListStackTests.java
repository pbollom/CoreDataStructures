package test;

import static org.junit.Assert.*;
import org.junit.Test;
import stack.LinkedListStack;

public class LinkedListStackTests {

	@Test
	public void Peek_EmptyStack_ReturnsNull() {
		LinkedListStack<Object> stack = new LinkedListStack<Object>();
		assertNull(stack.peek());
	}
	
	@Test
	public void Peek_SingleItemStack_ReturnsReferenceToSameObject()
	{
		LinkedListStack<Object> stack = new LinkedListStack<Object>();
		Object obj = new Object();
		stack.push(obj);
		
		assertEquals(obj, stack.peek());
	}
	
	@Test
	public void Peek_CalledMultipleTimes_DoesNotRemoveTopObject()
	{
		LinkedListStack<Object> stack = new LinkedListStack<Object>();
		Object obj = new Object();
		stack.push(obj);
		
		assertEquals(obj, stack.peek());
		assertEquals(obj, stack.peek());
		assertEquals(obj, stack.peek());
	}
	
	@Test
	public void Pop_EmptyStack_ReturnsNull() {
		LinkedListStack<Object> stack = new LinkedListStack<Object>();
		assertNull(stack.pop());
	}
	
	@Test
	public void Pop_SingleItemStack_ReturnsReferenceToSameObject()
	{
		LinkedListStack<Object> stack = new LinkedListStack<Object>();
		Object obj = new Object();
		stack.push(obj);
		
		assertEquals(obj, stack.pop());
	}
	
	@Test
	public void Pop_MultiItemStack_ReturnsObjectsLIFO()
	{
		LinkedListStack<Object> stack = new LinkedListStack<Object>();
		Object firstIn = new Object();
		stack.push(firstIn);
		Object secondIn = new Object();
		stack.push(secondIn);
		Object thirdIn = new Object();
		stack.push(thirdIn);
		
		assertEquals(thirdIn, stack.pop());
		assertEquals(secondIn, stack.pop());
		assertEquals(firstIn, stack.pop());
		assertNull(stack.pop());
	}

}
