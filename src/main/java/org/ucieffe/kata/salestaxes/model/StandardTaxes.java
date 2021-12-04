package org.ucieffe.kata.salestaxes.model;

public class StandardTaxes implements SalesTaxesApplication{

    private static final TaxPercentage TAX_PERCENTAGE = new TaxPercentage(10);

    @Override
    public TaxPercentage apply(Item item) {
        if(isExempted(item)) {
            return TaxPercentage.NO_TAX;
        }

        return TAX_PERCENTAGE;
    }

    private boolean isExempted(Item item) {
        return switch (item.getDescription()) {
            case "book", "box of chocolates", "chocolate bar", "packet of headache pills" -> true;
            default -> false;
        };
    }

}
