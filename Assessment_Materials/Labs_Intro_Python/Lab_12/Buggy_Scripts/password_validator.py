# Password Validator
# There are THREE bugs in this code

# Get user input
password = input("Enter a password to validate: ")

# Validate password length
if len(password) < 8:
    print("Password must be at least 8 characters long.")

# Check for uppercase letter
if any(char.isupper() for char in password):  
    print("Password must contain at least one uppercase letter.")

# Check for number
if any(char.isdigit() for char in password):  
    print("Password must contain at least one number.")

# Display result
if password.index(""):  
    print("Password is valid!")
else:
    print("Password is invalid.")
