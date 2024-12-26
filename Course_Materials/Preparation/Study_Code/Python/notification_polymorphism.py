class NotificationProvider:
    def send(self, message):
        raise NotImplementedError("Subclasses must implement the send method.")

class EmailProvider(NotificationProvider):
    def __init__(self, email_address):
        self.email_address = email_address

    def send(self, message):
        print(f"Sending email to {self.email_address} with subject: '{message.subject}' and body: '{message.body}'")

class SMSProvider(NotificationProvider):
    def __init__(self, phone_number):
        self.phone_number = phone_number

    def send(self, message):
        print(f"Sending SMS to {self.phone_number} with content: '{message.subject}: {message.body}'")

class PushProvider(NotificationProvider):
    def send(self, message):
        print(f"Sending push notification with title: '{message.subject}' and message: '{message.body}'")

class Message:
    def __init__(self, subject, body):
        self.subject = subject
        self.body = body

class NotificationService:
    def __init__(self):
        self.providers = []

    def add_provider(self, provider):
        if not isinstance(provider, NotificationProvider):
            raise ValueError("Provider must be an instance of NotificationProvider.")
        self.providers.append(provider)

    def send_all(self, message):
        for provider in self.providers:
            provider.send(message)

if __name__ == "__main__":
    message = Message("Important Update", "System maintenance scheduled")
    service = NotificationService()
    service.add_provider(EmailProvider("admin@example.com"))
    service.add_provider(SMSProvider("+1234567890"))
    service.add_provider(PushProvider())
    service.send_all(message)