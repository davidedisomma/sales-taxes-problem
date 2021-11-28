package org.ucieffe.kata.salestaxes;

import org.ucieffe.kata.salestaxes.model.Basket;
import org.ucieffe.kata.salestaxes.model.Item;

import java.math.BigDecimal;

import static java.util.Arrays.asList;

public class SemanticData {

    public static Basket basketWith(Item...items) {
        return new Basket(asList(items));
    }

    public static Item anExemptedItem(String price) {
        return new Item(1, price(price), "any", false);
    }

    public static Item aTaxedItem(String price) {
        return aTaxedItem(price, 1);
    }
    public static Item aTaxedItem(String price, Integer quantity) {
        return new Item(quantity, price(price), "any", true);
    }

    public static Item anImportedItem(String price) {
        return new Item(1, price(price), "any", false, true);
    }

    public static Item anImportedAndTaxedItem(String price) {
        return new Item(1, price(price), "any", true, true);
    }

    public static BigDecimal price(String price) {
        return new BigDecimal(price);
    }

}
