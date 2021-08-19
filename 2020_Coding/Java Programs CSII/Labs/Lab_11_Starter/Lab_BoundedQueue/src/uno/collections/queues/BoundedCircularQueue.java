                         // COURSE: CSCI1620
// TERM: FALL 2020
//
// NAME: Maverick Berkland
// RESOURCES: The given classes were used in the process of this lab.
package uno.collections.queues;

/**
 * Provides a standard definition of a circular queue (aka, a ring buffer)
 * with a maximum capacity.  All queue operations are guaranteed to complete
 * in constant time. 
 * 
 * @author mberkland
 *
 * @param <E> The type of an individual element stored in the queue.
 */
public class BoundedCircularQueue<E> implements Queue<E>
{
	/**
	 * The array where we will store data in this queue.
	 */
	private E[] values;
	
	/**
	 * The index of the current front item in the queue.
	 */
	private int front;
	
	/**
	 * The index of the current rear item in the queue.	
	 */
	private int rear;
	
	/**
	 * The number of items currently stored in the queue.
	 */
	private int numberOfItems;
	/**
	 * Constructs a new, initially empty BoundedCircularQueue with 
	 * a default maximum capacity of 10.
	 */
	public BoundedCircularQueue()
	{
		this(10); //BIG BRAIN MOMENT.
	}
	
	/**
	 * Constructs a new, initially empty BoundedCircularQueue.
	 * 
	 * @param capacity The maximum number of items that can be stored 
	 * in this queue.
	 */
	@SuppressWarnings("unchecked")
	public BoundedCircularQueue(int capacity)
	{
		values = (E[]) new Object[capacity];
		numberOfItems = 0;
		front = 0;
		rear = 0;
	}
	
	/* (non-Javadoc)
	 * @see uno.collections.queues.Queue#isEmpty()
	 */
	@Override
	public boolean isEmpty()
	{
		return numberOfItems == 0;
	}

	/* (non-Javadoc)
	 * @see uno.collections.queues.Queue#size()
	 */
	@Override
	public int size()
	{
		return numberOfItems;
	}

	/* (non-Javadoc)
	 * @see uno.collections.queues.Queue#peek()
	 */
	@Override
	public E peek()
	{
		if (isEmpty())
		{
			throw new IllegalStateException("Cannot peek on an empty queue!");
		}
		return values[front];
	}

	/* (non-Javadoc)
	 * @see uno.collections.queues.Queue#dequeue()
	 */
	@Override
	public E dequeue()
	{
		E e = null;
		if (!isEmpty())
		{
			e = values[front];
			values[front] = null;
			front = (front + 1) % values.length; // rear is unchanged.
			numberOfItems--;
		}
		else
		{
			throw new IllegalStateException("Cannot dequeue from an empty queue!");
		}
		return e;
	}

	/**
	 * Add an item to the rear of this queue.
	 * 
	 * @param item The value to be added to the queue.
	 * @throws IllegalStateException when the queue is full. 
	 * The message will read "Cannot enqueue because queue is already full!"
	 */
	@Override
	public void enqueue(E item)
	{	
		if (!isFull())
		{
			values[rear] = item;
			rear = (rear + 1) % values.length; //front is unchanged.
			numberOfItems++;
		}
		else
		{
			throw new IllegalStateException("Cannot enqueue because queue is already full!");
		}
	}

	/**
	 * A method to test whether this BoundedCircularQueue is currently
	 * full.
	 * 
	 * @return true if this queue is full, false if at least one more item 
	 * can be enqueued.
	 */
	public boolean isFull()
	{
		return numberOfItems == values.length;
	}
	
	
	
}
