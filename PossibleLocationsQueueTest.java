package project3;

/**
 * This class tests the PossibleLocationsQueue class.

 * @author Nazzerine Waldon
 *
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class PossibleLocationsQueueTest {

	//test the constructors
	@Test
	public void testPossibleLocationsQueue() {
		try {
			//test the default constructor
			PossibleLocationsQueue constructor1 = new PossibleLocationsQueue(); 
			assertTrue("This should create an empty queue with default capacity.", constructor1.isEmpty());
			//add more than default capacity to indirectly test capacity and makeLarger method
			addLocationElements(constructor1);
			assertFalse("The queue should not be empty.", constructor1.isEmpty());
			
			//if user sets capacity to 0, the capacity should be automatically set to the default capacity
			PossibleLocationsQueue constructor2 = new PossibleLocationsQueue(0);
			assertTrue("This should create an empty queue with default capacity.", constructor2.isEmpty());
			//add more than default capacity to indirectly test capacity and makeLarger method
			addLocationElements(constructor2);
			assertFalse("The queue should not be empty.", constructor2.isEmpty());
			
			//tests the second constructor - user is able to set capacity
			PossibleLocationsQueue constructor3 = new PossibleLocationsQueue(3);
			assertTrue("This should create an empty queue with a capacity of 3.", constructor3.isEmpty());
			//add more than capacity to indirectly test capacity and makeLarger method
			addLocationElements(constructor3);
			assertFalse("The queue should not be empty.", constructor3.isEmpty());
			
			//if user sets capacity to a negative number, capacity should be automatically set to the default
			PossibleLocationsQueue constructor4 = new PossibleLocationsQueue(-1);
			assertTrue("This should create an empty queue with default capacity.", constructor4.isEmpty());
			//add more than default capacity to indirectly test capacity and makeLarger method
			addLocationElements(constructor4);
			assertFalse("The queue should not be empty.", constructor4.isEmpty());
		} catch (Exception e) {
			fail("testPossibleLocationsQueue failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	//condensed test method for add and remove
	@Test
	public void testAddAndRemove() {
		testAddAndRemoveFromEmptyList();
		testAddAndRemoveFromOneElementList();
		testAddAndRemoveFromMultipleElementList();
	}
	
	//condensed test method for isEmpty
	@Test
	public void testIsEmpty() {
		testIsEmptyWithEmptyList();
		testIsEmptyWithOneElementList();
		testIsEmptyWithMutlipleElementList();
		testIsEmptyWithNullObject();
	}
	
	//condensed test method for makeLarger
	@Test
	public void testMakeLarger() {
		testMakeLargerWithDefaultCapacity();
		testMakeLargerWithUserCapacity();
	}
	
	
	// tests multiple methods
	@Test
	public void testSpecialCase1() {
		try {
			PossibleLocationsQueue tester = new PossibleLocationsQueue(); //queue with default capacity
			Location add1 = new Location(1,2); 
			tester.add(add1); //adds one object
			assertFalse("Should return false.", tester.isEmpty()); // queue is not empty
			assertEquals("Should return (1, 2).", add1, tester.remove()); // removes the object
		} catch (Exception e) {
			fail("testSpecialCase1 failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	//tests multiple methods
	@Test
	public void testSpecialCase2() {
		try {
			PossibleLocationsQueue tester = new PossibleLocationsQueue(); //queue with default capacity
			Location add1 = new Location(6, 2);
			Location add2 = new Location(3, 4);
			Location add3 = new Location(4, 6);
			Location add4 = new Location(5, 8);
			Location add5 = new Location(2, 6);
			//add the objects to the queue
			tester.add(add1);
			tester.add(add2);
			tester.add(add3);
			tester.add(add4);
			tester.add(add5);
			assertEquals("Should return (6,2).", add1, tester.remove()); //removes first object (FIFO)
			assertFalse("Should return false.", tester.isEmpty()); //queue is not empty -> testing capacity
		} catch (Exception e) {
			fail("testSpecialCase2 failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	//tests multiple methods
	@Test
	public void testSpecialCase3() {
		try {
			PossibleLocationsQueue tester = new PossibleLocationsQueue(2);
			Location add1 = new Location(1,1);
			Location add2 = null;
			//add objects to the queue
			tester.add(add1);
			tester.add(add2);
			//since one object is equal to null, size DOES not equal capacity
			assertEquals("Should return (1,1)", add1, tester.remove()); //remove first object (FIFO)
			//null object is only thing in the queue therefore size == 0;
			assertTrue("Should return true", tester.isEmpty());
		} catch (Exception e) {
			fail("testSpecialCase3 failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	/********** TESTS FOR ADD AND REMOVE **********/
	
	//creates empty queue
	public void testAddAndRemoveFromEmptyList() {
		try {
			PossibleLocationsQueue tester = new PossibleLocationsQueue();
			//should return null since there is nothing to remove
			assertNull("Should return null.", tester.remove());
		} catch (Exception e) {
			fail("testAddAndRemoveFromEmptyList failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}

	// creates queue with one object
	public void testAddAndRemoveFromOneElementList() {
		try {
			PossibleLocationsQueue tester = new PossibleLocationsQueue(); //creates queue with default capacity
			Location add1 = new Location(1, 23);
			//add object into queue
			tester.add(add1);
			assertEquals("Should return (1, 23).", add1, tester.remove()); //removes object from queue
		} catch (Exception e) {
			fail("testAddAndRemoveFromOneElementList failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	
	public void testAddAndRemoveFromMultipleElementList() {
		try {
			PossibleLocationsQueue tester = new PossibleLocationsQueue(); 
			Location add1 = new Location (10, 4);
			Location add2 = new Location (4, 7);
			Location add3 = new Location (5, 6);
			//adds all 3 objects to queue
			tester.add(add1);
			tester.add(add2);
			tester.add(add3);
			assertEquals("Should return (10, 4).", add1, tester.remove()); //removes first object in queue (FIFO)
		} catch (Exception e) {
			fail("testAddAndRemoveFromMultipleElementList failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}

	/********** TESTS FOR ISEMPTY **********/
	
	public void testIsEmptyWithEmptyList() {
		try {
			PossibleLocationsQueue tester = new PossibleLocationsQueue(7); //creates queue with user-set capacity of 7
			//no objects were added therefore size == 0 and queue is empty
			assertTrue("Should return true", tester.isEmpty());
		} catch (Exception e) {
			fail("testIsEmptyWithEmptyList failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	
	public void testIsEmptyWithOneElementList() {
		try {
			PossibleLocationsQueue tester = new PossibleLocationsQueue(6); //creates queue with user-set capacity of 6
			Location add1 = new Location(55, 78);
			//adds location object to queue
			tester.add(add1);
			assertFalse("Should return false.", tester.isEmpty()); //queue has a size of 1
		} catch (Exception e) {
			fail("testIsEmptyWithEmptyList failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
		
	}
	
	
	public void testIsEmptyWithMutlipleElementList() {
		try {
			PossibleLocationsQueue tester = new PossibleLocationsQueue(); //creates queue with default capacity
			Location add1 = new Location(55, 78);
			Location add2 = new Location(1, 2);
			Location add3 = new Location(4, 6);
			//adds in 3 location objects
			tester.add(add1);
			tester.add(add2);
			tester.add(add3);
			assertFalse("Should return false.", tester.isEmpty()); //queue has a size of 3
		} catch (Exception e) {
			fail("testIsEmptyWithEmptyList failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	public void testIsEmptyWithNullObject() {
		try {
			PossibleLocationsQueue tester = new PossibleLocationsQueue(); //creates queue with default capacity
			Location add1 = null;
			//adds in null location object
			tester.add(add1);
			//since object is null, queue is still empty
			assertTrue("Should return true", tester.isEmpty());
		} catch (Exception e) {
			fail("testIsEmptyWithNullObject failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	/********** TESTS FOR MAKELARGER **********/
	
	public void testMakeLargerWithDefaultCapacity() {
		try {
			PossibleLocationsQueue tester = new PossibleLocationsQueue(); //creates queue with default capacity
			addLocationElements(tester);
			//once size == capacity, capacity should double -> 5*2 = 10
			//indirectly test capacity to see if it doubled
			assertFalse("The queue should not be empty.", tester.isEmpty());
		} catch (Exception e) {
			fail("testMakeLarger failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	public void testMakeLargerWithUserCapacity() {
		try {
			PossibleLocationsQueue tester = new PossibleLocationsQueue(3); //creates queue with capacity == 3
			Location add1 = new Location(5, 8);
			Location add2 = new Location(3, 2);
			Location add3 = new Location(4, 19);
			//adds all 3 location objects
			tester.add(add1);
			tester.add(add2);
			tester.add(add3);
			//once size == capacity, capacity should double -> 3*2 = 6
			assertFalse("The queue should not be empty.", tester.isEmpty());
		} catch (Exception e) {
			fail("testMakeLarger failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	/********** ADDITIONAL TEST **********/
	
	//adds location elements 
	//should invoke makeLarger method if number of elements added > capacity
	//assuming default capacity is less than or equal to 10
	public void addLocationElements(PossibleLocationsQueue tester) {
		Location add1 = new Location (1, 2);
		Location add2 = new Location (2, 3);
		Location add3 = new Location (3, 4);
		Location add4 = new Location (4, 5);
		Location add5 = new Location (5, 6);
		Location add6 = new Location (6, 7);
		Location add7 = new Location (7, 8);
		Location add8 = new Location (8, 9);
		Location add9 = new Location (9, 10);
		Location add10 = new Location (10, 11);
		tester.add(add1);
		tester.add(add2);
		tester.add(add3);
		tester.add(add4);
		tester.add(add5);
		tester.add(add6);
		tester.add(add7);
		tester.add(add8);
		tester.add(add9);
		tester.add(add10);
	}
}
	
