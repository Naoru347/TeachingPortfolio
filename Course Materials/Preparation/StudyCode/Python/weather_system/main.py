# weather_system/main.py
"""
Main script demonstrating the weather system functionality.
"""

from weather_system import (
    generate_data,
    process_readings,
    format_temperature
)

def main():
    # Generate sample data
    print("Generating weather data...")
    weather_data = generate_data(days=5)
    
    # Display raw data
    print("\nRaw Weather Data:")
    for entry in weather_data:
        temp_str = format_temperature(entry['temp_c'])
        print(f"Date: {entry['date']}, Temperature: {temp_str}")
    
    # Process and display analysis
    print("\nWeather Analysis:")
    analysis = process_readings(weather_data)
    print(f"Number of readings: {analysis['count']}")
    print(f"Average temperature: {format_temperature(analysis['average_c'])}")
    print(f"Maximum temperature: {format_temperature(analysis['max_c'])}")
    print(f"Minimum temperature: {format_temperature(analysis['min_c'])}")

if __name__ == "__main__":
    main()