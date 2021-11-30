package org.ucieffe.kata.salestaxes;

import org.ucieffe.kata.salestaxes.model.Basket;
import org.ucieffe.kata.salestaxes.model.ImportTaxes;
import org.ucieffe.kata.salestaxes.model.Item;
import org.ucieffe.kata.salestaxes.model.StandardTaxes;

import java.math.BigDecimal;

import static java.util.Arrays.asList;

public class SemanticData {

    public static Basket basketWith(Item...items) {
        return new Basket(asList(items));
    }

    public static Item anExemptedItem(String price) {
        return new Item(1, price(price), "any");
    }

    public static Item aTaxedItem(String price) {
        return aTaxedItem(price, 1);
    }
    public static Item aTaxedItem(String price, Integer quantity) {
        return new Item(quantity, price(price), "any", false, new StandardTaxes());
    }

    public static Item anImportedItem(String price) {
        return new Item(1, price(price), "any", true, new ImportTaxes());
    }

    public static Item anImportedAndTaxedItem(String price) {
        return new Item(1, price(price), "any", true, new StandardTaxes(), new ImportTaxes());
    }

    public static BigDecimal price(String price) {
        return new BigDecimal(price);
    }

}
