# **Lab 13: Car Dealership Inventory Management (Java Version)**

---

## **Objectives**
1. Learn to define and use custom Java classes.
2. Understand how to create and interact with multiple objects.
3. Practice implementing methods and working with object attributes.
4. Apply OOP principles to solve a real-world problem in Java.

---

## **Scenario**
You are developing a Java program for a car dealership to manage its inventory. Each car is represented as an object with specific attributes and methods. The dealership needs a system to:
- Add cars to the inventory.
- Sell cars to customers.
- Restock cars that are running low.
- Calculate the total value of the available stock.

By the end of this lab, you will have a functioning dealership inventory management system written in Java.

---

## **Instructions**

### **Step 1: Define the `Car` Class**
1. Create a new Java file named `Car.java`.
2. Define a `Car` class with the following attributes:
   - `make` (String): The manufacturer of the car (e.g., "Toyota").
   - `model` (String): The model of the car (e.g., "Corolla").
   - `price` (double): The price of the car (e.g., 25000.0).
   - `availableStock` (int): The number of cars in stock (e.g., 5).

3. Add the following methods to the `Car` class:
   - `void sell(int quantity)`: Reduces the stock by the specified quantity and prints a confirmation. Ensure the stock doesn’t go negative.
   - `void restock(int quantity)`: Increases the stock by the specified quantity and prints a confirmation.
   - `void displayInfo()`: Prints the car’s details (make, model, price, and available stock).

---

### **Step 2: Create the Dealership Inventory System**
1. Create a new Java file named `CarDealership.java`.
2. In your `main` method, create an `ArrayList<Car>` to store inventory.
3. Add at least 3 cars to the inventory using the `Car` class.
4. Print the details of all cars in the inventory using the `displayInfo()` method.

---

### **Step 3: Simulate Transactions**
1. Create a menu system using a `while` loop to allow the user to:
   - View all cars and their details.
   - Sell a car by specifying the make, model, and quantity.
   - Restock a car by specifying the make, model, and quantity.
   - Calculate and display the total value of all available stock.
   - Exit the program.

2. Use `Scanner` to take user input and perform the corresponding action.

---

### **Stretch Challenge (Optional)**
1. Add a `Dealership` class to manage the inventory. The class should include methods for adding, selling, restocking, and calculating total value.
2. Add error handling for invalid inputs (e.g., attempting to sell more cars than are in stock).
3. Enhance the program to allow searching for cars by make or model.

---

## **Example Output**
```
Welcome to the Car Dealership Inventory System

1. View Inventory
2. Sell a Car
3. Restock a Car
4. Calculate Total Inventory Value
5. Exit

Enter your choice: 1

Available Cars:
1. Toyota Corolla - $25000.00 - 5 in stock
2. Honda Civic - $22000.00 - 3 in stock
3. Ford F-150 - $30000.00 - 2 in stock

Enter your choice: 2
Enter the make of the car to sell: Toyota
Enter the model of the car to sell: Corolla
Enter the quantity to sell: 2

You have sold 2 Toyota Corolla(s).

Enter your choice: 4

Total value of available stock: $154000.00

Enter your choice: 5
Goodbye!
```

---

## **Submission Instructions**
1. Submit the following to your GitHub Classroom repo:
   - `Car.java`
   - `CarDealership.java`
   - (Optional) `Dealership.java` if you implemented the stretch challenge.
   - A 1-2 paragraph reflection in a file called `Lab13_Reflection.md` describing what you learned, challenges faced, and how you overcame them.

---

## **Hints and Tips**
1. **Class Structure:**
   - Use constructors to initialize your class attributes.
2. **Stock Management:**
   - Always check stock before reducing it to avoid negative values.
3. **Total Inventory Value:**
   - Loop through all cars and sum the value using `price * availableStock`.
4. **Testing:**
   - Test each method independently before integrating.

---

Good luck building your Java Car Dealership Inventory System! This lab helps you build strong OOP skills in a real-world context.