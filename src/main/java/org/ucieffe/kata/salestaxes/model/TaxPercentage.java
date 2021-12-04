package org.ucieffe.kata.salestaxes.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class TaxPercentage {

    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);
    public static TaxPercentage NO_TAX = new TaxPercentage(0);

    private Integer percentage;

    TaxPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public TaxPercentage add(TaxPercentage that) {
        return new TaxPercentage(this.percentage + that.percentage);
    }

    public BigDecimal value() {
        return new BigDecimal(percentage.toString())
                .setScale(2, RoundingMode.HALF_UP)
                .divide(ONE_HUNDRED, RoundingMode.HALF_UP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxPercentage that = (TaxPercentage) o;
        return Objects.equals(percentage, that.percentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(percentage);
    }

    @Override
    public String toString() {
        return "TaxPercentage{" +
                "percentage=" + percentage +
                '}';
    }
}
