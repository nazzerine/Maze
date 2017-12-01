package project3;

/**
 * This class represents the linked-list based stack implementation of PossibleLocations class.
 * @author Nazzerine Waldon
 *
 */

public class PossibleLocationsStack implements PossibleLocations {
	
	// nested node class for linked list implementation of a stack of type Location objects
	private static class Node<Location> {
		//private node data fields
		private Location element;
		private Node<Location> next;
		
		//node constructor
		public Node(Location e, Node<Location> n) {
			element = e;
			next = n;
		}
		//accessor method for retrieving node data
		public Location getElement() {
			return element;
		}

		public Node<Location> getNext() {
			return next;
		}
	}
	
	//initialize data fields for the stack
	private Node<Location> head = null;
	private int size = 0; 
	
	/**
	 * Default constructor for the stack.
	 */
	
	public PossibleLocationsStack() {
	}
	
	/**
	 * Add a SquarePosition object to the stack.
	 * @param s
	 *    Location object to be added
	 */
 	@Override
	public void add(Location s) {
		// pop function -> addFirst()
 		if (s != null) {
 			head = new Node<Location> (s, head);
 			size++;
 		}
	}
 	
 	/**
	 * Remove the next object from the stack. Removes Location object at 
	 * the top of the stack.
	 * @return
	 *    the next object, or null if stack is empty
	 */
 	
 	// push function -> removeFirst()
	@Override
	public Location remove () {
		// if stack is empty throw exception
		if (isEmpty())
			return null;
		
		Location answer = head.getElement();
		
		// if not empty, remove head (first in list)
		head = head.getNext();
		size--;
		return answer;
		
	}

	/**
	 * Determines if the stack is empty or not.
	 * @return
	 *    true, if stack is empty,
	 *    false, otherwise.
	 */
	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} 
		//otherwise stack is not empty
		return false;
	}

}
