# Homework Assignment 2: Basic SQL Queries

## Overview
This assignment introduces you to fundamental SQL queries. You will practice using basic SQL clauses such as `WHERE`, `ORDER BY`, and aggregate functions (`COUNT()`, `AVG()`, `SUM()`, `MIN()`, `MAX()`). The goal is to help you become familiar and comfortable with writing and executing SQL queries on provided data.

---

## Assignment Instructions

### Step 1: Setup Your Database
1. Download the provided SQL script (**homework2_db_setup.sql**) from the course LMS.
2. Execute this script in MySQL Workbench to create and populate your sample database named `Homework2DB`.

### Step 2: Write and Execute SQL Queries
Write SQL queries to complete each of the following tasks:

**Task 1:** Display all records from the `Employees` table where the `Department` is 'Sales'.

**Task 2:** List all products in the `Products` table sorted by `Price` in descending order (highest to lowest).

**Task 3:** Find the total number of employees working in the 'Marketing' department using the `COUNT()` function.

**Task 4:** Retrieve the average salary (`AVG()`) of all employees from the `Employees` table.

**Task 5:** Determine the lowest (`MIN()`) and highest (`MAX()`) prices of products in the `Electronics` category.

**Task 6:** Calculate the total (`SUM()`) of the current stock for all products in the `Accessories` category.

---

## Submission Requirements

- **Format:** Submit your assignment as a single PDF document.
- **Structure:** Clearly label each query by task number. For each task, include:
  1. The written SQL query.
  2. A screenshot clearly showing the executed query and its results from MySQL Workbench.
- **Example Format:**

**Task 1:**

```sql
SELECT * FROM Employees WHERE Department = 'Sales';
```

*(Include screenshot here)*

---

## Grading Criteria

- **Query Accuracy (60%)**: Queries correctly fulfill the described tasks.
- **Clarity and Formatting (20%)**: Queries are clear, well-formatted, and easy to read.
- **Presentation (20%)**: Document is neatly organized, and screenshots clearly show executed queries and results.

---

## Due Date

Submit your completed PDF document via the course LMS by **[Insert Due Date Here]**.

---

Good luck and have fun practicing your SQL querying skills!

