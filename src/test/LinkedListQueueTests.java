package test;

import static org.junit.Assert.*;
import org.junit.Test;
import queue.LinkedListQueue;

public class LinkedListQueueTests {

	@Test
	public void dequeue_EmptyQueue_ReturnsNull()
	{
		LinkedListQueue<Object> queue = new LinkedListQueue<Object>();
		assertNull(queue.dequeue());
	}

	@Test
	public void dequeue_SingleItemQueue_ReturnsSingleItem()
	{
		LinkedListQueue<Object> queue = new LinkedListQueue<Object>();
		Object obj = new Object();
		queue.enqueue(obj);
		
		assertEquals(obj, queue.dequeue());
		assertNull(queue.dequeue());
	}
	
	@Test
	public void dequeue_MultiItemQueue_ReturnsItemsFIFO()
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

	@Test
	public void count_EmptyQueue_ReturnsZero()
	{
		LinkedListQueue<Object> queue = new LinkedListQueue<Object>();
		assertEquals(0, queue.count());
	}

	@Test
	public void count_WithItems_ReturnsNumberEnqueued()
	{
		LinkedListQueue<Object> queue = new LinkedListQueue<Object>();
		queue.enqueue(new Object());

		assertEquals(1, queue.count());
	}

	@Test
	public void count_WithItems_ReturnsEnqueuedMinusDequeued()
	{
		LinkedListQueue<Object> queue = new LinkedListQueue<Object>();
		queue.enqueue(new Object());
		queue.enqueue(new Object());
		queue.enqueue(new Object());
		queue.dequeue();
		
		assertEquals(2, queue.count());
	}
}
