package org.ucieffe.kata.salestaxes.model;

import java.math.BigDecimal;

public class ItemFactory {

    public static Item createItemFrom(String quantity, String price, String description, boolean isImported) {
        boolean isTaxed = switch (description) {
            case "book", "box of chocolates", "chocolate bar" -> false;
            default -> true;
        };
        return new Item(Integer.parseInt(quantity), new BigDecimal(price), description, isTaxed, isImported);
    }
}
