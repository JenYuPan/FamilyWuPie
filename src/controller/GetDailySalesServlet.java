package controller;

import Util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Jerry
 * @create 2025/4/28下午 05:52
 * @desc：
 */
@WebServlet("/getDailySales")
public class GetDailySalesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        PrintWriter out = resp.getWriter();

        LocalDate today = LocalDate.now();
        String todayStr = today.format(DateTimeFormatter.ISO_DATE);

        String sql =    "SELECT product_name, unit_price, SUM(quantity) AS total_sold " +
                        "FROM order_items oi " +
                        "JOIN orders o ON oi.order_id = o.order_id " +
                        "WHERE DATE(o.order_time) = ? " +
                        "GROUP BY product_name, unit_price";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement PS = conn.prepareStatement(sql)) {

            PS.setString(1, todayStr);
            ResultSet rs = PS.executeQuery();

            StringBuilder sb = new StringBuilder();
            sb.append("[");

            boolean data = false;

            while (rs.next()) {
                if (data) {
                    sb.append(",");
                }
                String productName = rs.getString("product_name");
                int unitPrice = rs.getInt("unit_price");
                int totalSold = rs.getInt("total_sold");

                sb.append("{")
                        .append("\"productName\":\"").append(productName).append("\",")
                        .append("\"unitPrice\":").append(unitPrice).append(",")
                        .append("\"totalSold\":").append(totalSold)
                        .append("}");

                data = true;
            }

            sb.append("]");
            out.write(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            out.write("{\"error\":\"資料庫錯誤\"}");
        }
    }
}