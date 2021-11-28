package org.ucieffe.kata.salestaxes.model;

import java.math.BigDecimal;

public class ReportItem {
    private final Integer quantity;
    private final String description;
    private final Boolean isImported;
    private final BigDecimal totalPrice;

    public ReportItem(Integer quantity, String description, Boolean isImported, BigDecimal totalPrice) {
        this.quantity = quantity;
        this.description = description;
        this.isImported = isImported;
        this.totalPrice = totalPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public Boolean isImported() {
        return isImported;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
