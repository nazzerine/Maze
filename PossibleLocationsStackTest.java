package project3;

/**
 * This class tests the PossibleLocationsStack class.
 * @author Nazzerine Waldon
 *
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class PossibleLocationsStackTest {

	//condensed test method for add and remove
	@Test
	public void testAddAndRemove() {
		testAddAndRemoveFromEmptyArray();
		testAddAndRemoveFromOneElementArray();
		testAddAndRemoveFromMultipleElementArray();
	}
	
	//condensed test method for isEmpty
	@Test
	public void testIsEmpty() {
		testIsEmptyWithEmptyArray();
		testIsEmptyWithOneElementArray();
		testIsEmptyWithMultipleElementArray();
		testIsEmptyWithNullObject();
	}

	//tests multiple methods
	@Test
	public void testSpecialCase1() {
		try {
			PossibleLocationsStack tester = new PossibleLocationsStack();
			Location add1 = new Location (105,6);
			Location add2 = new Location (4,4);
			//adds two location objects to stack
			tester.add(add1);
			tester.add(add2);
			assertEquals("Should remove (4,4) from the stack.", add2, tester.remove());	//removes last in (LIFO)
			assertFalse("Should return false.", tester.isEmpty()); //one object is left in stack so size != 0
		} catch (Exception e) {
			fail("testSpecialCase1 failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	//tests multiple methods
	@Test
	public void testSpecialCase2() {
		try {
			PossibleLocationsStack tester = new PossibleLocationsStack();
			Location add1 = new Location (73,63);
			Location add2 = new Location (8, 3);
			Location add3 = new Location (1,2);
			//adds three location objects to stack
			tester.add(add1);
			tester.add(add2);
			tester.add(add3);
			assertFalse("Should return false.", tester.isEmpty()); // size != 0
			assertEquals("Should remove (1,2) from the stack.", add3, tester.remove());	//removes last in (LIFO)
			assertFalse("Should return false.", tester.isEmpty()); //size still != 0
		} catch (Exception e) {
			fail("testSpecialCase2 failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	//tests multiple methods
	@Test
	public void testSpecialCase3() {
		try {
			PossibleLocationsStack tester = new PossibleLocationsStack();
			Location add1 = null;
			Location add2 = new Location (8, 3);
			//adds three location objects to stack
			tester.add(add1);
			tester.add(add2);
			assertFalse("Should return false.", tester.isEmpty()); //size == 1 
			assertEquals("Should remove (1,2) from the stack.", add2, tester.remove());	//removes last in (LIFO)
			assertTrue("Should return true", tester.isEmpty());  //size == 0 since add1 == null
		} catch (Exception e) {
			fail("testSpecialCase2 failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	/********** TESTS FOR ADD AND REMOVE **********/
	
	public void testAddAndRemoveFromEmptyArray() {
		try {
			PossibleLocationsStack tester = new PossibleLocationsStack();
			//should return null since there is nothing to remove
			assertNull("Should return null.", tester.remove());
		} catch (Exception e) {
			fail("testAddAndRemoveFromOneEmptyArray failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	public void testAddAndRemoveFromOneElementArray() {
		try {
			Location add1 = new Location(1,2);
			PossibleLocationsStack tester = new PossibleLocationsStack();
			//adds one location object to the stack
			tester.add(add1);
			assertEquals("Should remove (1,2) from the stack.", add1 , tester.remove()); //removes the only object in the stack
		} catch (Exception e) {
			fail("testAddAndRemoveFromOneElementArray failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	
	public void testAddAndRemoveFromMultipleElementArray() {
		try {
			PossibleLocationsStack tester = new PossibleLocationsStack();
			Location add1 = new Location (5,6);
			Location add2 = new Location (3,4);
			Location add3 = new Location (7,4);
			//adds 3 location objects to stack
			tester.add(add1);
			tester.add(add2);
			tester.add(add3);
			assertEquals("Should remove (7,4) from the stack.", add3, tester.remove()); //removes object on top of the stack
		} catch (Exception e) {
			fail("testAddAndRemoveFromMultipleElementArray failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	/********** TEST FOR ISEMPTY **********/
	
	public void testIsEmptyWithEmptyArray() {
		try {
			PossibleLocationsStack tester = new PossibleLocationsStack();
			//nothing added to the stack
			assertTrue("Should return true", tester.isEmpty());  //size == 0, therefore stack is empty
		} catch (Exception e) {
			fail("testIsEmptyWithEmptyArray failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	
	public void testIsEmptyWithOneElementArray() {
		try {
			PossibleLocationsStack tester = new PossibleLocationsStack();
			Location add1 = new Location (12,6);
			//adds one object to stack
			tester.add(add1);
			assertFalse("Should return false.", tester.isEmpty()); //size == 1 -> not empty
		} catch (Exception e) {
			fail("testIsEmptyWithOneElementArray failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	
	public void testIsEmptyWithMultipleElementArray() {
		try {
			PossibleLocationsStack tester = new PossibleLocationsStack();
			Location add1 = new Location (5,6);
			Location add2 = new Location (4,6);
			Location add3 = new Location (78,20);
			Location add4 = new Location (2, 3);
			//adds 4 objects to the stack
			tester.add(add1);
			tester.add(add2);
			tester.add(add3);
			tester.add(add4);
			assertFalse("Should return false.", tester.isEmpty()); //size == 4 -> not empty
		} catch (Exception e) {
			fail("testIsEmptyWithOneElementArray failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	public void testIsEmptyWithNullObject() {
		try {
			PossibleLocationsStack tester = new PossibleLocationsStack();
			Location add1 = null;
			//adds null location object to the stack
			tester.add(add1);
			assertTrue("Should return true", tester.isEmpty()); //null object does not get added to the stack -> size == 0
		} catch (Exception e) {
			fail("testIsEmptyWithOneElementArray failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	
}
