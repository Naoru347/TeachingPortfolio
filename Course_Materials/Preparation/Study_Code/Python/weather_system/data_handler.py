# weather_system/data_handler.py
"""
Data processing and validation module.
Handles all data management operations.
"""

from datetime import datetime
from .temperature import celsius_to_fahrenheit

def validate_data(data: list) -> bool:
    """Validate weather data structure and values."""
    if not isinstance(data, list):
        return False
        
    for entry in data:
        if not isinstance(entry, dict):
            return False
        if 'date' not in entry or 'temp_c' not in entry:
            return False
        try:
            datetime.strptime(entry['date'], "%Y-%m-%d")
            float(entry['temp_c'])
        except (ValueError, TypeError):
            return False
    return True

def process_readings(data: list) -> dict:
    """Process weather readings and return analysis."""
    if not validate_data(data):
        raise ValueError("Invalid data format")
        
    temps_c = [entry['temp_c'] for entry in data]
    temps_f = [celsius_to_fahrenheit(t) for t in temps_c]
    
    return {
        'count': len(data),
        'average_c': sum(temps_c) / len(temps_c),
        'average_f': sum(temps_f) / len(temps_f),
        'max_c': max(temps_c),
        'min_c': min(temps_c)
    }