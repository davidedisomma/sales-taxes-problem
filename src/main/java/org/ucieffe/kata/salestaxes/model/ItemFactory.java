package org.ucieffe.kata.salestaxes.model;

public class ItemFactory {

    public static Item createItemFrom(String quantity, String price, String description) {
        boolean isTaxed = true;
        switch(description) {
            case "book":
            case "chocolate bar":
                isTaxed = false;
                break;
        }
        return new Item(quantity, price, description, isTaxed);
    }
}
