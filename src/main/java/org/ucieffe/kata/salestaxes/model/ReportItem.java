package org.ucieffe.kata.salestaxes.model;

public record ReportItem(Integer quantity, String description, Boolean isImported,
                         Price totalPrice) {

}
