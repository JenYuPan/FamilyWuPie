package model;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jerry
 * @create 2025/4/23下午 01:45
 * @desc：
 */
public class OrderTempStore {
    private static final Map<String, List<Map<String, Object>>> orders = new ConcurrentHashMap<>();
    private static final Map<String, Integer> totals = new ConcurrentHashMap<>();

    private static final Map<String,String> statuses = new ConcurrentHashMap<>();

    public static void put(String orderId, List<Map<String, Object>> items, int total) {
        orders.put(orderId, items);
        totals.put(orderId, total);
        statuses.put(orderId,"pending");
    }

    public static List<Map<String, Object>> get(String orderId) {
        return orders.get(orderId);
    }

    public static int getTotal(String orderId) {
        return totals.getOrDefault(orderId, 0);
    }

    public static String getStatus(String orderId){
        return statuses.getOrDefault(orderId,"unknow");
    }

    public static void setStatus(String orderId,String status){
        statuses.put(orderId,status);
    }

    public static void remove(String orderId) {
        orders.remove(orderId);
        totals.remove(orderId);
        statuses.remove(orderId);
    }

    public static Set<String> getAllOrderIds() {
        return orders.keySet();
    }
}