package si.primoz.paurustaskone.dto;

import java.math.BigDecimal;

public record Outgoing(BigDecimal possibleReturnAmount, BigDecimal possibleReturnAmountBefTax, BigDecimal possibleReturnAmountAfterTax, BigDecimal taxRate, BigDecimal taxAmount) {
}
