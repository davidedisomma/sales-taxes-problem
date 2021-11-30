package org.ucieffe.kata.salestaxes.model;

import java.math.BigDecimal;

public class ImportTaxes implements SalesTaxesApplication{

    private static final BigDecimal IMPORT_TAX_PERCENTAGE = new BigDecimal("0.05");

    @Override
    public BigDecimal apply(Item item) {
        if(item.isImported()) {
            return IMPORT_TAX_PERCENTAGE;
        }

        return NO_TAX;
    }
}
