package controller;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.OrderTempStore;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Jerry
 * @create 2025/4/23下午 09:49
 * @desc：
 */
@WebServlet("/submitOrder")
public class OrderSubmitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        try {
            //讀取
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = req.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            //Gson類別庫，目的是要讀取json
            String json = sb.toString();
            JsonObject root = JsonParser.parseString(json).getAsJsonObject();

            String orderId = root.get("orderId").getAsString();
            JsonArray itemsArray = root.get("items").getAsJsonArray();

            int total = 0;
            //準備裝
            List<Map<String, Object>> itemList = new ArrayList<>();
            for (JsonElement e : itemsArray) {
                JsonObject obj = e.getAsJsonObject();
                String id = obj.get("id").getAsString();
                String name = obj.get("name").getAsString();
                int price = obj.get("price").getAsInt();
                int qty = obj.get("quantity").getAsInt();

                //寫入MAP
                Map<String, Object> map = new HashMap<>();
                map.put("id", id);
                map.put("name", name);
                map.put("price", price);
                map.put("quantity", qty);

                //裝進去
                itemList.add(map);

                total += price * qty;

            }
            //暫存
            OrderTempStore.put(orderId, itemList, total);

            //json回傳 終於= =
            resp.setContentType("application/json");
            //訂單狀態
            resp.getWriter().write("{\"status\":\"ok\", \"orderId\":\"" + orderId + "\"}");
        }catch (Exception e){
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.setContentType("application/json");
            resp.getWriter().write("{\"status\":\"error\", \"message\": \"" + e.getMessage() + "\"}");
        }
    }
}
