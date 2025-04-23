package com.example.WuPieOrderSystemSB.model.items;

import com.example.WuPieOrderSystemSB.model.Product;

/**
 * @author Jerry
 * @create 2025/4/22下午 03:07
 * @desc：
 */
public class ColdNoodle implements Product {
    private String name = "涼麵";
    private int price = 50;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }
}