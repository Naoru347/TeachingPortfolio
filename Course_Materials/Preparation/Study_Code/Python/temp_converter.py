def temperature_converter():
    print("Temperature Converter")
    print("----------------------")
    
    # Accept input for temperature and its unit
    temp_input = input("Enter the temperature (e.g., 32F or 100C): ").strip()
    
    # Validate input format
    if len(temp_input) < 2 or not temp_input[:-1].replace('.', '', 1).isdigit():
        print("Invalid input! Please enter a valid temperature (e.g., 32F or 100C).")
        return
    
    # Extract value and unit
    temp_value = float(temp_input[:-1])
    temp_unit = temp_input[-1].upper()
    
    # Perform conversion
    if temp_unit == 'F':
        celsius = (temp_value - 32) * 5 / 9
        print(f"{temp_value:.1f}F is equivalent to {celsius:.1f}C.")
    elif temp_unit == 'C':
        fahrenheit = (temp_value * 9 / 5) + 32
        print(f"{temp_value:.1f}C is equivalent to {fahrenheit:.1f}F.")
    else:
        print("Invalid unit! Please use 'F' for Fahrenheit or 'C' for Celsius.")

# Run the program
if __name__ == "__main__":
    temperature_converter()
