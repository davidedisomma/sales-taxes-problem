package org.ucieffe.kata.salestaxes;

import org.ucieffe.kata.salestaxes.model.Item;
import org.ucieffe.kata.salestaxes.model.Report;

import java.util.List;

public class SalesTaxes {
    private final InputParser inputParser;
    private final Calculator calculator;
    private final Deserializer deserializer;

    public SalesTaxes(InputParser inputParser, Calculator calculator, Deserializer deserializer) {

        this.inputParser = inputParser;
        this.calculator = calculator;
        this.deserializer = deserializer;
    }

    public String execute(String input) {
        List<Item> items = inputParser.run(input);
        Report report = calculator.calculateTotal(items);

        return deserializer.run(report);
    }
}
