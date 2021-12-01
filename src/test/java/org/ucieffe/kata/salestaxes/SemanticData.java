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
        return Item.createItemFrom(1, price(price), "book", false);
    }

    public static Item aTaxedItem(String price) {
        return aTaxedItem(price, 1);
    }
    public static Item aTaxedItem(String price, Integer quantity) {
        return Item.createItemFrom(quantity, price(price), "any", false);
    }

    public static Item anImportedItem(String price) {
        return Item.createItemFrom(1, price(price), "book", true);
    }

    public static Item anImportedAndTaxedItem(String price) {
        return Item.createItemFrom(1, price(price), "any", true);
    }

    public static BigDecimal price(String price) {
        return new BigDecimal(price);
    }

}
