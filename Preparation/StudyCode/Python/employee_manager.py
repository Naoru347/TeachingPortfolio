# Global variable for default department
default_department = "General"

def add_employee(name, position, salary=50_000):
    # Default salary parameter if none is passed as an argument when the function is called
    return {"name": name, "position": position, "salary": salary, "department": default_department}

def calculate_average_salary(employees):
    total_salary = 0
    for emp in employees:
        total_salary += emp["salary"]
    return total_salary / len(employees)

def print_employees(*employees):
    print("\nEmployee Details:")
    for emp in employees:
        print(f"- Name: {emp['name']}, Position: {emp['position']}, Salary: ${emp['salary']:,.2f}")

def main(): 
    # Shadows global variable while in local scope
    default_department = "HR"
    print("In Main()")
    print(f"Default department - local scope = {default_department}")

    # Add employees to the dict
    emp1 = add_employee("Alice", "Manager", 70_000)
    emp2 = add_employee("Bob", "Engineer", 60_000)
    emp3 = add_employee("Charlie", "Technical")  # Uses default salary

    # Calculate average salary
    employees = [emp1, emp2, emp3]
    avg_salary = calculate_average_salary(employees)
    print(f"\nAverage Salary: ${avg_salary:,.2f}")

    # Print employee details
    print_employees(*employees)

if __name__ == "__main__":
    main()
