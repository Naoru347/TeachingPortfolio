import csv
import json

def read_student_data(filename):
    """Read student information from CSV file."""
    students = {}
    try:
        with open(filename, 'r') as file:
            # DictReader allows us to automatically handle CSV headers
            reader = csv.DictReader(file)
            # Build a dict with student id as KEY and name as VALUE
            for row in reader:
                students[row['Student ID']] = row['Name']
    except FileNotFoundError:
        print(f"Could not find {filename}")
        raise
    return students

def read_grades(filename):
    """Read grades from JSON file."""
    try:
        with open(filename, 'r') as file:
            # Automatically loads JSON contents into a Python data structure
            return json.load(file)
    except FileNotFoundError:
        print(f"Could not find {filename}")
        raise

def calculate_student_averages(students, grades):
    """Calculate average for each student and store with their info."""
    results = {}
    for student_id, name in students.items():
        if student_id in grades:
            student_grades = grades[student_id].values()
            average = sum(student_grades) / len(student_grades)
            results[student_id] = {
                "name": name,
                "average": average,
                "grades": grades[student_id]
            }
    return results

def write_report(filename, results):
    """Write formatted report to text file."""
    with open(filename, 'w') as file:
        file.write("Student Grade Report\n")
        file.write("------------------\n\n")
        
        # Write individual student reports
        for student_id, data in results.items():
            file.write(f"{data['name']} ({student_id})\n")
            file.write(f"Average Grade: {data['average']:.1f}\n\n")
        
        # Calculate and write subject analysis
        subjects = {"math": [], "science": [], "history": []}
        for data in results.values():
            for subject, grade in data['grades'].items():
                subjects[subject].append(grade)
        
        file.write("Subject Analysis\n")
        file.write("------------------\n")
        for subject, grades in subjects.items():
            highest = max(grades)
            file.write(f"{subject.capitalize()} - Highest Grade: {highest}\n")
        
        # Calculate and write class average
        all_averages = [data['average'] for data in results.values()]
        class_average = sum(all_averages) / len(all_averages)
        file.write(f"\nClass Average: {class_average:.1f}\n")

def main():
    try:
        students = read_student_data('students.csv')
        grades = read_grades('grades.json')
        results = calculate_student_averages(students, grades)
        write_report('report.txt', results)
        print("Report generated successfully!")
    except Exception as e:
        print(f"An error occurred: {str(e)}")

if __name__ == "__main__":
    main()