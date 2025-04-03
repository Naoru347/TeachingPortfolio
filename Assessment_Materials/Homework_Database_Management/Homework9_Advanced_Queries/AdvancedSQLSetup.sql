-- SQL Script for the Advanced SQL Queries Assignment
-- Creates a sample database (AdvSQLDB) and populates it with data suitable for subqueries, CTEs, and window functions.

-- 1. Drop the database if it already exists
DROP DATABASE IF EXISTS AdvSQLDB;

-- 2. Create the new database
CREATE DATABASE AdvSQLDB;

-- 3. Switch to the newly created database
USE AdvSQLDB;

-- 4. Create Departments table
CREATE TABLE Departments (
    DepartmentID INT PRIMARY KEY,
    DepartmentName VARCHAR(100)
);

-- 5. Populate Departments table
INSERT INTO Departments (DepartmentID, DepartmentName) VALUES
(1, 'Sales'),
(2, 'Marketing'),
(3, 'IT');

-- 6. Create Employees table
CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    DepartmentID INT,
    Salary DECIMAL(10, 2),
    HireDate DATE,
    FOREIGN KEY (DepartmentID) REFERENCES Departments(DepartmentID)
);

-- 7. Populate Employees table
INSERT INTO Employees (EmployeeID, FirstName, LastName, DepartmentID, Salary, HireDate) VALUES
(101, 'Alice', 'Wong', 1, 65000, '2021-06-15'),
(102, 'Bob', 'Smith', 1, 55000, '2022-01-10'),
(103, 'Carol', 'Chen', 2, 70000, '2020-03-05'),
(104, 'David', 'Lin', 2, 72000, '2019-12-01'),
(105, 'Ethan', 'Zhou', 3, 80000, '2021-08-20'),
(106, 'Fiona', 'Gupta', 3, 82000, '2018-10-31');

-- 8. Create Customers table
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    City VARCHAR(50),
    State VARCHAR(50),
    Zip VARCHAR(10)
);

-- 9. Populate Customers table
INSERT INTO Customers (CustomerID, FirstName, LastName, City, State, Zip) VALUES
(201, 'George', 'Adams', 'Seattle', 'WA', '98104'),
(202, 'Hannah', 'Brown', 'Portland', 'OR', '97205'),
(203, 'Ian', 'Collins', 'San Francisco', 'CA', '94102'),
(204, 'Jenna', 'Diaz', 'Austin', 'TX', '78701');

-- 10. Create Products table
CREATE TABLE Products (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(100),
    Category VARCHAR(50),
    ListPrice DECIMAL(10, 2)
);

-- 11. Populate Products table
INSERT INTO Products (ProductID, ProductName, Category, ListPrice) VALUES
(301, 'Laptop', 'Electronics', 999.99),
(302, 'Smartphone', 'Electronics', 799.99),
(303, 'Desk Chair', 'Furniture', 129.99),
(304, 'Coffee Table', 'Furniture', 89.50),
(305, 'Headphones', 'Electronics', 199.99),
(306, 'LED Monitor', 'Electronics', 249.99);

-- 12. Create Orders table
CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    OrderDate DATE,
    CustomerID INT,
    TotalAmount DECIMAL(10, 2),
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- 13. Populate Orders table
INSERT INTO Orders (OrderID, OrderDate, CustomerID, TotalAmount) VALUES
(401, '2023-08-01', 201, 1199.98),
(402, '2023-08-02', 202, 129.99),
(403, '2023-08-05', 201, 999.99),
(404, '2023-08-07', 203, 1049.49),
(405, '2023-08-10', 204, 199.99),
(406, '2023-08-12', 202, 129.99);

-- 14. Create OrderItems table
CREATE TABLE OrderItems (
    OrderID INT,
    ProductID INT,
    Quantity INT,
    Price DECIMAL(10, 2),
    PRIMARY KEY (OrderID, ProductID),
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

-- 15. Populate OrderItems table
INSERT INTO OrderItems (OrderID, ProductID, Quantity, Price) VALUES
(401, 301, 1, 999.99),  -- 1 Laptop
(401, 305, 1, 199.99),  -- 1 Headphones
(402, 303, 1, 129.99),  -- 1 Desk Chair
(403, 302, 1, 799.99),  -- 1 Smartphone
(403, 306, 1, 200.00),  -- 1 LED Monitor (discounted price for example)
(404, 301, 1, 999.99),  -- 1 Laptop
(405, 304, 1, 89.50),   -- 1 Coffee Table
(405, 303, 1, 110.49),  -- 1 Desk Chair (fictional discounted price)
(406, 303, 1, 129.99);  -- 1 Desk Chair

-- 16. Final check
SELECT 'Setup Complete. Tables Created and Data Inserted.' AS Status;
