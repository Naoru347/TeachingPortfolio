-- Starter Database for Homework: User Management
-- This script creates a sample database (HomeworkUserDB) and populates it with minimal data.

-- 1. Drop the database if it already exists
DROP DATABASE IF EXISTS HomeworkUserDB;

-- 2. Create the new database
CREATE DATABASE HomeworkUserDB;

-- 3. Switch to the newly created database
USE HomeworkUserDB;

-- 4. Create a sample table: 'Projects'
CREATE TABLE Projects (
    ProjectID INT PRIMARY KEY,
    ProjectName VARCHAR(100),
    StartDate DATE,
    Budget DECIMAL(10,2)
);

-- 5. Insert sample data into 'Projects'
INSERT INTO Projects (ProjectID, ProjectName, StartDate, Budget) VALUES
(1, 'Campus Redesign', '2023-05-01', 50000.00),
(2, 'Library Digital Archive', '2023-06-15', 120000.00),
(3, 'Online Registration Overhaul', '2023-09-01', 80000.00);

-- 6. Create a second sample table: 'Employees'
CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Role VARCHAR(50)
);

-- 7. Insert sample data into 'Employees'
INSERT INTO Employees (EmployeeID, FirstName, LastName, Role) VALUES
(101, 'Alice', 'Wong', 'Project Manager'),
(102, 'Bob', 'Smith', 'Developer'),
(103, 'Carol', 'Lee', 'Analyst');

-- 8. View the initial data (optional check)
SELECT * FROM Projects;
SELECT * FROM Employees;

-- Now the 'HomeworkUserDB' database is ready for you to practice creating users and granting privileges.
-- You can log in as different users once you finish the user management steps.
-- Note: Make sure to adjust the database connection settings in your SQL client to connect to 'HomeworkUserDB'.
-- This database is intended for educational purposes and should not be used in a production environment.
