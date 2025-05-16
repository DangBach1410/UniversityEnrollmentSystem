package FACTORY_METHOD_PATTERN.bt6;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ProductFactory {
    private static final Map<String, Supplier<Product>> registry = new HashMap<>();

    // Đăng ký class với tên type
    public static void register(String type, Supplier<Product> supplier) {
        registry.put(type.toLowerCase(), supplier);
    }

    // Tạo object từ type đã đăng ký
    public static Product create(String type) {
        Supplier<Product> supplier = registry.get(type.toLowerCase());
        if (supplier == null) {
            throw new IllegalArgumentException("Không tìm thấy sản phẩm cho loại: " + type);
        }
        return supplier.get();
    }
}

