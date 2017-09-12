package com.kyj.po;

import java.math.BigDecimal;

public class EchartTest1 {
    private Integer id;

    private String productName;

    private Integer productTotal;

    private BigDecimal productPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Integer getProductTotal() {
        return productTotal;
    }

    public void setProductTotal(Integer productTotal) {
        this.productTotal = productTotal;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
}