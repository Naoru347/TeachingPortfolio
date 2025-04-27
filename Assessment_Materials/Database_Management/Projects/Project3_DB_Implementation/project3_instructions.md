# Project: Personal Finance Tracker

## Concept
Build a local or cloud-hosted database to manage personal finances, focusing on **accounts**, **transactions**, **bills**, **budgets**, and **income sources**. You will define and implement the database schema, populate it with sample data, and write **SQL** (and optional stored procedures or triggers) to automate tasks such as calculating monthly budgets or labeling expenses.

## Objectives
1. **Database Design**  
   - Create tables for different types of accounts (e.g., Checking, Savings, Credit Cards).  
   - Track transactions (deposits, withdrawals, transfers) over time.  
   - Store recurring bills (rent, utilities, subscriptions, etc.) and income sources (paychecks, side gigs, etc.).

2. **Data Handling & Automation**  
   - Learn to manage time-based data (dates, recurring events).  
   - Implement **constraints** to ensure data integrity (e.g., preventing negative balances if desired).  
   - Write optional **stored procedures/triggers** that handle routine tasks (e.g., monthly statements, email notifications, auto-labeling of expenses).

3. **SQL Proficiency**  
   - Practice DDL (Data Definition Language) and DML (Data Manipulation Language).  
   - Develop queries to retrieve, aggregate, and analyze financial information (e.g., total monthly spending, average daily balance).

4. **Real-World Constraints**  
   - Think through concurrency or edge cases (e.g., overdrafts, partial payments).  
   - Explore how financial data can be summarized or reported (e.g., monthly budget breakdown, annual expense categories).

---

## Requirements / Scope

1. **Accounts Table**  
   - Must store at least:  
     - An **account_id** (primary key).  
     - **account_type** (e.g., Checking, Savings, Credit Card).  
     - **account_name** or **nickname**.  
     - **balance** (with a suitable numeric or decimal type).  
   - Optionally, track **interest_rate**, **credit_limit**, or any other fields relevant to financial accounts.

2. **Transactions Table**  
   - Records money moving in or out of accounts.  
   - Must include:  
     - **transaction_id** (primary key).  
     - **account_id** (foreign key to Accounts).  
     - **transaction_date** and **amount**.  
     - **transaction_type** (credit vs. debit, or deposit/withdrawal).  
     - **category** (e.g., groceries, rent, entertainment) – can be text or a foreign key to a Categories table if you want.  
   - Consider constraints or logic to **prohibit negative balances** (if that’s part of your design).

3. **Recurring Bills & Income Table**  
   - Track repeating bills (like rent) or paychecks (like a monthly salary).  
   - Must store:  
     - **recurring_id** (primary key).  
     - **description** (e.g., “Monthly Rent,” “Paycheck from Company X”).  
     - **amount** (how much is charged or received each cycle).  
     - **frequency** (weekly, bi-weekly, monthly, etc.).  
     - **start_date** and optionally **end_date** if it’s temporary.  

4. **Budget / Summary Tables (Optional)**  
   - You may create additional tables for **budget goals** (monthly or yearly).  
   - Or consider a **Categories** table to organize transaction spending.

5. **Stored Procedures / Triggers (Optional but Encouraged)**  
   - Example triggers:  
     - **Auto-update account balances** when a new transaction is inserted.  
     - **Prevent** transactions that cause the balance to drop below zero (for certain account types).  
   - Example procedures:  
     - **Generate monthly statements** summarizing all transactions for each account.  
     - **Auto-label** transactions based on merchant names or categories.

---

## Deliverables

1. **Database Schema (DDL) Script**  
   - A `.sql` file that **creates** all tables with columns, data types, constraints (primary/foreign keys, check constraints, etc.).  
   - Include all optional or advanced tables (e.g., Categories, Budgets) if you choose to implement them.

2. **Sample Data Insertion**  
   - Populate each table with **enough records** to demonstrate functionality (e.g., 10–20 accounts, 50–100 transactions, a few recurring bills).  
   - The data should reflect a variety of scenarios—different transaction types, categories, and frequencies.

3. **Queries / Operations**  
   - Provide a set of **SQL queries** that illustrate how one can retrieve meaningful financial information:  
     - E.g., total monthly spending by category, largest expenses, monthly net income, etc.  
   - (Optional) If you implemented triggers or procedures, **demonstrate** them (e.g., show how a trigger updates account balances automatically).

4. **Documentation**  
   - A brief **explanation** of your design and assumptions.  
   - If you implemented advanced features, document how they work (e.g., stored procedures or triggers, concurrency handling).  
   - Outline any constraints or special rules (e.g., “No negative balances for savings accounts”).

---

## Example Tasks Students Might Tackle
1. **Check Balances Across Accounts**  
   - “Select each account’s current balance; which accounts have the highest or lowest balances?”

2. **Identify High Expenses**  
   - “Which 5 transactions in the past month had the largest amounts (debits)?”

3. **Monthly Summaries**  
   - “How much was spent in each category during the past month? The past year?”

4. **Recurring Payments**  
   - “Insert monthly rent transactions automatically via a stored procedure or scheduled job.”

5. **Preventing Negative Balances**  
   - “Write a trigger that rejects (ROLLBACK) a transaction if it would push a checking or savings account balance below zero.”

---

## Submission Guidelines

1. **Files**  
   - `create_finance_db.sql`: Contains all `CREATE TABLE` statements and any constraints.  
   - `insert_sample_data.sql`: Contains `INSERT` statements for sample data.  
   - `queries_and_operations.sql`: Contains queries (e.g., SELECT statements, JOINs, etc.) and optional triggers/procedures.

2. **Format**  
   - Ensure your `.sql` scripts can be run sequentially in your chosen DBMS (e.g., MySQL).  
   - Provide a short PDF/Markdown document summarizing your design, assumptions, and steps to run or test the project.

3. **Deadline**  
   - Check the course LMS for the exact due date and time.  
   - Late submissions may be penalized according to the course’s late policy.

4. **Grading**  
   - **Completeness**: Did you create all required tables? Insert enough data? Cover essential use cases?  
   - **Accuracy**: Do the tables, constraints, and relationships reflect a workable financial system?  
   - **Complexity**: Did you go beyond the basics (e.g., triggers, stored procedures, views)?  
   - **Documentation**: Are your assumptions, design rationale, and usage instructions clear?

---

### Tips for Success
- Think carefully about your **data types** (use `DECIMAL` for money values to avoid floating-point imprecision).  
- Decide whether some accounts can go negative (like credit cards) and how to handle that logically.  
- If implementing triggers or stored procedures, **test** them thoroughly with sample transactions.  
- Keep your design organized—clean naming conventions help maintain clarity (e.g., `accounts`, `transactions`, `recurring_bills`).

**Enjoy building your Personal Finance Tracker, and remember to test your database thoroughly.** 
