-- Bài tập cuối học phần 3
-- Question 1:
CREATE DATABASE IF NOT EXISTS NhanVienDB;
USE NhanVienDB;

-- Bảng Quốc gia
CREATE TABLE Country (
    country_id INT PRIMARY KEY,
    country_name VARCHAR(100)
);

-- Bảng Địa điểm
CREATE TABLE Location (
    location_id INT PRIMARY KEY,
    street_address VARCHAR(255),
    postal_code VARCHAR(20),
    country_id INT,
    FOREIGN KEY (country_id) REFERENCES Country(country_id)
);

-- Bảng Nhân viên
CREATE TABLE Employee (
    employee_id INT PRIMARY KEY,
    full_name VARCHAR(100),
    email VARCHAR(100),
    location_id INT,
    FOREIGN KEY (location_id) REFERENCES Location(location_id)
        ON DELETE SET NULL
);

-- Thêm dữ liệu mẫu
INSERT INTO Country (country_id, country_name) VALUES
(1, 'Vietnam'),
(2, 'USA'),
(3, 'Japan');

INSERT INTO Location (location_id, street_address, postal_code, country_id) VALUES
(101, '123 Le Loi, HCM', '700000', 1),
(102, '456 Nguyen Hue, HN', '100000', 1),
(201, '789 Silicon Valley, CA', '95000', 2);

INSERT INTO Employee (employee_id, full_name, email, location_id) VALUES
(1, 'Nguyen Nam', 'nn03@gmail.com', 101),
(2, 'Tran Thi Bich', 'bich.tran@gmail.com', 102),
(3, 'John Smith', 'john.smith@gmail.com', 201);
-- Question 2:
-- a) Lấy tất cả các nhân viên thuộc Việt Nam
SELECT e.*
FROM Employee e
JOIN Location l ON e.location_id = l.location_id
JOIN Country c ON l.country_id = c.country_id
WHERE c.country_name = 'Vietnam';
-- b) Lấy ra tên quốc gia của employee có email là "nn03@gmail.com"
SELECT c.country_name
FROM Employee e
JOIN Location l ON e.location_id = l.location_id
JOIN Country c ON l.country_id = c.country_id
WHERE e.email = 'nn03@gmail.com';
-- c) Thống kê mỗi country, mỗi location có bao nhiêu employee đang làm việc.
SELECT 
  c.country_name,
  l.location_id,
  COUNT(e.employee_id) AS employee_count
FROM Country c
JOIN Location l ON c.country_id = l.country_id
LEFT JOIN Employee e ON l.location_id = e.location_id
GROUP BY c.country_name, l.location_id;
-- Question 3:
DELIMITER $$
CREATE TRIGGER CheckMaxEmployeePerCountry
BEFORE INSERT ON Employee
FOR EACH ROW
BEGIN
    DECLARE emp_count INT;

    SELECT COUNT(*) INTO emp_count
    FROM Employee e
    JOIN Location l ON e.location_id = l.location_id
    JOIN Country c ON l.country_id = c.country_id
    WHERE c.country_id = (
        SELECT country_id
        FROM Location
        WHERE location_id = NEW.location_id
    );

    IF emp_count >= 10 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Quốc gia này đã có đủ 10 nhân viên!';
    END IF;
END$$
DELIMITER ;
-- Question 4:
-- Đã cấu hình ngay trong bảng Employee khi tạo:
-- FOREIGN KEY (location_id) REFERENCES Location(location_id) ON DELETE SET NULL 


