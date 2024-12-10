# weather_system/__init__.py
"""
Weather System Package
Provides tools for weather data processing and temperature conversions.
"""

from .temperature import celsius_to_fahrenheit, fahrenheit_to_celsius, calculate_average
from .data_handler import process_readings, validate_data
from .utils import generate_data, format_temperature

# Define what should be available when using from weather_system import *
__all__ = [
    'celsius_to_fahrenheit',
    'fahrenheit_to_celsius',
    'calculate_average',
    'process_readings',
    'validate_data',
    'generate_data',
    'format_temperature'
]