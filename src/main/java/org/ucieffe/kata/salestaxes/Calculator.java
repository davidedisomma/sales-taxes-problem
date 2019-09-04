/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.ucieffe.kata.salestaxes;

import java.math.BigDecimal;
import java.util.List;

import static java.util.stream.Collectors.reducing;

public class Calculator {


    public Report calculateTotal(List<Item> items) {
        BigDecimal total = items.stream()
                .map(Item::getPrice)
                .collect(reducing((i1, i2) -> i1.add(i2)))
                .orElse(new BigDecimal("0.00"));
        return new Report(items, new BigDecimal("0.00"), total);
    }
}
