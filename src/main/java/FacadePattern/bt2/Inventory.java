package FacadePattern.bt2;

class Inventory {
    public boolean checkStock(String productId, int quantity) {
        System.out.println("Kiểm tra kho: " + productId + ", số lượng: " + quantity);
        return true;
    }

    public void reduceStock(String productId, int quantity) {
        System.out.println("Trừ kho: " + productId + " - " + quantity);
    }
}