import datetime

class BankAccount:
    def __init__(self, initial_balance=0):
        if initial_balance < 0:
            raise ValueError("Initial balance cannot be negative.")
        self.__balance = initial_balance  # Private balance attribute
        self.__transaction_history = []  # Private transaction history attribute
        self.__log_transaction("Account created", initial_balance)

    def deposit(self, amount):
        if amount <= 0:
            raise ValueError("Deposit amount must be positive.")
        self.__balance += amount
        self.__log_transaction("Deposit", amount)

    def withdraw(self, amount):
        if amount <= 0:
            raise ValueError("Withdrawal amount must be positive.")
        if amount > self.__balance:
            raise ValueError("Insufficient funds.")
        self.__balance -= amount
        self.__log_transaction("Withdrawal", -amount)

    def get_balance(self):
        return self.__balance

    def get_transaction_history(self):
        return self.__transaction_history

    def __log_transaction(self, transaction_type, amount):
        timestamp = datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")
        self.__transaction_history.append({
            "type": transaction_type,
            "amount": amount,
            "timestamp": timestamp,
            "balance_after": self.__balance
        })

# Example usage
if __name__ == "__main__":
    account = BankAccount(1000)  # Initial balance
    try:
        account.deposit(500)  # Should work
        print("Deposit successful.")
    except ValueError as e:
        print(f"Error: {e}")

    try:
        account.withdraw(2000)  # Should fail (insufficient funds)
    except ValueError as e:
        print(f"Error: {e}")

    print("Current balance:", account.get_balance())  # Should show current balance
    print("Transaction history:")
    for transaction in account.get_transaction_history():
        print(transaction)
