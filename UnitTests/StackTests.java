package UnitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import Stack.Stack;

public class StackTests {

	@Test
	public void peek_emptyStack_returnsNull() {
		Stack<Object> stack = new Stack<Object>();
		assertNull(stack.Peek());
	}
	
	@Test
	public void peek_stackWithOneObject_returnsReferenceToSameObject()
	{
		Stack<Object> stack = new Stack<Object>();
		Object obj = new Object();
		stack.Push(obj);
		
		assertEquals(obj, stack.Peek());
	}
	
	@Test
	public void peek_calledMultipleTimes_doesNotRemoveTopObject()
	{
		Stack<Object> stack = new Stack<Object>();
		Object obj = new Object();
		stack.Push(obj);
		
		assertEquals(obj, stack.Peek());
		assertEquals(obj, stack.Peek());
		assertEquals(obj, stack.Peek());
	}
	
	@Test
	public void pop_emptyStack_returnsNull() {
		Stack<Object> stack = new Stack<Object>();
		assertNull(stack.Pop());
	}
	
	@Test
	public void pop_stackWithOneObject_retursReferenceToSameObject()
	{
		Stack<Object> stack = new Stack<Object>();
		Object obj = new Object();
		stack.Push(obj);
		
		assertEquals(obj, stack.Pop());
	}
	
	@Test
	public void pop_stackWithMultipleObjects_returnsObjectsLIFO()
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
