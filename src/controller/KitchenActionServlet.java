package controller;

import dao.OrderDao;
import model.Order;
import model.OrderItem;
import model.OrderTempStore;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Jerry
 * @create 2025/4/24下午 04:55
 * @desc：
 */
@WebServlet("/kitchenAction")
public class KitchenActionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        String orderId = req.getParameter("orderId");
        String action = req.getParameter("action");
        String status;

        PrintWriter out = resp.getWriter();

        if(orderId==null || action==null){
            out.write("{\"status\":\"error\",\"message\":\"參數遺失\"}");
            return;
        }

        if("done".equals(action)){
            status="completed";
        } else if ("cancel".equals(action)) {
            status="cancelled";
        }else {
            out.write("\"status\":\"error\",\"message\":\"無法辨識的行為\"");
            return;
        }

        try {
            List<Map<String,Object>> itemList = OrderTempStore.get(orderId);
            int total = OrderTempStore.getTotal(orderId);

            List<OrderItem> orderItems = new ArrayList<>();
            for(Map<String,Object> item:itemList){
                Product product = new Product() {
                    @Override
                    public String getName() {
                        return (String) item.get("name");
                    }

                    @Override
                    public int getPrice() {
                        return (int) item.get("price");
                    }

                    @Override
                    public int getQuantity() {
                        return (int) item.get("quantity");
                    }

                    @Override
                    public void setQuantity(int qty) {

                    }


                    @Override
                    public int getSubtotal() {
                        return getPrice()*getQuantity();
                    }

                    @Override
                    public String getId() {
                        return (String) item.get("id");
                    }
                };
                OrderItem orderItem = new OrderItem();
                orderItem.setProduct(product);
                orderItem.setQuantity(product.getQuantity());
                orderItems.add(orderItem);

            }
            Order order = new Order();
            order.setOrderId(orderId);
            order.setItems(orderItems);
            order.setOrderTime(LocalDateTime.now());
            order.setTotal(total);
            order.setStatus(status);

            OrderDao dao = new OrderDao();
            dao.insertOrder(order);

            OrderTempStore.remove(orderId);

            out.write("{\"status\":\"ok\"}");


        }catch (Exception e){
            e.printStackTrace();
            out.write("{\"status\":\"error\",\"message\":\"寫入資料庫失敗\"}");
        }

    }
}
