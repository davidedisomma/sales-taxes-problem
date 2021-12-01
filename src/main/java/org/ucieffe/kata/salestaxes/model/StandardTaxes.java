package org.ucieffe.kata.salestaxes.model;

import java.math.BigDecimal;

public class StandardTaxes implements SalesTaxesApplication{

    private static final BigDecimal TAX_PERCENTAGE = new BigDecimal("0.10");

    @Override
    public BigDecimal apply(Item item) {
        if(isExempted(item)) {
            return NO_TAX;
        }

        return TAX_PERCENTAGE;
    }

    private boolean isExempted(Item item) {
        return switch (item.getDescription()) {
            case "book", "box of chocolates", "chocolate bar", "packet of headache pills" -> true;
            default -> false;
        };
    }

}
