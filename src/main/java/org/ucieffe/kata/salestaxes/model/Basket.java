package org.ucieffe.kata.salestaxes.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Basket {

    private final List<Item> itemList;

    public Basket(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Basket(Item... items) {
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

    public Report produceReport() {
        Price total = calculateGrossPrice();
        Price taxes = calculateTaxesPrice();
        List<ReportItem> reportItems = itemList.stream().map(item -> new ReportItem(
                        item.getQuantity(),
                        item.getDescription(),
                        item.isImported(),
                        item.getTotalPrice()
                )
        ).collect(Collectors.toList());
        return new Report(reportItems, taxes, total);
    }

    public Price calculateTaxesPrice() {
        return itemList.stream()
                .map(Item::getTotalTaxes)
                .reduce(Price::add)
                .orElse(new Price("0.00"));
    }

    public Price calculateGrossPrice() {
        return itemList.stream()
                .map(Item::getTotalPrice)
                .reduce(Price::add)
                .orElse(new Price("0.00"));
    }

    public Integer size() {
        return itemList.size();
    }

    public Boolean isEmpty() {
        return itemList.isEmpty();
    }
}
