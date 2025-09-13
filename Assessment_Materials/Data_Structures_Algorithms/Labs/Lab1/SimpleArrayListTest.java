import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the SimpleArrayList implementation.
 * These tests verify that the implementation correctly follows the SimpleList contract.
 * 
 * @author [Your Name Here]
 * @version Lab 1
 */
public class SimpleArrayListTest {
    
    private SimpleArrayList<String> stringList;
    private SimpleArrayList<Integer> intList;
    
    /**
     * Set up test fixtures before each test method.
     * This method runs before every individual test.
     */
    @BeforeEach
    public void setUp() {
        stringList = new SimpleArrayList<>();
        intList = new SimpleArrayList<>();
    }
    
    /**
     * Test that a new list is initially empty.
     */
    @Test
    public void testNewListIsEmpty() {
        // TODO: Test that size() returns 0
        // TODO: Test that isEmpty() returns true
        
        // Example assertions:
        // assertEquals(0, stringList.size());
        // assertTrue(stringList.isEmpty());
    }
    
    /**
     * Test adding a single element to the list.
     */
    @Test
    public void testAddSingleElement() {
        // TODO: Add one element to stringList
        // TODO: Verify size is 1
        // TODO: Verify isEmpty() returns false
        // TODO: Verify get(0) returns the added element
        
        // Example:
        // stringList.add("Hello");
        // assertEquals(1, stringList.size());
        // assertFalse(stringList.isEmpty());
        // assertEquals("Hello", stringList.get(0));
    }
    
    /**
     * Test adding multiple elements to the list.
     */
    @Test
    public void testAddMultipleElements() {
        // TODO: Add several elements to intList
        // TODO: Verify size is correct
        // TODO: Verify each element can be retrieved with get()
        
        // Hint: Add at least 3 different integers and verify each one
    }
    
    /**
     * Test that get() throws exception for invalid indices.
     */
    @Test
    public void testGetWithInvalidIndex() {
        // TODO: Test that get(-1) throws IndexOutOfBoundsException
        // TODO: Test that get(0) throws IndexOutOfBoundsException on empty list
        // TODO: Add some elements, then test get(size) throws exception
        
        // Example:
        // assertThrows(IndexOutOfBoundsException.class, () -> {
        //     stringList.get(-1);
        // });
    }
    
    /**
     * Test that the list automatically resizes when capacity is exceeded.
     * This test adds more than the default capacity (10) elements.
     */
    @Test
    public void testDynamicResizing() {
        // TODO: Add more than 10 elements to trigger resizing
        // TODO: Verify all elements are still accessible
        // TODO: Verify size is correct
        
        // Example approach:
        // for (int i = 0; i < 15; i++) {
        //     intList.add(i);
        // }
        // assertEquals(15, intList.size());
        // for (int i = 0; i < 15; i++) {
        //     assertEquals(Integer.valueOf(i), intList.get(i));
        // }
    }
    
    /**
     * Test the toString() method for debugging output.
     */
    @Test
    public void testToString() {
        // TODO: Test toString() on empty list
        // TODO: Add elements and test toString() shows them correctly
        
        // assertEquals("[]", stringList.toString());
        // stringList.add("A");
        // stringList.add("B");
        // assertEquals("[A, B]", stringList.toString());
    }
    
    /**
     * Test that the list can handle null elements.
     */
    @Test
    public void testNullElements() {
        // TODO: Add null to the list
        // TODO: Verify it can be retrieved
        // TODO: Verify size is still correct
        
        // stringList.add(null);
        // assertEquals(1, stringList.size());
        // assertNull(stringList.get(0));
    }
    
    /**
     * Test the alternative constructor with custom initial capacity.
     */
    @Test
    public void testCustomCapacityConstructor() {
        // TODO: Create a new SimpleArrayList with capacity 5
        // TODO: Add 6 elements to trigger resizing
        // TODO: Verify all elements are accessible
        
        // SimpleArrayList<String> customList = new SimpleArrayList<>(5);
        // (Add your test implementation here)
    }
}