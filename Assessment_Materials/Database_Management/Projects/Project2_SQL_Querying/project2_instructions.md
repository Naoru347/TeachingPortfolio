# Project 2: SQL Querying with the Campus Club Database

## Overview
In this assignment, you will practice writing SQL queries against a database schema designed to manage campus clubs, memberships, events, venues, sponsors, and attendance records. You’ll explore various SQL concepts such as **SELECT** statements, **JOINs**, **GROUP BY** queries, **aggregate functions**, **subqueries**, and more.

## Getting Started
1. **Download & Run the Script**  
   - Download the file `club_db.sql` from the course LMS.  
   - Execute it in your MySQL environment. This script will:  
     - Create a new database named `campus_club`.  
     - Create the necessary tables.  
     - Insert **hundreds of rows** of sample data for clubs, members, events, venues, sponsors, etc.

2. **Verify the Database**  
   - Use `USE campus_club;` to switch to the newly created database.  
   - Run simple queries (e.g., `SELECT COUNT(*) FROM members;`) to confirm the tables are populated.

## Task Requirements

1. **Basic SELECT & Filtering**  
   - Write a query that returns all columns from the `clubs` table.  
   - Write a query that returns all **distinct** majors from the `members` table.  
   - Retrieve the **first name** and **last name** of any members who are in the **Art and Design** major.  

2. **Sorting & Limiting Results**  
   - Show a list of all `events` sorted by `event_date` (newest first).  
   - Retrieve the top 10 student email addresses from the `members` table, sorted by `student_id` ascending.

3. **JOINs**  
   - **Inner Join**: List each event along with the **club name** that is hosting it (join `events` and `clubs`). Display `event_name`, `event_date`, and `club_name`.  
   - **Multiple Table Join**: Find which members attended which events. Include `first_name`, `last_name`, `event_name`, and `event_date`.  
   - **Aggregated Query**: For each club, show the **total number of members** (join `clubs` and `membership`). Sort results by the largest membership count first.

4. **GROUP BY & Aggregate Functions**  
   - For each `venue`, calculate how many events have been held (or are scheduled) there. Display `venue_name` and `event_count`.  
   - Show the **average feedback_rating** per event from the `attendance` table. Include `event_name`, `avg_rating`, and round the rating to 2 decimal places.  
   - Find out how much total sponsorship (`SUM(amount)`) each **sponsor** provides across all clubs. Display `sponsor_name` and the sum of `amount`.

5. **Subqueries**  
   - Retrieve the **club name(s)** that have the highest total membership. (Hint: use a subquery to first find the maximum membership count, then filter clubs with that count.)  
   - List the **members** (first name, last name) who are attending at least **two different events**. (Hint: subquery or `HAVING COUNT(*) >= 2` in `attendance`.)

6. **Conditional Queries**  
   - Show all **events** where `budget_allocated` is greater than 200.  
   - List any **members** who serve as **President** or **Treasurer** (from the `membership` table).  
   - Identify any **clubs** founded before the year 2020.

7. **Updates & Inserts (Optional)**  
   - **Update**: Suppose the “Coding Club” is receiving an additional 500.00 to its budget. Show the SQL to update that club’s `club_budget`.  
   - **Insert**: Demonstrate adding a new sponsor (you choose the details), and create a `sponsorship` record linking them to any one club.

8. **Advanced Challenge (Optional)**  
   - Identify the “most active members,” defined as those who have attended the **most events** (use a subquery or advanced JOIN plus `GROUP BY`). Display the top 3 such members.  
   - Find all “underequipped clubs” by checking if they have **no sponsors** and **zero club_budget** (i.e., no external funding at all).

## Deliverables
1. **SQL Queries**  
   - Put **all** final queries into a `.sql` file or a PDF/Word document.  
   - Provide brief comments (where necessary) explaining the purpose of each query.  

2. **Query Output** (Recommended)  
   - Paste or screenshot representative results (especially for multi-join queries) to confirm correctness.  
   - If the result sets are large, limit your output to a few lines (e.g., `LIMIT 5`).  

3. **Optional Explanations**  
   - If you used subqueries or more advanced techniques, include a sentence explaining how your query works.  

## Submission
- **Format**: Submit either (1) a `.sql` file containing your queries or (2) a `.pdf/.docx` file with your queries and outputs.  
- **File Naming**: `Lastname_Firstname_Project2.sql` or `Lastname_Firstname_Project2.pdf`.  
- **Deadline**: Check the LMS for the due date and submission instructions.

## Grading Criteria
1. **Completeness (40%)**  
   - Did you attempt all required query types (SELECT, JOIN, GROUP BY, subquery, etc.)?  
   - Have you addressed any advanced or optional tasks (for extra credit)?  

2. **Correctness (30%)**  
   - Do your queries run without errors?  
   - Are the results logically correct given the prompt?  

3. **Clarity & Formatting (20%)**  
   - Are queries well-organized and readable? (Use indentation and comments where helpful.)  
   - Is your output or explanation clear to follow?

4. **Efficiency & Creativity (10%)**  
   - Did you write queries in a way that follows best practices and avoids unnecessary complexity?  
   - Did you explore interesting or advanced features (subqueries, advanced aggregations, etc.)?

---

**Happy querying!** By exploring this rich dataset, you’ll gain hands-on experience with real-world data operations and build confidence in SQL fundamentals.
