package org.ucieffe.kata.salestaxes.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

public class Item {
    private final String quantity;
    private final String price;
    private final String type;

    public Item(String quantity, String price, String type) {
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }

    public Item(String price) {
        this("1", price, "");
    }

    public String getPrice() {
        return price;
    }

    public String getTotalPrice() {
        return new BigDecimal(price).multiply(new BigDecimal(quantity)).toString();
    }

    public String getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(quantity, item.quantity) &&
                Objects.equals(price, item.price) &&
                Objects.equals(type, item.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, price, type);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Item.class.getSimpleName() + "[", "]")
                .add("quantity='" + quantity + "'")
                .add("price='" + price + "'")
                .add("type='" + type + "'")
                .toString();
    }
}
