def login(users):
    """
    Handles user login.
    """
    username = input("Enter your username: ").strip()
    password = input("Enter your password: ").strip()
    
    if username in users and users[username] == password:
        print("Login successful!")
    else:
        print("Invalid username or password.")

def register(users):
    """
    Handles new user registration.
    """
    username = input("Enter a new username: ").strip()
    if username in users:
        print("Username already exists. Try a different one.")
        return
    
    password = input("Enter a new password: ").strip()
    users[username] = password
    print("Registration successful!")

def main():
    print("Welcome to the Login System!")
    
    # Students will implement loading and saving user data
    users = {}  # Temporary in-memory storage for user credentials
    
    while True:
        print("\nOptions:")
        print("1. Login")
        print("2. Register")
        print("3. Exit")
        choice = input("Choose an option: ").strip()
        
        if choice == "1":
            login(users)
        elif choice == "2":
            register(users)
        elif choice == "3":
            print("Goodbye!")
            break
        else:
            print("Invalid option. Please try again.")

if __name__ == "__main__":
    main()
