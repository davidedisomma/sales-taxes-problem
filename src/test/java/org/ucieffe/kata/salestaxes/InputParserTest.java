package org.ucieffe.kata.salestaxes;

import org.junit.Test;
import org.ucieffe.kata.salestaxes.model.Basket;
import org.ucieffe.kata.salestaxes.model.Item;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class InputParserTest {

    @Test
    public void returnEmptyBasket() {
        InputParser inputParser = new InputParser();
        Basket basket = inputParser.run("");

        assertTrue(basket.isEmpty());
    }

    @Test
    public void returnBasketWithOneKindOfNoTaxedItem() {
        InputParser inputParser = new InputParser();

        Basket basket = inputParser.run("2 book at 12.49");

        assertThat(basket.size(), is(1));
        assertThat(basket.getItemList().get(0), is(new Item("2", "12.49", "book", false)));
    }

    @Test
    public void returnBasketWithOneKindOfTaxedItem() {
        InputParser inputParser = new InputParser();

        Basket basket = inputParser.run("1 music CD at 14.99");

        assertThat(basket.size(), is(1));
        assertThat(basket.getItemList().get(0), is(new Item("1", "14.99", "music CD", true)));
    }

    @Test
    public void returnBasketWithMoreThanOneKindOfItem() {
        InputParser inputParser = new InputParser();
        String input = "2 book at 12.49\n" +
                "1 music CD at 14.99\n" +
                "1 chocolate bar at 0.85";

        Basket basket = inputParser.run(input);

        assertThat(basket.size(), is(3));
        assertThat(basket.getItemList(), contains(
                new Item("2", "12.49", "book", false),
                new Item("1", "14.99", "music CD", true),
                new Item("1", "0.85", "chocolate bar", false))
        );
    }
}