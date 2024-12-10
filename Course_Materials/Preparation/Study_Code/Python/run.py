"""
Entry point for our weather system application.
This file sits outside our package and imports it.
"""

# Since run.py is at the same level as the weather_system directory,
# Python can find our package
from weather_system.main import main

if __name__ == "__main__":
    main()