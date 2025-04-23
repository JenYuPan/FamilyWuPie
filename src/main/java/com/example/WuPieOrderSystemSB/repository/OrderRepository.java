package com.example.WuPieOrderSystemSB.repository;

import com.example.WuPieOrderSystemSB.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jerry
 * @create 2025/4/22下午 03:11
 * @desc：
 */
public interface OrderRepository extends JpaRepository<Order,Long> {
    Order findByOrderNumber(String orderNumber);
}
