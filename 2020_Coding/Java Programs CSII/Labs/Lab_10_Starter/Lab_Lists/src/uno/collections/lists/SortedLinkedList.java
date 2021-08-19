// COURSE: CSCI1620
// TERM: Fall 2020
//
// NAME: Maverick Berkland
// RESOURCES: Classmate Assistance aided the creation of this class.
//            And starter code was provided by professors.

package uno.collections.lists;

/**
 * This class sorts the LinkedList.
 * 
 * @author mberkland
 *
 * @param <E> The type of an individual item to be stored in the list.
 */
public class SortedLinkedList<E extends Comparable<E>> extends LinkedList<E> implements List<E>
{

	/**
	 * Creates a new empty SortedLinkedList.
	 */
	public SortedLinkedList()
	{
		super();
	}

	/**
	 * Adds the specified item to the list while preserving the global sorted order
	 * of the list. This method guarantees no worse than linear runtime performance
	 * for each add operation.
	 * 
	 * @implSpec add in interface List E extends java.lang.Comparable E .
	 * @param item - The new item to be inserted.
	 * @return true when the item was successfully added (which is always).
	 */
	@Override
	public boolean add(E item)
	{
		boolean ret = true;
		if (numElements == 0)
		{
			firstNode = new ListNode<E>(item, null);
			lastNode = firstNode;
		}
		else if (item == null)
		{
			ListNode<E> itemNode = new ListNode<E>(item, null);
			lastNode.setNext(itemNode);
			lastNode = itemNode;
		}
		else if (item.compareTo(firstNode.getData()) < 0)
		{
			ListNode<E> itemNode = new ListNode<E>(item, firstNode);
			firstNode = itemNode;
		}
		else
		{
			ListNode<E> parent = firstNode;
			ListNode<E> child = parent.getNext();
			while (parent != null)
			{
				if (child == null)
				{
					parent.setNext(new ListNode<E>(item, child));
					lastNode = parent.getNext();
					break;
				}
				else if (item.compareTo(child.getData()) < 0)
				{
					parent.setNext(new ListNode<E>(item, child));
					break;
				}
				parent = child;
				child = parent.getNext();
			}
		}
		numElements++;
		return ret;
	}

	/**
	 * This method is disallowed for SortedLinkedLists. All calls will result in an
	 * exception. Specified by: add in interface List E extends java.lang.Comparable
	 * E Overrides: add in class LinkedList E extends java.lang.Comparable E
	 * Parameters: index - The index where an item is to be added in the list. item
	 * - The item to be added to the list. Throws:
	 * java.lang.UnsupportedOperationException - is thrown any time this method gets
	 * called as it would violate sorted ordering requirements of SortedLinkedList.
	 * 
	 * @param index - The index where an item is to be added in the list.
	 * @param item  - The item to be added to the list.
	 */
	public void add(final int index, final E item) throws java.lang.UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * This method is disallowed for SortedLinkedLists. All calls will result in an
	 * exception.
	 * 
	 * @implSpec add in interface List E extends java.lang.Comparable E
	 * @Override add in class LinkedList E extends java.lang.Comparable E
	 * @param index - The index where an item is to be added in the list.
	 * @param item  - The item to be added to the list.
	 * @throws java.lang.UnsupportedOperationException - is thrown any time this
	 *                                                 method gets called as it
	 *                                                 would violate sorted ordering
	 *                                                 requirements of
	 *                                                 SortedLinkedList.
	 * @return the element previously stored at the specified index.
	 */
	public E set(final int index, final E item) throws java.lang.UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
}
