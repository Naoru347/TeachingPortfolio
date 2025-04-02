-- SQL Script to Create and Populate Sample Database for Homework 2

-- Drop database if it already exists
DROP DATABASE IF EXISTS Homework2DB;

-- Create new database
CREATE DATABASE Homework2DB;

-- Use the new database
USE Homework2DB;

-- Create 'Employees' table
CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Department VARCHAR(50),
    Salary DECIMAL(10, 2),
    HireDate DATE
);

-- Insert sample data into 'Employees' table
INSERT INTO Employees (EmployeeID, FirstName, LastName, Department, Salary, HireDate) VALUES
(1, 'John', 'Doe', 'Sales', 55000, '2018-03-15'),
(2, 'Jane', 'Smith', 'Marketing', 62000, '2019-07-22'),
(3, 'Mike', 'Johnson', 'Sales', 48000, '2020-05-17'),
(4, 'Emily', 'Davis', 'HR', 59000, '2017-10-12'),
(5, 'Samuel', 'Brown', 'IT', 72000, '2021-01-20'),
(6, 'Laura', 'Wilson', 'Marketing', 64000, '2022-03-30'),
(7, 'Alex', 'Garcia', 'IT', 68000, '2019-11-01'),
(8, 'Sophie', 'Lee', 'HR', 56000, '2023-02-05'),
(9, 'James', 'Martinez', 'Sales', 50000, '2020-08-25'),
(10, 'Olivia', 'Clark', 'Marketing', 63000, '2021-09-14');

-- Create 'Products' table
CREATE TABLE Products (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(100),
    Category VARCHAR(50),
    Price DECIMAL(10, 2),
    Stock INT
);

-- Insert sample data into 'Products' table
INSERT INTO Products (ProductID, ProductName, Category, Price, Stock) VALUES
(101, 'Wireless Mouse', 'Electronics', 25.99, 120),
(102, 'Bluetooth Keyboard', 'Electronics', 45.50, 80),
(103, 'Water Bottle', 'Accessories', 12.00, 150),
(104, 'Notebook', 'Stationery', 3.50, 200),
(105, 'Desk Lamp', 'Electronics', 29.99, 60),
(106, 'Backpack', 'Accessories', 35.00, 90),
(107, 'Pen Set', 'Stationery', 5.99, 300),
(108, 'USB Drive 64GB', 'Electronics', 15.99, 140),
(109, 'Travel Mug', 'Accessories', 10.00, 110),
(110, 'Headphones', 'Electronics', 59.99, 70);

-- Verify the inserted data
SELECT * FROM Employees;
SELECT * FROM Products;
