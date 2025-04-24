package controller;

import model.OrderTempStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Jerry
 * @create 2025/4/23下午 10:47
 * @desc：
 */
@WebServlet("/checkPaymentStatus")
public class CheckPaymentStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String orderId = req.getParameter("orderId");

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        if(orderId == null || orderId.isEmpty()){
            out.write("{\"error\":true,\"message\":\"Missing orderId\"}");
            return;
        }
        String status = OrderTempStore.getStatus(orderId);

        switch (status) {
            case "paid":
                out.write("{\"paid\": true}");
                break;
            case "cancelled":
                out.write("{\"cancelled\": true}");
                break;
            case "pending":
                out.write("{\"paid\": false, \"cancelled\": false}");
                break;
            default:
                out.write("{\"error\": true, \"message\": \"Invalid orderId\"}");
                break;

        }
    }
}
