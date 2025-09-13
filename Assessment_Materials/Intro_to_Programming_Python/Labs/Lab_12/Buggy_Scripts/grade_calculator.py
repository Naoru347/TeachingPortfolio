# Grade Calculator
# There are three bugs in this code.

# Get user input
grades_input = input("Enter grades separated by commas (e.g., 85,90,78): ")
grades = grades_input.split(",")  
# Calculate average
total = 0
for grade in grades:
    if int(grade) < 0 or int(grade) > 100:  
        print(f"Invalid grade found: {grade}")
        continue
    total += grade  
average = total / len(grades) 
print(f"The average grade is: {average:.2f}")
