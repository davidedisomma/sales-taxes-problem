package org.ucieffe.kata.salestaxes.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class Report {

    private final List<ReportItem> reportItems;
    private final BigDecimal salesTaxes;
    private final BigDecimal total;

    public Report(List<ReportItem> reportItems, BigDecimal salesTaxes, BigDecimal total) {
        this.reportItems = reportItems;
        this.salesTaxes = salesTaxes;
        this.total = total;
    }

    public List<ReportItem> getReportItems() {
        return reportItems;
    }

    public BigDecimal getSalesTaxes() {
        return salesTaxes;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
