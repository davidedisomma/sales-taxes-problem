package org.ucieffe.kata.salestaxes.model;

public class ItemFactory {

    public static Item createItemFrom(String quantity, String price, String type) {
        return new Item(quantity, price, type, false);
    }
}
