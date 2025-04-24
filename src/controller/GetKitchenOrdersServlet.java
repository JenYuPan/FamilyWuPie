package controller;

import model.OrderTempStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Jerry
 * @create 2025/4/24下午 04:39
 * @desc：
 */
@WebServlet("/getKitchenOrders")
public class GetKitchenOrdersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        PrintWriter out = resp.getWriter();
        Set<String> orderIds = OrderTempStore.getAllOrderIds();

        List<String> pendingIds = new ArrayList<>();

        for (String id:orderIds){
            if("paid".equals(OrderTempStore.getStatus(id))){
                pendingIds.add(id);
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for (int i = 0; i < pendingIds.size(); i++) {
            String id = pendingIds.get(i);
            List<Map<String, Object>> items = OrderTempStore.get(id);

            sb.append("{\"orderId\":\"").append(id).append("\",");
            sb.append("\"items\":[");
            for (int j = 0; j < items.size(); j++) {
                Map<String, Object> item = items.get(j);
                sb.append("{\"name\":\"").append(item.get("name")).append("\",");
                sb.append("\"quantity\":").append(item.get("quantity")).append("}");
                if (j < items.size() - 1) sb.append(",");
            }
            sb.append("]}");
            if (i < pendingIds.size() - 1) sb.append(",");
        }
        sb.append("]");


        out.write(sb.toString());
    }
}