package org.ucieffe.kata.salestaxes.model;

import java.math.BigDecimal;

public interface SalesTaxesApplication {

    BigDecimal NO_TAX = BigDecimal.ZERO;

    BigDecimal apply(Item item);
}
