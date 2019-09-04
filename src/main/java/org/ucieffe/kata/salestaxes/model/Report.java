package org.ucieffe.kata.salestaxes.model;

import java.math.BigDecimal;
import java.util.List;

public class Report {

    private final BigDecimal salesTaxes;
    private final BigDecimal total;
    private final Basket basket;

    public Report(Basket basket, BigDecimal salesTaxes, BigDecimal total) {
        this.basket = basket;
        this.salesTaxes = salesTaxes;
        this.total = total;
    }

    public List<Item> getItems() {
        return basket.getItemList();
    }

    public BigDecimal getSalesTaxes() {
        return salesTaxes;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
