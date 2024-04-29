package si.primoz.paurustaskone.dto;

import java.math.BigDecimal;

public record Incoming(long traderId, BigDecimal playedAmount, BigDecimal odd) {

    public BigDecimal winAmount() {
        return amountBefTax().subtract(playedAmount);
    }

    public BigDecimal amountBefTax() {
        return playedAmount.multiply(odd);
    }
}
