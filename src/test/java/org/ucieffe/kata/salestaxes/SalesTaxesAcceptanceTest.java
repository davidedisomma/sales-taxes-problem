package org.ucieffe.kata.salestaxes;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SalesTaxesAcceptanceTest {

    private SalesTaxes salesTaxes;

    @Before
    public void setUp() {
        salesTaxes = new SalesTaxes(new InputParser(), new Deserializer());
    }

    @Test
    public void input1() {
        String input = "2 book at 12.49\n" +
                "1 music CD at 14.99\n" +
                "1 chocolate bar at 0.85";

        String output = salesTaxes.execute(input);

        String expected = "2 book: 24.98\n" +
                "1 music CD: 16.49\n" +
                "1 chocolate bar: 0.85\n" +
                "Sales Taxes: 1.50\n" +
                "Total: 42.32";
        assertThat(output, is(expected));
    }

    @Test
    public void input2() {
        String input = "1 imported box of chocolates at 10.00\n" +
                "1 imported bottle of perfume at 47.50";

        String output = salesTaxes.execute(input);

        String expected = "1 imported box of chocolates: 10.50\n" +
                "1 imported bottle of perfume: 54.65\n" +
                "Sales Taxes: 7.65\n" +
                "Total: 65.15";
        assertThat(output, is(expected));
    }
}
