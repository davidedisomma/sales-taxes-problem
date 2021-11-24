package org.ucieffe.kata.salestaxes.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Item {
    private static final BigDecimal TAX_PERCENTAGE = new BigDecimal("0.1");
    private final Integer quantity;
    private final BigDecimal rawPrice;
    private final String description;
    private final boolean isTaxed;

    public Item(Integer quantity, BigDecimal rawPrice, String description, boolean isTaxed) {
        this.quantity = quantity;
        this.rawPrice = rawPrice;
        this.description = description;
        this.isTaxed = isTaxed;
    }

    public BigDecimal getGrossUnitPrice() {
        BigDecimal taxes = getTaxesUnitPrice();

        return this.rawPrice.add(taxes).setScale(2, RoundingMode.HALF_UP);

    }

    private BigDecimal getTaxesUnitPrice() {
        if(isTaxed) {
            return rawPrice.multiply(TAX_PERCENTAGE).setScale(2, RoundingMode.HALF_UP);
        }
        return BigDecimal.ZERO;
    }

    public BigDecimal getTotalPrice() {
        return getGrossUnitPrice().multiply(new BigDecimal(quantity));
    }

    public BigDecimal getTotalTaxes() {
        return getTaxesUnitPrice().multiply(new BigDecimal(quantity));
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return isTaxed == item.isTaxed && Objects.equals(quantity, item.quantity) && Objects.equals(rawPrice, item.rawPrice) && Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, rawPrice, description, isTaxed);
    }

    @Override
    public String toString() {
        return "Item{" +
                "quantity='" + quantity + '\'' +
                ", price='" + rawPrice + '\'' +
                ", description='" + description + '\'' +
                ", isTaxed=" + isTaxed +
                '}';
    }
}
