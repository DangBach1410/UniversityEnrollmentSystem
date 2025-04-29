-- Bài tập cuối học phần 2
-- Question 1:
CREATE DATABASE IF NOT EXISTS ThucTap;
USE ThucTap;

-- Bảng Giảng Viên
CREATE TABLE GiangVien (
    magv INT PRIMARY KEY,
    hoten VARCHAR(100),
    luong DECIMAL(10,2)
);

-- Bảng Sinh Viên
CREATE TABLE SinhVien (
    masv INT PRIMARY KEY,
    hoten VARCHAR(100),
    namsinh INT,
    quequan VARCHAR(100)
);

-- Bảng Đề Tài
CREATE TABLE DeTai (
    madt INT PRIMARY KEY,
    tendt VARCHAR(200),
    kinhphi DECIMAL(10,2),
    NoiThucTap VARCHAR(100)
);

-- Bảng Hướng Dẫn
CREATE TABLE HuongDan (
    id INT PRIMARY KEY AUTO_INCREMENT,
    masv INT,
    madt INT,
    magv INT,
    ketqua VARCHAR(10),
    FOREIGN KEY (masv) REFERENCES SinhVien(masv) ON DELETE CASCADE,
    FOREIGN KEY (madt) REFERENCES DeTai(madt),
    FOREIGN KEY (magv) REFERENCES GiangVien(magv)
);

-- Thêm dữ liệu
INSERT INTO GiangVien (magv, hoten, luong) VALUES
(1, 'Nguyen Van A', 15000000),
(2, 'Tran Thi B', 16000000),
(3, 'Le Van C', 14500000);

INSERT INTO SinhVien (masv, hoten, namsinh, quequan) VALUES
(101, 'Pham Van Nam', 2002, 'Ha Noi'),
(102, 'Tran Thi Mai', 2001, 'Hai Phong'),
(103, 'Le Dinh Tuan', 2003, 'Da Nang');

INSERT INTO DeTai (madt, tendt, kinhphi, NoiThucTap) VALUES
(201, 'CONG NGHE SINH HOC', 50000000, 'Cong ty BioTech'),
(202, 'TRI TUE NHAN TAO', 60000000, 'FPT AI Lab'),
(203, 'PHAT TRIEN WEB', 30000000, 'VNG');

INSERT INTO HuongDan (masv, madt, magv, ketqua) VALUES
(101, 201, 1, 'Dat'),
(102, 202, 2, 'Tot');
-- SV 103 chưa có đề tài

-- Question 2:
-- a) Lấy tất cả các sinh viên chưa có đề tài hướng dẫn
SELECT sv.masv, sv.hoten
FROM SinhVien sv
LEFT JOIN HuongDan hd ON sv.masv = hd.masv
WHERE hd.masv IS NULL;
-- b) Lấy ra số sinh viên làm đề tài ‘CONG NGHE SINH HOC’
SELECT COUNT(*) AS SoSinhVien
FROM HuongDan hd
JOIN DeTai dt ON hd.madt = dt.madt
WHERE dt.tendt = 'CONG NGHE SINH HOC';
-- Question 3:
CREATE VIEW SinhVienInfo AS
SELECT 
    sv.masv,
    sv.hoten,
    COALESCE(dt.tendt, 'Chưa có') AS tendetai
FROM SinhVien sv
LEFT JOIN HuongDan hd ON sv.masv = hd.masv
LEFT JOIN DeTai dt ON hd.madt = dt.madt;
-- Question 4:
DELIMITER $$
CREATE TRIGGER CheckNamSinh
BEFORE INSERT ON SinhVien
FOR EACH ROW
BEGIN
    IF NEW.namsinh <= 1900 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'năm sinh phải > 1900';
    END IF;
END$$
DELIMITER ;
-- Question 5:
-- Đã được cấu hình ngay trong bảng HuongDan ở phần tạo bảng
-- FOREIGN KEY (masv) REFERENCES SinhVien(masv) ON DELETE CASCADE

