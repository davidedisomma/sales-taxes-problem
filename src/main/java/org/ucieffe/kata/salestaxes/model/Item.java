package org.ucieffe.kata.salestaxes.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

public class Item {
    private final String quantity;
    private final String price;
    private final String description;
    private final boolean isTaxed;

    public Item(String quantity, String price, String description, boolean isTaxed) {
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.isTaxed = isTaxed;
    }

    public String getPrice() {
        BigDecimal price = new BigDecimal(this.price);
        BigDecimal taxes = new BigDecimal(getUnitPrice());
        price = price.add(taxes).setScale(2, BigDecimal.ROUND_HALF_UP);

        return price.toString();
    }

    private String getUnitPrice() {
        BigDecimal price = new BigDecimal(this.price);
        BigDecimal taxes = BigDecimal.ZERO;
        if(isTaxed) {
            taxes = price.multiply(new BigDecimal(0.1)).setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        return taxes.toString();
    }

    public String getTotalPrice() {
        return new BigDecimal(getPrice()).multiply(new BigDecimal(quantity)).toString();
    }

    public String getTotalTaxes() {
        return new BigDecimal(getUnitPrice()).multiply(new BigDecimal(quantity)).toString();
    }

    public String getQuantity() {
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
        return isTaxed == item.isTaxed && Objects.equals(quantity, item.quantity) && Objects.equals(price, item.price) && Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, price, description, isTaxed);
    }

    @Override
    public String toString() {
        return "Item{" +
                "quantity='" + quantity + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", isTaxed=" + isTaxed +
                '}';
    }
}
