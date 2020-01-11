package UnitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import Queue.Queue;

public class QueueTests {

	@Test
	public void Dequeue_EmptyQueue_ReturnsNull()
	{
		Queue<Object> queue = new Queue<Object>();
		assertNull(queue.Dequeue());
	}

	@Test
	public void Dequeue_SingleItemQueue_ReturnsSingleItem()
	{
		Queue<Object> queue = new Queue<Object>();
		Object obj = new Object();
		queue.Enqueue(obj);
		
		assertEquals(obj, queue.Dequeue());
		assertNull(queue.Dequeue());
	}
	
	@Test
	public void Dequeue_MultiItemQueue_ReturnsItemsFIFO()
	{
		Queue<Object> queue = new Queue<Object>();
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
