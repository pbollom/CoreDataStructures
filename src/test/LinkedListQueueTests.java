package test;

import static org.junit.Assert.*;
import org.junit.Test;
import Queue.LinkedListQueue;

public class LinkedListQueueTests {

	@Test
	public void Dequeue_EmptyQueue_ReturnsNull()
	{
		LinkedListQueue<Object> queue = new LinkedListQueue<Object>();
		assertNull(queue.Dequeue());
	}

	@Test
	public void Dequeue_SingleItemQueue_ReturnsSingleItem()
	{
		LinkedListQueue<Object> queue = new LinkedListQueue<Object>();
		Object obj = new Object();
		queue.Enqueue(obj);
		
		assertEquals(obj, queue.Dequeue());
		assertNull(queue.Dequeue());
	}
	
	@Test
	public void Dequeue_MultiItemQueue_ReturnsItemsFIFO()
	{
		LinkedListQueue<Object> queue = new LinkedListQueue<Object>();
		Object firstIn = new Object();
		queue.Enqueue(firstIn);
		Object secondIn = new Object();
		queue.Enqueue(secondIn);
		Object thirdIn = new Object();
		queue.Enqueue(thirdIn);
		
		assertEquals(firstIn, queue.Dequeue());
		assertEquals(secondIn, queue.Dequeue());
		assertEquals(thirdIn, queue.Dequeue());
		assertNull(queue.Dequeue());
	}
}
