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
 * @create 2025/4/24下午 04:55
 * @desc：
 */
@WebServlet("/kitchenAction")
public class KitchenActionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        String orderId = req.getParameter("orderId");
        String action = req.getParameter("action");

        PrintWriter out = resp.getWriter();

        if(orderId==null || action==null){
            out.write("{\"status\":\"error\",\"message\":\"參數遺失\"}");
            return;
        }

        if("done".equals(action)){
            OrderTempStore.setStatus(orderId,"completed");
            //Dao呼叫
            OrderTempStore.remove(orderId);
            out.write("{\"status\":\"ok\"}");
        }else if("cancel".equals(action)){
            OrderTempStore.setStatus(orderId,"kitchen_cancel");
            //Dao呼叫
            OrderTempStore.remove(orderId);
            out.write("{\"status\":\"ok\"}");
        }else {
            out.write("{\"status\":\"error\",\"message\":\"無法辨識的動作\"}");
        }



    }
}
