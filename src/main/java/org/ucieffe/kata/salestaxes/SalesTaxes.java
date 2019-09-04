package org.ucieffe.kata.salestaxes;

import org.ucieffe.kata.salestaxes.model.Basket;
import org.ucieffe.kata.salestaxes.model.Report;

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
        Basket basket = inputParser.run(input);
        Report report = calculator.calculateTotal(basket);

        return deserializer.run(report);
    }
}
