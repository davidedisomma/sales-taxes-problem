package org.ucieffe.kata.salestaxes;

import org.junit.Test;
import org.ucieffe.kata.salestaxes.model.Basket;
import org.ucieffe.kata.salestaxes.model.Item;
import org.ucieffe.kata.salestaxes.model.Report;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DeserializerTest {

    @Test
    public void deserialize_empty_report() {
        Deserializer deserializer = new Deserializer();

        String output = deserializer.run(new Report(new Basket(), new BigDecimal("0.00"), new BigDecimal("0.00")));

        String expected =
                "Sales Taxes: 0.00\n" +
                "Total: 0.00";
        assertThat(output, is(expected));
    }

    @Test
    public void deserialize_one_item_report() {
        Deserializer deserializer = new Deserializer();

        Basket basket = new Basket();
        basket.add(new Item("1", "16.49", "music CD"));
        String output = deserializer.run(new Report(basket, new BigDecimal("1.50"), new BigDecimal("16.49")));

        String expected =
                "1 music CD: 16.49\n" +
                "Sales Taxes: 1.50\n" +
                "Total: 16.49";
        assertThat(output, is(expected));
    }

    @Test
    public void deserialize_multiple_items_report() {
        Deserializer deserializer = new Deserializer();

        Basket basket = new Basket();
        basket.add(new Item("2", "12.49", "book"));
        basket.add(new Item("1", "16.49", "music CD"));
        basket.add(new Item("1", "0.85", "chocolate bar"));
        String output = deserializer.run(new Report(basket, new BigDecimal("1.50"), new BigDecimal("42.32")));

        String expected = "2 book: 24.98\n" +
                "1 music CD: 16.49\n" +
                "1 chocolate bar: 0.85\n" +
                "Sales Taxes: 1.50\n" +
                "Total: 42.32";
        assertThat(output, is(expected));
    }
}