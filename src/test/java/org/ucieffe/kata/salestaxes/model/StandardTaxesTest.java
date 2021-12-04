package org.ucieffe.kata.salestaxes.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class StandardTaxesTest {

    private static final BigDecimal TAX_PERCENTAGE = new BigDecimal("0.10").setScale(2, RoundingMode.HALF_UP);
    private static final BigDecimal NO_TAX = BigDecimal.ZERO;

    private StandardTaxes standardTaxes;

    @BeforeEach
    void setUp() {
        standardTaxes = new StandardTaxes();
    }

    @ParameterizedTest
    @ValueSource(strings = {"book", "chocolate bar", "box of chocolates",
            "packet of headache pills"})
    void food_book_medical_product_are_tax_exempted(String description) {
        assertThat(standardTaxes.apply(itemFrom(description)), is(NO_TAX));
    }

    @ParameterizedTest
    @ValueSource(strings = {"music CD", "bottle of perfume"})
    void other_stuffs_are_tax_applicable(String description) {
        assertThat(standardTaxes.apply(itemFrom(description)), is(TAX_PERCENTAGE));
    }

    private Item itemFrom(String good) {
        return Item.createItemFrom(1, new Price("1"), good, false);
    }

}