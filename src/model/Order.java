package model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Jerry
 * @create 2025/4/21下午 10:33
 * @desc：
 */
public class Order {
    private String orderId;
    private List<OrderItem> items;
    private LocalDateTime orderTime;
    private int total;

    public void calculateTotal(){
        int sum = 0;
        for(OrderItem item:items){
            sum+=item.getSubTotal();
        }
        total=sum;
    }
}
