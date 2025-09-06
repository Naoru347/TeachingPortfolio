/**
 * RecursionStarter - Lab 5 Starter Code
 * 
 * This file provides skeleton implementations for classic recursive algorithms.
 * Students will complete the TODOs to implement fundamental recursive patterns
 * and divide-and-conquer techniques.
 * 
 * @author CSC 220 Teaching Team
 * @version Lab 5 - Fall 2025
 */

public class RecursionStarter {
    
    // =============================================================================
    // Basic Recursive Algorithms
    // =============================================================================
    
    /**
     * TODO: Calculate base^exponent using recursion
     * 
     * Examples:
     * power(2, 3) = 8
     * power(5, 0) = 1
     * power(3, 4) = 81
     * 
     * Time Complexity: O(exponent)
     * Space Complexity: O(exponent) due to call stack
     * 
     * @param base the base number
     * @param exponent the exponent (assume non-negative)
     * @return base raised to the power of exponent
     */
    public static long power(int base, int exponent) {
        // TODO: Identify base case(s)
        // HINT: What is any number to the power of 0?
        // HINT: What about base^1?
        
        // TODO: Identify recursive case
        // HINT: base^n = base * base^(n-1)
        
        // BASE CASE:
        // if (exponent == 0) {
        //     return 1;
        // }
        
        // RECURSIVE CASE:
        // return base * power(base, exponent - 1);
        
        return 0; // Placeholder - remove this line
    }
    
    /**
     * TODO: Reverse a string using recursion
     * 
     * Examples:
     * reverse("hello") = "olleh"
     * reverse("a") = "a"
     * reverse("") = ""
     * 
     * Time Complexity: O(n) where n is string length
     * Space Complexity: O(n) due to call stack and string creation
     * 
     * @param str the string to reverse
     * @return the reversed string
     */
    public static String reverse(String str) {
        // TODO: Base case - what's the smallest string you can reverse?
        // HINT: Empty string or single character
        
        // TODO: Recursive case - how do you break down the problem?
        // HINT: reverse("hello") = reverse("ello") + "h"
        // HINT: Use str.substring(1) to get all but first character
        // HINT: Use str.charAt(0) to get first character
        
        // BASE CASE:
        // if (str.length() <= 1) {
        //     return str;
        // }
        
        // RECURSIVE CASE:
        // return reverse(str.substring(1)) + str.charAt(0);
        
        return ""; // Placeholder - remove this line
    }
    
    /**
     * TODO: Check if a string is a palindrome using recursion
     * 
     * Examples:
     * isPalindrome("racecar") = true
     * isPalindrome("hello") = false
     * isPalindrome("a") = true
     * isPalindrome("") = true
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n) due to call stack
     * 
     * @param str the string to check
     * @return true if the string is a palindrome
     */
    public static boolean isPalindrome(String str) {
        // TODO: Base cases - when is a string definitely a palindrome?
        // HINT: Empty string? Single character?
        
        // TODO: Recursive case - compare first and last characters
        // HINT: If first == last, check the middle part recursively
        // HINT: Use str.substring(1, str.length()-1) for middle part
        
        // BASE CASES:
        // if (str.length() <= 1) {
        //     return true;
        // }
        
        // RECURSIVE CASE:
        // if (str.charAt(0) == str.charAt(str.length() - 1)) {
        //     return isPalindrome(str.substring(1, str.length() - 1));
        // } else {
        //     return false;
        // }
        
        return false; // Placeholder - remove this line
    }
    
    /**
     * TODO: Calculate the sum of digits in a number using recursion
     * 
     * Examples:
     * sumOfDigits(123) = 6  (1 + 2 + 3)
     * sumOfDigits(9) = 9
     * sumOfDigits(0) = 0
     * 
     * @param n the number (assume non-negative)
     * @return sum of all digits
     */
    public static int sumOfDigits(int n) {
        // TODO: Base case - single digit number
        // HINT: When n < 10, what should you return?
        
        // TODO: Recursive case - break off last digit
        // HINT: n % 10 gives last digit
        // HINT: n / 10 gives remaining digits
        
        return 0; // Placeholder
    }
    
    /**
     * TODO: Calculate nth Fibonacci number using recursion
     * 
     * WARNING: This is an inefficient implementation for demonstration!
     * Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21...
     * 
     * Examples:
     * fibonacci(0) = 0
     * fibonacci(1) = 1
     * fibonacci(5) = 5
     * fibonacci(10) = 55
     * 
     * Time Complexity: O(2^n) - exponential! Very slow for large n
     * Space Complexity: O(n) due to call stack depth
     * 
     * @param n the position in Fibonacci sequence
     * @return the nth Fibonacci number
     */
    public static int fibonacci(int n) {
        // TODO: Base cases - first two Fibonacci numbers
        // HINT: fib(0) = 0, fib(1) = 1
        
        // TODO: Recursive case
        // HINT: fib(n) = fib(n-1) + fib(n-2)
        
        return 0; // Placeholder
    }
    
    // =============================================================================
    // Array and List Recursive Algorithms
    // =============================================================================
    
    /**
     * TODO: Find the maximum element in an array using recursion
     * 
     * Examples:
     * findMax([3, 1, 4, 1, 5], 0) = 5
     * findMax([42], 0) = 42
     * 
     * @param arr the array to search
     * @param index current index (start with 0)
     * @return the maximum element
     */
    public static int findMax(int[] arr, int index) {
        // TODO: Base case - last element
        // HINT: When index == arr.length - 1
        
        // TODO: Recursive case - compare current with max of rest
        // HINT: Math.max(arr[index], findMax(arr, index + 1))
        
        return 0; // Placeholder
    }
    
    /**
     * TODO: Calculate sum of array elements using recursion
     * 
     * @param arr the array
     * @param index starting index (use 0)
     * @return sum of all elements
     */
    public static int sumArray(int[] arr, int index) {
        // TODO: Base case - past end of array
        // TODO: Recursive case - current element + sum of rest
        
        return 0; // Placeholder
    }
    
    /**
     * TODO: Count occurrences of a target value in array using recursion
     * 
     * @param arr the array
     * @param target the value to count
     * @param index starting index (use 0)
     * @return number of occurrences
     */
    public static int countOccurrences(int[] arr, int target, int index) {
        // TODO: Base case - past end of array
        // TODO: Recursive case - check current element and recurse
        
        return 0; // Placeholder
    }
    
    // =============================================================================
    // Divide-and-Conquer Algorithms
    // =============================================================================
    
    /**
     * TODO: Implement recursive binary search
     * 
     * Precondition: Array must be sorted
     * 
     * Examples:
     * binarySearch([1, 3, 5, 7, 9], 5, 0, 4) = 2
     * binarySearch([1, 3, 5, 7, 9], 6, 0, 4) = -1
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(log n) due to call stack
     * 
     * @param arr the sorted array to search
     * @param target the value to find
     * @param left left boundary (inclusive)
     * @param right right boundary (inclusive)
     * @return index of target, or -1 if not found
     */
    public static int binarySearch(int[] arr, int target, int left, int right) {
        // TODO: Base case - invalid range
        // HINT: When left > right, element not found
        
        // TODO: Calculate middle index
        // HINT: int mid = left + (right - left) / 2;
        // IMPORTANT: Don't use (left + right) / 2 - can cause overflow!
        
        // TODO: Check middle element
        // TODO: If found, return index
        // TODO: If target < middle, search left half
        // TODO: If target > middle, search right half
        
        // BASE CASE:
        // if (left > right) {
        //     return -1;  // Not found
        // }
        
        // DIVIDE:
        // int mid = left + (right - left) / 2;
        
        // CONQUER:
        // if (arr[mid] == target) {
        //     return mid;  // Found!
        // } else if (target < arr[mid]) {
        //     return binarySearch(arr, target, left, mid - 1);  // Search left
        // } else {
        //     return binarySearch(arr, target, mid + 1, right);  // Search right
        // }
        
        return -1; // Placeholder - remove this line
    }
    
    /**
     * Convenience method for binary search - calls recursive version
     */
    public static int binarySearch(int[] arr, int target) {
        return binarySearch(arr, target, 0, arr.length - 1);
    }
    
    /**
     * TODO: Implement recursive merge sort
     * 
     * This is a classic divide-and-conquer algorithm:
     * - Divide: Split array in half
     * - Conquer: Recursively sort both halves
     * - Combine: Merge the sorted halves
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(n) for temporary arrays in merge
     * 
     * @param arr the array to sort
     * @param left left boundary (inclusive)
     * @param right right boundary (inclusive)
     */
    public static void mergeSort(int[] arr, int left, int right) {
        // TODO: Base case - when is array small enough to stop dividing?
        // HINT: When left >= right, subarray has 0 or 1 elements
        
        if (left < right) {
            // TODO: Divide - find middle point
            // HINT: int mid = left + (right - left) / 2;
            
            // TODO: Conquer - recursively sort both halves
            // HINT: mergeSort(arr, left, mid);
            // HINT: mergeSort(arr, mid + 1, right);
            
            // TODO: Combine - merge the sorted halves
            // HINT: merge(arr, left, mid, right);
            
            // DIVIDE:
            // int mid = left + (right - left) / 2;
            
            // CONQUER:
            // mergeSort(arr, left, mid);        // Sort left half
            // mergeSort(arr, mid + 1, right);   // Sort right half
            
            // COMBINE:
            // merge(arr, left, mid, right);     // Merge sorted halves
        }
    }
    
    /**
     * Convenience method for merge sort - calls recursive version
     */
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }
    
    /**
     * Helper method to merge two sorted subarrays
     * Left subarray: arr[left...mid]
     * Right subarray: arr[mid+1...right]
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        // Create temporary arrays for the two subarrays
        int[] leftArray = new int[mid - left + 1];
        int[] rightArray = new int[right - mid];
        
        // Copy data to temporary arrays
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < rightArray.length; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }
        
        // Merge the temporary arrays back into arr[left...right]
        int i = 0, j = 0, k = left;
        
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements
        while (i < leftArray.length) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightArray.length) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
    
    /**
     * TODO: Calculate the height of a binary tree (preview for Lab 6!)
     * 
     * This demonstrates tree recursion where we make multiple recursive calls
     * 
     * @param node the current node (null represents empty tree)
     * @return height of the tree (0 for empty tree, 1 for single node)
     */
    public static int treeHeight(TreeNode node) {
        // TODO: Base case - empty tree
        // HINT: null node has height 0
        
        // TODO: Recursive case - height is 1 + max of subtree heights
        // HINT: Math.max(treeHeight(node.left), treeHeight(node.right)) + 1
        
        return 0; // Placeholder
    }
    
    // =============================================================================
    // Advanced Recursive Patterns
    // =============================================================================
    
    /**
     * TODO: Generate all permutations of a string using backtracking
     * 
     * This demonstrates backtracking - a recursive technique for exploring
     * all possible solutions
     * 
     * Example: permutations("ABC") = ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
     * 
     * @param str the string to permute
     * @return array of all permutations
     */
    public static java.util.List<String> permutations(String str) {
        java.util.List<String> result = new java.util.ArrayList<>();
        permuteHelper(str.toCharArray(), 0, result);
        return result;
    }
    
    /**
     * Helper method for permutations using backtracking
     */
    private static void permuteHelper(char[] chars, int index, java.util.List<String> result) {
        // TODO: Base case - when we've placed all characters
        // HINT: When index == chars.length, we have a complete permutation
        
        // TODO: Recursive case - try each remaining character in current position
        // HINT: Swap characters, recurse, then swap back (backtrack)
        
        // if (index == chars.length) {
        //     result.add(new String(chars));
        //     return;
        // }
        // 
        // for (int i = index; i < chars.length; i++) {
        //     // Choose: swap current character to index position
        //     swap(chars, index, i);
        //     
        //     // Explore: recurse with next position
        //     permuteHelper(chars, index + 1, result);
        //     
        //     // Unchoose: swap back (backtrack)
        //     swap(chars, index, i);
        // }
    }
    
    /**
     * Helper method to swap characters in array
     */
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    
    /**
     * TODO: Solve Tower of Hanoi puzzle recursively
     * 
     * Rules:
     * - Move all disks from source peg to destination peg
     * - Only move one disk at a time
     * - Never place larger disk on smaller disk
     * 
     * @param n number of disks
     * @param source source peg name
     * @param destination destination peg name  
     * @param auxiliary auxiliary peg name
     */
    public static void hanoi(int n, String source, String destination, String auxiliary) {
        // TODO: Base case - single disk
        // HINT: Just move the disk directly
        
        // TODO: Recursive case for n disks:
        // 1. Move n-1 disks from source to auxiliary (using destination)
        // 2. Move bottom disk from source to destination
        // 3. Move n-1 disks from auxiliary to destination (using source)
        
        // if (n == 1) {
        //     System.out.println("Move disk 1 from " + source + " to " + destination);
        //     return;
        // }
        // 
        // hanoi(n - 1, source, auxiliary, destination);
        // System.out.println("Move disk " + n + " from " + source + " to " + destination);
        // hanoi(n - 1, auxiliary, destination, source);
    }
    
    // =============================================================================
    // Tail Recursion Examples
    // =============================================================================
    
    /**
     * TODO: Tail-recursive factorial using accumulator
     * 
     * Tail recursion can be optimized by compilers to avoid stack overflow
     * 
     * @param n the number
     * @param accumulator running product (start with 1)
     * @return factorial of n
     */
    public static long factorialTail(int n, long accumulator) {
        // TODO: Base case - return accumulator
        // TODO: Recursive case - update accumulator and recurse
        
        // if (n <= 1) {
        //     return accumulator;
        // }
        // return factorialTail(n - 1, n * accumulator);
        
        return 0; // Placeholder
    }
    
    /**
     * Convenience method for tail-recursive factorial
     */
    public static long factorialTail(int n) {
        return factorialTail(n, 1);
    }
    
    /**
     * TODO: Tail-recursive sum using accumulator
     */
    public static int sumTail(int n, int accumulator) {
        // TODO: Convert regular sum to tail-recursive form
        
        return 0; // Placeholder
    }
    
    // =============================================================================
    // Helper Classes (for tree example)
    // =============================================================================
    
    /**
     * Simple tree node class for tree height example
     */
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    // =============================================================================
    // Call Stack Visualization Helpers
    // =============================================================================
    
    /**
     * Factorial with debug prints to show call stack
     */
    public static int factorialDebug(int n, int depth) {
        // Print indentation based on recursion depth
        String indent = "  ".repeat(depth);
        System.out.println(indent + "factorialDebug(" + n + ") called");
        
        if (n <= 1) {
            System.out.println(indent + "Base case reached, returning 1");
            return 1;
        }
        
        System.out.println(indent + "Making recursive call: factorialDebug(" + (n-1) + ")");
        int result = n * factorialDebug(n - 1, depth + 1);
        System.out.println(indent + "Returning " + n + " * " + (result/n) + " = " + result);
        
        return result;
    }
    
    /**
     * Binary search with debug prints
     */
    public static int binarySearchDebug(int[] arr, int target, int left, int right, int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(indent + "binarySearch(target=" + target + ", left=" + left + ", right=" + right + ")");
        
        if (left > right) {
            System.out.println(indent + "Base case: left > right, returning -1");
            return -1;
        }
        
        int mid = left + (right - left) / 2;
        System.out.println(indent + "Mid index: " + mid + ", value: " + arr[mid]);
        
        if (arr[mid] == target) {
            System.out.println(indent + "Found target at index " + mid);
            return mid;
        } else if (target < arr[mid]) {
            System.out.println(indent + "Target < mid, searching left half");
            return binarySearchDebug(arr, target, left, mid - 1, depth + 1);
        } else {
            System.out.println(indent + "Target > mid, searching right half");
            return binarySearchDebug(arr, target, mid + 1, right, depth + 1);
        }
    }
    
    // =============================================================================
    // Main Method for Testing
    // =============================================================================
    
    /**
     * Basic testing method - use RecursionTester for comprehensive tests
     */
    public static void main(String[] args) {
        System.out.println("CSC 220 Lab 5 - Recursive Algorithms");
        System.out.println("=====================================");
        
        // Test basic algorithms
        System.out.println("\n--- Testing Basic Recursive Algorithms ---");
        
        System.out.println("power(2, 3) = " + power(2, 3));
        System.out.println("reverse('hello') = '" + reverse("hello") + "'");
        System.out.println("isPalindrome('racecar') = " + isPalindrome("racecar"));
        System.out.println("sumOfDigits(123) = " + sumOfDigits(123));
        System.out.println("fibonacci(5) = " + fibonacci(5));
        
        // Test array algorithms
        System.out.println("\n--- Testing Array Algorithms ---");
        int[] testArray = {3, 1, 4, 1, 5, 9, 2, 6};
        System.out.println("Array: " + java.util.Arrays.toString(testArray));
        System.out.println("findMax = " + findMax(testArray, 0));
        System.out.println("sumArray = " + sumArray(testArray, 0));
        System.out.println("count 1's = " + countOccurrences(testArray, 1, 0));
        
        // Test divide-and-conquer
        System.out.println("\n--- Testing Divide-and-Conquer ---");
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13};
        System.out.println("Sorted array: " + java.util.Arrays.toString(sortedArray));
        System.out.println("binarySearch(7) = " + binarySearch(sortedArray, 7));
        System.out.println("binarySearch(6) = " + binarySearch(sortedArray, 6));
        
        int[] unsortedArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Before merge sort: " + java.util.Arrays.toString(unsortedArray));
        mergeSort(unsortedArray);
        System.out.println("After merge sort: " + java.util.Arrays.toString(unsortedArray));
        
        // Demonstrate call stack visualization
        System.out.println("\n--- Call Stack Visualization ---");
        System.out.println("Factorial(4) with debug output:");
        factorialDebug(4, 0);
        
        System.out.println("\nBinary search debug:");
        binarySearchDebug(sortedArray, 7, 0, sortedArray.length - 1, 0);
        
        // Test advanced algorithms
        System.out.println("\n--- Advanced Algorithms ---");
        System.out.println("Permutations of 'ABC': " + permutations("ABC"));
        
        System.out.println("\nTower of Hanoi for 3 disks:");
        hanoi(3, "A", "C", "B");
        
        System.out.println("\nTail recursive factorial(5) = " + factorialTail(5));
        
        System.out.println("\nBasic tests completed. Run RecursionTester for comprehensive testing.");
    }
}