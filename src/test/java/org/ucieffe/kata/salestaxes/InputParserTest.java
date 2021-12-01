package org.ucieffe.kata.salestaxes;

import org.junit.jupiter.api.Test;
import org.ucieffe.kata.salestaxes.model.Basket;
import org.ucieffe.kata.salestaxes.model.Item;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputParserTest {

    @Test
    public void return_empty_basket() {
        InputParser inputParser = new InputParser();
        Basket basket = inputParser.run("");

        assertTrue(basket.isEmpty());
    }

    @Test
    public void return_basket_with_one_kind_of_no_taxed_item() {
        InputParser inputParser = new InputParser();

        Basket basket = inputParser.run("2 book at 12.49");

        assertThat(basket.size(), is(1));
        assertThat(basket.getItemList().get(0), is(Item.createItemFrom(2, new BigDecimal("12.49"), "book", false)));
    }

    @Test
    public void return_basket_when_item_has_imported_word_at_the_beginning() {
        InputParser inputParser = new InputParser();

        Basket basket = inputParser.run("1 imported box of chocolates at 10.00");

        assertThat(basket.size(), is(1));
        assertThat(basket.getItemList().get(0), is(Item.createItemFrom(1, new BigDecimal("10.00"), "box of chocolates", true)));
    }

    @Test
    public void return_basket_when_item_has_imported_word_in_the_middle() {
        InputParser inputParser = new InputParser();

        Basket basket = inputParser.run("1 box of imported chocolates at 10.00");

        assertThat(basket.size(), is(1));
        assertThat(basket.getItemList().get(0), is(Item.createItemFrom(1, new BigDecimal("10.00"), "box of chocolates", true)));
    }

    @Test
    public void return_basket_with_one_kind_of_taxed_item() {
        InputParser inputParser = new InputParser();

        Basket basket = inputParser.run("1 music CD at 14.99");

        assertThat(basket.size(), is(1));
        assertThat(basket.getItemList().get(0), is(Item.createItemFrom(1, new BigDecimal("14.99"), "music CD", false)));
    }

    @Test
    public void return_basket_with_more_than_one_kind_of_item() {
        InputParser inputParser = new InputParser();
        String input = "2 book at 12.49\n" +
                "1 music CD at 14.99\n" +
                "1 chocolate bar at 0.85";

        Basket basket = inputParser.run(input);

        assertThat(basket.size(), is(3));
        assertThat(basket.getItemList(), contains(
                Item.createItemFrom(2, new BigDecimal("12.49"), "book", false),
                Item.createItemFrom(1, new BigDecimal("14.99"), "music CD", false),
                Item.createItemFrom(1, new BigDecimal("0.85"), "chocolate bar", false))
        );
    }
}