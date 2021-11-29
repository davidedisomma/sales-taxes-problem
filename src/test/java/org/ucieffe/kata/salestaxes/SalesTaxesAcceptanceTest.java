package org.ucieffe.kata.salestaxes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SalesTaxesAcceptanceTest {

    private SalesTaxes salesTaxes;

    @BeforeEach
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

    @Test
    public void input3() {
        String input = "1 imported bottle of perfume at 27.99\n" +
                "1 bottle of perfume at 18.99\n" +
                "1 packet of headache pills at 9.75\n" +
                "3 box of imported chocolates at 11.25";

        String output = salesTaxes.execute(input);

        String expected = "1 imported bottle of perfume: 32.19\n" +
                "1 bottle of perfume: 20.89\n" +
                "1 packet of headache pills: 9.75\n" +
                "3 imported box of chocolates: 35.55\n" +
                "Sales Taxes: 7.90\n" +
                "Total: 98.38";
        assertThat(output, is(expected));
    }
}
