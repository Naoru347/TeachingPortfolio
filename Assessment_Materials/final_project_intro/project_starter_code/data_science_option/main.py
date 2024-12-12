import csv

def load_csv(file_path):
    """
    Loads a CSV file and returns its contents as a list of dictionaries.
    Each row in the CSV becomes a dictionary with column headers as keys.
    """
    try:
        with open(file_path, mode='r') as file:
            reader = csv.DictReader(file)
            data = [row for row in reader]
        return data
    except FileNotFoundError:
        print("Error: File not found.")
        return []
    except Exception as e:
        print(f"An error occurred: {e}")
        return []

def display_data(data):
    """
    Displays the loaded CSV data in a tabular format.
    """
    if not data:
        print("No data to display.")
        return

    # Display the headers
    headers = data[0].keys()
    print("\t".join(headers))

    # Display the rows
    for row in data:
        print("\t".join(row.values()))

if __name__ == "__main__":
    print("Welcome to the Data Analysis Tool!")
    
    # Prompt the user to enter the file path
    file_path = input("Enter the path to your CSV file: ")
    data = load_csv(file_path)

    if data:
        print("\nLoaded Data:\n")
        display_data(data)
    else:
        print("No data loaded. Please check the file and try again.")
