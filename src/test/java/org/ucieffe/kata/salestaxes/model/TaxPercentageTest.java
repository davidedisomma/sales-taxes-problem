package org.ucieffe.kata.salestaxes.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class TaxPercentageTest {

    @Test
    void testValue() {
        assertThat(new TaxPercentage(10).value(), is(new BigDecimal("0.10")));
    }
}