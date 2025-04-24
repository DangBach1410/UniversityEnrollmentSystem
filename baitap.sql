-- Bài 1: Lấy danh sách tất cả người dùng
SELECT * FROM users;

-- Bài 2: Lấy danh sách tất cả sản phẩm còn hàng (stock > 0)
SELECT * FROM products
WHERE stock > 0;

-- Bài 3: Tính tổng số đơn hàng của từng người dùng
SELECT u.user_id, u.name, COUNT(o.order_id) AS total_orders
FROM users u
LEFT JOIN orders o ON u.user_id = o.user_id
GROUP BY u.user_id, u.name;

-- Bài 4: Tính tổng doanh thu của hệ thống
SELECT SUM(total_amount) AS total_revenue
FROM orders;

-- Bài 5: Tìm sản phẩm có giá cao nhất
SELECT * FROM products
ORDER BY price DESC
LIMIT 1;

-- Bài 6: Liệt kê các đơn hàng và tên người mua tương ứng
SELECT o.order_id, u.name AS customer_name, o.order_date, o.total_amount
FROM orders o
JOIN users u ON o.user_id = u.user_id;

-- Bài 7: Tính tổng số lượng mỗi sản phẩm đã bán
SELECT p.product_id, p.name, SUM(oi.quantity) AS total_sold
FROM order_items oi
JOIN products p ON oi.product_id = p.product_id
GROUP BY p.product_id, p.name;

-- Bài 8: Lấy top 2 người dùng có tổng chi tiêu cao nhất
SELECT u.user_id, u.name, SUM(o.total_amount) AS total_spent
FROM users u
JOIN orders o ON u.user_id = o.user_id
GROUP BY u.user_id, u.name
ORDER BY total_spent DESC
LIMIT 2;

-- Bài 9: Liệt kê các đơn hàng có chứa sản phẩm thuộc loại "Clothing"
SELECT DISTINCT o.order_id, o.user_id, o.order_date, o.total_amount
FROM orders o
JOIN order_items oi ON o.order_id = oi.order_id
JOIN products p ON oi.product_id = p.product_id
WHERE p.category = 'Clothing';

-- Bài 10: Tìm người dùng chưa từng đặt hàng
SELECT u.user_id, u.name, u.email
FROM users u
LEFT JOIN orders o ON u.user_id = o.user_id
WHERE o.order_id IS NULL;

-- EXPERT LEVEL
-- Câu 1: Tìm sản phẩm bán chạy nhất theo tổng số lượng đã bán
SELECT product_id, SUM(quantity) AS total_sold
FROM order_items
GROUP BY product_id
ORDER BY total_sold DESC
LIMIT 1;

-- Câu 2: Tìm đơn hàng có nhiều sản phẩm nhất
SELECT order_id, SUM(quantity) AS total_quantity
FROM order_items
GROUP BY order_id
ORDER BY total_quantity DESC
LIMIT 1;

-- Câu 3: Tính tổng doanh thu theo từng tháng
SELECT 
    DATE_FORMAT(order_date, '%Y-%m') AS month,
    SUM(total_amount) AS total_revenue
FROM orders
GROUP BY month
ORDER BY month;

-- Câu 4: Tính số lần mua trung bình mỗi tháng của từng người dùng
SELECT 
    user_id,
    COUNT(*) / COUNT(DISTINCT DATE_FORMAT(order_date, '%Y-%m')) AS avg_orders_per_month
FROM orders
GROUP BY user_id;

-- Câu 5: Liệt kê người dùng và đơn hàng gần nhất của họ
SELECT o.*
FROM orders o
INNER JOIN (
    SELECT user_id, MAX(order_date) AS latest_order
    FROM orders
    GROUP BY user_id
) latest ON o.user_id = latest.user_id AND o.order_date = latest.latest_order;

-- Câu 6: Tìm đơn hàng có giá trị lớn nhất của mỗi người dùng (Window Function)
SELECT *
FROM (
    SELECT o.*, 
           RANK() OVER (PARTITION BY user_id ORDER BY total_amount DESC) AS rank
    FROM orders o
) ranked_orders
WHERE rank = 1;

-- Câu 7: Tìm các sản phẩm chưa từng được bán
SELECT * 
FROM products
WHERE product_id NOT IN (
    SELECT DISTINCT product_id FROM order_items
);

-- Câu 8: Mỗi người dùng đã mua bao nhiêu loại sản phẩm khác nhau
SELECT o.user_id, COUNT(DISTINCT p.category) AS category_count
FROM orders o
JOIN order_items oi ON o.order_id = oi.order_id
JOIN products p ON oi.product_id = p.product_id
GROUP BY o.user_id;

-- Câu 9: Sử dụng CTE để tìm những người dùng có tổng chi tiêu vượt 30 triệu
WITH user_spending AS (
    SELECT user_id, SUM(total_amount) AS total_spent
    FROM orders
    GROUP BY user_id
)
SELECT * 
FROM user_spending
WHERE total_spent > 30000000;

-- Câu 10: Tổng doanh thu mỗi tháng và phần trăm tăng trưởng so với tháng trước
WITH monthly_revenue AS (
    SELECT 
        DATE_FORMAT(order_date, '%Y-%m') AS month,
        SUM(total_amount) AS revenue
    FROM orders
    GROUP BY month
)
SELECT 
    month,
    revenue,
    LAG(revenue) OVER (ORDER BY month) AS previous_month_revenue,
    ROUND(
        (revenue - LAG(revenue) OVER (ORDER BY month)) / 
        NULLIF(LAG(revenue) OVER (ORDER BY month), 0) * 100, 2
    ) AS growth_percent
FROM monthly_revenue;
