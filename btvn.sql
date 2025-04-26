-- 1. Liệt kê tất cả sản phẩm hiện có trong kho.
SELECT * FROM Product;

-- 2. Hiển thị tên và email của tất cả khách hàng.
SELECT customerName, email FROM Customer;

-- 3. Lấy các đơn hàng được đặt trong tháng 1 năm 2023.
SELECT * 
FROM OrderInfo 
WHERE orderDate BETWEEN '2023-01-01' AND '2023-01-31';

-- 4. Tìm các sản phẩm có giá trên 500.
SELECT * 
FROM Product 
WHERE price > 500;

-- 5. Liệt kê đơn hàng có trạng thái là "Completed".
SELECT * 
FROM OrderInfo 
WHERE status = 'Completed';

-- 6. Tìm các khách hàng đăng ký sau ngày 01/06/2022.
SELECT * 
FROM Customer 
WHERE joinDate > '2022-06-01';

-- 7. Lấy số lượng sản phẩm trong từng danh mục (category).
SELECT category, COUNT(*) AS product_count 
FROM Product 
GROUP BY category;

-- 8. Tính tổng số sản phẩm có trong kho (stock).
SELECT SUM(stock) AS total_stock 
FROM Product;

-- 9. Hiển thị tên sản phẩm và giá.
SELECT productName, price 
FROM Product;

-- 10. Tìm sản phẩm thuộc danh mục "Electronics".
SELECT * 
FROM Product 
WHERE category = 'Electronics';

-- 11. Lấy tên khách hàng và tổng số đơn hàng họ đã đặt.
SELECT c.customerName, COUNT(o.orderId) AS total_orders
FROM Customer c
LEFT JOIN OrderInfo o ON c.customerId = o.customerId
GROUP BY c.customerId, c.customerName;

-- 12. Tính tổng tiền của từng đơn hàng (quantity × unitPrice).
SELECT orderId, SUM(quantity * unitPrice) AS total_amount
FROM OrderDetail
GROUP BY orderId;

-- 13. Liệt kê các đơn hàng mà tổng tiền lớn hơn 1000.
SELECT od.orderId, SUM(od.quantity * od.unitPrice) AS total_amount
FROM OrderDetail od
GROUP BY od.orderId
HAVING total_amount > 1000;

-- 14. Tìm những khách hàng chưa từng đặt đơn hàng nào.
SELECT c.customerName
FROM Customer c
LEFT JOIN OrderInfo o ON c.customerId = o.customerId
WHERE o.orderId IS NULL;

-- 15. Lấy danh sách khách hàng đã hủy đơn hàng (status = 'Cancelled').
SELECT DISTINCT c.customerName, c.email
FROM Customer c
JOIN OrderInfo o ON c.customerId = o.customerId
WHERE o.status = 'Cancelled';

-- 16. Lấy sản phẩm bán chạy nhất (dựa trên tổng quantity trong OrderDetail).
SELECT p.productName, SUM(od.quantity) AS total_sold
FROM Product p
JOIN OrderDetail od ON p.productId = od.productId
GROUP BY p.productId, p.productName
ORDER BY total_sold DESC
LIMIT 1;

-- 17. Hiển thị tất cả sản phẩm chưa từng được bán.
SELECT p.productName
FROM Product p
LEFT JOIN OrderDetail od ON p.productId = od.productId
WHERE od.productId IS NULL;

-- 18. Lấy các đơn hàng có chứa sản phẩm tên là “Wireless Mouse”.
SELECT oi.orderId, oi.orderDate, c.customerName
FROM OrderInfo oi
JOIN OrderDetail od ON oi.orderId = od.orderId
JOIN Product p ON od.productId = p.productId
JOIN Customer c ON oi.customerId = c.customerId
WHERE p.productName = 'Wireless Mouse';

-- 19. Tính doanh thu theo từng loại danh mục sản phẩm.
SELECT p.category, SUM(od.quantity * od.unitPrice) AS total_revenue
FROM Product p
JOIN OrderDetail od ON p.productId = od.productId
GROUP BY p.category;

-- 20. Hiển thị chi tiết từng đơn hàng gồm: tên khách hàng, ngày đặt, sản phẩm và số lượng.
SELECT c.customerName, oi.orderDate, p.productName, od.quantity
FROM OrderInfo oi
JOIN Customer c ON oi.customerId = c.customerId
JOIN OrderDetail od ON oi.orderId = od.orderId
JOIN Product p ON od.productId = p.productId;

-- 21. Tính doanh thu theo từng khách hàng
SELECT 
    c.customerName,
    SUM(od.quantity * od.unitPrice) AS totalRevenue
FROM Customer c
JOIN OrderInfo o ON c.customerId = o.customerId
JOIN OrderDetail od ON o.orderId = od.orderId
GROUP BY c.customerId;

-- 22. Tìm đơn hàng có số lượng sản phẩm nhiều nhất
SELECT 
    o.orderId,
    SUM(od.quantity) AS totalQuantity
FROM OrderInfo o
JOIN OrderDetail od ON o.orderId = od.orderId
GROUP BY o.orderId
ORDER BY totalQuantity DESC
LIMIT 1;

-- 23. Liệt kê khách hàng đã mua hàng mỗi tháng trong năm 2023
SELECT DISTINCT 
    c.customerName,
    MONTH(o.orderDate) AS month
FROM Customer c
JOIN OrderInfo o ON c.customerId = o.customerId
WHERE YEAR(o.orderDate) = 2023
ORDER BY month;

-- 24. Lấy sản phẩm được bán trong ít nhất 2 đơn hàng khác nhau
SELECT 
    p.productName,
    COUNT(DISTINCT od.orderId) AS numOrders
FROM Product p
JOIN OrderDetail od ON p.productId = od.productId
GROUP BY p.productId
HAVING numOrders >= 2;

-- 25. Tìm đơn hàng có giá trị thấp nhất và cao nhất
WITH OrderTotals AS (
    SELECT 
        o.orderId,
        SUM(od.quantity * od.unitPrice) AS totalValue
    FROM OrderInfo o
    JOIN OrderDetail od ON o.orderId = od.orderId
    GROUP BY o.orderId
),
MinOrder AS (
    SELECT * FROM OrderTotals ORDER BY totalValue ASC LIMIT 1
),
MaxOrder AS (
    SELECT * FROM OrderTotals ORDER BY totalValue DESC LIMIT 1
)
SELECT * FROM MinOrder
UNION ALL
SELECT * FROM MaxOrder;

-- 26. Tìm khách hàng chi tiêu nhiều nhất từ trước đến nay
SELECT 
    c.customerName,
    SUM(od.quantity * od.unitPrice) AS totalSpent
FROM Customer c
JOIN OrderInfo o ON c.customerId = o.customerId
JOIN OrderDetail od ON o.orderId = od.orderId
GROUP BY c.customerId
ORDER BY totalSpent DESC
LIMIT 1;

-- 27. Hiển thị danh sách đơn hàng có ít nhất 2 loại sản phẩm
SELECT 
    o.orderId,
    COUNT(DISTINCT p.category) AS productTypes
FROM OrderInfo o
JOIN OrderDetail od ON o.orderId = od.orderId
JOIN Product p ON p.productId = od.productId
GROUP BY o.orderId
HAVING productTypes >= 2;

-- 28. Tính doanh thu trung bình mỗi tháng trong năm 2023
SELECT 
    MONTH(o.orderDate) AS month,
    AVG(od.quantity * od.unitPrice) AS avgRevenue
FROM OrderInfo o
JOIN OrderDetail od ON o.orderId = od.orderId
WHERE YEAR(o.orderDate) = 2023
GROUP BY MONTH(o.orderDate)
ORDER BY month;

-- 29. Báo cáo: tên khách hàng, tổng số đơn, tổng tiền, số lượng sản phẩm
SELECT 
    c.customerName,
    COUNT(DISTINCT o.orderId) AS totalOrders,
    SUM(IFNULL(od.quantity * od.unitPrice, 0)) AS totalSpent,
    SUM(IFNULL(od.quantity, 0)) AS totalItems
FROM Customer c
LEFT JOIN OrderInfo o ON c.customerId = o.customerId
LEFT JOIN OrderDetail od ON o.orderId = od.orderId
GROUP BY c.customerId;

-- 30. Tìm khách hàng mua tất cả sản phẩm thuộc danh mục "Electronics"
SELECT c.customerName
FROM Customer c
WHERE NOT EXISTS (
    SELECT p.productId
    FROM Product p
    WHERE p.category = 'Electronics'
    AND NOT EXISTS (
        SELECT 1
        FROM OrderInfo o
        JOIN OrderDetail od ON o.orderId = od.orderId
        WHERE o.customerId = c.customerId
        AND od.productId = p.productId
    )
);
