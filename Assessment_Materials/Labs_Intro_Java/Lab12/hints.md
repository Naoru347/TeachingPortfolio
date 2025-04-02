# Hints for Students (Java Version)

As you give out hints, update `teacher_hint_log.xlsx` to track the number of hints provided to each student for the diminishing bonus. If a script is incomplete, mark with '0'.

---

## **Hints for Debugging: `BuggyCalculator.java`**

### **1. Syntax Error:**
- **Hint:** "Take a close look at how you're structuring your `if` statement for the operator. Does anything look missing at the end?"
- **Details:** One of the `if` or `else if` conditions may be missing braces `{}` or uses incorrect Java syntax.

### **2. Logic Error:**
- **Hint:** "What happens if the second number is 0 and the user chooses division? Can the program handle that gracefully?"
- **Details:** The program does not guard against division by zero, which will throw an `ArithmeticException` in Java.

### **3. Runtime Error:**
- **Hint:** "Check the function you're using to get user input. Does `imput` exist in Java or Python?"
- **Details:** There's a typo in the `Scanner` usage or a method call. It should be `scanner.nextDouble()` or `scanner.nextLine()` instead of a misspelled method.

---

## **Hints for Debugging: `BuggyGradeCalculator.java`**

### **1. Logical Error:**
- **Hint:** "Are you sure you're working with numbers and not text? Think about how the data is being parsed."
- **Details:** The grades are not being converted from `String` to `int` before being added to the total.

### **2. Runtime Error:**
- **Hint:** "What happens if the user types a letter instead of a number?"
- **Details:** `Integer.parseInt()` will throw a `NumberFormatException` if non-numeric input is entered. Consider wrapping it in a `try-catch` block.

### **3. Edge Case Bug:**
- **Hint:** "What happens if the user enters nothing or just hits enter?"
- **Details:** The input might be empty, which leads to a divide-by-zero error when calculating the average. Check if the input list has length > 0.

---

## **Hints for Debugging: `BuggyLibraryManager.java`**

### **1. Logic Error:**
- **Hint:** "Why does borrowing any book increase the count for *all* books?"
- **Details:** The code is looping over the entire `borrowCount` map instead of just updating the selected book.

### **2. Fixing Logic Error:**
- **Hint:** "Instead of using a loop to increment all borrow counts, can you target the one that was borrowed?"
- **Details:** Use `borrowCount.put(bookName, borrowCount.get(bookName) + 1);` directly.

### **3. Edge Case:**
- **Hint:** "Does the program check if the book name actually exists in the inventory before borrowing?"
- **Details:** There may not be a proper check or feedback for unavailable books or typos in the book name.

---

## **Hints for Debugging: `BuggyPasswordValidator.java`**

### **1. Logic Error:**
- **Hint:** "Think about the conditions you're checking: should all of them be true, or just one?"
- **Details:** The validation doesn't require all conditions to be met. Combine them using logical `&&` to ensure all are satisfied.

### **2. Runtime Error:**
- **Hint:** "What happens if the user enters an empty string?"
- **Details:** Calling `.indexOf("")` can return 0 even if the string is empty, causing a false positive.

### **3. Validation Bug:**
- **Hint:** "Are you printing the right error messages based on which conditions fail?"
- **Details:** The messages say what the password *must* contain even when those conditions are met. Consider inverting the logic.

---

## **Hints for Debugging: `BuggyShoppingCart.java`**

### **1. Logic Error (Item Removal):**
- **Hint:** "What happens if a user tries to remove an item that doesn’t exist in the cart?"
- **Details:** There is no check before removing an item, which can silently fail or confuse users.

### **2. UI Bug (Discount Message):**
- **Hint:** "If your program applies a discount, shouldn’t the user know?"
- **Details:** A 10% discount is silently applied in the `calculateTotal()` method but not communicated to the user.

### **3. Logic Error (Cart Check):**
- **Hint:** "Look at how you're checking if the cart is empty. Does that condition make logical sense?"
- **Details:** `cart.size() < 0` is always false. It should be `cart.size() == 0` to detect an empty cart.

---