# Case Study: Campus Library Database

## Scenario Overview
You have been asked to design a database system for your community college’s campus library. The goal is to create an organized, efficient database that will handle the everyday operations and information management needs of the library, improving the overall user experience for students, faculty, and library staff.

## Library Operations and Requirements

The library has an extensive collection of books, journals, and multimedia materials (DVDs, CDs, audiobooks). Each item in the collection must be tracked individually to manage inventory accurately. The library needs to track details such as the title, author(s), ISBN, genre, publication year, and number of copies for books, while multimedia items will require tracking their format type and publisher information.

Students and faculty members can borrow library items using their college ID cards. Each borrower must be recorded in the system, including their name, ID number, contact information (email, phone), and their borrower category (student, faculty, staff).

The library imposes borrowing limits, which vary based on borrower category:
- Students can borrow up to 5 items simultaneously for a period of two weeks.
- Faculty and staff can borrow up to 10 items simultaneously for a period of four weeks.

Items can be renewed if they are not on hold or reserved by another borrower. The library needs to maintain records of all borrowing transactions, including borrow dates, due dates, renewals, and return dates. Late returns result in penalties, which must also be tracked.

The library provides reservation services, allowing borrowers to reserve an item that is currently checked out. Once the reserved item becomes available, the borrower receives a notification via email.

Additionally, the library employs several staff members responsible for managing the collection, assisting borrowers, handling borrowing transactions, and enforcing library policies. Staff members' details, including their staff ID, names, roles, and contact information, must be recorded.

Finally, the library occasionally organizes special events like book readings, workshops, or guest lectures. The details of these events, including event name, date, time, description, and presenter information, should be documented in the database.

## Your Task

Analyze the provided scenario to identify:
- Potential database entities.
- Attributes relevant to each entity.
- Relationships between entities (including their type: one-to-one, one-to-many, many-to-many).

Carefully document your findings, clearly explaining your reasoning for each entity, attribute, and relationship identified.

Good luck, and enjoy designing an effective and user-friendly library database!