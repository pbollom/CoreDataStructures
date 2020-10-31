package test;

import static org.junit.Assert.*;
import org.junit.Test;
import Queue.LinkedListQueue;

public class LinkedListQueueTests {

	@Test
	public void Dequeue_EmptyQueue_ReturnsNull()
	{
		LinkedListQueue<Object> queue = new LinkedListQueue<Object>();
		assertNull(queue.dequeue());
	}

	@Test
	public void Dequeue_SingleItemQueue_ReturnsSingleItem()
	{
		LinkedListQueue<Object> queue = new LinkedListQueue<Object>();
		Object obj = new Object();
		queue.enqueue(obj);
		
		assertEquals(obj, queue.dequeue());
		assertNull(queue.dequeue());
	}
	
	@Test
	public void Dequeue_MultiItemQueue_ReturnsItemsFIFO()
	{
		LinkedListQueue<Object> queue = new LinkedListQueue<Object>();
		Object firstIn = new Object();
		queue.enqueue(firstIn);
		Object secondIn = new Object();
		queue.enqueue(secondIn);
		Object thirdIn = new Object();
		queue.enqueue(thirdIn);
		
		assertEquals(firstIn, queue.dequeue());
		assertEquals(secondIn, queue.dequeue());
		assertEquals(thirdIn, queue.dequeue());
		assertNull(queue.dequeue());
	}
}
