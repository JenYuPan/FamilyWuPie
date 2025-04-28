package controller;

import model.OrderTempStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Jerry
 * @create 2025/4/24上午 09:00
 * @desc：
 */
@WebServlet("/confirmPayment")
public class ConfirmPaymentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        String orderId = req.getParameter("orderId");
        PrintWriter out = resp.getWriter();

        if(orderId == null || orderId.isEmpty()){
            out.write("{\"status\":\"error\",\"message\":\"訂單編號遺失\"}");
            return;
        }
        if(OrderTempStore.get(orderId) == null){
            out.write("{\"status\":\"error\",\"message\":\"查無此單\"}");
            return;
        }

        OrderTempStore.setStatus(orderId,"paid");

        out.write("{\"status\":\"ok\",\"message\":\"付款成功\"}");

    }
}
