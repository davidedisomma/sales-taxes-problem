/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.ucieffe.kata.salestaxes;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void return_zero_when_no_item() {
        assertThat(new BigDecimal("0.00"), is(calculator.calculateTotal()));
    }

    @Test
    public void return_item_price_when_add_one_item_with_exemption() {
        calculator.add(new Item("1.10"));

        assertThat(new BigDecimal("1.10"), is(calculator.calculateTotal()));
    }

    @Test
    public void return_sum_price_when_add_more_than_one_item_with_exemption() {
        calculator.add(new Item("1.10"));
        calculator.add(new Item("2.20"));
        calculator.add(new Item("3.30"));

        assertThat(new BigDecimal("6.60"), is(calculator.calculateTotal()));
    }

}