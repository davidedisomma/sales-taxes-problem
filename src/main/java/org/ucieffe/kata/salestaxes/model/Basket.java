package org.ucieffe.kata.salestaxes.model;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class Basket {

    private final List<Item> itemList;

    public Basket(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> getItemList() {
        return ImmutableList.copyOf(itemList);
    }
}
