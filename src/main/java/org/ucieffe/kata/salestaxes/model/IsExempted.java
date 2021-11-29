package org.ucieffe.kata.salestaxes.model;

import java.util.function.Predicate;

public class IsExempted implements Predicate<String> {

    @Override
    public boolean test(String description) {
        return switch (description) {
            case "book", "box of chocolates", "chocolate bar", "packet of headache pills" -> true;
            default -> false;
        };
    }
}
