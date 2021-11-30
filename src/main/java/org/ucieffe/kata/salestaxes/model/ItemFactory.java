package org.ucieffe.kata.salestaxes.model;

import java.math.BigDecimal;

public class ItemFactory {

    public static Item createItemFrom(String quantity, String price, String description, boolean isImported) {
        return new Item(Integer.parseInt(quantity), new BigDecimal(price), description, isImported, new StandardTaxes(), new ImportTaxes());
    }
}
