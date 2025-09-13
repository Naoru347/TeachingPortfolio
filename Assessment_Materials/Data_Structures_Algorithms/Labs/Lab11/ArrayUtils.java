import java.util.Arrays;
import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;

/**
 * Utility class providing helper methods for array operations in Lab 11.
 * 
 * This class contains static methods for generating test data, manipulating arrays,
 * and displaying results. These utilities support the sorting algorithm implementations
 * and performance testing.
 * 
 * All methods are static - no need to create ArrayUtils objects.
 * 
 * @author Lab 11 Framework
 * @version 1.0
 */
public class ArrayUtils {
    
    // Random number generator with fixed seed for reproducible results
    private static final Random random = new Random(42);
    
    // =============================================================================
    // ARRAY GENERATION METHODS
    // =============================================================================
    
    /**
     * Generates an array of random integers.
     * 
     * @param size the size of array to generate
     * @param maxValue the maximum value for random numbers (0 to maxValue-1)
     * @return array of random integers
     */
    public static int[] generateRandomArray(int size, int maxValue) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValue);
        }
        return array;
    }
    
    /**
     * Generates an array of random integers with default max value.
     * Max value is set to size * 10 for good distribution.
     * 
     * @param size the size of array to generate
     * @return array of random integers
     */
    public static int[] generateRandomArray(int size) {
        return generateRandomArray(size, Math.max(100, size * 10));
    }
    
    /**
     * Generates an array with values in ascending order.
     * 
     * @param size the size of array to generate
     * @return sorted array with values 1, 2, 3, ..., size
     */
    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        return array;
    }
    
    /**
     * Generates an array with values in descending order.
     * 
     * @param size the size of array to generate
     * @return reverse sorted array with values size, size-1, ..., 2, 1
     */
    public static int[] generateReverseSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }
    
    /**
     * Generates an array with many duplicate values.
     * Only uses about 10% of the range as unique values, creating many duplicates.
     * 
     * @param size the size of array to generate
     * @return array with many duplicate values
     */
    public static int[] generateDuplicateArray(int size) {
        int[] array = new int[size];
        int numUniqueValues = Math.max(1, size / 10); // 10% unique values
        
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(numUniqueValues) + 1;
        }
        return array;
    }
    
    /**
     * Generates a nearly sorted array with a few elements out of place.
     * Starts with sorted array and randomly swaps a small percentage of elements.
     * 
     * @param size the size of array to generate
     * @param swapPercentage percentage of elements to swap (0.0 to 1.0)
     * @return nearly sorted array
     */
    public static int[] generateNearlySortedArray(int size, double swapPercentage) {
        int[] array = generateSortedArray(size);
        int swapsToMake = (int) (size * swapPercentage);
        
        for (int i = 0; i < swapsToMake; i++) {
            int index1 = random.nextInt(size);
            int index2 = random.nextInt(size);
            swap(array, index1, index2);
        }
        
        return array;
    }
    
    /**
     * Generates a nearly sorted array with 5% of elements out of place.
     * 
     * @param size the size of array to generate
     * @return nearly sorted array
     */
    public static int[] generateNearlySortedArray(int size) {
        return generateNearlySortedArray(size, 0.05);
    }
    
    /**
     * Generates an array with all identical values.
     * 
     * @param size the size of array to generate
     * @param value the value to fill the array with
     * @return array with all elements equal to value
     */
    public static int[] generateUniformArray(int size, int value) {
        int[] array = new int[size];
        Arrays.fill(array, value);
        return array;
    }
    
    // =============================================================================
    // ARRAY MANIPULATION METHODS
    // =============================================================================
    
    /**
     * Creates a deep copy of an array.
     * 
     * @param array the array to copy
     * @return new array with same values
     */
    public static int[] copyArray(int[] array) {
        if (array == null) return null;
        return array.clone();
    }
    
    /**
     * Swaps two elements in an array.
     * 
     * @param array the array containing elements to swap
     * @param i index of first element
     * @param j index of second element
     */
    public static void swap(int[] array, int i, int j) {
        if (array == null || i < 0 || j < 0 || i >= array.length || j >= array.length) {
            return; // Invalid indices, do nothing
        }
        
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    /**
     * Shuffles an array randomly using Fisher-Yates shuffle algorithm.
     * 
     * @param array the array to shuffle (modified in place)
     */
    public static void shuffleArray(int[] array) {
        if (array == null) return;
        
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swap(array, i, j);
        }
    }
    
    /**
     * Reverses an array in place.
     * 
     * @param array the array to reverse
     */
    public static void reverseArray(int[] array) {
        if (array == null) return;
        
        int left = 0;
        int right = array.length - 1;
        
        while (left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }
    
    /**
     * Fills an array with a specific value.
     * 
     * @param array the array to fill
     * @param value the value to fill with
     */
    public static void fillArray(int[] array, int value) {
        if (array == null) return;
        Arrays.fill(array, value);
    }
    
    // =============================================================================
    // ARRAY VALIDATION AND CHECKING METHODS
    // =============================================================================
    
    /**
     * Checks if an array is sorted in ascending order.
     * 
     * @param array the array to check
     * @return true if array is sorted, false otherwise
     */
    public static boolean isSorted(int[] array) {
        if (array == null || array.length <= 1) {
            return true;
        }
        
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Checks if an array is sorted in descending order.
     * 
     * @param array the array to check
     * @return true if array is reverse sorted, false otherwise
     */
    public static boolean isReverseSorted(int[] array) {
        if (array == null || array.length <= 1) {
            return true;
        }
        
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Compares two arrays for equality.
     * 
     * @param array1 first array
     * @param array2 second array
     * @return true if arrays have same elements in same order
     */
    public static boolean arraysEqual(int[] array1, int[] array2) {
        return Arrays.equals(array1, array2);
    }
    
    /**
     * Finds the minimum value in an array.
     * 
     * @param array the array to search
     * @return minimum value, or Integer.MAX_VALUE if array is null or empty
     */
    public static int findMin(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MAX_VALUE;
        }
        
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
    
    /**
     * Finds the maximum value in an array.
     * 
     * @param array the array to search
     * @return maximum value, or Integer.MIN_VALUE if array is null or empty
     */
    public static int findMax(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MIN_VALUE;
        }
        
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    
    /**
     * Counts the number of duplicate values in an array.
     * 
     * @param array the array to analyze
     * @return number of elements that appear more than once
     */
    public static int countDuplicates(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }
        
        int duplicates = 0;
        Arrays.sort(copyArray(array)); // Sort a copy to group duplicates
        
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                duplicates++;
                // Skip over all instances of this duplicate
                while (i < array.length - 1 && array[i] == array[i + 1]) {
                    i++;
                }
            }
        }
        
        return duplicates;
    }
    
    // =============================================================================
    // ARRAY DISPLAY AND OUTPUT METHODS
    // =============================================================================
    
    /**
     * Prints an array with a descriptive label.
     * 
     * @param array the array to print
     * @param label descriptive label for the array
     */
    public static void printArray(int[] array, String label) {
        if (array == null) {
            System.out.println(label + ": null");
            return;
        }
        
        System.out.print(label + ": [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    /**
     * Prints an array without a label.
     * 
     * @param array the array to print
     */
    public static void printArray(int[] array) {
        printArray(array, "Array");
    }
    
    /**
     * Prints first n elements of an array (useful for large arrays).
     * 
     * @param array the array to print
     * @param label descriptive label
     * @param n number of elements to show
     */
    public static void printArrayPartial(int[] array, String label, int n) {
        if (array == null) {
            System.out.println(label + ": null");
            return;
        }
        
        int elementsToShow = Math.min(n, array.length);
        System.out.print(label + " (first " + elementsToShow + "): [");
        
        for (int i = 0; i < elementsToShow; i++) {
            System.out.print(array[i]);
            if (i < elementsToShow - 1) {
                System.out.print(", ");
            }
        }
        
        if (array.length > n) {
            System.out.print(", ... (" + (array.length - n) + " more)");
        }
        
        System.out.println("]");
    }
    
    /**
     * Returns a string representation of an array.
     * 
     * @param array the array to convert
     * @return string representation of the array
     */
    public static String arrayToString(int[] array) {
        if (array == null) {
            return "null";
        }
        return Arrays.toString(array);
    }
    
    /**
     * Prints array statistics (size, min, max, sorted status).
     * 
     * @param array the array to analyze
     * @param label descriptive label
     */
    public static void printArrayStats(int[] array, String label) {
        if (array == null) {
            System.out.println(label + " Statistics: null array");
            return;
        }
        
        System.out.println(label + " Statistics:");
        System.out.println("  Size: " + array.length);
        if (array.length > 0) {
            System.out.println("  Min: " + findMin(array));
            System.out.println("  Max: " + findMax(array));
            System.out.println("  Sorted: " + (isSorted(array) ? "Yes" : "No"));
            System.out.println("  Reverse sorted: " + (isReverseSorted(array) ? "Yes" : "No"));
            System.out.println("  Duplicates: " + countDuplicates(array));
        }
        System.out.println();
    }
    
    // =============================================================================
    // UTILITY METHODS FOR TESTING
    // =============================================================================
    
    /**
     * Generates a test suite of arrays with different characteristics.
     * Useful for comprehensive testing of sorting algorithms.
     * 
     * @param size the size of arrays to generate
     * @return array of test arrays with different properties
     */
    public static int[][] generateTestSuite(int size) {
        return new int[][] {
            generateRandomArray(size),
            generateSortedArray(size),
            generateReverseSortedArray(size),
            generateDuplicateArray(size),
            generateNearlySortedArray(size),
            generateUniformArray(size, 42),
            new int[]{},  // empty array
            new int[]{5}  // single element
        };
    }
    
    /**
     * Returns descriptive names for the test suite arrays.
     * 
     * @return array of names corresponding to generateTestSuite arrays
     */
    public static String[] getTestSuiteNames() {
        return new String[] {
            "Random Array",
            "Sorted Array", 
            "Reverse Sorted Array",
            "Array with Duplicates",
            "Nearly Sorted Array",
            "Uniform Array (all same)",
            "Empty Array",
            "Single Element Array"
        };
    }
    
    /**
     * Measures approximate memory usage of an integer array.
     * 
     * @param array the array to measure
     * @return estimated memory usage in bytes
     */
    public static long estimateMemoryUsage(int[] array) {
        if (array == null) return 0;
        
        // Each int is 4 bytes, plus object overhead
        return array.length * 4 + 16; // 16 bytes estimated object overhead
    }
    
    /**
     * Creates multiple copies of an array for testing.
     * Useful when you need to test multiple algorithms on identical data.
     * 
     * @param original the array to copy
     * @param numCopies number of copies to create
     * @return array of array copies
     */
    public static int[][] createMultipleCopies(int[] original, int numCopies) {
        if (original == null) return null;
        
        int[][] copies = new int[numCopies][];
        for (int i = 0; i < numCopies; i++) {
            copies[i] = copyArray(original);
        }
        return copies;
    }
    
    // =============================================================================
    // DEMONSTRATION METHOD
    // =============================================================================
    
    /**
     * Demonstration method showing various ArrayUtils capabilities.
     * Run this to see examples of what the utility methods can do.
     */
    public static void main(String[] args) {
        System.out.println("ArrayUtils Demonstration");
        System.out.println("========================");
        System.out.println();
        
        // Generate different types of arrays
        System.out.println("--- Array Generation Examples ---");
        printArray(generateRandomArray(10), "Random Array (size 10)");
        printArray(generateSortedArray(8), "Sorted Array (size 8)");
        printArray(generateReverseSortedArray(6), "Reverse Sorted Array (size 6)");
        printArray(generateDuplicateArray(12), "Array with Duplicates (size 12)");
        printArray(generateNearlySortedArray(10), "Nearly Sorted Array (size 10)");
        printArray(generateUniformArray(7, 42), "Uniform Array (all 42s, size 7)");
        System.out.println();
        
        // Array analysis
        System.out.println("--- Array Analysis Examples ---");
        int[] testArray = {5, 2, 8, 1, 9, 3};
        printArrayStats(testArray, "Test Array");
        
        System.out.println("Is sorted? " + isSorted(testArray));
        Arrays.sort(testArray);
        printArray(testArray, "After sorting");
        System.out.println("Is sorted? " + isSorted(testArray));
        System.out.println();
        
        // Array manipulation
        System.out.println("--- Array Manipulation Examples ---");
        int[] manipulateArray = {1, 2, 3, 4, 5};
        printArray(manipulateArray, "Original");
        
        shuffleArray(manipulateArray);
        printArray(manipulateArray, "After shuffle");
        
        reverseArray(manipulateArray);
        printArray(manipulateArray, "After reverse");
        
        System.out.println("\nArrayUtils demonstration complete!");
    }
}