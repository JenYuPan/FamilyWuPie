package model;

/**
 * @author Jerry
 * @create 2025/4/21下午 10:30
 * @desc：
 */
public class OrderItem {
    private Product product;
    private int quantity;

    public int getSubTotal(){
        return product.getPrice() * quantity;
    }
}
