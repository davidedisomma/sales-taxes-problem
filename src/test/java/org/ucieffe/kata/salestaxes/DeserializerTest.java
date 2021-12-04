package org.ucieffe.kata.salestaxes;

import org.junit.jupiter.api.Test;
import org.ucieffe.kata.salestaxes.model.Price;
import org.ucieffe.kata.salestaxes.model.Report;
import org.ucieffe.kata.salestaxes.model.ReportItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeserializerTest {

    @Test
    public void deserialize_empty_report() {
        Deserializer deserializer = new Deserializer();

        String output = deserializer.run(new Report(new ArrayList<>(), new Price("0.00"), new Price("0.00")));

        String expected =
                "Sales Taxes: 0.00\n" +
                        "Total: 0.00";
        assertThat(output, is(expected));
    }

    @Test
    public void deserialize_one_item_report() {
        Deserializer deserializer = new Deserializer();

        List<ReportItem> reportItems = List.of(new ReportItem(1, "music CD", false, new Price("16.49")));
        String output = deserializer.run(new Report(reportItems, new Price("1.50"), new Price("16.49")));

        String expected = """
                        1 music CD: 16.49
                        Sales Taxes: 1.50
                        Total: 16.49""";
        assertThat(output, is(expected));
    }

    @Test
    public void deserialize_one_imported_item_report() {
        Deserializer deserializer = new Deserializer();

        List<ReportItem> reportItems = List.of(new ReportItem(1, "music CD", true, new Price("15.74")));
        String output = deserializer.run(new Report(reportItems, new Price("1.50"), new Price("15.74")));

        String expected = """
              1 imported music CD: 15.74
              Sales Taxes: 1.50
              Total: 15.74""";
        assertThat(output, is(expected));
    }

    @Test
    public void deserialize_multiple_items_report() {
        Deserializer deserializer = new Deserializer();

        List<ReportItem> reportItems = List.of(
                new ReportItem(2, "book", false, new Price("24.98")),
                new ReportItem(1, "music CD", false, new Price("16.49")),
                new ReportItem(1, "chocolate bar", false, new Price("0.85"))
        );
        String output = deserializer.run(new Report(reportItems, new Price("1.50"), new Price("42.32")));

        String expected = """
                2 book: 24.98
                1 music CD: 16.49
                1 chocolate bar: 0.85
                Sales Taxes: 1.50
                Total: 42.32""";
        assertThat(output, is(expected));
    }
}