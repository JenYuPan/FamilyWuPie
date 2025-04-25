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

    private String status;

    public Order(String orderId, List<OrderItem> items, LocalDateTime orderTime, int total, String status) {
        this.orderId = orderId;
        this.items = items;
        this.orderTime = orderTime;
        this.total = total;
        this.status = status;
    }

    public Order() {
        this.orderTime=LocalDateTime.now();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void calculateTotal(){
        int sum = 0;
        for(OrderItem item:items){
            sum+=item.getSubTotal();
        }
        total=sum;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getOrderId() {
        return orderId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public int getTotal() {
        return total;
    }
}
