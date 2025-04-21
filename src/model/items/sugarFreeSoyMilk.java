package model.items;

import model.Product;

/**
 * @author Jerry
 * @create 2025/4/21下午 09:46
 * @desc：
 */
public class sugarFreeSoyMilk implements Product {
    private String name = "無糖豆漿";
    private int price = 20;
    private int quantity;
    private int subTotal = price * quantity;
    private String Id = "sugarFreeSoyMilkRd";

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
