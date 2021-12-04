package org.ucieffe.kata.salestaxes.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Price {

    private final BigDecimal amount;

    public Price(String amount) {
        this.amount = new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP);
    }

    public String getAmount() {
        return amount.toString();
    }

    public Price add(Price other) {
        BigDecimal sum = amount.add(new BigDecimal(other.getAmount()));
        return new Price(sum.toString());
    }

    public Price multiply(Integer quantity) {
        BigDecimal multiplication = amount.multiply(new BigDecimal(quantity));

        return new Price(multiplication.toString());
    }

    public Price apply(TaxPercentage taxPercentage) {
        BigDecimal taxBeforeRounding = amount.multiply(taxPercentage.value()).setScale(2, RoundingMode.HALF_UP);
        BigDecimal taxRounded = taxBeforeRounding
                .multiply(new BigDecimal(2)).setScale(1, RoundingMode.UP)
                .divide(new BigDecimal(2), 2, RoundingMode.HALF_UP);
        return new Price(taxRounded.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(amount, price.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Price{" +
                "amount=" + amount +
                '}';
    }
}
