package org.ucieffe.kata.salestaxes;

import org.ucieffe.kata.salestaxes.model.Item;
import org.ucieffe.kata.salestaxes.model.Report;
import org.ucieffe.kata.salestaxes.model.ReportItem;

public class Deserializer {

    public static final String CARRIAGE_RETURN = "\n";

    public String run(Report report) {
        StringBuilder result = new StringBuilder();
        report.getReportItems().forEach(item -> appendItem(result, item));
        appendSalesTaxes(result, report);
        appendTotal(result, report);
        return result.toString();
    }

    private void appendItem(StringBuilder result, final ReportItem item) {
        result.append(item.quantity()).append(" ");
        if (item.isImported())
            result.append("imported").append(" ");
        result.append(item.description()).append(": ")
                .append(item.totalPrice()).append(CARRIAGE_RETURN);
    }

    private void appendTotal(StringBuilder result, Report report) {
        result.append("Total: ").append(report.getTotal());
    }

    private void appendSalesTaxes(StringBuilder result, Report report) {
        result.append("Sales Taxes: ").append(report.getSalesTaxes()).append(CARRIAGE_RETURN);
    }
}
