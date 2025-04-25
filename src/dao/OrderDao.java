package dao;

import model.DBUtil;
import model.Order;
import model.OrderItem;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author Jerry
 * @create 2025/4/22下午 10:11
 * @desc：
 */
public class OrderDao {
    public void insertOrder(Order order) throws Exception {
        String insertOrderSql = "INSERT INTO orders (order_id, order_time, total, status) VALUES (?, ?, ?, ?)";
        String insertItemSql = "INSERT INTO order_items (order_id, product_name, unit_price, quantity, subtotal) VALUES (?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement orderStatement = null;
        PreparedStatement itemStatement = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            //把資料insert ORDER 表
            orderStatement = conn.prepareStatement(insertOrderSql);
            orderStatement.setString(1, order.getOrderId());
            orderStatement.setTimestamp(2, java.sql.Timestamp.valueOf(order.getOrderTime()));
            orderStatement.setInt(3, order.getTotal());
            orderStatement.setString(4,order.getStatus());
            orderStatement.executeUpdate();


            //把資料insert ORDER_items 表
            itemStatement = conn.prepareStatement(insertItemSql);
            for (OrderItem item : order.getItems()) {
                itemStatement.setString(1, order.getOrderId());
                itemStatement.setString(2, item.getProduct().getName());
                itemStatement.setInt(3, item.getProduct().getPrice());
                itemStatement.setInt(4, item.getQuantity());
                itemStatement.setInt(5, item.getSubTotal());
                itemStatement.addBatch();
            }
            itemStatement.executeBatch();

            conn.commit();
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            e.printStackTrace();
        } finally {
            if (orderStatement != null) {
                orderStatement.close();
            }
            if (itemStatement != null) {
                itemStatement.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }
}
