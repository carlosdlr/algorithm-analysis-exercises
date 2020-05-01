package com.carlosdlr.algorithm.exercises.adyen;

import java.math.BigDecimal;
import java.util.List;

public class SoldProductsAggregate {
    private List<SimpleSoldProduct> products;
    private BigDecimal total;

    public List<SimpleSoldProduct> getProducts() {
        return products;
    }

    public void setProducts(List<SimpleSoldProduct> products) {
        this.products = products;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
