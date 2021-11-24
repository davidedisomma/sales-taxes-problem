/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.ucieffe.kata.salestaxes;

import org.junit.Before;
import org.junit.Test;
import org.ucieffe.kata.salestaxes.model.Basket;
import org.ucieffe.kata.salestaxes.model.Item;

import java.math.BigDecimal;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void return_zero_when_no_item() {
        assertThat(new BigDecimal("0.00"), is(calculator.calculateTotal(basketWith()).getTotal()));
    }

    @Test
    public void return_item_price_when_add_one_item_with_exemption() {
        assertThat(new BigDecimal("1.10"), is(calculator.calculateTotal(basketWith(anExemptedItem("1.10"))).getTotal()));
    }

    @Test
    public void return_item_price_when_add_one_item_with_tax() {
        assertThat(new BigDecimal("1.21"), is(calculator.calculateTotal(basketWith(aTaxedItem("1.10"))).getTotal()));
    }

    private Item anExemptedItem(String price) {
        return new Item(1, new BigDecimal(price), "any", false);
    }

    private Item aTaxedItem(String price) {
        return new Item(1, new BigDecimal(price), "any", true);
    }

    @Test
    public void return_sum_price_when_add_more_than_one_item_with_exemption() {
        Basket basketWithMultipleItems = basketWith(
                anExemptedItem("1.10"),
                anExemptedItem("2.20"),
                anExemptedItem("3.30")
        );
        assertThat(new BigDecimal("6.60"), is(calculator.calculateTotal(basketWithMultipleItems).getTotal()));
    }

    private Basket basketWith(Item...items) {
        return new Basket(asList(items));
    }

}
