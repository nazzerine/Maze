package project3;

/**
 * This class represents the array-based queue implementation of the PossibleLocations class.
 * @author Nazzerine Waldon
 *
 */

public class PossibleLocationsQueue implements PossibleLocations {
	// array based queue
	
	private int front;
	private int back;
	private int size;
	private int capacity;
	Location [] elementData;
	
	
	/**
	 * Construct an instance of a PossibleLocationsQueue with no initial capacity.
	 * This is the default constructor.
	 * 
	 */
	public PossibleLocationsQueue () {
		this.capacity = 5; //default capacity
		this.size = 0; //size is set to 0 until location objects are added
		this.front = 0; //first element of qArray
		this.back = size - 1; //last element of qArray
		this.elementData = new Location[capacity]; //create array of size capacity
	}
	 
	/**
	 * Construct an instance of a PossibleLocationsQueue with initial capacity identified.
	 * 
	 * @param c
	 * 		value of initial capacity
	 */
	public PossibleLocationsQueue (int c) {
		//if user-set capacity is negative or 0, set capacity to 5 by default
		if ( c <= 0 ) {
			this.capacity = 5; //default capacity
		} else {
			this.capacity = c; //capacity is equal to user-defined integer
		}
		
		this.size = 0; //size is set to 0 until location objects are added
		this.front = 0; //first element of qArray
		this.back = size - 1; //last element of qArray
		this.elementData = new Location[capacity]; //create array of size capacity
	}
	
	/**
	 * Add a SquarePosition object to the queue.
	 * @param s
	 *    Location object to be added
	 */
	@Override
	public void add(Location s) { //throws IllegalArgumentException {
		// enqueue function
		if (s != null) {
			int avail = (back + 1) % capacity; // pg. 243
			elementData[avail] = s;
			back++;
			size++;
		} 
		
		if (size == capacity)
			makeLarger();
		
	}	

	/**
	 * Remove the next object from the queue. The first object in the
	 * queue is removed.
	 * 
	 * @return
	 *    the next object, or null if set is empty
	 */
	@Override
	public Location remove() {
		// dequeue function -> FIFO
		if (isEmpty()) // if queue is empty
			return null;
		Location tmp = elementData[front]; // reference to removed object
		elementData[front] = null; //empty out object from set
		front = (front + 1) % capacity; // set front to the next object
		size--; //decrease size
		// return removed object
		return tmp;
	}

	/**
	 * Determines if queue is empty or not.
	 * @return
	 *    true, if queue is empty,
	 *    false, otherwise.
	 */
	@Override
	public boolean isEmpty() {
		if (size == 0) 
			return true;
		// otherwise queue is not empty
		return false;
	}
	
	/**
	 * Enlarges array-based queue once size reaches capacity of the storage.
	 * 
	 */
	private void makeLarger() {
		Location[] tmp = new Location[capacity*2]; //make a new array of any multiple of current capacity
		int j = front;
		// copy data from old array to new array
		for (int i = 0; i < elementData.length; i++) {
			tmp[i] = elementData[j];
			j++; // iterate j through the array
			if ( j == elementData.length ) // if front is at the end, wrap it back to the front
				j = 0;
		}
		elementData = tmp; // elementData is now equal to new array
		front = 0; //front should now be at index 0 of the new array
		back = size - 1; //back is at size - 1 leaving indices size to capacity empty
		capacity = capacity*2; // the new capacity is equal to capacity*2
	}
}
