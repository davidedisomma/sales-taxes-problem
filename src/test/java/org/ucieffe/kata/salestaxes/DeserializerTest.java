package org.ucieffe.kata.salestaxes;

import org.junit.Test;
import org.ucieffe.kata.salestaxes.model.Item;
import org.ucieffe.kata.salestaxes.model.Report;
import org.ucieffe.kata.salestaxes.model.ReportItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DeserializerTest {

    @Test
    public void deserialize_empty_report() {
        Deserializer deserializer = new Deserializer();

        String output = deserializer.run(new Report(new ArrayList<>(), new BigDecimal("0.00"), new BigDecimal("0.00")));

        String expected =
                "Sales Taxes: 0.00\n" +
                        "Total: 0.00";
        assertThat(output, is(expected));
    }

    @Test
    public void deserialize_one_item_report() {
        Deserializer deserializer = new Deserializer();

        List<Item> items = List.of(new Item(1, new BigDecimal("14.99"), "music CD", true));
        List<ReportItem> reportItems = List.of(new ReportItem(1, "music CD", false, new BigDecimal("16.49")));
        String output = deserializer.run(new Report(reportItems, new BigDecimal("1.50"), new BigDecimal("16.49")));

        String expected =
                "1 music CD: 16.49\n" +
                        "Sales Taxes: 1.50\n" +
                        "Total: 16.49";
        assertThat(output, is(expected));
    }

    @Test
    public void deserialize_one_imported_item_report() {
        Deserializer deserializer = new Deserializer();

        List<Item> items = List.of(new Item(1, new BigDecimal("14.99"), "music CD", false, true));
        List<ReportItem> reportItems = List.of(new ReportItem(1, "music CD", true, new BigDecimal("15.74")));
        String output = deserializer.run(new Report(reportItems, new BigDecimal("1.50"), new BigDecimal("15.74")));

        String expected =
                "1 imported music CD: 15.74\n" +
                        "Sales Taxes: 1.50\n" +
                        "Total: 15.74";
        assertThat(output, is(expected));
    }

    @Test
    public void deserialize_multiple_items_report() {
        Deserializer deserializer = new Deserializer();

        List<Item> items = List.of(
                new Item(2, new BigDecimal("12.49"), "book", false),
                new Item(1, new BigDecimal("14.99"), "music CD", true),
                new Item(1, new BigDecimal("0.85"), "chocolate bar", false));
        List<ReportItem> reportItems = List.of(
                new ReportItem(2, "book", false, new BigDecimal("24.98")),
                new ReportItem(1, "music CD", false, new BigDecimal("16.49")),
                new ReportItem(1, "chocolate bar", false, new BigDecimal("0.85"))
        );
        String output = deserializer.run(new Report(reportItems, new BigDecimal("1.50"), new BigDecimal("42.32")));

        String expected = "2 book: 24.98\n" +
                "1 music CD: 16.49\n" +
                "1 chocolate bar: 0.85\n" +
                "Sales Taxes: 1.50\n" +
                "Total: 42.32";
        assertThat(output, is(expected));
    }
}