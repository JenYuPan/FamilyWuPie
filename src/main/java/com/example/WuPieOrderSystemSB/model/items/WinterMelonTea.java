package com.example.WuPieOrderSystemSB.model.items;

import com.example.WuPieOrderSystemSB.model.Product;

/**
 * @author Jerry
 * @create 2025/4/22下午 03:09
 * @desc：
 */
public class WinterMelonTea implements Product {
    private String name = "冬瓜茶";
    private int price = 20;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
