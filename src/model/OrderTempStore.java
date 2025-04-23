package model;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jerry
 * @create 2025/4/23下午 01:45
 * @desc：
 */
public class OrderTempStore {private static final Map<String, List<Map<String, Object>>> orders = new ConcurrentHashMap<>();
    private static final Map<String, Integer> totals = new ConcurrentHashMap<>();

    public static void put(String orderId, List<Map<String, Object>> items, int total) {
        orders.put(orderId, items);
        totals.put(orderId, total);
    }

    public static List<Map<String, Object>> get(String orderId) {
        return orders.get(orderId);
    }

    public static int getTotal(String orderId) {
        return totals.getOrDefault(orderId, 0);
    }

    public static void remove(String orderId) {
        orders.remove(orderId);
        totals.remove(orderId);
    }
}