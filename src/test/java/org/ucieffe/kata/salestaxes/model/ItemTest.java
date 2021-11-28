package org.ucieffe.kata.salestaxes.model;

import org.junit.Test;
import org.ucieffe.kata.salestaxes.SemanticData;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void noTaxesWhenItemIsExempted() {
        Item item = SemanticData.anExemptedItem("2.01");

        assertThat(item.getTotalTaxes().toString(), is("0.00"));
        assertThat(item.getTotalPrice().toString(), is("2.01"));
    }

    @Test
    public void calculateTaxesWhenItemIsTaxedGood() {
        Item item = SemanticData.aTaxedItem("2.01");

        assertThat(item.getTotalTaxes().toString(), is("0.20"));
        assertThat(item.getTotalPrice().toString(), is("2.21"));
    }

    @Test
    public void taxIsRoundedToUpperHalfOneTenth() {
        Item item = SemanticData.aTaxedItem("12.70");

        assertThat(item.getTotalTaxes().toString(), is("1.30"));
        assertThat(item.getTotalPrice().toString(), is("14.00"));
    }

    @Test
    public void calculateTaxesWhenMultipleQuantityItemIsTaxedGood() {
        Item item = SemanticData.aTaxedItem("2.01", 5);

        assertThat(item.getTotalTaxes().toString(), is("1.00"));
        assertThat(item.getTotalPrice().toString(), is("11.05"));
    }

    @Test
    public void calculateTaxesWhenItemIsImportedGood() {
        Item item = SemanticData.anImportedItem("10.00");

        assertThat(item.getTotalTaxes().toString(), is("0.50"));
        assertThat(item.getTotalPrice().toString(), is("10.50"));
    }

    @Test
    public void calculateTaxesWhenItemIsBothTaxedAndImportedGood() {
        Item item = SemanticData.anImportedAndTaxedItem("47.50");

        assertThat(item.getTotalTaxes().toString(), is("7.15"));
        assertThat(item.getTotalPrice().toString(), is("54.65"));
    }

}