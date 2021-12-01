package org.ucieffe.kata.salestaxes.model;

import java.math.BigDecimal;

public record ReportItem(Integer quantity, String description, Boolean isImported,
                         BigDecimal totalPrice) {

}
