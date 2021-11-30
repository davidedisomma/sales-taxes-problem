package org.ucieffe.kata.salestaxes;

import org.ucieffe.kata.salestaxes.model.Basket;
import org.ucieffe.kata.salestaxes.model.Item;
import org.ucieffe.kata.salestaxes.model.ItemFactory;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    private static final String SPACE = " ";
    private static final String AT_WORD = " at ";
    public static final String IMPORTED_WORD = "imported";

    public Basket run(String input) {
        if(input.isEmpty())
            return emptyBasket();

        return createBasketFrom(input);
    }

    private Basket createBasketFrom(String input) {
        Basket basket = emptyBasket();
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
        String quantity = fetchQuantityFrom(input);
        String type = fetchTypeFrom(input);
        String price = fetchPriceFrom(input);

        return ItemFactory.createItemFrom(quantity, price, type, hasImportedWord(input));
    }

    private String fetchPriceFrom(String input) {
        return input.substring(input.lastIndexOf(AT_WORD) + AT_WORD.length());
    }

    private String fetchTypeFrom(String input) {
        if(this.hasImportedWord(input))
            input = input.replace(IMPORTED_WORD + SPACE, "");

        return input.substring(input.indexOf(SPACE) + SPACE.length(), input.lastIndexOf(AT_WORD));
    }

    private boolean hasImportedWord(String input) {
        return input.contains(IMPORTED_WORD);
    }

    private String fetchQuantityFrom(String input) {
        return input.substring(0, input.indexOf(SPACE));
    }
}
