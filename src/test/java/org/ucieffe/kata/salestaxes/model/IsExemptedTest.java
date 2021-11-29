package org.ucieffe.kata.salestaxes.model;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsExemptedTest {

    @ParameterizedTest
    @ValueSource(strings = {"book", "chocolate bar", "box of chocolates",
    "packet of headache pills"})
    void food_book_medical_product_are_tax_exempted(String good) {
        assertTrue(new IsExempted().test(good));
    }

    @ParameterizedTest
    @ValueSource(strings = {"music CD", "bottle of perfume"})
    void other_stuffs_are_tax_applicable(String good) {
        assertFalse(new IsExempted().test(good));
    }
}