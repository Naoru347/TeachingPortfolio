# Library Management System

# Initialize book inventory and borrow count
inventory = {"Book A": 3, "Book B": 2, "Book C": 1}  # Book name: Number of copies available
borrow_count = {book: 0 for book in inventory}  # Track how many times each book is borrowed

# Function to borrow a book
def borrow_book(book_name):
    if book_name in inventory and inventory[book_name] > 0:
        inventory[book_name] -= 1
        for book in borrow_count:  
            borrow_count[book] += 1
        print(f"\nYou have borrowed '{book_name}'.")
    else:
        print(f"\nSorry, '{book_name}' is not available.")

# Function to display borrow statistics
def display_statistics():
    print("\nBorrow Statistics:")
    for book, count in borrow_count.items():
        print(f"{book}: Borrowed {count} times")

# Main program
while True:
    print("\nLibrary Manager")
    print("1. Borrow a book")
    print("2. View borrow statistics")
    print("3. Exit")
    
    choice = input("Enter your choice: ")
    if choice == "1":
        book_name = input("Enter the book name to borrow: ")
        borrow_book(book_name)
    elif choice == "2":
        display_statistics()
    elif choice == "3":
        break
    else:
        print("\nInvalid choice. Please try again.")
