package model.items;

import model.Product;

/**
 * @author Jerry
 * @create 2025/4/21下午 09:45
 * @desc：
 */
public class soyMilk implements Product {
    private String name = "豆漿";
    private int price = 20;
    private int quantity;
    private int subTotal = price * quantity;
    private String Id = "soyMilkRd";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int qty) {
        quantity = qty;
    }

    @Override
    public int getSubtotal() {
        return subTotal;
    }

    @Override
    public String getId() {
        return Id;
    }
}