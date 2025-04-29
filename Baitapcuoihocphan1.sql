-- Bài tập cuối học phần 1
-- Question 1:
DROP DATABASE IF EXISTS SchoolDB;
CREATE DATABASE SchoolDB;
USE SchoolDB;
CREATE TABLE Student (
    ID INT PRIMARY KEY,
    Name VARCHAR(100),
    Age INT,
    Gender TINYINT -- 0 = Male, 1 = Female, NULL = Unknown
);

CREATE TABLE Subject (
    ID INT PRIMARY KEY,
    Name VARCHAR(100)
);

CREATE TABLE StudentSubject (
    StudentID INT,
    SubjectID INT,
    Mark DECIMAL(5,2),
    Date DATE,
    PRIMARY KEY (StudentID, SubjectID, Date),
    FOREIGN KEY (StudentID) REFERENCES Student(ID),
    FOREIGN KEY (SubjectID) REFERENCES Subject(ID)
);

-- Thêm dữ liệu mẫu
INSERT INTO Student (ID, Name, Age, Gender) VALUES
(1, 'An', 17, 0),
(2, 'Bình', 18, 1),
(3, 'Chi', 17, NULL);

INSERT INTO Subject (ID, Name) VALUES
(101, 'Toán'),
(102, 'Văn'),
(103, 'Lý');

INSERT INTO StudentSubject (StudentID, SubjectID, Mark, Date) VALUES
(1, 101, 9.5, '2024-01-10'),
(2, 101, 8.0, '2024-01-12'),
(3, 102, 7.5, '2024-01-15');
-- Question 2:
-- a) Lấy tất cả các môn học không có bất kỳ điểm nào
SELECT s.ID, s.Name
FROM Subject s
LEFT JOIN StudentSubject ss ON s.ID = ss.SubjectID
WHERE ss.SubjectID IS NULL;
-- b) Lấy danh sách các môn học có ít nhất 2 điểm
SELECT s.ID, s.Name, COUNT(*) AS TotalMarks
FROM Subject s
JOIN StudentSubject ss ON s.ID = ss.SubjectID
GROUP BY s.ID, s.Name
HAVING COUNT(*) >= 2;
-- Question 3:
CREATE VIEW StudentInfo AS
SELECT
    st.ID AS StudentID,
    sb.ID AS SubjectID,
    st.Name AS StudentName,
    st.Age AS StudentAge,
    CASE
        WHEN st.Gender = 0 THEN 'Male'
        WHEN st.Gender = 1 THEN 'Female'
        ELSE 'Unknown'
    END AS Gender,
    sb.Name AS SubjectName,
    ss.Mark,
    ss.Date
FROM Student st
JOIN StudentSubject ss ON st.ID = ss.StudentID
JOIN Subject sb ON sb.ID = ss.SubjectID;
-- Question 4:
-- a) Tạo trigger cho table Subject có tên là SubjectUpdateID
DELIMITER $$
CREATE TRIGGER SubjectUpdateID
BEFORE UPDATE ON Subject
FOR EACH ROW
BEGIN
    UPDATE StudentSubject
    SET SubjectID = NEW.ID
    WHERE SubjectID = OLD.ID;
END$$
DELIMITER ;
-- b) Tạo trigger cho table StudentSubject có tên là StudentDeleteID
DELIMITER $$
CREATE TRIGGER StudentDeleteID
BEFORE DELETE ON Student
FOR EACH ROW
BEGIN
    DELETE FROM StudentSubject
    WHERE StudentID = OLD.ID;
END$$
DELIMITER ;
-- Question 5:
DELIMITER $$
CREATE PROCEDURE DeleteStudentByNames(
    IN studentName1 VARCHAR(100),
    IN studentName2 VARCHAR(100)
)
BEGIN
    IF studentName1 = '*' OR studentName2 = '*' THEN
        DELETE FROM StudentSubject;
        DELETE FROM Student;
    ELSE
        DELETE FROM StudentSubject
        WHERE StudentID IN (
            SELECT ID FROM Student
            WHERE Name = studentName1 OR Name = studentName2
        );
        
        DELETE FROM Student
        WHERE Name = studentName1 OR Name = studentName2;
    END IF;
END$$
DELIMITER ;

