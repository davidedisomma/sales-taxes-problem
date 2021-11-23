package org.ucieffe.kata.salestaxes;

import org.ucieffe.kata.salestaxes.model.Basket;
import org.ucieffe.kata.salestaxes.model.Item;
import org.ucieffe.kata.salestaxes.model.ItemFactory;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    private static final String SPACE = " ";
    private static final String AT = " at ";

    public Basket run(String input) {
        Basket basket = emptyBasket();
        if(input.isEmpty())
            return basket;

        lines(input).stream()
                .map(this::item)
                .forEach(basket::add);
        return basket;
    }

    private Basket emptyBasket() {
        return new Basket();
    }

    private List<String> lines(String input) {
        return Arrays.asList(input.split("\\n"));
    }

    private Item item(String input) {
        String quantity = getQuantityFrom(input);
        String type = getTypeFrom(input);
        String price = getPriceFrom(input);
        return ItemFactory.createItemFrom(quantity, price, type);
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
