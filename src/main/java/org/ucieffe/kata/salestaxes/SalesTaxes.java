package org.ucieffe.kata.salestaxes;

import org.ucieffe.kata.salestaxes.model.Basket;
import org.ucieffe.kata.salestaxes.model.Report;

public class SalesTaxes {
    private final InputParser inputParser;
    private final Deserializer deserializer;

    public SalesTaxes(InputParser inputParser, Deserializer deserializer) {

        this.inputParser = inputParser;
        this.deserializer = deserializer;
    }

    public String execute(String input) {
        Basket basket = inputParser.run(input);
        Report report = basket.calculateTotal();

        return deserializer.run(report);
    }
}
