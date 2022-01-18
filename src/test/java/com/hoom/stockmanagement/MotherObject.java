package com.hoom.stockmanagement;

import com.hoom.stockmanagement.model.Product;

public class MotherObject {
    public static Product getAnyProduct() {
        return new Product(1L, "cellphone", "black", "Test description", 50L);
    }
}
