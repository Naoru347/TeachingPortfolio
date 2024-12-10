# weather_system/temperature.py
"""
Temperature conversion and calculation utilities.
Handles all temperature-related operations.
"""

def celsius_to_fahrenheit(celsius: float) -> float:
    """Convert Celsius to Fahrenheit with validation."""
    if not isinstance(celsius, (int, float)):
        raise TypeError("Temperature must be a number")
    return (celsius * 9/5) + 32

def fahrenheit_to_celsius(fahrenheit: float) -> float:
    """Convert Fahrenheit to Celsius with validation."""
    if not isinstance(fahrenheit, (int, float)):
        raise TypeError("Temperature must be a number")
    return (fahrenheit - 32) * 5/9

def calculate_average(temperatures: list) -> float:
    """Calculate average temperature from a list of readings."""
    if not temperatures:
        raise ValueError("Temperature list cannot be empty")
    valid_temps = [t for t in temperatures if isinstance(t, (int, float))]
    return sum(valid_temps) / len(valid_temps)