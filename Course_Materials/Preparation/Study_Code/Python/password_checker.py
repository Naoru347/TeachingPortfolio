class PasswordValidationError(Exception):
    """Custom exception for password validation failures."""
    pass

def validate_password(password):
    """
    Validates password against security requirements.
    Raises PasswordValidationError with specific message if requirements not met.
    """
    # Check length
    if len(password) < 8:
        raise PasswordValidationError(
            "Password must be at least 8 characters long"
        )
    
    # Check uppercase
    if not any(c.isupper() for c in password):
        raise PasswordValidationError(
            "Password must contain at least one uppercase letter"
        )
    
    # Check numbers
    if not any(c.isdigit() for c in password):
        raise PasswordValidationError(
            "Password must contain at least one number"
        )
    
    # Check special characters
    special_chars = "!@#$%^&*"
    if not any(c in special_chars for c in password):
        raise PasswordValidationError(
            f"Password must contain at least one special character ({special_chars})"
        )
    
    return True

def main():
    """
    Test the password validator with various test cases.
    """
    test_passwords = [
        "abc123",                   # Too short
        "abcdefgh",                 # No uppercase/number/special
        "Abcdefgh",                 # No number/special
        "Abcdefgh1",                # No special
        "ThisIsATest",              # No number/special
        "ThisIsATest123",           # No special
        "Password123!",             # Valid

    ]
    
    for password in test_passwords:
        try:
            validate_password(password)
            print(f"Password '{password}' is valid")
        except PasswordValidationError as e:
            print(f"Password '{password}' is invalid: {str(e)}")

if __name__ == "__main__":
    main()