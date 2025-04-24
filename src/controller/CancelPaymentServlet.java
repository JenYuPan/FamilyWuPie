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
 * @create 2025/4/24上午 09:18
 * @desc：
 */
@WebServlet("/cancelPayment")
public class CancelPaymentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String orderId = req.getParameter("orderId");

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        if(orderId==null||orderId.isEmpty()){
            out.write("{\"status\":\"error\",\"message\":\"訂單編號遺失\"}");
            return;
        }
        if(OrderTempStore.get(orderId)==null){
            out.write("{\"status\":error},\"message\":\"查無此單\"");
            return;
        }

        OrderTempStore.setStatus(orderId,"cancelled");

        out.write("{\"status\":\"ok\",\"message\":\"訂單已經取消\"}");
    }
}
