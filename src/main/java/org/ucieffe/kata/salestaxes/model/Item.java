package org.ucieffe.kata.salestaxes.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;

public class Item {
    private final Integer quantity;
    private final Price rawPrice;
    private final String description;
    private final boolean isImported;
    private final SalesTaxesApplication[] salesTaxes;

    private Item(Integer quantity, Price rawPrice, String description, boolean isImported, SalesTaxesApplication... salesTaxes) {
        this.quantity = quantity;
        this.rawPrice = rawPrice;
        this.description = description;
        this.isImported = isImported;
        this.salesTaxes = salesTaxes;
    }

    public static Item createItemFrom(Integer quantity, Price rawPrice, String description, boolean isImported) {
        return new Item(quantity, new Price(rawPrice.getAmount()), description, isImported, new StandardTaxes(), new ImportTaxes());
    }

    private Price getGrossUnitPrice() {
        Price taxes = getTaxesUnitPrice();


        return this.rawPrice.add(new Price(taxes.getAmount()));

    }

    private Price getTaxesUnitPrice() {
        BigDecimal taxPercentage = Arrays.stream(salesTaxes)
                .map(salesTax -> salesTax.apply(this))
                .reduce(BigDecimal::add)
                .orElse(SalesTaxesApplication.NO_TAX);

        BigDecimal taxBeforeRounding = new BigDecimal(rawPrice.getAmount()).multiply(taxPercentage).setScale(2, RoundingMode.HALF_UP);
        BigDecimal taxRounded = taxBeforeRounding
                .multiply(new BigDecimal(2)).setScale(1, RoundingMode.UP)
                .divide(new BigDecimal(2), 2, RoundingMode.HALF_UP);
        return new Price(taxRounded.toString());
    }

    public Price getTotalPrice() {
        return getGrossUnitPrice().multiply(quantity);
    }

    public Price getTotalTaxes() {
        return getTaxesUnitPrice().multiply(quantity);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public boolean isImported() {
        return isImported;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return isImported == item.isImported && Objects.equals(quantity, item.quantity) && Objects.equals(rawPrice, item.rawPrice) && Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, rawPrice, description, isImported);
    }

    @Override
    public String toString() {
        return "Item{" +
                "quantity=" + quantity +
                ", rawPrice=" + rawPrice +
                ", description='" + description + '\'' +
                ", isImported=" + isImported +
                '}';
    }

}
