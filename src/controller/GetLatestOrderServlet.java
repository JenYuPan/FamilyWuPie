package controller;

import model.OrderTempStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Jerry
 * @create 2025/4/24上午 09:37
 * @desc：
 */
@WebServlet("/getLatestOrder")
public class GetLatestOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        PrintWriter out = resp.getWriter();

        Set<String> orderIds = OrderTempStore.getAllOrderIds();

        for(String orderId : orderIds){
            String status = OrderTempStore.getStatus(orderId);
            if("pending".equals(status)){
                List<Map<String,Object>> items = OrderTempStore.get(orderId);
                int total = OrderTempStore.getTotal(orderId);

                //合體json 先訂單 再商品
                StringBuilder sb = new StringBuilder();

                sb.append("{");
                sb.append("\"orderId\":\"").append(orderId).append("\",");
                sb.append("\"total\":\"").append(total).append("\",");
                sb.append("\"items\":[");

                for(int i =0;i<items.size();i++){
                    Map<String,Object> item = items.get(i);

                    sb.append("{");
                    sb.append("\"id\":\"").append(item.get("id")).append("\",");
                    sb.append("\"name\":\"").append(item.get("name")).append("\",");
                    sb.append("\"price\":\"").append(item.get("price")).append("\",");
                    sb.append("\"quantity\":").append(item.get("quantity"));
                    sb.append("}");

                    if(i<items.size()-1){
                        sb.append(",");
                    }

                }

                sb.append("]}");

                out.write(sb.toString());
                return;
            }
        }
        out.write("{}");
    }
}
