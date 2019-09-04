package org.ucieffe.kata.salestaxes;

import org.junit.Before;
import org.junit.Test;
import org.ucieffe.kata.salestaxes.model.Item;
import org.ucieffe.kata.salestaxes.model.Report;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class SalesTaxesTest {

    private InputParser inputParser = mock(InputParser.class);
    private Calculator calculator = mock(Calculator.class);
    private Deserializer deserializer = mock(Deserializer.class);

    private SalesTaxes salesTaxes;

    public static final String ANY_INPUT = "any_input";
    public static final List<Item> ANY_LIST_OF_ITEMS = Arrays.asList(new Item("0.01"));
    public static final Report ANY_REPORT = new Report(ANY_LIST_OF_ITEMS, BigDecimal.ONE, BigDecimal.TEN);

    @Before
    public void setUp() {
        salesTaxes = new SalesTaxes(inputParser, calculator, deserializer);
    }

    @Test
    public void should_convert_result_in_a_string() {
        when(inputParser.run(ANY_INPUT))
                .thenReturn(ANY_LIST_OF_ITEMS);
        when(calculator.calculateTotal(ANY_LIST_OF_ITEMS))
                .thenReturn(ANY_REPORT);

        salesTaxes.execute(ANY_INPUT);

        verify(deserializer).run(ANY_REPORT);
    }
}