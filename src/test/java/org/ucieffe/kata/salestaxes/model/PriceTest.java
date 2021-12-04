package org.ucieffe.kata.salestaxes.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class PriceTest {

    @Test
    void create_price_from_string() {
        assertThat(new Price("1.99").getAmount(), is("1.99"));
    }

    @Test
    void createPriceRoundingTwoSecondDecimalUp() {
        assertThat(new Price("1.994").getAmount(), is("1.99"));
        assertThat(new Price("1.995").getAmount(), is("2.00"));
        assertThat(new Price("1.996").getAmount(), is("2.00"));
    }

//    @Test
//    void create_price_from_string() {
//        assertThat(new Price("1.99").getAmount(), is("1.99"));
//    }
}