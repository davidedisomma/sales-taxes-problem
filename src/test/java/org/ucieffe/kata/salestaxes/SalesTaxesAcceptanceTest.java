package org.ucieffe.kata.salestaxes;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SalesTaxesAcceptanceTest {

    private SalesTaxes salesTaxes;

    @Before
    public void setUp() throws Exception {
        salesTaxes = new SalesTaxes(null, null, null);
    }

    @Test
    @Ignore
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
}
