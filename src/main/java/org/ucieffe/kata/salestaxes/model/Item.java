package org.ucieffe.kata.salestaxes.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Item {
    private static final BigDecimal TAX_PERCENTAGE = new BigDecimal("0.1");
    private static final BigDecimal IMPORT_TAX_PERCENTAGE = new BigDecimal("0.05");
    public static final BigDecimal NO_TAX = BigDecimal.ZERO;
    private final Integer quantity;
    private final BigDecimal rawPrice;
    private final String description;
    private final boolean isTaxed;
    private final boolean isImported;

    public Item(Integer quantity, BigDecimal rawPrice, String description, boolean isTaxed) {
        this(quantity, rawPrice, description, isTaxed, false);
    }

    public Item(Integer quantity, BigDecimal rawPrice, String description, boolean isTaxed, boolean isImported) {
        this.quantity = quantity;
        this.rawPrice = rawPrice;
        this.description = description;
        this.isTaxed = isTaxed;
        this.isImported = isImported;
    }

    public BigDecimal getGrossUnitPrice() {
        BigDecimal taxes = getTaxesUnitPrice();

        return this.rawPrice.add(taxes).setScale(2, RoundingMode.HALF_UP);

    }

    private BigDecimal getTaxesUnitPrice() {
        BigDecimal taxPercentage = NO_TAX;
        if(isTaxed) {
            taxPercentage = taxPercentage.add(TAX_PERCENTAGE);
        }
        if(isImported) {
            taxPercentage = taxPercentage.add(IMPORT_TAX_PERCENTAGE);
        }

        BigDecimal taxBeforeRounding = rawPrice.multiply(taxPercentage).setScale(2, RoundingMode.HALF_UP);
        return taxBeforeRounding
                .multiply(new BigDecimal(2)).setScale(1, RoundingMode.UP)
                .divide(new BigDecimal(2), 2, RoundingMode.HALF_UP);
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

    public boolean isImported() {
        return isImported;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return isTaxed == item.isTaxed && isImported == item.isImported && Objects.equals(quantity, item.quantity) && Objects.equals(rawPrice, item.rawPrice) && Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, rawPrice, description, isTaxed, isImported);
    }

    @Override
    public String toString() {
        return "Item{" +
                "quantity=" + quantity +
                ", rawPrice=" + rawPrice +
                ", description='" + description + '\'' +
                ", isTaxed=" + isTaxed +
                ", isImported=" + isImported +
                '}';
    }

}
