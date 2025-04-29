-- 1. Liệt kê tất cả các người dùng trong hệ thống.
SELECT * FROM users;

-- 2. Tìm tên và email của các khách hàng.
SELECT CONCAT(first_name, " ", last_name) as fullName FROM customers;

-- 3. Đếm số lượng sản phẩm hiện có.
SELECT COUNT(*) AS total_products FROM products;

-- 4. Liệt kê tất cả các đơn hàng và tổng tiền tương ứng.
SELECT o.order_id, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM orders o
JOIN order_items oi ON o.order_id = oi.order_id
GROUP BY o.order_id;

-- 5. Tìm các đơn hàng đang ở trạng thái "Pending".
SELECT * FROM orders WHERE status = 'Pending';

-- 6. Tìm tất cả sản phẩm có giá lớn hơn 500.
SELECT * FROM products WHERE price > 500;

-- 7. Đếm số khách hàng theo từng tỉnh/thành phố.
-- không tìm thấy trường tinh/thành phố trong database 

-- 8. Liệt kê tất cả sản phẩm thuộc danh mục "Electronics".
SELECT p.*, c.name as category FROM products p
JOIN product_categories pc ON pc.product_id = p.product_id
JOIN categories c on c.category_id = pc.category_id
WHERE c.name = 'Electronics';

-- 9. Hiển thị thông tin chi tiết các đơn hàng: mã đơn hàng, tên sản phẩm, số lượng.
SELECT o.order_id, p.name as product_name, oi.quantity
FROM order_items oi
JOIN orders o ON oi.order_id = o.order_id
JOIN products p ON oi.product_id = p.product_id
ORDER BY order_id;

-- 10. Tìm tất cả các kho hàng hiện có.
SELECT * FROM warehouses;

-- 11. Liệt kê tất cả sản phẩm có tồn kho dưới 20.
SELECT p.*, i.stock_quantity
FROM inventory i
JOIN products p ON i.product_id = p.product_id
WHERE i.stock_quantity < 20;

-- 12. Tìm các phương thức thanh toán có chi phí lớn hơn 1000.
SELECT DISTINCT payment_method FROM payments 
WHERE amount > 1000;

-- 13. Liệt kê các đơn hàng của khách hàng có user_id = 5.
SELECT * FROM orders 
WHERE customer_id = 5;

-- 14. Lấy 10 sản phẩm có giá cao nhất.
SELECT * FROM products 
ORDER BY price DESC 
LIMIT 10;

-- 15. Tính tổng tiền đã thanh toán của đơn hàng có ID = 1.
SELECT total_amount
FROM orders
WHERE order_id = 1;

-- 16. Liệt kê tên khách hàng và tổng số đơn hàng họ đã đặt.
SELECT CONCAT(c.first_name, " ", c.last_name) as full_name, COUNT(o.order_id) AS total_orders
FROM customers c
LEFT JOIN orders o ON c.customer_id = o.customer_id
GROUP BY c.customer_id;

-- 17. Tìm các sản phẩm chưa từng xuất hiện trong bất kỳ đơn hàng nào.
SELECT * FROM products
WHERE product_id NOT IN (SELECT DISTINCT product_id FROM order_items);

-- 18. Đếm số lượng sản phẩm theo từng danh mục.
SELECT c.name as category_name, COUNT(p.product_id) AS total_products
FROM categories c
LEFT JOIN product_categories pc ON pc.category_id = c.category_id
LEFT JOIN products p ON pc.product_id = p.product_id
GROUP BY c.category_id;

-- 19. Liệt kê các sản phẩm của nhà cung cấp có id = 3.
SELECT * FROM products WHERE supplier_id = 3;

-- 20. Tìm các đơn hàng có tổng tiền lớn hơn 1000 và đã được giao hàng.
SELECT o.order_id, SUM(oi.quantity * oi.unit_price) AS total
FROM orders o
JOIN order_items oi ON o.order_id = oi.order_id
WHERE o.status = 'Delivered'
GROUP BY o.order_id
HAVING total > 1000;

-- 21. Liệt kê tên người dùng và vai trò của họ.
SELECT IFNULL(CONCAT(c.first_name, " ", c.last_name), u.username) as full_name , r.role_name
FROM users u
LEFT JOIN customers c ON u.user_id = c.user_id
JOIN user_roles ur ON u.user_id = ur.user_id
JOIN roles r ON r.role_id = ur.role_id;

-- 22. Đếm số lượng người dùng theo từng vai trò.
SELECT r.role_name, COUNT(u.user_id) AS total_users
FROM users u
JOIN user_roles ur ON ur.user_id = u.user_id
JOIN roles r ON ur.role_id = r.role_id
GROUP BY r.role_id;

-- 23. Tìm khách hàng không có bất kỳ đơn hàng nào.
SELECT * FROM customers
WHERE customer_id NOT IN (SELECT DISTINCT customer_id FROM orders);

-- 24. Tính tổng số tiền mà mỗi khách hàng đã thanh toán.
SELECT c.customer_id, CONCAT(c.first_name, " ", c.last_name) as full_name, SUM(p.amount) AS total_paid
FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
JOIN payments p ON o.order_id = p.order_id
GROUP BY c.customer_id;

-- 25. Liệt kê danh sách khách hàng và tên sản phẩm họ đã mua.
SELECT DISTINCT CONCAT(c.first_name, " ", c.last_name) as full_name, p.name as product_name
FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
JOIN order_items oi ON o.order_id = oi.order_id
JOIN products p ON oi.product_id = p.product_id;

-- 26. Tìm các sản phẩm thuộc nhiều hơn một danh mục.
SELECT p.product_id, p.name as product_name
FROM product_categories pc
JOIN products p ON pc.product_id = p.product_id
GROUP BY p.product_id
HAVING COUNT(DISTINCT pc.category_id) > 1;

-- 27. Hiển thị các sản phẩm được lưu trữ ở nhiều kho khác nhau.
SELECT product_id, COUNT(DISTINCT warehouse_id) AS warehouse_count
FROM inventory
GROUP BY product_id
HAVING warehouse_count > 1;

-- 28. Tìm tên sản phẩm và số lượng còn tồn trong mỗi kho.
SELECT w.name as warehouse_name, p.name as product_name, i.stock_quantity
FROM inventory i
JOIN warehouses w ON i.warehouse_id = w.warehouse_id
JOIN products p ON i.product_id = p.product_id;

-- 29. Tính tổng giá trị hàng tồn kho tại mỗi kho.
SELECT w.warehouse_name, SUM(i.quantity * p.price) AS total_value
FROM inventory i
JOIN warehouses w ON i.warehouse_id = w.warehouse_id
JOIN products p ON i.product_id = p.product_id
GROUP BY w.warehouse_id;

-- 30. Liệt kê các đơn hàng được giao bằng phương thức "Express".
SELECT o.* FROM orders o
JOIN shipments s ON o.order_id = s.order_id
JOIN shipping_methods sm ON sm.shipping_method_id = s.shipping_method_id
WHERE sm.name = 'Express';

-- 31. Tìm đơn hàng có nhiều mặt hàng nhất.
SELECT order_id, COUNT(*) AS item_count
FROM order_items
GROUP BY order_id
ORDER BY item_count DESC
LIMIT 1;

-- 32. Tính số lượng sản phẩm bán được theo từng thương hiệu (brand).
SELECT b.name as brand_name, SUM(oi.quantity) AS total_sold
FROM products p
JOIN brands b ON p.brand_id = b.brand_id
JOIN order_items oi ON p.product_id = oi.product_id
GROUP BY b.brand_id;

-- 33. Tìm các sản phẩm bán chạy nhất (tổng số lượng cao nhất).
SELECT p.name as product_name, SUM(oi.quantity) AS total_sold
FROM order_items oi
JOIN products p ON oi.product_id = p.product_id
GROUP BY oi.product_id
ORDER BY total_sold DESC
LIMIT 1;

-- 34. Liệt kê tất cả các đơn hàng chưa thanh toán đầy đủ.
SELECT o.order_id
FROM orders o
JOIN payments p ON o.order_id = p.order_id
GROUP BY o.order_id, o.total_amount
HAVING o.total_amount > SUM(p.amount);

-- 35. Đếm số đơn hàng và tổng tiền theo trạng thái đơn hàng.
SELECT status, COUNT(*) AS order_count, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM orders o
JOIN order_items oi ON o.order_id = oi.order_id
GROUP BY status;

-- Câu 36: Liệt kê top 5 khách hàng có tổng chi tiêu cao nhất.
SELECT
    c.customer_id,
    CONCAT(c.first_name, " ", c.last_name) as full_name,
    SUM(o.total_amount) AS total_spent
FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
GROUP BY c.customer_id
ORDER BY total_spent DESC
LIMIT 5;

-- Câu 37: Tính trung bình số tiền trên mỗi đơn hàng của mỗi khách hàng.
SELECT
    c.customer_id,
    CONCAT(c.first_name, " ", c.last_name) as full_name,
    AVG(o.total_amount) AS avg_order_amount
FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
GROUP BY c.customer_id;

-- Câu 38: Liệt kê các sản phẩm bán được trong cả ba phương thức vận chuyển.
SELECT p.name as product_name
FROM products p
JOIN order_items oi ON p.product_id = oi.product_id
JOIN orders o ON oi.order_id = o.order_id
JOIN shipments s ON o.order_id = s.order_id
JOIN shipping_methods sm ON sm.shipping_method_id = s.shipping_method_id
WHERE sm.name IN ('Standard', 'Express', 'SameDay')
GROUP BY p.product_id, p.name
HAVING COUNT(DISTINCT sm.name) = 3;

-- Câu 39: Tìm các sản phẩm chưa được nhập kho nào (không có dòng inventory).
SELECT p.name as product_name
FROM products p
LEFT JOIN inventory i ON p.product_id = i.product_id
WHERE i.product_id IS NULL;

-- Câu 40: Xác định những nhà cung cấp có sản phẩm được bán nhiều nhất.
SELECT s.name as supplier_name, p.name as product_name, SUM(oi.quantity) AS total_sold
FROM order_items oi
JOIN products p ON oi.product_id = p.product_id
JOIN suppliers s ON s.supplier_id = p.supplier_id
GROUP BY oi.product_id
ORDER BY total_sold DESC
LIMIT 1;

-- Câu 41: Tìm các khách hàng đã đặt hàng nhiều lần trong cùng một ngày.
SELECT o.customer_id, o.order_date, COUNT(o.order_id) AS order_count
FROM orders o
GROUP BY o.customer_id, o.order_date
HAVING order_count > 1;

-- Câu 42: Liệt kê các đơn hàng có tổng số tiền bằng tổng tiền các sản phẩm trong đó (kiểm tra tính đúng).
SELECT o.order_id, o.total_amount, SUM(oi.quantity * oi.unit_price) AS total_items_amount
FROM orders o
JOIN order_items oi ON o.order_id = oi.order_id
GROUP BY o.order_id
HAVING total_amount = total_items_amount;

-- Câu 43: Tìm tên khách hàng và số lượng phương thức thanh toán họ đã sử dụng.
SELECT CONCAT(c.first_name, " ", c.last_name) as full_name, COUNT(DISTINCT p.payment_method) AS payment_method_count
FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
JOIN payments p ON o.order_id = p.order_id
GROUP BY c.customer_id;

-- Câu 44: Đếm số lượng sản phẩm theo từng thương hiệu và danh mục.
SELECT b.name as brand, c.name as category, COUNT(p.product_id) AS product_count
FROM brands b
JOIN products p ON p.brand_id = b.brand_id
JOIN product_categories pc ON p.product_id = pc.product_id 
JOIN categories c ON c.category_id = pc.category_id
GROUP BY brand, category;

-- Câu 45: Tìm các kho chứa sản phẩm có tổng giá trị lớn nhất.
SELECT i.warehouse_id, SUM(i.stock_quantity * p.price) AS total_value
FROM inventory i
JOIN products p ON i.product_id = p.product_id
GROUP BY i.warehouse_id
ORDER BY total_value DESC
LIMIT 1;

-- Câu 46: Tính tổng số lượng hàng đã giao cho từng khách hàng trong tháng gần nhất.
SELECT o.customer_id, SUM(oi.quantity) AS total_shipped
FROM orders o
JOIN order_items oi ON o.order_id = oi.order_id
WHERE o.order_date >= CURDATE() - INTERVAL 1 MONTH
GROUP BY o.customer_id;

-- Câu 47: Tìm sản phẩm có doanh thu cao nhất (quantity × price).
SELECT p.name as product_name, SUM(oi.quantity * oi.unit_price) AS revenue
FROM products p
JOIN order_items oi ON p.product_id = oi.product_id
GROUP BY p.product_id
ORDER BY revenue DESC
LIMIT 1;

-- Câu 48: Tìm các đơn hàng có ít nhất 2 sản phẩm thuộc thương hiệu khác nhau.
SELECT o.order_id
FROM orders o
JOIN order_items oi ON o.order_id = oi.order_id
JOIN products p ON oi.product_id = p.product_id
GROUP BY o.order_id
HAVING COUNT(DISTINCT p.brand_id) > 1;

-- Câu 49: Tìm những khách hàng có ít nhất một đơn hàng thuộc trạng thái "Delivered" và thanh toán bằng PayPal.
SELECT DISTINCT c.customer_id, CONCAT(c.first_name, " ", c.last_name) as fullName
FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
JOIN payments p ON o.order_id = p.order_id
WHERE o.status = 'Shipped' AND p.payment_method = 'PayPal';

-- Câu 50: Tạo bảng thống kê tổng tiền theo từng tháng trong năm và theo từng trạng thái đơn hàng.
SELECT
    m.month,
    IFNULL(o.status, "NO STATUS") as status,
    IFNULL(SUM(o.total_amount), 0) AS total_sales
FROM (
    SELECT '01-2025' AS month UNION ALL
    SELECT '02-2025' UNION ALL
    SELECT '03-2025' UNION ALL
    SELECT '04-2025' UNION ALL
    SELECT '05-2025' UNION ALL
    SELECT '06-2025' UNION ALL
    SELECT '07-2025' UNION ALL
    SELECT '08-2025' UNION ALL
    SELECT '09-2025' UNION ALL
    SELECT '10-2025' UNION ALL
    SELECT '11-2025' UNION ALL
    SELECT '12-2025'
) AS m
LEFT JOIN orders o ON DATE_FORMAT(o.order_date, '%m-%Y') = m.month
GROUP BY m.month, o.status
ORDER BY m.month, o.status;

-- Câu 51: Tìm top 3 sản phẩm có doanh thu cao nhất mỗi tháng, bao gồm tên sản phẩm, tháng, tổng doanh thu.
WITH months AS (
    SELECT '2025-01' AS month UNION ALL
    SELECT '2025-02' UNION ALL
    SELECT '2025-03' UNION ALL
    SELECT '2025-04' UNION ALL
    SELECT '2025-05' UNION ALL
    SELECT '2025-06' UNION ALL
    SELECT '2025-07' UNION ALL
    SELECT '2025-08' UNION ALL
    SELECT '2025-09' UNION ALL
    SELECT '2025-10' UNION ALL
    SELECT '2025-11' UNION ALL
    SELECT '2025-12'
),
revenue_by_month_product AS (
    SELECT
        DATE_FORMAT(o.order_date, '%Y-%m') AS month,
        p.product_id,
        p.name as product_name,
        SUM(oi.quantity * oi.unit_price) AS total_revenue
    FROM orders o
    JOIN order_items oi ON o.order_id = oi.order_id
    JOIN products p ON oi.product_id = p.product_id
    GROUP BY DATE_FORMAT(o.order_date, '%Y-%m'), p.product_id
),
ranked_products AS (
    SELECT
        m.month,
        r.product_name,
        r.total_revenue,
        ROW_NUMBER() OVER (PARTITION BY m.month ORDER BY r.total_revenue DESC) AS rn
    FROM months m
    LEFT JOIN revenue_by_month_product r ON m.month = r.month
)
SELECT
    month,
    product_name,
    total_revenue
FROM ranked_products
WHERE rn <= 3
ORDER BY month, total_revenue DESC;

-- Câu 52: Tìm các khách hàng có tổng số tiền mua hàng nhiều hơn trung bình tổng chi tiêu của tất cả khách hàng.
SELECT
    c.customer_id,
    CONCAT(c.first_name, " ", c.last_name) as fullName,
    SUM(o.total_amount) AS total_spent
FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
GROUP BY c.customer_id
HAVING total_spent > (
    SELECT AVG(total_amount_sum)
    FROM (
        SELECT customer_id, SUM(total_amount) AS total_amount_sum
        FROM orders
        GROUP BY customer_id
    ) AS avg_spending
);

-- Câu 53: Liệt kê các sản phẩm được bán bởi nhiều hơn 2 nhà cung cấp khác nhau.
SELECT
    p.product_id,
    p.name as product_name,
    COUNT(DISTINCT p.supplier_id) AS supplier_count
FROM products p
JOIN order_items oi ON p.product_id = oi.product_id
GROUP BY p.product_id
HAVING supplier_count > 2;

-- Câu 54: Tìm tất cả khách hàng đã mua cùng một sản phẩm từ hai đơn hàng khác nhau trong vòng 30 ngày.
SELECT DISTINCT o1.customer_id, o1.order_id, o2.order_id, oi1.product_id
FROM orders o1
JOIN order_items oi1 ON o1.order_id = oi1.order_id
JOIN orders o2 ON o1.customer_id = o2.customer_id
JOIN order_items oi2 ON o2.order_id = oi2.order_id
WHERE oi1.product_id = oi2.product_id
  AND o1.order_id != o2.order_id
  AND ABS(DATEDIFF(o2.order_date, o1.order_date)) <= 30;

-- Câu 55: Tìm tất cả các đơn hàng có tổng tiền chênh lệch với tổng đơn giá * số lượng trong order_items.
SELECT o.order_id, o.total_amount, SUM(oi.quantity * oi.unit_price) AS total_items_amount
FROM orders o
JOIN order_items oi ON o.order_id = oi.order_id
GROUP BY o.order_id
HAVING total_amount != total_items_amount;

-- Câu 56: Xác định các sản phẩm có doanh thu giảm dần trong 3 tháng gần nhất.
WITH recent_months AS (
    SELECT DATE_FORMAT(LAST_DAY(CURDATE() - INTERVAL n MONTH), '%Y-%m') AS month
    FROM (SELECT 0 AS n UNION ALL SELECT 1 UNION ALL SELECT 2) AS nums
),
monthly_revenue AS (
    SELECT
        p.product_id,
        p.name AS product_name,
        DATE_FORMAT(o.order_date, '%Y-%m') AS month,
        SUM(oi.quantity * oi.unit_price) AS total_revenue
    FROM products p
    JOIN order_items oi ON p.product_id = oi.product_id
    JOIN orders o ON oi.order_id = o.order_id
    WHERE o.order_date >= CURDATE() - INTERVAL 3 MONTH
    GROUP BY p.product_id, product_name, month
),
combined AS (
    SELECT
        p.product_id,
        p.name AS product_name,
        m.month,
        COALESCE(r.total_revenue, 0) AS total_revenue,
        ROW_NUMBER() OVER (PARTITION BY p.product_id ORDER BY m.month DESC) AS rn
    FROM products p
    CROSS JOIN recent_months m
    LEFT JOIN monthly_revenue r ON p.product_id = r.product_id AND m.month = r.month
)
SELECT
    c.product_id,
    c.product_name
FROM combined c
JOIN combined c2 ON c.product_id = c2.product_id AND c2.rn = c.rn + 1
JOIN combined c3 ON c.product_id = c3.product_id AND c3.rn = c.rn + 2
WHERE c.total_revenue <= c2.total_revenue
AND c2.total_revenue <= c3.total_revenue
GROUP BY c.product_id, c.product_name;

-- Câu 57: Liệt kê các đơn hàng có ít nhất một sản phẩm được vận chuyển chậm hơn 5 ngày kể từ ngày đặt hàng.
SELECT o.order_id
FROM orders o
JOIN order_items oi ON o.order_id = oi.order_id
JOIN shipments s ON s.order_id = o.order_id
WHERE ABS(DATEDIFF(s.shipped_date, o.order_date)) > 5;

-- Câu 58: Tính tổng tiền đơn hàng và so sánh với tổng tiền thanh toán để xác định đơn hàng bị thiếu/ dư tiền.
SELECT o.order_id, o.total_amount, SUM(p.amount) AS total_payment
FROM orders o
JOIN payments p ON o.order_id = p.order_id
GROUP BY o.order_id
HAVING total_amount != total_payment;

-- Câu 59: Liệt kê top 5 kho hàng có tổng giá trị tồn kho cao nhất (số lượng × giá sản phẩm).
SELECT i.warehouse_id, SUM(i.stock_quantity * p.price) AS total_inventory_value
FROM inventory i
JOIN products p ON i.product_id = p.product_id
GROUP BY i.warehouse_id
ORDER BY total_inventory_value DESC
LIMIT 5;

-- Câu 60: Tìm các khách hàng đã mua hàng từ ít nhất 3 thương hiệu khác nhau.
SELECT o.customer_id
FROM orders o
JOIN order_items oi ON o.order_id = oi.order_id
JOIN products p ON oi.product_id = p.product_id
GROUP BY o.customer_id
HAVING COUNT(DISTINCT p.brand_id) >= 3;

-- Câu 61: Tìm các khách hàng đã mua sản phẩm thuộc ít nhất 3 danh mục khác nhau trong cùng một đơn hàng.
SELECT o.customer_id
FROM orders o
JOIN order_items oi ON o.order_id = oi.order_id
JOIN products p ON oi.product_id = p.product_id
JOIN product_categories pc ON pc.product_id = p.product_id
GROUP BY o.order_id
HAVING COUNT(DISTINCT pc.category_id) >= 3;

-- Câu 62: Tạo bảng xếp hạng khách hàng theo số lượng đơn hàng trung bình mỗi tháng.
SELECT o.customer_id, COUNT(DISTINCT o.order_id) / COUNT(DISTINCT DATE_FORMAT(o.order_date, '%Y-%m')) AS avg_orders_per_month
FROM orders o
GROUP BY o.customer_id
ORDER BY avg_orders_per_month;

-- Câu 63: Liệt kê tất cả các đơn hàng có chứa sản phẩm chưa từng được bán trước đó.
SELECT DISTINCT o.order_id
FROM orders o
JOIN order_items oi ON o.order_id = oi.order_id
WHERE oi.product_id NOT IN (
    SELECT DISTINCT _oi.product_id FROM order_items _oi
    WHERE o.order_id != _oi.order_id
);

-- Câu 64: Xác định tỷ lệ phần trăm đơn hàng bị huỷ hoặc không giao hàng thành công.
SELECT
    (COUNT(CASE WHEN o.status = 'Cancelled' THEN 1 ELSE null END) / COUNT(o.order_id)) * 100 AS cancelled_percentage
FROM orders o;

-- Câu 65: Tìm tất cả khách hàng có tổng số lần thanh toán bằng PayPal nhiều hơn Credit Card.
SELECT c.customer_id
FROM customers c
JOIN orders o ON o.customer_id = c.customer_id
JOIN payments p ON o.order_id = p.order_id
GROUP BY c.customer_id
HAVING SUM(CASE WHEN p.payment_method = 'PayPal' THEN 1 ELSE 0 END) > SUM(CASE WHEN p.payment_method = 'Credit Card' THEN 1 ELSE 0 END);

-- Câu 66: Tính tổng số tiền khách hàng đã chi tiêu theo từng danh mục sản phẩm.
SELECT o.customer_id, c.name as category_name, SUM(oi.quantity * oi.unit_price) AS total_spent
FROM orders o
JOIN order_items oi ON o.order_id = oi.order_id
JOIN products p ON oi.product_id = p.product_id
JOIN product_categories pc ON pc.product_id = p.product_id
JOIN categories c ON c.category_id = pc.category_id
GROUP BY o.customer_id, category_name;

-- Câu 67: Tìm những sản phẩm có tỷ lệ tồn kho cao hơn 80% so với số lượng đã bán.
SELECT p.name as product_name, i.stock_quantity, SUM(oi.quantity) AS sold_quantity
FROM products p
JOIN inventory i ON p.product_id = i.product_id
JOIN order_items oi ON p.product_id = oi.product_id
GROUP BY p.product_id
HAVING (stock_quantity / sold_quantity) > 0.8;

-- Câu 68: Tìm danh sách khách hàng có đơn hàng đầu tiên trong năm 2024 nhưng không có đơn hàng tiếp theo.
SELECT c.customer_id, MIN(o.order_date) AS first_order_date
FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
WHERE YEAR(o.order_date) = 2024
GROUP BY c.customer_id
HAVING COUNT(o.order_id) = 1;

-- Câu 69: Liệt kê mỗi sản phẩm cùng số lượng tồn kho hiện tại, tổng số đã bán, và số lượng nhập kho.
SELECT p.name as product_name, i.stock_quantity AS current_stock, SUM(IFNULL(oi.quantity, 0)) AS total_sold, SUM(CASE WHEN sm.movement_type = 'IN' THEN sm.quantity ELSE 0 END) as Incoming_Quantity
FROM products p
LEFT JOIN inventory i ON p.product_id = i.product_id
LEFT JOIN order_items oi ON p.product_id = oi.product_id
LEFT JOIN stock_movements sm ON sm.product_id = p.product_id
GROUP BY p.product_id;

-- Câu 70: Tìm các sản phẩm có số lượng bán tăng trưởng theo từng quý trong năm 2023.
SELECT p.name as product_name, 
       SUM(CASE WHEN QUARTER(o.order_date) = 1 THEN oi.quantity ELSE 0 END) AS Q1_sales,
       SUM(CASE WHEN QUARTER(o.order_date) = 2 THEN oi.quantity ELSE 0 END) AS Q2_sales,
       SUM(CASE WHEN QUARTER(o.order_date) = 3 THEN oi.quantity ELSE 0 END) AS Q3_sales,
       SUM(CASE WHEN QUARTER(o.order_date) = 4 THEN oi.quantity ELSE 0 END) AS Q4_sales
FROM products p
JOIN order_items oi ON p.product_id = oi.product_id
JOIN orders o ON oi.order_id = o.order_id
WHERE YEAR(o.order_date) = 2023
GROUP BY p.product_id
HAVING Q1_sales <= Q2_sales AND Q2_sales <= Q3_sales AND Q3_sales <= Q4_sales;

