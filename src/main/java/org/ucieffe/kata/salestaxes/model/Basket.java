package org.ucieffe.kata.salestaxes.model;


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

    public Integer size() {
        return itemList.size();
    }

    public Boolean isEmpty() {
        return itemList.isEmpty();
    }
}
