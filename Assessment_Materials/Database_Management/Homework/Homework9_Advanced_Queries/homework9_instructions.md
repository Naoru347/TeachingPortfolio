# Homework: Advanced SQL Queries

## Overview
In this assignment, you'll expand your SQL skills by writing advanced queries that use **subqueries**, **common table expressions (CTEs)**, and **window functions**. This deeper level of SQL knowledge allows you to handle complex data retrieval tasks more efficiently.

---

## Objectives
1. **Subqueries**: Use nested queries to filter and transform data.
2. **Common Table Expressions (CTEs)**: Break down complex logic into readable, stepwise solutions.
3. **Window Functions**: Perform calculations across sets of rows related to the current row.
4. **Analytical Thinking**: Apply these techniques to answer meaningful data questions.

---

## Instructions

1. **Setup the Database**
   - Run the provided SQL script (*AdvancedSQLSetup.sql*) to create and populate sample tables. 
     - This will create the AdvSQLDB test DB for you to complete this homework in. 
   - Ensure you have a working environment (e.g., MySQL Workbench, psql, or another SQL client) to execute and test queries.

2. **Tasks**
   **Task 1: Subqueries**
   - Write a query using a subquery in the `WHERE` clause. Example scenario: "Select products with a price higher than the average product price."  
   - Write a query using a subquery in the `FROM` clause (sometimes called an inline view). E.g., "Return the top 3 departments with the highest total salary."  
   - Provide a brief explanation of how your subqueries filter or transform data.

   **Task 2: Common Table Expressions (CTEs)**
   - Create a CTE to simplify a multi-step calculation (e.g., computing total sales by region, then referencing that result in a final SELECT).  
   - Use at least one recursive CTE if possible (e.g., building a hierarchical org chart).  
   - Document how using a CTE improves readability compared to a single complex query.

   **Task 3: Window Functions**
   - Use a window function like `ROW_NUMBER()`, `RANK()`, or `DENSE_RANK()` to label or rank rows within a partition (e.g., list employees by salary within each department).  
   - Use an aggregate window function like `SUM()` or `AVG()` to compute rolling totals or moving averages across partitions.  
   - Explain how window functions differ from regular aggregate functions.

3. **Document Your Queries & Results**
   - For each task, include:
     1. The **SQL query**.
     2. A **short explanation** of how it works.
     3. A **screenshot** or **query result** to show correct execution.

4. **Submission Format**
   - Submit as a single PDF file.
   - Clearly label **Task 1**, **Task 2**, **Task 3**.
   - Follow best practices for query readability (proper indentation, aliases, etc.).

---

## Grading Criteria
- **Query Accuracy (50%)**: Queries execute successfully, produce correct results, and use advanced features properly.
- **Explanations & Documentation (30%)**: Concise yet clear explanations of each query’s logic and purpose.
- **Organization & Presentation (10%)**: Neatly structured PDF, labeled queries, results, and screenshots.
- **Syntax & Style (10%)**: Well-formatted SQL, consistent use of aliases, indentation, etc.

---

## Due Date
Submit your completed PDF document via the course LMS by **[Insert Due Date Here]**.

Good luck and have fun exploring the power of advanced SQL techniques!

