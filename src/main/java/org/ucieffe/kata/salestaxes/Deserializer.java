package org.ucieffe.kata.salestaxes;

import org.ucieffe.kata.salestaxes.model.Item;
import org.ucieffe.kata.salestaxes.model.Report;

public class Deserializer {

    public static final String CARRIAGE_RETURN = "\n";

    public String run(Report report) {
        StringBuilder result = new StringBuilder();
        report.getItems().forEach(item -> appendItem(result, item));
        appendSalesTaxes(result, report);
        appendTotal(result, report);
        return result.toString();
    }

    private void appendItem(StringBuilder result, final Item item) {
        result.append(item.getQuantity()).append(" ");
        if (item.isImported())
            result.append("imported").append(" ");
        result.append(item.getDescription()).append(": ")
                .append(item.getTotalPrice()).append(CARRIAGE_RETURN);
    }

    private void appendTotal(StringBuilder result, Report report) {
        result.append("Total: ").append(report.getTotal());
    }

    private void appendSalesTaxes(StringBuilder result, Report report) {
        result.append("Sales Taxes: ").append(report.getSalesTaxes()).append(CARRIAGE_RETURN);
    }
}
