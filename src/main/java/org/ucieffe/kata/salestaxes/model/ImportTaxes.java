package org.ucieffe.kata.salestaxes.model;

public class ImportTaxes implements SalesTaxesApplication {

    private static final TaxPercentage IMPORT_TAX_PERCENTAGE = new TaxPercentage(5);

    @Override
    public TaxPercentage apply(Item item) {
        if(item.isImported()) {
            return IMPORT_TAX_PERCENTAGE;
        }

        return TaxPercentage.NO_TAX;
    }
}
