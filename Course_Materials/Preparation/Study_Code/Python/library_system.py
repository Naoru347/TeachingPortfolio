def display_menu():
    """Display the main menu."""
    print("\n--- Library System ---")
    print("1. Add a Book")
    print("2. Borrow a Book")
    print("3. Check Availability")
    print("4. Quit")
    return int(input("\nEnter your choice: "))

def add_book(catalog):
    """Add a new book to the library catalog."""
    title = input("Enter book title: ").strip()
    author = input("Enter author: ").strip()
    copies = int(input("Enter number of copies: "))
    
    # Add the book to the catalog
    if title in catalog:
        catalog[title]["copies"] += copies  # If the book exists, increase the copies
        print(f'Updated "{title}". Total copies: {catalog[title]["copies"]}.')
    else:
        catalog[title] = {"author": author, "copies": copies}
        print(f'"{title}" by {author} added to the library.')

def borrow_book(catalog):
    """Borrow a book if it is available."""
    title = input("Enter book title to borrow: ").strip()
    if title in catalog and catalog[title]["copies"] > 0:
        catalog[title]["copies"] -= 1
        print(f'You have borrowed "{title}". Copies left: {catalog[title]["copies"]}.')
    else:
        print(f'Sorry, "{title}" is not available or out of stock.')

def check_availability(catalog):
    """Check if a book is available in the catalog."""
    title = input("Enter book title to check: ").strip()
    if title in catalog:
        copies = catalog[title]["copies"]
        if copies > 0:
            print(f'"{title}" is available. Copies left: {copies}.')
        else:
            print(f'"{title}" is currently out of stock.')
    else:
        print(f'"{title}" is not in the library catalog.')

def main():
    """Main function to run the library system."""
    catalog = {}  # Dictionary to store the library's catalog
    while True:
        try:
            choice = display_menu()
            if choice == 1:
                add_book(catalog)
            elif choice == 2:
                borrow_book(catalog)
            elif choice == 3:
                check_availability(catalog)
            elif choice == 4:
                print("Goodbye!")
                break
            else:
                print("Invalid choice. Please try again.")
        except ValueError:
            print("Invalid input. Please enter a number between 1 and 4.")

if __name__ == "__main__":
    main()
