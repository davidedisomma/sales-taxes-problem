package org.ucieffe.kata.salestaxes;

import java.math.BigDecimal;

public class Item {
    private final BigDecimal price;

    public Item(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
