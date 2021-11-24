package org.ucieffe.kata.salestaxes.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class Basket {

    private final List<Item> itemList;

    public Basket(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Basket(Item...items) {
        itemList = new ArrayList<>();
        itemList.addAll(asList(items));
    }

    public List<Item> getItemList() {
        return Collections.unmodifiableList(itemList);
    }

    public Basket add(Item item) {
        itemList.add(item);
        return this;
    }

    public Report calculateTotal() {
        BigDecimal total = calculateGrossPrice();
        BigDecimal taxes = calculateTaxesPrice();
        return new Report(itemList, taxes, total);
    }

    public BigDecimal calculateTaxesPrice() {
        return itemList.stream()
                .map(Item::getTotalTaxes)
                .reduce(BigDecimal::add)
                .orElse(new BigDecimal("0.00"));
    }

    public BigDecimal calculateGrossPrice() {
        return itemList.stream()
                    .map(Item::getTotalPrice)
                    .reduce(BigDecimal::add)
                    .orElse(new BigDecimal("0.00"));
    }

    public Integer size() {
        return itemList.size();
    }

    public Boolean isEmpty() {
        return itemList.isEmpty();
    }
}
