package org.ucieffe.kata.salestaxes;

import org.ucieffe.kata.salestaxes.model.Basket;
import org.ucieffe.kata.salestaxes.model.Item;

public class InputParser {

    private static final String SPACE = " ";
    private static final String AT = " at ";

    public Basket run(String input) {
        Basket basket = new Basket();
        if(input.isEmpty())
            return basket;

        basket.add(createItem(input));
        return basket;
    }

    private Item createItem(String input) {
        String quantity = getQuantityFrom(input);
        String type = getTypeFrom(input);
        String price = getPriceFrom(input);
        return new Item(quantity, price, type);
    }

    private String getPriceFrom(String input) {
        return input.substring(input.lastIndexOf(AT) + AT.length());
    }

    private String getTypeFrom(String input) {
        return input.substring(input.indexOf(SPACE) + SPACE.length(), input.lastIndexOf(AT));
    }

    private String getQuantityFrom(String input) {
        return input.substring(0, input.indexOf(SPACE));
    }
}
