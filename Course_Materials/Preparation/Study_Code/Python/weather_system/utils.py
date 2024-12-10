# weather_system/utils.py
"""
Utility functions for the weather system.
Provides helper functions for data generation and formatting.
"""

import random
from datetime import datetime, timedelta

def generate_data(days: int = 7) -> list:
    """Generate sample weather data for specified number of days."""
    base_date = datetime.now()
    data = []
    
    for i in range(days):
        current_date = base_date + timedelta(days=i)
        temp_c = round(random.uniform(15.0, 35.0), 1)
        data.append({
            "date": current_date.strftime("%Y-%m-%d"),
            "temp_c": temp_c
        })
    return data

def format_temperature(temp: float, unit: str = "C") -> str:
    """Format temperature with unit for display."""
    return f"{temp:.1f}°{unit}"