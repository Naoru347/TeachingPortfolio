# **Lab 13: Car Dealership Inventory Management**

---

## **Objectives**
1. Learn to define and use custom Python classes.
2. Understand how to create and interact with multiple objects.
3. Practice implementing methods and working with object attributes.
4. Apply OOP principles to solve a real-world problem.

---

## **Scenario**
You are developing a program for a car dealership to manage its inventory. Each car is represented as an object with specific attributes and methods. The dealership needs a system to:
- Add cars to the inventory.
- Sell cars to customers.
- Restock cars that are running low.
- Calculate the total value of the available stock.

By the end of this lab, you will have a functioning dealership inventory management system.

---

## **Instructions**

### **Step 1: Define the `Car` Class**
1. Create a new Python script named `car_dealership.py`.
2. Define a `Car` class with the following attributes:
   - `make` (string): The manufacturer of the car (e.g., "Toyota").
   - `model` (string): The model of the car (e.g., "Corolla").
   - `price` (float): The price of the car (e.g., 25000.0).
   - `available_stock` (integer): The number of cars in stock (e.g., 5).

3. Add the following methods to the `Car` class:
   - `sell(quantity)`: Reduces the stock by the specified quantity and prints a confirmation. Ensure the stock doesn’t go negative.
   - `restock(quantity)`: Increases the stock by the specified quantity and prints a confirmation.
   - `display_info()`: Prints the car’s details (make, model, price, and available stock).

---

### **Step 2: Create the Dealership Inventory**
1. Create a list named `inventory` to store `Car` objects.
2. Add at least 3 cars to the inventory using the `Car` class.
3. Print the details of all cars in the inventory using the `display_info` method.

---

### **Step 3: Simulate Transactions**
1. Allow the user to interact with the inventory by performing the following actions:
   - View all cars and their details.
   - Sell a car by specifying the make, model, and quantity.
   - Restock a car by specifying the make, model, and quantity.
   - Calculate and display the total value of all available stock.
2. Use a loop to let the user perform multiple actions until they choose to exit the program.

---

### **Stretch Challenge (Optional)**
1. Add a `Dealership` class to manage the inventory. The class should include methods for adding cars, selling cars, restocking cars, and calculating the total value of the inventory.
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
1. Save your program as `car_dealership.py`.
2. Submit the following to your GitHub Classroom repo:
   - The Python script.
   - A 1-2 paragraph reflection on what you learned during the lab, including challenges faced and how you solved them.

---

## **Hints and Tips**
1. **Class Structure:**
   - Define your class first, then instantiate objects later.
   - Use `__init__` to initialize attributes.

2. **Stock Management:**
   - Always check the stock before selling cars to avoid negative values.

3. **Total Inventory Value:**
   - Use a loop to sum the values of all cars in stock.

4. **Testing:**
   - Test each method of the `Car` class independently before integrating them into the full program.

---

Good luck with your Car Dealership Inventory System! This lab will help you understand how to use classes and objects to solve real-world problems.
