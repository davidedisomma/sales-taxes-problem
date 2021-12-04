package org.ucieffe.kata.salestaxes.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class Report {

    private final List<ReportItem> reportItems;
    private final Price salesTaxes;
    private final Price total;

    public Report(List<ReportItem> reportItems, Price salesTaxes, Price total) {
        this.reportItems = reportItems;
        this.salesTaxes = salesTaxes;
        this.total = total;
    }

    public List<ReportItem> getReportItems() {
        return reportItems;
    }

    public Price getSalesTaxes() {
        return salesTaxes;
    }

    public Price getTotal() {
        return total;
    }
}
