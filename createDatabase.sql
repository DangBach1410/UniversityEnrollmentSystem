-- Tạo cơ sở dữ liệu
DROP database IF exists CompanyDB;
CREATE DATABASE CompanyDB;
USE CompanyDB;

-- Bảng phòng ban
CREATE TABLE Department (
    departmentId INT AUTO_INCREMENT PRIMARY KEY,
    departmentName VARCHAR(100) NOT NULL
);

-- Bảng nhân viên
CREATE TABLE Employee (
    employeeId INT AUTO_INCREMENT PRIMARY KEY,
    employeeName VARCHAR(100),
    email VARCHAR(100),
    salary DECIMAL(10,2),
    hireDate DATE,
    departmentId INT,
    managerId INT,
    FOREIGN KEY (departmentId) REFERENCES Department(departmentId),
    FOREIGN KEY (managerId) REFERENCES Employee(employeeId)
);

-- Bảng dự án
CREATE TABLE Project (
    projectId INT AUTO_INCREMENT PRIMARY KEY,
    projectName VARCHAR(100),
    startDate DATE,
    endDate DATE
);

-- Bảng phân công nhân viên vào dự án
CREATE TABLE EmployeeProject (
    employeeId INT,
    projectId INT,
    assignedDate DATE,
    PRIMARY KEY (employeeId, projectId),
    FOREIGN KEY (employeeId) REFERENCES Employee(employeeId),
    FOREIGN KEY (projectId) REFERENCES Project(projectId)
);

INSERT INTO Department (departmentName) VALUES 
('Engineering'),
('HR'),
('Sales'),
('Marketing');
INSERT INTO Employee (employeeName, email, salary, hireDate, departmentId, managerId) VALUES
('Alice Johnson', 'alice@company.com', 75000.00, '2021-05-10', 1, NULL), -- Manager in Engineering
('Bob Smith', 'bob@company.com', 72000.00, '2022-03-15', 1, 1), -- Under Alice
('Carol White', 'carol@company.com', 68000.00, '2020-11-20', 2, NULL), -- HR Manager
('David Lee', 'david@company.com', 61000.00, '2023-01-05', 2, 3), -- Under Carol
('Eve Turner', 'eve@company.com', 69000.00, '2022-07-10', 3, NULL), -- Sales Manager
('Frank Green', 'frank@company.com', 71000.00, '2023-03-01', 3, 5), -- Under Eve
('Grace Hall', 'grace@company.com', 80000.00, '2021-12-12', 4, NULL); -- Marketing Manager
INSERT INTO Project (projectName, startDate, endDate) VALUES
('Website Redesign', '2022-01-10', '2022-12-30'),
('Mobile App', '2023-05-01', NULL),
('Cloud Migration', '2021-06-15', '2023-06-15'),
('Internal Audit', '2024-01-01', NULL);
INSERT INTO EmployeeProject (employeeId, projectId, assignedDate) VALUES
(1, 1, '2021-01-15'), -- Alice on Website Redesign
(2, 1, '2022-01-20'), -- Bob on Website Redesign
(2, 2, '2023-05-01'), -- Bob on Mobile App
(3, 4, '2024-01-01'), -- Carol on Internal Audit
(4, 4, '2024-01-02'), -- David on Internal Audit
(5, 3, '2021-06-20'), -- Eve on Cloud Migration
(6, 2, '2023-06-01'), -- Frank on Mobile App
(6, 3, '2023-03-01'), -- Frank on Cloud Migration
(7, 2, '2023-05-10'); -- Grace on Mobile App

