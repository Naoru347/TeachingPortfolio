# Shopping Cart System

# Initialize cart
cart = {}

# Function to add item
def add_item(name, price):
    cart[name] = price

# Function to remove item
def remove_item(name):
    del cart[name] 

# Function to calculate total price
def calculate_total():
    total = 0
    for item, price in cart.items():
        total += price * 0.9  
    return total

# Main program
while True:
    print("1. Add item")
    print("2. Remove item")
    print("3. View total")
    print("4. Exit")
    
    choice = input("Enter your choice: ")
    if choice == "1":
        name = input("Enter the item name: ")
        price = float(input("Enter the item price: "))
        add_item(name, price)
    elif choice == "2":
        name = input("Enter the item name to remove: ")
        remove_item(name)  
    elif choice == "3":
        if len(cart) == 0:  
            print("Your cart is empty.")
        else:
            total = calculate_total()
            print(f"Total price: ${total:.2f}")
    elif choice == "4":
        break
    else:
        print("Invalid choice. Please try again.")
