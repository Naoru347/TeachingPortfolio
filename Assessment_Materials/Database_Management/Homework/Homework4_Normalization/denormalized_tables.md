# Denormalized Sample Tables for Homework 4: Normalization Practice

## Table A: Course Enrollments (Denormalized)

| StudentID | StudentName | CourseIDs                | CourseNames                                                | InstructorNames                              |
|-----------|-------------|--------------------------|------------------------------------------------------------|----------------------------------------------|
| 1001      | Alice Lee   | C101, C102               | Intro to SQL, Data Modeling                                | Prof. Adams, Dr. Benson                      |
| 1002      | Bob Smith   | C102, C103               | Data Modeling, Database Applications                       | Dr. Benson, Dr. Rivera                       |
| 1003      | Carol Chen  | C101, C103, C104         | Intro to SQL, Database Applications, ER Modeling           | Prof. Adams, Dr. Rivera, Dr. James           |
| 1004      | David Lin   | C101, C104               | Intro to SQL, ER Modeling                                  | Prof. Adams, Dr. James                       |
| 1005      | Ethan Zhou  | C101, C102, C105         | Intro to SQL, Data Modeling, Advanced SQL Queries          | Prof. Adams, Dr. Benson, Dr. Wu              |
| 1006      | Fiona Gupta | C103, C104, C105         | Database Applications, ER Modeling, Advanced SQL Queries   | Dr. Rivera, Dr. James, Dr. Wu                |

---

## Table B: Book Orders (Denormalized)

| OrderID | CustomerName | CustomerPhone | BookTitle                   | Quantity | Price | TotalOrderAmount |
|---------|--------------|---------------|-----------------------------|----------|-------|------------------|
| O5001   | Mia Torres   | 555-1234      | Learn SQL                   | 2        | 40    | 145              |
| O5001   | Mia Torres   | 555-1234      | Database Systems            | 1        | 65    | 145              |
| O5001   | Mia Torres   | 555-1234      | Entity-Relational Guide     | 1        | 40    | 145              |
| O5002   | Jake Patel   | 555-5678      | Learn SQL                   | 1        | 40    | 40               |
| O5003   | Alice Lee    | 555-6789      | Database Systems            | 2        | 65    | 130              |
| O5004   | Fiona Gupta  | 555-9876      | Advanced SQL Queries        | 1        | 55    | 55               |
| O5004   | Fiona Gupta  | 555-9876      | Data Modeling Essentials    | 1        | 50    | 105              |

---

## Table C: Event Attendance (Denormalized)

| EventID | EventName           | AttendeeNames                                               | AttendeeEmails                                                                       | EventDate  |
|---------|---------------------|-------------------------------------------------------------|--------------------------------------------------------------------------------------|------------|
| E101    | Data Science Talk   | Alice Lee, Bob Smith, Jake Patel                            | alice@gwmail.edu, bob@gwmail.edu, jake@gwmail.edu                                   | 2023-10-15 |
| E102    | SQL Workshop        | Carol Chen, David Lin, Alice Lee                            | carol@gwmail.edu, david@gwmail.edu, alice@gwmail.edu                                | 2023-11-01 |
| E103    | Data Modeling Panel | Bob Smith, Carol Chen, Mia Torres, Fiona Gupta              | bob@gwmail.edu, carol@gwmail.edu, mia@gwmail.edu, fiona@gwmail.edu                  | 2023-11-10 |
| E104    | ER Design Showcase  | Jake Patel, Mia Torres, David Lin, Alice Lee, Ethan Zhou    | jake@gwmail.edu, mia@gwmail.edu, david@gwmail.edu, alice@gwmail.edu, ethan@gwmail.edu | 2023-11-15 |

