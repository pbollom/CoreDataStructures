package UnitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import Stack.Stack;

public class StackTests {

	@Test
	public void Peek_EmptyStack_ReturnsNull() {
		Stack<Object> stack = new Stack<Object>();
		assertNull(stack.Peek());
	}
	
	@Test
	public void Peek_SingleItemStack_ReturnsReferenceToSameObject()
	{
		Stack<Object> stack = new Stack<Object>();
		Object obj = new Object();
		stack.Push(obj);
		
		assertEquals(obj, stack.Peek());
	}
	
	@Test
	public void Peek_CalledMultipleTimes_DoesNotRemoveTopObject()
	{
		Stack<Object> stack = new Stack<Object>();
		Object obj = new Object();
		stack.Push(obj);
		
		assertEquals(obj, stack.Peek());
		assertEquals(obj, stack.Peek());
		assertEquals(obj, stack.Peek());
	}
	
	@Test
	public void Pop_EmptyStack_ReturnsNull() {
		Stack<Object> stack = new Stack<Object>();
		assertNull(stack.Pop());
	}
	
	@Test
	public void Pop_SingleItemStack_ReturnsReferenceToSameObject()
	{
		Stack<Object> stack = new Stack<Object>();
		Object obj = new Object();
		stack.Push(obj);
		
		assertEquals(obj, stack.Pop());
	}
	
	@Test
	public void Pop_MultiItemStack_ReturnsObjectsLIFO()
	{
		Stack<Object> stack = new Stack<Object>();
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
