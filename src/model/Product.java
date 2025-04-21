package model;

/**
 * @author Jerry
 * @create 2025/4/21下午 03:37
 * @desc：
 */
public interface Product {
    String getName();
    int getPrice();
    int getQuantity();
    void setQuantity(int qty);// 設定選擇的數量
    int getSubtotal();// 小計 = price * quantity
    String getId();// 商品代碼，用來給 JSP input id 綁定

}
