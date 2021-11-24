package org.ucieffe.kata.salestaxes.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class Report {

    private final List<Item> items;
    private final BigDecimal salesTaxes;
    private final BigDecimal total;

    public Report(List<Item> items, BigDecimal salesTaxes, BigDecimal total) {
        this.items = items;
        this.salesTaxes = salesTaxes;
        this.total = total;
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal getSalesTaxes() {
        return salesTaxes;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
