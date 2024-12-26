from datetime import datetime, timedelta

# Base LibraryItem class
class LibraryItem:
    def __init__(self, title, identifier):
        self.title = title
        self.identifier = identifier
        self.is_available = True

    def __str__(self):
        return f"{self.__class__.__name__}: {self.title} ({self.identifier})"

class Book(LibraryItem):
    def __init__(self, title, author, isbn):
        super().__init__(title, isbn)
        self.author = author

class DVD(LibraryItem):
    def __init__(self, title, duration, identifier):
        super().__init__(title, identifier)
        self.duration = duration

class Magazine(LibraryItem):
    def __init__(self, title, issue, identifier):
        super().__init__(title, identifier)
        self.issue = issue

# Member class
class Member:
    def __init__(self, name, member_id):
        self.name = name
        self.member_id = member_id
        self.loan_history = []

    def checkout_item(self, item):
        if not item.is_available:
            raise ValueError(f"Item {item.title} is not available.")
        item.is_available = False
        loan = {
            "item": item,
            "due_date": datetime.now() + timedelta(days=14)
        }
        self.loan_history.append(loan)
        return loan

    def return_item(self, item):
        for loan in self.loan_history:
            if loan["item"] == item:
                item.is_available = True
                self.loan_history.remove(loan)
                break
        else:
            raise ValueError(f"Item {item.title} is not currently loaned by this member.")

    def get_loan_history(self):
        return [f"{loan['item']} (Due: {loan['due_date']:%Y-%m-%d})" for loan in self.loan_history]

# Library class
class Library:
    def __init__(self):
        self.items = []
        self.members = []

    def add_item(self, item):
        if not isinstance(item, LibraryItem):
            raise ValueError("Item must be an instance of LibraryItem.")
        self.items.append(item)

    def register_member(self, member):
        if not isinstance(member, Member):
            raise ValueError("Member must be an instance of Member.")
        self.members.append(member)

    def checkout_item(self, member, item):
        if member not in self.members:
            raise ValueError("Member is not registered.")
        if item not in self.items:
            raise ValueError("Item is not in the library.")
        return member.checkout_item(item)

    def return_item(self, member, item):
        if member not in self.members:
            raise ValueError("Member is not registered.")
        if item not in self.items:
            raise ValueError("Item is not in the library.")
        member.return_item(item)

# Example usage
if __name__ == "__main__":
    library = Library()

    # Add items
    book = Book("Python Programming", "Jane Doe", "ISBN123")
    dvd = DVD("Nature Documentary", "120 mins", "DOC456")
    magazine = Magazine("Science Weekly", "Issue 42", "MAG789")
    library.add_item(book)
    library.add_item(dvd)
    library.add_item(magazine)

    # Register member
    member = Member("John Smith", "MS123")
    library.register_member(member)

    # Checkout and return
    library.checkout_item(member, book)
    print(member.get_loan_history())
    library.return_item(member, book)
    print(member.get_loan_history())
