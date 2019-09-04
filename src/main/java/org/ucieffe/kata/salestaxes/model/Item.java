package org.ucieffe.kata.salestaxes.model;

import java.math.BigDecimal;

public class Item {
    private final BigDecimal price;

    public Item(String price) {
        this.price = new BigDecimal(price);
    }

    public BigDecimal getPrice() {
        return price;
    }
}
