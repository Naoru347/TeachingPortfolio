# Basic Calculator
# There are THREE bugs in this code

# Get user input
num1 = float(imput("Enter the first number: "))  # Runtime Error: 'imput' misspelled
num2 = float(input("Enter the second number: "))
operation = input("Enter an operation (+, -, *, /): ")

# Perform the operation
if operation == "+":  # Syntax Error: Missing colon
    result = num1 + num2
elif operation == "-":
    result = num1 - num2
elif operation == "*":
    result = num1 * num2
elif operation == "/":
    result = num1 / num2  # Logic Error: Dividing by zero crashes the program
else:
    print("Invalid operation.")
    result = None

if result is not None:
    print(f"The result is: {result}")
