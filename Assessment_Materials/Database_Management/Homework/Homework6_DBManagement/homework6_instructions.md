# Homework: User Management in MySQL

## Overview
In this homework, you will practice managing database users and permissions in a MySQL environment. By creating new users, assigning privileges, and revoking permissions, you’ll gain hands-on experience in securing and maintaining a database.

---

## Homework Objectives
1. **Create and manage database users**: Understand how to add new MySQL users with different permission levels.
2. **Assign appropriate privileges**: Learn how to grant permissions based on user roles.
3. **Revoke and test permissions**: Demonstrate the ability to remove user privileges and confirm that the user’s actions are restricted.
4. **Practice good security practices**: Emphasize principles like least privilege to maintain a secure database environment.

---

## Instructions

1. **Set Up the Environment**
   - Use MySQL Workbench or the MySQL command line.
   - Connect to your local MySQL server using an account with `CREATE USER` and `GRANT OPTION` privileges (e.g., `root` or a similarly privileged account).

2. **Create a New Database**
   - Optionally, create a small database for testing user permissions (e.g., `CREATE DATABASE HomeworkUserDB;`).
   - Use `USE HomeworkUserDB;` to switch to the database.
   - You may also make use of/modify the attached homeworkuserdb.sql script.

3. **Create Users**
   - Create at least two new MySQL user accounts:
     - **User A**: A developer with permissions to create tables and modify data.
     - **User B**: A reporting analyst with read-only permissions.
   - Use `CREATE USER` syntax to define each user and password.
   - Example:
     ```sql
     CREATE USER 'dev_user'@'localhost' IDENTIFIED BY 'DevUserPass123';
     CREATE USER 'report_user'@'localhost' IDENTIFIED BY 'ReportUserPass123';
     ```

4. **Grant Permissions**
   - **User A** (Developer):
     - Grant privileges to create, alter, insert, update, and delete tables in `HomeworkUserDB`.
   - **User B** (Reporting Analyst):
     - Grant only SELECT privileges in `HomeworkUserDB`.
   - Use `GRANT` statements for these permissions.
   - Example:
     ```sql
     GRANT CREATE, ALTER, INSERT, UPDATE, DELETE ON HomeworkUserDB.* TO 'dev_user'@'localhost';
     GRANT SELECT ON HomeworkUserDB.* TO 'report_user'@'localhost';
     ```

5. **Test Permissions**
   - **Log in** as each user (dev_user and report_user) in a new MySQL Workbench session or CLI session.
   - Attempt various operations (e.g., creating tables, inserting data, selecting data) to confirm the correct permissions.

6. **Revoke Permissions**
   - Choose one privilege from dev_user (e.g., `ALTER`) and revoke it.
   - Example:
     ```sql
     REVOKE ALTER ON HomeworkUserDB.* FROM 'dev_user'@'localhost';
     ```
   - Verify that dev_user can no longer alter tables.

7. **Document Your Work**
   - Provide the SQL statements used for creating users, granting privileges, and revoking privileges.
   - Explain why each permission is assigned or revoked.
   - Include screenshots or logs demonstrating successful or failed operations under each user account.

---

## Submission Requirements
- **Format:** Submit a single PDF containing your SQL statements, brief explanations, and evidence (screenshots) of testing.
- **Structure:** Use clear headings for each step (Create Users, Grant Permissions, Test, Revoke).

---

## Grading Criteria
- **Correctness of SQL Statements (50%)**: Proper `CREATE USER`, `GRANT`, and `REVOKE` syntax.
- **Testing and Validation (30%)**: Clear evidence that permissions are correctly assigned and revoked.
- **Documentation & Organization (20%)**: Well-structured PDF, concise explanations, labeled screenshots.

---

## Due Date
Submit your final PDF document via the course LMS by **[Insert Due Date Here]**.

---

Remember: Proper user management and permission assignment is essential for database security. Good luck and have fun exploring MySQL user management!

