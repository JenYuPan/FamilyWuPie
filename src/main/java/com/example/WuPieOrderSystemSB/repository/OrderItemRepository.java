package com.example.WuPieOrderSystemSB.repository;

import com.example.WuPieOrderSystemSB.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jerry
 * @create 2025/4/22下午 03:14
 * @desc：
 */
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
