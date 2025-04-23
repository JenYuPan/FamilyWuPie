package com.example.WuPieOrderSystemSB.controller;

import com.example.WuPieOrderSystemSB.model.Order;
import com.example.WuPieOrderSystemSB.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jerry
 * @create 2025/4/22下午 03:17
 * @desc：
 */

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping//建立Order
    public Order createOrder(@RequestBody Order order){
        order.calculateTotal();
        return orderRepository.save(order);
    }


    @GetMapping//所有訂單列出
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/{orderNumber}") //依照號馬找到該筆訂單
    public Order getOrderById(@PathVariable String orderNumber){
        return orderRepository.findByOrderNumber(orderNumber);
    }


    // TODO:根據時間區間查詢、刪除訂單、更新訂單等功能
}
